package view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;
import model.Hospede;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.HashMap;

public class ListaHospedesView extends JFrame {

	private JPanel contentPane;
	HashMap<String, Hospede> hospedeMap = new HashMap<>();
	/**
	 * Launch the application.
	 */
	public static void main(CadastroController cadastro) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaHospedesView frame = new ListaHospedesView(cadastro);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ListaHospedesView(CadastroController cadastro) {
		DefaultListModel values = new DefaultListModel();
		System.out.println("Teste 2");
		for (Hospede h: cadastro.getHospedes()) {
			System.out.println("Teste");
			String key = h.getNome() + ' '  + h.getCpf();
			System.out.println(key);
			values.addElement(key);
			hospedeMap.put(key, h);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JList list = new JList(values);
		list.setModel(values);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 1;
		gbc_list.gridy = 1;
		contentPane.add(list, gbc_list);
	}

}
