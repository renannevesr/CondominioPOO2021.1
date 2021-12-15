package Screens;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JDesktopPane;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import java.awt.Cursor;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

public class Login_Frame extends JFrame {
	private JTextField txtUsurio;
	private JPasswordField pwdSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Frame frame = new Login_Frame();
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
	public Login_Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 500, 700, 500);
//		setContentPane(contentPane);
		setUndecorated(false);
		getContentPane().setLayout(null);
		
		JPanel welcome = new JPanel();
		welcome.setBackground(new Color(51, 255, 204));
		welcome.setBounds(0, -20, 300, 500);
		getContentPane().add(welcome);
		welcome.setLayout(null);
		
		JPanel Title = new JPanel();
		Title.setBackground(new Color(51, 255, 204));
		Title.setBounds(71, 110, 183, 52);
		welcome.add(Title);
		
		JLabel lblBemVindo = new JLabel("Bem vindo!");
		Title.add(lblBemVindo);
		lblBemVindo.setFont(new Font("Fira Code Retina", Font.BOLD, 24));
		lblBemVindo.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel Icon = new JPanel();
		Icon.setBackground(new Color(51, 255, 204));
		Icon.setBounds(43, 178, 233, 238);
		welcome.add(Icon);
		
		JLabel label = new JLabel("");
		label.setBackground(Color.GREEN);
		label.setIcon(new ImageIcon(Login_Frame.class.getResource("/assets/apartament-icon.png")));
		Icon.add(label);
		
		JPanel login_form = new JPanel();
		login_form.setBackground(Color.WHITE);
		login_form.setBounds(300, -20, 400, 500);
		getContentPane().add(login_form);
		login_form.setLayout(null);
		
		JPanel form_input = new JPanel();
		form_input.setBackground(Color.WHITE);
		form_input.setBounds(60, 179, 293, 153);
		login_form.add(form_input);
		form_input.setLayout(null);
		
		JPanel user_input = new JPanel();
		user_input.setBackground(Color.LIGHT_GRAY);
		user_input.setBounds(23, 12, 245, 54);
		form_input.add(user_input);
		user_input.setLayout(null);
		
		txtUsurio = new JTextField();
		txtUsurio.setBounds(12, 12, 157, 31);
		txtUsurio.setText("Usuário");
		user_input.add(txtUsurio);
		txtUsurio.setColumns(10);
		
		JPanel user_icon = new JPanel();
		user_icon.setBackground(Color.LIGHT_GRAY);
		user_icon.setBounds(181, 0, 64, 54);
		user_input.add(user_icon);
		user_icon.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(12, 12, 30, 34);
		label_1.setIcon(new ImageIcon(Login_Frame.class.getResource("/assets/user_icon.png")));
		user_icon.add(label_1);
		
		JPanel password_input = new JPanel();
		password_input.setBackground(Color.LIGHT_GRAY);
		password_input.setBounds(23, 89, 245, 52);
		form_input.add(password_input);
		password_input.setLayout(null);
		
		JPanel password_icon = new JPanel();
		password_icon.setBackground(Color.LIGHT_GRAY);
		password_icon.setBounds(179, 0, 66, 54);
		password_input.add(password_icon);
		password_icon.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(12, 12, 30, 34);
		label_2.setIcon(new ImageIcon(Login_Frame.class.getResource("/assets/lock_icon.png")));
		password_icon.add(label_2);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBounds(12, 12, 158, 35);
		password_input.add(pwdSenha);
		pwdSenha.setText("Senha");
		
		JPanel login_button = new JPanel();
		login_button.setBackground(Color.WHITE);
		login_button.setBounds(132, 361, 152, 49);
		login_form.add(login_button);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setMaximumSize(new Dimension(150, 75));
		btnLogin.setBackground(new Color(51, 255, 204));
		login_button.add(btnLogin);
		
		JPanel form_title = new JPanel();
		form_title.setBackground(Color.WHITE);
		form_title.setBounds(73, 118, 265, 49);
		login_form.add(form_title);
		
		JLabel lblLogin = new JLabel("Login de usuário");
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 26));
		form_title.add(lblLogin);
	}
}