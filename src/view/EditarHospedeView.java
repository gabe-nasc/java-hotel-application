package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;
import controller.MainController;
import model.Endereco;
import model.Hospede;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditarHospedeView extends JFrame {

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

	private CadastroController cadastro;

	public EditarHospedeView(MainController mainController, Hospede original) {
		setResizable(false);
		this.cadastro = mainController.getCadastro();
		String old_cpf = original.getCpf();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 357);
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

		btnNewButton = new JButton("Concluir");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(267, 263, 205, 40);
		contentPane.add(btnNewButton);

		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereco.setBounds(10, 155, 60, 25);
		contentPane.add(lblEndereco);

		endereco = new JTextField();
		endereco.setColumns(10);
		endereco.setBounds(91, 157, 381, 20);
		contentPane.add(endereco);

		nome.setText(original.getNome());
		cpf.setText((original.getCpf()));
		email.setText(original.getEmail());
		telefone.setText(original.getTelefone());
		bairro.setText(original.getEndereco().getBairro());
		cidade.setText(original.getEndereco().getCidade().getNome());
		uf.setSelectedItem(original.getEndereco().getUf());
		endereco.setText(original.getEndereco().getLogradouro());
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCancelar.setBounds(20, 263, 205, 40);
		contentPane.add(btnCancelar);


		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				original.setCpf(cpf.getText());
				original.setEmail(email.getText());
				original.setNome(nome.getText());
				original.setTelefone(telefone.getText());
				original.setEndereco(new Endereco(bairro.getText(), cidade.getText(), endereco.getText(), (String) uf.getSelectedItem()));

				JOptionPane.showMessageDialog(null, "Hospede atualizado com sucesso!");

				dispose();
			}
		});
	}
}
