import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertxt;
	private JTextField passtxt;
	private JTextField repasstxt;

	/**
	 * Launch the application.
	 */

	
	public void regist() throws IOException{ //Register method
		
	String file = "src/data/Admin.txt";
		
        String user, pass;
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
     
        user = usertxt.getText();
        pass = passtxt.getText();
        
        if (usertxt.getText().equals("")) {
        	JOptionPane.showMessageDialog(null, "Please fill the username");
        }
        else if (passtxt.getText().equals("")) {
        	JOptionPane.showMessageDialog(null, "Please fill the password");
        }
        else if (!passtxt.getText().equals(repasstxt.getText())){
        	JOptionPane.showMessageDialog(null, "Password is not match");
        }
        else {
        	bw.write(user + "," + pass);
            bw.flush();
            bw.newLine();
            bw.close();
            
            JOptionPane.showMessageDialog(null, "Data has been added");
        }
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
		setTitle("Register");
		setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userlbl = new JLabel("Username");
		userlbl.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 14));
		userlbl.setBounds(54, 92, 64, 17);
		contentPane.add(userlbl);
		
		JLabel passlbl = new JLabel("Password");
		passlbl.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 14));
		passlbl.setBounds(54, 128, 64, 14);
		contentPane.add(passlbl);
		
		usertxt = new JTextField();
		usertxt.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		usertxt.setBounds(168, 88, 217, 23);
		contentPane.add(usertxt);
		usertxt.setColumns(10);
		
		passtxt = new JTextField();
		passtxt.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		passtxt.setColumns(10);
		passtxt.setBounds(168, 123, 217, 23);
		contentPane.add(passtxt);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login log = new Login(); //calling login form
                log.setVisible(true); //show the login form
                this.dispose();//close the register form
			}
		});
		btnLogin.setBounds(298, 201, 87, 27);
		contentPane.add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					regist(); //Calling Register method
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		});
		btnRegister.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 13));
		btnRegister.setBounds(168, 201, 111, 27);
		contentPane.add(btnRegister);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 434, 50);
		contentPane.add(panel);
		
		JLabel tittle = new JLabel("Rumah Makan Borneo");
		panel.add(tittle);
		tittle.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 28));
		
		repasstxt = new JTextField();
		repasstxt.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
		repasstxt.setColumns(10);
		repasstxt.setBounds(168, 157, 217, 23);
		contentPane.add(repasstxt);
		
		JLabel repasslbl = new JLabel("Re-Password");
		repasslbl.setFont(new Font("JetBrains Mono Medium", Font.PLAIN, 14));
		repasslbl.setBounds(54, 162, 96, 14);
		contentPane.add(repasslbl);
	}
}
