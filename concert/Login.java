package concert;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import db.MemberDAO;
import db.MemberVO;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Button;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login {
	
	private JFrame frame;
	private JTextField idtxtField;
	private JPasswordField pwdtxtField;
	private MemberDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}
	
	public JFrame getFrame() {
		return frame;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		dao = new MemberDAO();

		frame = new JFrame();
		frame.setBounds(100, 100, 680, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel idLabel = new JLabel("\uC544\uC774\uB514");
		idLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		idLabel.setBounds(227, 333, 63, 22);
		frame.getContentPane().add(idLabel);

		JLabel pwLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwLabel.setBounds(227, 357, 63, 22);
		frame.getContentPane().add(pwLabel);

		idtxtField = new JTextField();
		idtxtField.setBounds(302, 334, 126, 21);
		frame.getContentPane().add(idtxtField);
		idtxtField.setColumns(10);

		pwdtxtField = new JPasswordField();
		pwdtxtField.setBounds(302, 358, 126, 22);
		frame.getContentPane().add(pwdtxtField);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(227, 387, 201, 22);
		frame.getContentPane().add(lblNewLabel_1);

		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(341, 414, 87, 28);
		loginbtn.setActionCommand("");
		loginbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idtxtField.getText().equals("")) {
					lblNewLabel_1.setText("ID를 입력해주세요.");
				} else if (pwdtxtField.getText().equals("")) {
					lblNewLabel_1.setText("Password를 입력해주세요.");
				} else {
					System.out.println(idtxtField.getText());
					System.out.println(pwdtxtField.getText());

					MemberVO vo = dao.list(idtxtField.getText(), pwdtxtField.getText());
					if(vo.getId()==null) {
						JOptionPane.showMessageDialog(frame, "잘못된 정보입니다.");
					}else {
						frame.dispose();
						new CalendarTicket(vo).getFrame().setVisible(true);
					}
				}
			}
		});

		frame.getContentPane().add(loginbtn);

		JButton signupbtn = new JButton("\uD68C\uC6D0\uAC00\uC785");
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new ConcertSignUp(null).getFrame().setVisible(true);
			}
		});
		signupbtn.setActionCommand("");
		signupbtn.setBounds(227, 414, 87, 28);
		frame.getContentPane().add(signupbtn);

		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("G:\\\uB0B4 \uB4DC\uB77C\uC774\uBE0C\\Work\\Login1.jpg"));
		lblNewLabel.setBounds(0, 0, 660, 540);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
}
