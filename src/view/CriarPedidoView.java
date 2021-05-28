package view;

import java.awt.*;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import controller.CadastroController;
import controller.MainController;
import controller.RestauranteController;
import model.*;

import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Map;

public class CriarPedidoView extends JFrame {

	private JPanel contentPane;
	private CatalogoProdutos catalogo;
	private RestauranteController restaurante;
	private CadastroController cadastro;
	private HashMap<String, IProduto> produtosMap = new HashMap<>();
	private HashMap<IProduto, Integer> carrinhoMap = new HashMap<>();
	private Double totalItemConta = 0D;

	public CriarPedidoView(MainController mainController, Hospedagem hospedagem) {
		restaurante = mainController.restaurante;
		cadastro = mainController.cadastro;
		catalogo = restaurante.getCatalogo();

		DefaultListModel values = new DefaultListModel();
		for (Categoria c: catalogo.getCategorias()) {
			for (IProduto p: c.getProdutos()) {
				String key = p.getNome() + ' '  + p.getPreco();
				System.out.println(key);
				values.addElement(key);
				produtosMap.put(key, p);
			}
		}

		System.out.println(values);

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome do Produto");
		lblNewLabel.setBounds(10, 11, 89, 14);
		contentPane.add(lblNewLabel);
		
		JLabel valorPedido = new JLabel("Valor");
		valorPedido.setHorizontalAlignment(SwingConstants.CENTER);
		valorPedido.setBounds(199, 11, 77, 14);
		contentPane.add(valorPedido);
		
		JButton adicionarItemButton = new JButton("Adicionar ao carrinho");

		adicionarItemButton.setBounds(341, 36, 209, 32);
		contentPane.add(adicionarItemButton);
		
		JSpinner qtdAdicionar = new JSpinner();
		qtdAdicionar.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		qtdAdicionar.setBounds(286, 36, 48, 32);
		contentPane.add(qtdAdicionar);

		JList carrinhoList = new JList();
		carrinhoList.setEnabled(false);
		DefaultListModel valuesCarrinho = new DefaultListModel();
		carrinhoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		carrinhoList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		carrinhoList.setBounds(286, 171, 266, 299);
		carrinhoList.setModel(valuesCarrinho);
		contentPane.add(carrinhoList);
		
		JLabel totalpedido = new JLabel("Total: R$ 0,00");
		totalpedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalpedido.setHorizontalAlignment(SwingConstants.CENTER);
		totalpedido.setBounds(286, 147, 264, 14);
		contentPane.add(totalpedido);
		
		JList listaItems = new JList();
		listaItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaItems.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		listaItems.setBounds(10, 36, 266, 434);
		listaItems.setModel(values);
		contentPane.add(listaItems);
		
		JButton removerItemButton = new JButton("Remover Item");
		removerItemButton.setBounds(341, 79, 211, 32);
		contentPane.add(removerItemButton);
		
		JSpinner qtdRemover = new JSpinner();
		qtdRemover.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		qtdRemover.setBounds(286, 79, 48, 32);
		contentPane.add(qtdRemover);
		
		JButton confirmarButton = new JButton("Confirmar Pedido");
		confirmarButton.setBounds(10, 481, 540, 37);
		contentPane.add(confirmarButton);

		// ADICIONAR ITEM AO CARRINHO
		adicionarItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IProduto tmp = produtosMap.get(listaItems.getSelectedValue().toString());

				if (carrinhoMap.containsKey(tmp)){
					carrinhoMap.replace(tmp, carrinhoMap.get(tmp) + (int) qtdAdicionar.getValue());
				} else {
					carrinhoMap.put(tmp, (int) qtdAdicionar.getValue());
				}


				valuesCarrinho.clear();
				for (Map.Entry<IProduto, Integer> entry : carrinhoMap.entrySet()) {
					valuesCarrinho.addElement(entry.getKey().getNome() + ' ' + entry.getValue());
				}

				totalItemConta += Math.round(tmp.getPreco()* (int) qtdAdicionar.getValue() * 100.0) / 100.0;
				totalpedido.setText("Total: R$" + totalItemConta.toString());
			}
		});

		// REMOVER ITEM DO CARRINHO
		removerItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IProduto tmp = produtosMap.get(listaItems.getSelectedValue().toString());
				System.out.println(listaItems.getSelectedValue().toString());

				if(carrinhoMap.get(tmp) - (int) qtdRemover.getValue() <= 0){
					carrinhoMap.remove(tmp);
				} else {
					carrinhoMap.replace(tmp, carrinhoMap.get(tmp)- (int) qtdRemover.getValue());
				}

				valuesCarrinho.clear();
				totalItemConta = 0D;
				for (Map.Entry<IProduto, Integer> entry : carrinhoMap.entrySet()) {
					valuesCarrinho.addElement(entry.getKey().getNome() + ' ' + entry.getValue());
					totalItemConta += Math.round(entry.getKey().getPreco() * entry.getValue() * 100.0) / 100.0;
				}

				totalpedido.setText("Total: R$" + totalItemConta.toString());
			}
		});

		// CONFIRMAR PEDIDO
		confirmarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Map.Entry<IProduto, Integer> entry : carrinhoMap.entrySet()) {
					hospedagem.addToConta(restaurante.generateItemConta(entry.getKey(), entry.getValue()));
				}

				hospedagem.getRelatorioConta();

				JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");
				dispose();
			}
		});
	}
}
