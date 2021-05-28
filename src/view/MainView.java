package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import controller.CadastroController;

import com.jgoodies.forms.layout.FormSpecs;
import controller.MainController;
import controller.RestauranteController;
import controller.Serializer;

import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class MainView extends JFrame {
	/**
	 * Create the frame.
	 */
	public MainView(MainController mainController) {

		addWindowListener(new WindowAdapter()
		{
			@Override
			public void windowClosing(WindowEvent e)
			{
				System.out.println("Closed");
				Serializer.save();
				e.getWindow().dispose();
			}
		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 473, 537);
		getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(685, 281, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Hotel California");
		lblNewLabel.setFont(new Font("Unispace", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 21, 467, 52);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);;
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CADASTRAR HOSPEDE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SelecionarQuarto frame = new SelecionarQuarto(mainController);
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(10, 115, 447, 52);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("LISTAR HOSPEDES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							ListaHospedesView frame = new ListaHospedesView(mainController);
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_2.setBounds(10, 178, 447, 52);
		getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("RESTAURANTE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SelecionarHospedeView frame = new SelecionarHospedeView(mainController);
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});

		btnNewButton_3.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_3.setBounds(10, 241, 447, 52);
		getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CHECK OUT");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_4.setBounds(10, 304, 447, 52);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("LISTAR QUARTOS");
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_5.setBounds(10, 367, 447, 52);
		getContentPane().add(btnNewButton_5);
	}
}
