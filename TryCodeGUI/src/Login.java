import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertxt;
	private JTextField passtxt;
	private JFrame Login;

	/**
	 * Launch the application.
	 */

	
	public void login() throws IOException{ //Login Method & validation
		
		String file = "src/data/Admin.txt";
		
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        	boolean login = false;
			String record;
			while ((record = br.readLine()) != null){
			    String data[] = record.split(",");
			    if (usertxt.getText().equals(data[0]) && passtxt.getText().equals(data[1])){
			        JOptionPane.showMessageDialog(null, "Login Success \n Welcome " + usertxt.getText());
//			        login = true;
//                AdminMenu prod = new AdminMenu(usertxt.getText()); //calling product form
//                prod.setVisible(true); //show the product form
//                this.dispose(); //close the login form
			    }
			}
			if (usertxt.getText().equals("")) {
			    JOptionPane.showMessageDialog(null, "Please fill out the username");   
			}
			else if (passtxt.getText().equals("")) {
			    JOptionPane.showMessageDialog(null, "Please fill out the password");
			}
			else if(!login){
			    JOptionPane.showMessageDialog(null, "Wrong Username or Password !!", "Message", JOptionPane.ERROR_MESSAGE);
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userlbl = new JLabel("Username");
		userlbl.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 14));
		userlbl.setBounds(54, 91, 64, 17);
		contentPane.add(userlbl);
		
		JLabel passlbl = new JLabel("Password");
		passlbl.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 14));
		passlbl.setBounds(54, 138, 64, 14);
		contentPane.add(passlbl);
		
		usertxt = new JTextField();
		usertxt.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		usertxt.setBounds(168, 88, 217, 23);
		contentPane.add(usertxt);
		usertxt.setColumns(10);
		
		passtxt = new JTextField();
		passtxt.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		passtxt.setColumns(10);
		passtxt.setBounds(168, 135, 217, 23);
		contentPane.add(passtxt);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login(); //Calling login method
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(298, 191, 87, 27);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register reg = new Register(); //calling regist form
                reg.setVisible(true); //show the regist form
                Login.dispose(); //close the login form
				
			}
		});
		btnRegister.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 13));
		btnRegister.setBounds(168, 191, 111, 27);
		contentPane.add(btnRegister);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 434, 50);
		contentPane.add(panel);
		
		JLabel tittle = new JLabel("Rumah Makan Borneo");
		panel.add(tittle);
		tittle.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 28));
	}
}
