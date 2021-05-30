package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;
import controller.MainController;
import model.Endereco;
import model.Hospede;

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
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnCancelar;
	private JLabel lblEndereco;
	private JLabel lblCidade;
	private JComboBox uf;

	private CadastroController cadastro;

	public EditarHospedeView(MainController mainController, Hospede original) {
		setResizable(false);
		this.cadastro = mainController.getCadastro();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 357);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		lblNewLabel = new JLabel("Nome");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 60, 25);
		contentPane.add(lblNewLabel);

		nome = new JTextField();
		nome.setBounds(91, 13, 381, 20);
		contentPane.add(nome);
		nome.setColumns(10);


		lblNewLabel_1 = new JLabel("Email");
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
		cpf.setEditable(false);
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


		uf = new JComboBox();
		uf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RR", "RS", "SC", "SE", "SP", "TO"}));
		uf.setBounds(91, 224, 72, 22);
		contentPane.add(uf);

		lblCidade = new JLabel("Cidade");
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


		lblEndereco = new JLabel("Endere\u00E7o");
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
		numero.setText(String.valueOf(original.getEndereco().getNumero()));
		

		btnCancelar = new JButton("Cancelar");
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
				confirmEdit(original);
				dispose();
			}
		});
	}

	private void confirmEdit(Hospede original){
		if(nome.getText().isEmpty() || email.getText().isEmpty() || telefone.getText().isEmpty() || endereco.getText().isEmpty() || bairro.getText().isEmpty() || cidade.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Por favor, preencha todos os campos");
			return;
		}

		try {
			Integer.parseInt(numero.getText());
		}
		catch (NumberFormatException n) {
			JOptionPane.showMessageDialog(null,"Por favor, insira um numero valido");
			return;
		}

		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		if(!pattern.matcher(email.getText()).matches()){
			JOptionPane.showMessageDialog(null,"Por favor, insira um email valido\n Email Inserido: " + email.getText());
			return;
		}

		original.setEmail(email.getText());
		original.setNome(nome.getText());
		original.setTelefone(telefone.getText());
		original.setEndereco(new Endereco(bairro.getText(), cidade.getText(), endereco.getText(), (String) uf.getSelectedItem(), Integer.parseInt(numero.getText())));

		JOptionPane.showMessageDialog(null, "Hospede atualizado com sucesso!");
	}
}
