package view;

import controller.MainController;
import controller.RestauranteController;
import model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;

public class EditarItemContaView extends JFrame {
	private final MainController mainController;
	private final RestauranteController restauranteController;
	private JPanel contentPane;

	private HashMap<String, IProduto> stringToProduto;
	private DefaultComboBoxModel values;

	/**
	 * Create the frame.
	 */
	public EditarItemContaView(MainController mainController, ItemConta item) {
		this.mainController = mainController;
		this.restauranteController = mainController.getRestaurante();

		stringToProduto = new HashMap<>();
		values = new DefaultComboBoxModel();
		for(Categoria ctg: restauranteController.getCatalogo().getCategorias()){
			for(IProduto produto: ctg.getProdutos()){
				stringToProduto.put(produto.getNome(), produto);
				values.addElement(produto.getNome());
			}
		}

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 234, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox itemComboBox = new JComboBox();
		itemComboBox.setModel(values);
		itemComboBox.setSelectedItem(item.getProduto().getNome());
		itemComboBox.setBounds(10, 11, 191, 28);
		contentPane.add(itemComboBox);
		
		JSpinner qtdSpinner = new JSpinner();
		qtdSpinner.setValue(item.getQtd());
		qtdSpinner.setBounds(171, 50, 30, 20);
		contentPane.add(qtdSpinner);
		
		JLabel qtdLbl = new JLabel("Quantidade");
		qtdLbl.setBounds(10, 50, 88, 20);
		contentPane.add(qtdLbl);
		
		JButton Confirmar = new JButton("Confirmar");
		Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setQtd((Integer) qtdSpinner.getValue());
				item.setProduto(stringToProduto.get((String) itemComboBox.getSelectedItem()));

				dispose();
			}
		});
		Confirmar.setBounds(10, 81, 191, 23);
		contentPane.add(Confirmar);
		
		JButton Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Cancelar.setBounds(10, 110, 191, 23);
		contentPane.add(Cancelar);
	}

}
