package view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;
import controller.MainController;
import model.Hospede;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.HashMap;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaHospedesView extends JFrame {

	private JPanel contentPane;
	private CadastroController cadastro;
	private HashMap<String, Hospede> hospedeMap = new HashMap<>();

	/**
	 * Create the frame.
	 */
	public ListaHospedesView(MainController mainController) {
		cadastro = mainController.cadastro;

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
		contentPane.setLayout(null);
		
		JList list = new JList(values);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setBounds(10, 11, 254, 448);
		list.setModel(values);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);
		
		JButton editButton = new JButton("Editar");

		editButton.setBounds(274, 11, 268, 61);
		contentPane.add(editButton);
		
		JTextArea previewArea = new JTextArea();
		previewArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		previewArea.setEditable(false);
		previewArea.setVisible(false);
		previewArea.setBounds(274, 243, 268, 216);
		previewArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(previewArea);
		
		JButton deleteButton = new JButton("Deletar");
		deleteButton.setBounds(274, 83, 268, 61);
		contentPane.add(deleteButton);

		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				previewArea.setVisible(true);

				//System.out.println(textPane.getSelectedText());
				Hospede tmp = hospedeMap.get(list.getSelectedValue().toString());
				previewArea.setText(tmp.listaInfoHospede());
			}
		});

		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditarHospedeView frame = new EditarHospedeView(mainController, hospedeMap.get(list.getSelectedValue().toString()));
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
	}
}
