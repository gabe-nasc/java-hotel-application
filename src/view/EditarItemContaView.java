package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import controller.MainController;
import controller.RestauranteController;
import model.CategoriaProduto;
import model.IProduto;
import model.ItemConta;

public class EditarItemContaView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2543427095661833748L;
	private final MainController mainController;
	private final RestauranteController restauranteController;
	private JPanel contentPane;

	private HashMap<String, IProduto> stringToProduto;
	private DefaultComboBoxModel values;
	private JButton Cancelar;
	private JButton Confirmar;
	private JLabel qtdLbl;
	private JSpinner qtdSpinner;
	private JComboBox itemComboBox;

	/**
	 * Create the frame.
	 */
	public EditarItemContaView(MainController mainController, ItemConta item) {
		this.mainController = mainController;
		this.restauranteController = mainController.getRestaurante();

		stringToProduto = new HashMap<>();
		values = new DefaultComboBoxModel();
		for(CategoriaProduto ctg: restauranteController.getCatalogo().getCategorias()){
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

		itemComboBox = new JComboBox();
		itemComboBox.setModel(values);
		itemComboBox.setSelectedItem(item.getProduto().getNome());
		itemComboBox.setBounds(10, 11, 191, 28);
		contentPane.add(itemComboBox);

		qtdSpinner = new JSpinner();
		qtdSpinner.setValue(item.getQtd());
		qtdSpinner.setBounds(171, 50, 30, 20);
		contentPane.add(qtdSpinner);

		qtdLbl = new JLabel("Quantidade");
		qtdLbl.setBounds(10, 50, 88, 20);
		contentPane.add(qtdLbl);


		Confirmar = new JButton("Confirmar");
		Confirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				item.setQtd((Integer) qtdSpinner.getValue());
				item.setProduto(stringToProduto.get((String) itemComboBox.getSelectedItem()));

				dispose();
			}
		});
		Confirmar.setBounds(10, 81, 191, 23);
		contentPane.add(Confirmar);
		

		Cancelar = new JButton("Cancelar");
		Cancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		Cancelar.setBounds(10, 110, 191, 23);
		contentPane.add(Cancelar);
	}

}
