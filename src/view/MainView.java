package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.MainController;
import controller.Serializer;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainView extends JFrame {
	private MainController mainController;
	/**
	 * Create the frame.
	 */
	public MainView(MainController mc) {
		this.mainController = mc;

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
		setBounds(100, 100, 481, 470);
		getContentPane().setLayout(null);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(685, 281, 89, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Hotel California");
		lblNewLabel.setFont(new Font("Unispace", Font.BOLD, 24));
		lblNewLabel.setBounds(0, 21, 467, 52);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);;
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Check In");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SelecionarQuartoView frame = new SelecionarQuartoView(mainController);
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
		
		JButton btnNewButton_2 = new JButton("Lista Hospedes");
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
		
		JButton btnNewButton_3 = new JButton("Restaurante");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SelecionarHospedeView frame = new SelecionarHospedeView(mainController, 2);
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
		
		JButton btnNewButton_4 = new JButton("Check out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							SelecionarHospedeView frame = new SelecionarHospedeView(mainController, 1);
							frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_4.setBounds(10, 304, 447, 52);
		getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5_1 = new JButton("Sair");
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Serializer.save();
				dispose();
			}
		});
		btnNewButton_5_1.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton_5_1.setBounds(10, 367, 447, 52);
		getContentPane().add(btnNewButton_5_1);
	}
}
