package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;

public class CadastroHospedeView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblTelefone;
	private JTextField textField_2;
	private JLabel lblCpf;
	private JTextField textField_3;
	private JLabel lblNumero;
	private JTextField textField_4;
	private JLabel lblBairro;
	private JTextField textField_5;
	private JLabel lblUf;
	private JTextField textField_6;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroHospedeView frame = new CadastroHospedeView();
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
	public CadastroHospedeView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 60, 25);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(91, 13, 381, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 47, 60, 25);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(91, 49, 381, 20);
		contentPane.add(textField_1);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setBounds(10, 83, 60, 25);
		contentPane.add(lblTelefone);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(91, 85, 381, 20);
		contentPane.add(textField_2);
		
		lblCpf = new JLabel("Endere\u00E7o");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(10, 119, 60, 25);
		contentPane.add(lblCpf);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(91, 121, 381, 20);
		contentPane.add(textField_3);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(10, 155, 60, 25);
		contentPane.add(lblNumero);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(91, 157, 72, 20);
		contentPane.add(textField_4);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setBounds(185, 155, 60, 25);
		contentPane.add(lblBairro);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(255, 157, 217, 20);
		contentPane.add(textField_5);
		
		lblUf = new JLabel("U.F.");
		lblUf.setHorizontalAlignment(SwingConstants.CENTER);
		lblUf.setBounds(10, 191, 60, 25);
		contentPane.add(lblUf);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		comboBox.setBounds(91, 188, 72, 22);
		contentPane.add(comboBox);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setBounds(185, 191, 60, 25);
		contentPane.add(lblCidade);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(255, 188, 217, 20);
		contentPane.add(textField_6);
		
		btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(10, 227, 462, 61);
		contentPane.add(btnNewButton);
	}
}
