package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.CadastroController;
import controller.MainController;
import controller.RestauranteController;
import model.CatalogoProdutos;
import model.CategoriaProduto;
import model.Hospedagem;
import model.IProduto;

public class CriarPedidoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6253543043082408609L;
	private JPanel contentPane;
	private CatalogoProdutos catalogo;
	private RestauranteController restaurante;
	private CadastroController cadastro;
	private HashMap<String, IProduto> produtosMap = new HashMap<>();
	private HashMap<IProduto, Integer> carrinhoMap = new HashMap<>();
	private Double totalItemConta = 0D;
	private DefaultListModel values;
	private JLabel lblNewLabel;
	private JButton adicionarItemButton;
	private JSpinner qtdAdicionar;
	private JList carrinhoList;
	private DefaultListModel valuesCarrinho;
	private JLabel totalpedido;
	private JList listaItems;
	private JButton removerItemButton;
	private JSpinner qtdRemover;
	private JButton confirmarButton;
	private JButton cancelarButton;

	public CriarPedidoView(MainController mainController, Hospedagem hospedagem) {
		restaurante = mainController.getRestaurante();
		cadastro = mainController.getCadastro();
		catalogo = restaurante.getCatalogo();

		values = new DefaultListModel();
		for (CategoriaProduto c: catalogo.getCategorias()) {
			for (IProduto p: c.getProdutos()) {
				String key = p.getNome() + ' '  + p.getPreco();
				values.addElement(key);
				produtosMap.put(key, p);
			}
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Nome do Produto (Valor)");
		lblNewLabel.setBounds(10, 11, 130, 14);
		contentPane.add(lblNewLabel);
		
		adicionarItemButton = new JButton("Adicionar ao carrinho");

		adicionarItemButton.setBounds(341, 36, 209, 32);
		contentPane.add(adicionarItemButton);
		

		qtdAdicionar = new JSpinner();
		qtdAdicionar.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		qtdAdicionar.setBounds(286, 36, 48, 32);
		contentPane.add(qtdAdicionar);


		carrinhoList = new JList();
		carrinhoList.setEnabled(false);

		valuesCarrinho = new DefaultListModel();
		carrinhoList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		carrinhoList.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		carrinhoList.setBounds(286, 171, 266, 299);
		carrinhoList.setModel(valuesCarrinho);
		contentPane.add(carrinhoList);
		

		totalpedido = new JLabel("Total: R$ 0,00");
		totalpedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		totalpedido.setHorizontalAlignment(SwingConstants.CENTER);
		totalpedido.setBounds(286, 147, 264, 14);
		contentPane.add(totalpedido);
		

		listaItems = new JList();
		listaItems.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaItems.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		listaItems.setBounds(10, 36, 266, 434);
		listaItems.setModel(values);
		contentPane.add(listaItems);
		

		removerItemButton = new JButton("Remover Item");
		removerItemButton.setBounds(341, 79, 211, 32);
		contentPane.add(removerItemButton);
		

		qtdRemover = new JSpinner();
		qtdRemover.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		qtdRemover.setBounds(286, 79, 48, 32);
		contentPane.add(qtdRemover);
		

		confirmarButton = new JButton("Confirmar Pedido");
		confirmarButton.setBounds(286, 481, 264, 37);
		contentPane.add(confirmarButton);
		

		cancelarButton = new JButton("Cancelar");
		cancelarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelarButton.setBounds(10, 481, 266, 37);
		contentPane.add(cancelarButton);

		// ADICIONAR ITEM AO CARRINHO
		adicionarItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addToCarrinho();
			}
		});

		// REMOVER ITEM DO CARRINHO
		removerItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFromCarrinho();
			}
		});

		// CONFIRMAR PEDIDO
		confirmarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmPedido(hospedagem);
			}
		});
	}

	private void removeFromCarrinho(){
		IProduto tmp;
		try{
			tmp = produtosMap.get(listaItems.getSelectedValue().toString());
		}
		catch (Exception n) {
			JOptionPane.showMessageDialog(null,"Por favor, selecione um item");
			return;
		}
		try{
			if (carrinhoMap.get(tmp) - (int) qtdRemover.getValue() <= 0) {
				carrinhoMap.remove(tmp);
			} else {
				carrinhoMap.replace(tmp, carrinhoMap.get(tmp) - (int) qtdRemover.getValue());
			}
		} catch (NullPointerException n) {
			JOptionPane.showMessageDialog(null,"Nao ha mais items deste tipo para remover");
		}

		valuesCarrinho.clear();
		totalItemConta = 0D;
		for (Map.Entry<IProduto, Integer> entry : carrinhoMap.entrySet()) {
			valuesCarrinho.addElement(entry.getKey().getNome() + ' ' + entry.getValue());
			totalItemConta += Math.round(entry.getKey().getPreco() * entry.getValue() * 100.0) / 100.0;
		}

		totalpedido.setText("Total: R$" + totalItemConta.toString());
	}

	private void addToCarrinho(){
		IProduto tmp;
		try{
			tmp = produtosMap.get(listaItems.getSelectedValue().toString());
		}
		catch (Exception n) {
			JOptionPane.showMessageDialog(null,"Por favor, selecione um item");
			return;
		}

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

	private void confirmPedido(Hospedagem hospedagem){
		for (Map.Entry<IProduto, Integer> entry : carrinhoMap.entrySet()) {
			hospedagem.addToConta(restaurante.generateItemConta(entry.getKey(), entry.getValue()));
		}

		hospedagem.getRelatorioConta();

		JOptionPane.showMessageDialog(null, "Pedido realizado com sucesso!");
		dispose();
	}
}
