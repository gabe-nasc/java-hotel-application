package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class SelecionarQuarto extends JFrame {

	private JPanel contentPane;
	private JTextField numeroHospedes;
	private JTable quartosDisponiveis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecionarQuarto frame = new SelecionarQuarto();
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
	public SelecionarQuarto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de Hospedes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 118, 31);
		contentPane.add(lblNewLabel);
		
		numeroHospedes = new JTextField();
		numeroHospedes.setBounds(141, 16, 86, 20);
		contentPane.add(numeroHospedes);
		numeroHospedes.setColumns(10);
		
		quartosDisponiveis = new JTable();
		quartosDisponiveis.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		quartosDisponiveis.setColumnSelectionAllowed(true);
		quartosDisponiveis.setCellSelectionEnabled(true);
		quartosDisponiveis.setEnabled(false);
		quartosDisponiveis.setBounds(10, 235, 414, -170);
		contentPane.add(quartosDisponiveis);
	}
}
