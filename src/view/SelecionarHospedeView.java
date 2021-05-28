package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

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
import model.Hospedagem;
import model.Hospede;

public class SelecionarHospedeView extends JFrame {

	private JPanel contentPane;
	private CadastroController cadastro;
	private HashMap<String, Hospede> hospedeMap = new HashMap<>();

	/**
	 * Create the frame.
	 */
	public SelecionarHospedeView(MainController mainController) {
		cadastro = mainController.cadastro;
		
		DefaultListModel values = new DefaultListModel();
		for (Hospede h: cadastro.getHospedes()) {
			String key = h.getNome() + ' '  + h.getCpf();
			values.addElement(key);
			hospedeMap.put(key, h);
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 553);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList list = new JList(values);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setBounds(10, 11, 275, 448);
		list.setModel(values);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);
		
		JButton confirmaButton = new JButton("Escolher");
		confirmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Hospede tmp = hospedeMap.get(list.getSelectedValue().toString());
				Hospedagem hospedagem = cadastro.getHospedagem(tmp);

				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CriarPedidoView frame = new CriarPedidoView(mainController, hospedagem);
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		confirmaButton.setBounds(10, 470, 275, 33);
		contentPane.add(confirmaButton);
	}

}
