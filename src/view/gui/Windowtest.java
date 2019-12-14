package view.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Windowtest {

	private JFrame frame;
	private JTextField Username;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Windowtest window = new Windowtest();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Windowtest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 395);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWeddingClothesRental = new JLabel("Wedding Clothes Rental System ");
		lblWeddingClothesRental.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblWeddingClothesRental.setBounds(203, 13, 299, 62);
		frame.getContentPane().add(lblWeddingClothesRental);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(124, 127, 109, 48);
		frame.getContentPane().add(lblUsername);
		
		Username = new JTextField();
		Username.setBounds(214, 141, 212, 22);
		frame.getContentPane().add(Username);
		Username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(124, 176, 109, 48);
		frame.getContentPane().add(lblPassword);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(214, 188, 212, 22);
		frame.getContentPane().add(Password);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent event) 
					{
						if (Username.getText().isEmpty() || Password.getText().isEmpty())
						{
							JOptionPane.showMessageDialog(null, "Please enter username and password!");
						}
						else if(Username.getText().equals("admin")&& Password.getText().equals("123456"))
						{
							JOptionPane.showMessageDialog(null, "Log in success!");
							Object source = event.getSource();
							if(source == btnLogIn)
								new MainFrame();
						}
						else 
							JOptionPane.showMessageDialog(null, "Incorrect username and password!");
					}
				});
		btnLogIn.setBounds(329, 234, 97, 25);
		frame.getContentPane().add(btnLogIn);
	}
}
