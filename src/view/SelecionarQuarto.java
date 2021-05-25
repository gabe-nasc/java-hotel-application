package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class SelecionarQuarto extends JFrame {

	private JPanel contentPane;
//	CadastroController cd;

	/**
	 * Launch the application.
	 */
	public static void main(CadastroController cadastro) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelecionarQuarto frame = new SelecionarQuarto(cadastro);
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
	public SelecionarQuarto(CadastroController cadastro) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 90);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Numero de Hospedes");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 118, 31);
		contentPane.add(lblNewLabel);
		
		JButton iniciaCadastro = new JButton("OK");
		iniciaCadastro.setBounds(245, 15, 65, 23);
		contentPane.add(iniciaCadastro);
		
		JSpinner numeroDeHospedes = new JSpinner();
		numeroDeHospedes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				cadastro.setNovosHospedes((Integer) numeroDeHospedes.getValue());
			}
		});
		numeroDeHospedes.setBounds(138, 16, 42, 20);
		contentPane.add(numeroDeHospedes);

		iniciaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CadastroHospedeView frame = new CadastroHospedeView(cadastro);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				dispose();
			}
		});
	}
}
