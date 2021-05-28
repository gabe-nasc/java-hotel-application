package view;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import controller.CadastroController;
import controller.MainController;
import controller.QuartoController;
import model.IQuarto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class SelecionarQuartoView extends JFrame {

	private JPanel contentPane;
	private CadastroController cadastroController;
	private QuartoController quartoController;
	private JTable table;
	private DefaultTableModel dtm;

	public SelecionarQuartoView(MainController mainController) {
		setResizable(false);
		cadastroController = mainController.cadastro;
		quartoController = mainController.quarto;
		dtm = new DefaultTableModel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hospedes");
		lblNewLabel.setBounds(10, 11, 82, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton iniciaCadastro = new JButton("OK");
		iniciaCadastro.setBounds(10, 444, 300, 49);
		contentPane.add(iniciaCadastro);
		
		JSpinner numeroDeHospedes = new JSpinner();

		numeroDeHospedes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		numeroDeHospedes.setBounds(102, 16, 42, 20);
		contentPane.add(numeroDeHospedes);

		JComboBox categoriaQuarto = new JComboBox();
		categoriaQuarto.setModel(new DefaultComboBoxModel(quartoController.getNomeCategorias().toArray()));
		categoriaQuarto.setBounds(179, 15, 131, 22);
		contentPane.add(categoriaQuarto);
		
		table = new JTable();

		dtm.setColumnIdentifiers(new String[] {"Numero", "Vagas"});
		for (IQuarto qt: quartoController.getQuartosDisponiveis((String) categoriaQuarto.getSelectedItem())) {
			dtm.addRow(new Object[]{qt.getNumero(), qt.getQtdVagas()});
		}

		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBounds(10, 52, 300, 381);
		contentPane.add(table);


		numeroDeHospedes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				dtm = new DefaultTableModel(0, 0);
				dtm.setColumnIdentifiers(new String[] {"Numero", "Vagas"});
				for (IQuarto qt: quartoController.getQuartosDisponiveis((String) categoriaQuarto.getSelectedItem())) {
					if (qt.getQtdVagas() >= (Integer) numeroDeHospedes.getValue()){
						dtm.addRow(new Object[]{qt.getNumero(), qt.getQtdVagas()});
					}
				}
				table.setModel(dtm);
				cadastroController.setNovosHospedes((Integer) numeroDeHospedes.getValue());
			}
		});

		categoriaQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm = new DefaultTableModel(0, 0);
				dtm.setColumnIdentifiers(new String[] {"Numero", "Vagas"});
				for (IQuarto qt: quartoController.getQuartosDisponiveis((String) categoriaQuarto.getSelectedItem())) {
					if (qt.getQtdVagas() >= (Integer) numeroDeHospedes.getValue()){
						dtm.addRow(new Object[]{qt.getNumero(), qt.getQtdVagas()});
					}
				}

				table.setModel(dtm);
				cadastroController.setNovosHospedes((Integer) numeroDeHospedes.getValue());
			}
		});


		iniciaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							CadastroHospedeView frame = new CadastroHospedeView(cadastroController);
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
