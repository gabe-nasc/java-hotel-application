package view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;
import controller.MainController;
import model.Hospede;
import model.IHospede;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;
import java.util.List;

public class ListaHospedesView extends JFrame {

	private JPanel contentPane;
	private CadastroController cadastro;
	private HashMap<String, IHospede> hospedeMap = new HashMap<>();
	private DefaultListModel values;
	private List<String> stringsToSort;

	/**
	 * Create the frame.
	 */
	public ListaHospedesView(MainController mainController) {
		cadastro = mainController.cadastro;

		values = new DefaultListModel();
		stringsToSort = new ArrayList<>();
		for (IHospede h: cadastro.getHospedes()) {
			String key = "(" + cadastro.getHospedagem(h).getNumeroQuarto() + ") " + h.getNome();
			System.out.println(key);
			stringsToSort.add(key);
			hospedeMap.put(key, h);
		}

		java.util.Collections.sort(stringsToSort);
		values.addAll(stringsToSort);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 818, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList(values);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setBounds(10, 11, 504, 448);
		list.setModel(values);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);
		
		JButton editButton = new JButton("Editar");

		editButton.setBounds(524, 11, 268, 32);
		contentPane.add(editButton);
		
		JTextArea previewArea = new JTextArea();
		previewArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		previewArea.setEditable(false);
		previewArea.setVisible(false);
		previewArea.setBounds(524, 190, 268, 269);
		previewArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(previewArea);
		
		JButton goBackButton = new JButton("Sair");
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		goBackButton.setBounds(524, 54, 268, 32);
		contentPane.add(goBackButton);


		list.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				previewArea.setVisible(true);

				//System.out.println(textPane.getSelectedText());
				try {
					IHospede tmp = hospedeMap.get(list.getSelectedValue().toString());
					StringBuilder Builder = new StringBuilder();

					Builder.append("Nome:   ").append(tmp.getNome()).append("\n")
							.append("CPF:    ").append(tmp.getCpf()).append("\n")
							.append("Email:  ").append(tmp.getEmail()).append("\n");

					previewArea.setText(Builder.toString());
				}
				catch (NullPointerException n){
					System.out.println("Selection is NULL");
				}
			}
		});

		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditarHospedeView frame = new EditarHospedeView(mainController, (Hospede) hospedeMap.get(list.getSelectedValue().toString()));
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				values = new DefaultListModel();
				hospedeMap.clear();
				stringsToSort = new ArrayList<>();
				for (IHospede h: cadastro.getHospedes()) {
					String key = "(" + cadastro.getHospedagem(h).getNumeroQuarto() + ") " + h.getNome();
					System.out.println(key);
					stringsToSort.add(key);
					hospedeMap.put(key, h);
				}

				java.util.Collections.sort(stringsToSort);
				values.addAll(stringsToSort);

				list.setModel(values);
				list.setSelectedIndex(0);
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
	}
}
