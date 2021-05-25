package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroHospedeView extends JFrame {

	private JPanel contentPane;
	private JTextField nome;
	private JTextField email;
	private JLabel lblTelefone;
	private JTextField telefone;
	private JLabel lblCpf;
	private JTextField cpf;
	private JLabel lblNumero;
	private JTextField numero;
	private JLabel lblBairro;
	private JTextField bairro;
	private JLabel lblUf;
	private JTextField cidade;
	private JButton btnNewButton;
	private JTextField endereco;
	
	CadastroController cadastro;

	/**
	 * Launch the application.
	 */
	public static void main(CadastroController cd) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroHospedeView frame = new CadastroHospedeView(cd);
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
	public CadastroHospedeView(CadastroController cd) {
		this.cadastro = cd;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 60, 25);
		contentPane.add(lblNewLabel);
		
		nome = new JTextField();
		nome.setBounds(91, 13, 381, 20);
		contentPane.add(nome);
		nome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 47, 60, 25);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(91, 49, 381, 20);
		contentPane.add(email);
		
		lblTelefone = new JLabel("Telefone");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setBounds(10, 83, 60, 25);
		contentPane.add(lblTelefone);
		
		telefone = new JTextField();
		telefone.setColumns(10);
		telefone.setBounds(91, 85, 381, 20);
		contentPane.add(telefone);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setBounds(10, 119, 60, 25);
		contentPane.add(lblCpf);
		
		cpf = new JTextField();
		cpf.setColumns(10);
		cpf.setBounds(91, 121, 381, 20);
		contentPane.add(cpf);
		
		lblNumero = new JLabel("Numero");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(10, 191, 60, 25);
		contentPane.add(lblNumero);
		
		numero = new JTextField();
		numero.setColumns(10);
		numero.setBounds(91, 193, 72, 20);
		contentPane.add(numero);
		
		lblBairro = new JLabel("Bairro");
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		lblBairro.setBounds(185, 191, 60, 25);
		contentPane.add(lblBairro);
		
		bairro = new JTextField();
		bairro.setColumns(10);
		bairro.setBounds(255, 193, 217, 20);
		contentPane.add(bairro);
		
		lblUf = new JLabel("U.F.");
		lblUf.setHorizontalAlignment(SwingConstants.CENTER);
		lblUf.setBounds(10, 227, 60, 25);
		contentPane.add(lblUf);
		
		JComboBox uf = new JComboBox();
		uf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		uf.setBounds(91, 224, 72, 22);
		contentPane.add(uf);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		lblCidade.setBounds(185, 227, 60, 25);
		contentPane.add(lblCidade);
		
		cidade = new JTextField();
		cidade.setColumns(10);
		cidade.setBounds(255, 224, 217, 20);
		contentPane.add(cidade);
		
		btnNewButton = new JButton("CADASTRAR");
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(10, 263, 462, 61);
		contentPane.add(btnNewButton);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereco.setBounds(10, 155, 60, 25);
		contentPane.add(lblEndereco);
		
		endereco = new JTextField();
		endereco.setColumns(10);
		endereco.setBounds(91, 157, 381, 20);
		contentPane.add(endereco);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastro.novosHospedes -= 1;
				cadastro.createHospede(nome.getText(), email.getText(), cpf.getText(), telefone.getText(), endereco.getText(), bairro.getText(), cidade.getText(), (String) uf.getSelectedItem());

				JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
				if(cadastro.novosHospedes == 0){
					cadastro.createHospedagem();
					dispose();
				}

				nome.setText("");
				email.setText("");
				cpf.setText("");
				telefone.setText("");
				endereco.setText("");
				bairro.setText("");
				cidade.setText("");
				uf.setSelectedIndex(0);
			}
		});
	}
}
