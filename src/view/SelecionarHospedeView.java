package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.CadastroController;
import controller.MainController;
import controller.QuartoController;
import model.Hospedagem;
import model.IHospede;
import model.IQuarto;

public class SelecionarHospedeView extends JFrame {

	private final QuartoController quartoController;
	private JPanel contentPane;
	private CadastroController cadastroController;
	private HashMap<Integer, IQuarto> hospedeMap = new HashMap<>();

	/**
	 * Create the frame.
	 */
	public SelecionarHospedeView(MainController mainController, Integer next) {
		setResizable(false);
		cadastroController = mainController.cadastro;
		quartoController = mainController.quarto;
		
		DefaultListModel values = new DefaultListModel();
		for (IQuarto h: quartoController.getQuartosOcupados()) {
			Integer key = h.getNumero();
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
		list.setBounds(10, 41, 275, 418);
		list.setModel(values);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);

		DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton confirmaButton = new JButton("Escolher");
		confirmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IQuarto tmp = hospedeMap.get((Integer) list.getSelectedValue());
				Hospedagem hospedagem = cadastroController.getHospedagem(tmp);
				if(next.equals(1)){
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								CheckOutView frame = new CheckOutView(mainController, hospedagem);
								frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
				else if (next.equals(2)){
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
				dispose();
			}
		});
		confirmaButton.setBounds(10, 470, 275, 33);
		contentPane.add(confirmaButton);
		
		JLabel lblNewLabel = new JLabel("Selecione um quarto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 16, 275, 14);
		contentPane.add(lblNewLabel);
	}

}
