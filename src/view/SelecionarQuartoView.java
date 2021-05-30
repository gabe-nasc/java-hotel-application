package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import com.sun.tools.javac.Main;
import controller.CadastroController;
import controller.MainController;
import controller.QuartoController;
import model.IQuarto;

public class SelecionarQuartoView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1286527722409819839L;
	private JPanel contentPane;
	private CadastroController cadastroController;
	private QuartoController quartoController;
	private JTable table;
	private DefaultTableModel dtm;
	private JLabel lblDias;
	private JSpinner numeroDias;
	private JComboBox categoriaQuarto;
	private JSpinner numeroDeHospedes;
	private JLabel lblNewLabel;
	private JButton iniciaCadastro;

	public SelecionarQuartoView(MainController mainController) {
		setResizable(false);
		cadastroController = mainController.getCadastro();
		quartoController = mainController.getQuarto();
		dtm = new DefaultTableModel();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 428, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Hospedes");
		lblNewLabel.setBounds(10, 11, 58, 31);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);

		iniciaCadastro = new JButton("OK");
		iniciaCadastro.setBounds(10, 444, 388, 49);
		contentPane.add(iniciaCadastro);

		numeroDeHospedes = new JSpinner();

		numeroDeHospedes.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		numeroDeHospedes.setBounds(78, 16, 42, 20);
		contentPane.add(numeroDeHospedes);

		categoriaQuarto = new JComboBox();
		categoriaQuarto.setModel(new DefaultComboBoxModel(quartoController.getNomeCategorias().toArray()));
		categoriaQuarto.setBounds(267, 15, 131, 22);
		contentPane.add(categoriaQuarto);
		
		table = new JTable();
		table.setShowVerticalLines(false);

		dtm.setColumnIdentifiers(new String[] {"Numero", "Vagas"});
		for (IQuarto qt: quartoController.getQuartosDisponiveis((String) categoriaQuarto.getSelectedItem())) {
			dtm.addRow(new Object[]{qt.getNumero(), qt.getQtdVagas()});
		}

		table.setModel(dtm);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBounds(10, 52, 388, 381);
		contentPane.add(table);

		numeroDias = new JSpinner();
		numeroDias.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		numeroDias.setBounds(215, 16, 42, 20);
		contentPane.add(numeroDias);
		

		lblDias = new JLabel("Dias");
		lblDias.setHorizontalAlignment(SwingConstants.CENTER);
		lblDias.setBounds(147, 11, 58, 31);
		contentPane.add(lblDias);


		numeroDeHospedes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				refreshQuartos();
			}
		});

		categoriaQuarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshQuartos();
			}
		});


		iniciaCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openCadastroHospedeView(mainController);
				dispose();
			}
		});
	}

	private void refreshQuartos(){
		dtm = new DefaultTableModel(0, 0);
		dtm.setColumnIdentifiers(new String[] {"Numero", "Vagas"});
		for (IQuarto qt: quartoController.getQuartosDisponiveis((String) categoriaQuarto.getSelectedItem())) {
			if (qt.getQtdVagas() >= (Integer) numeroDeHospedes.getValue()){
				dtm.addRow(new Object[]{qt.getNumero(), qt.getQtdVagas()});
			}
		}
		table.setModel(dtm);
	}

	private void openCadastroHospedeView(MainController mainController){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Integer rowIndex = table.getSelectedRow();
				if (rowIndex == -1){
					JOptionPane.showMessageDialog(null, "Nenhum quarto foi selecionado!");
					return;
				}
				Integer numeroQuarto = (Integer) table.getValueAt(rowIndex, 0);

				try {
					CadastroHospedeView frame = new CadastroHospedeView(mainController, numeroQuarto, (String) categoriaQuarto.getSelectedItem(), (Integer) numeroDias.getValue(), (Integer) numeroDeHospedes.getValue());
					frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
