package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.CadastroController;
import controller.MainController;
import model.Hospede;
import model.IHospede;

public class ListaHospedesView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1541600329239999558L;
	private JPanel contentPane;
	private CadastroController cadastro;
	private HashMap<String, IHospede> hospedeMap = new HashMap<>();
	private DefaultListModel values;
	private List<String> stringsToSort;
	private JButton goBackButton;
	private JTextArea previewArea;
	private JButton editButton;
	private JList list;

	/**
	 * Create the frame.
	 */
	public ListaHospedesView(MainController mainController) {
		cadastro = mainController.getCadastro();

		values = new DefaultListModel();
		stringsToSort = new ArrayList<>();
		for (IHospede h: cadastro.getHospedes()) {
			String key = "(" + cadastro.getHospedagem(h).getNumeroQuarto() + ") " + h.getNome();
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

		list = new JList(values);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setBounds(10, 11, 504, 448);
		list.setModel(values);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);

		editButton = new JButton("Editar");

		editButton.setBounds(524, 11, 268, 32);
		contentPane.add(editButton);

		previewArea = new JTextArea();
		previewArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		previewArea.setEditable(false);
		previewArea.setVisible(false);
		previewArea.setBounds(524, 190, 268, 269);
		previewArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(previewArea);
		

		goBackButton = new JButton("Sair");
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
				updatePreviewArea();
			}
		});

		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openEditView(mainController);
			}
		});

		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				refresh();
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
	}

	private void refresh(){
		values = new DefaultListModel();
		hospedeMap.clear();
		stringsToSort = new ArrayList<>();
		for (IHospede h: cadastro.getHospedes()) {
			String key = "(" + cadastro.getHospedagem(h).getNumeroQuarto() + ") " + h.getNome();
			stringsToSort.add(key);
			hospedeMap.put(key, h);
		}

		java.util.Collections.sort(stringsToSort);
		values.addAll(stringsToSort);

		list.setModel(values);
		list.setSelectedIndex(0);
	}

	private void openEditView(MainController mainController){
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

	private void updatePreviewArea(){
		previewArea.setVisible(true);

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
}
