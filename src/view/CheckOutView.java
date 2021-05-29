package view;

import controller.CadastroController;
import controller.MainController;
import controller.QuartoController;
import model.ETipoPagamento;
import model.Hospedagem;
import model.IQuarto;
import model.ItemConta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.HashMap;
import java.awt.Font;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowEvent;

public class CheckOutView extends JFrame {

	private final MainController mainController;
	private final CadastroController cadastroController;
	private final QuartoController quartoController;
	private DefaultTableModel dtm;

	private JPanel contentPane;
	private JTable table;
	private JButton confirmaCheckOut;
	private JComboBox metodoPagamento;
	private JButton btnCancelar;

	private HashMap<Integer, ItemConta> rowToItem; // Mapeia a row em que cada item está
	private JButton removerItem;
	private JButton editarItem;
	private JButton reloadBttn;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;

	/**
	 * Create the frame.
	 */
	public CheckOutView(MainController mainController, Hospedagem hospedagem) {
		setResizable(false);
		this.mainController = mainController;
		this.cadastroController = mainController.cadastro;
		this.quartoController = mainController.quarto;

		this.dtm = new DefaultTableModel();
		this.rowToItem = new HashMap<>();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1000, 543);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setText(hospedagem.getResumoHospedagem());
		textArea.setBounds(10, 67, 300, 417);
		textArea.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(textArea);

		JLabel valorTotal = new JLabel("VALOR");
		valorTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		valorTotal.setHorizontalAlignment(SwingConstants.CENTER);
		valorTotal.setBounds(816, 78, 168, 54);
		contentPane.add(valorTotal);

		JLabel lblTotal = new JLabel("TOTAL:");
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTotal.setBounds(816, 30, 168, 54);
		contentPane.add(lblTotal);

		
		table = new JTable();

		resetTable(table, valorTotal, hospedagem);

		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		table.setBounds(320, 67, 486, 417);
		contentPane.add(table);
		
		confirmaCheckOut = new JButton("Check Out");
		confirmaCheckOut.setBounds(816, 378, 156, 32);
		contentPane.add(confirmaCheckOut);
		
		metodoPagamento = new JComboBox();
		metodoPagamento.setModel(new DefaultComboBoxModel(ETipoPagamento.values()));
		metodoPagamento.setBounds(816, 345, 156, 22);
		contentPane.add(metodoPagamento);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(816, 421, 156, 32);
		contentPane.add(btnCancelar);
		
		removerItem = new JButton("Remover Selecionado");
		removerItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (table.getSelectedRow() != -1) {
					hospedagem.removeItemConta(rowToItem.get(table.getSelectedRow()));
					resetTable(table, valorTotal, hospedagem);
				}
			}
		});
		removerItem.setBounds(816, 259, 156, 32);
		contentPane.add(removerItem);
		
		editarItem = new JButton("Editar Selecionado");
		editarItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditarItemContaView frame = new EditarItemContaView(mainController, rowToItem.get(table.getSelectedRow()));
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		editarItem.setBounds(816, 216, 156, 32);
		contentPane.add(editarItem);
		
		reloadBttn = new JButton("Recarregar Lista");
		reloadBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetTable(table, valorTotal, hospedagem);
			}
		});
		reloadBttn.setBounds(816, 302, 156, 32);
		contentPane.add(reloadBttn);
		
		lblNewLabel = new JLabel("Resumo Hospedagem");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 42, 300, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Conta do Restaurante");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(320, 17, 486, 14);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Nome                     Valor                              Quantidade                    Data");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(320, 42, 486, 14);
		contentPane.add(lblNewLabel_2);
		

		
		
		confirmaCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Date checkOut = new Date();

				hospedagem.setCheckOut(checkOut);
				hospedagem.setPagamento(hospedagem.getValorTotal(), (ETipoPagamento) metodoPagamento.getSelectedItem());
				hospedagem.liberaQuarto();
				cadastroController.deleteHospedagem(hospedagem.getNumero());
				JOptionPane.showMessageDialog(null, "Check-out realizado!");
				dispose();
			}
		});

		addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				resetTable(table, valorTotal, hospedagem);
			}
			public void windowLostFocus(WindowEvent e) {
			}
		});
	}

	private void resetTable(JTable table, JLabel valorTotal, Hospedagem hospedagem){
		dtm = new DefaultTableModel(0, 0);
		dtm.setColumnIdentifiers(new String[] {"Produto", "Valor", "Qtd", "Data"});
		rowToItem.clear();

		Integer n = 0;

		for (ItemConta item: hospedagem.getListaConta()) {
			dtm.addRow(new Object[]{item.getProduto().getNome(), item.getPreco(), item.getQtd(), item.getData()});
			rowToItem.put(n, item);
			n += 1;
		}

		table.setModel(dtm);

		valorTotal.setText("R$ " + String.valueOf(hospedagem.getValorTotal()));
	}
}
