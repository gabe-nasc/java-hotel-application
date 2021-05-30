package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.CadastroController;
import controller.MainController;
import controller.QuartoController;
import model.Hospedagem;
import model.IQuarto;

public class SelecionarHospedeView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2758819793432256658L;
	private final QuartoController quartoController;
	private JPanel contentPane;
	private CadastroController cadastroController;
	private HashMap<Integer, IQuarto> hospedeMap = new HashMap<>();
	private JLabel lblNewLabel;
	private JButton confirmaButton;
	private DefaultListCellRenderer renderer;
	private JList list;
	private DefaultListModel values;
	/**
	 * Create the frame.
	 */
	public SelecionarHospedeView(MainController mainController, Integer next) {
		setResizable(false);
		cadastroController = mainController.getCadastro();
		quartoController = mainController.getQuarto();

		values = new DefaultListModel();
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

		list = new JList(values);
		list.setFont(new Font("Tahoma", Font.PLAIN, 16));
		list.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		list.setBounds(10, 41, 275, 418);
		list.setModel(values);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		contentPane.add(list);

		renderer = (DefaultListCellRenderer) list.getCellRenderer();
		renderer.setHorizontalAlignment(SwingConstants.CENTER);

		confirmaButton = new JButton("Escolher");
		confirmaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IQuarto tmp = hospedeMap.get((Integer) list.getSelectedValue());
				Hospedagem hospedagem = cadastroController.getHospedagem(tmp);
				if(next.equals(1)){
					openCheckOut(mainController, hospedagem);
				}
				else if (next.equals(2)){
					openCriarPedido(mainController, hospedagem);
				}
				dispose();
			}
		});
		confirmaButton.setBounds(10, 470, 275, 33);
		contentPane.add(confirmaButton);
		

		lblNewLabel = new JLabel("Selecione um quarto");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 16, 275, 14);
		contentPane.add(lblNewLabel);
	}

	private void openCheckOut(MainController mainController, Hospedagem hospedagem){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOutView frame = new CheckOutView(mainController, hospedagem);
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
				}
			}
		});
	}

	private void openCriarPedido(MainController mainController, Hospedagem hospedagem){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CriarPedidoView frame = new CriarPedidoView(mainController, hospedagem);
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, e.getLocalizedMessage());
				}
			}
		});
	}
}
