package concert;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

//import db.SignUpDAO;
//import db.SignUpVO;

import java.awt.Color;
import java.awt.Component;
import java.awt.Checkbox;
import java.awt.Button;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.List;
import javax.swing.SwingConstants;

import db.MemberDAO;
import db.MemberVO;
import concert.CalendarTicket;

import java.awt.Font;
import java.awt.GridLayout;

public class ConcertSignUp {
	private JFrame frame;
	private MemberDAO dao;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public ConcertSignUp(MemberVO vo) {
		initialize(vo);
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberVO vo) {
		dao = new MemberDAO();
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		TextField namefield = new TextField();
		namefield.setBounds(259, 128, 230, 23);
		frame.getContentPane().add(namefield);

		TextField idfield = new TextField();
		idfield.setBounds(259, 162, 230, 23);
		frame.getContentPane().add(idfield);

		TextField pwdfield = new TextField();
		pwdfield.setBounds(259, 193, 230, 23);
		frame.getContentPane().add(pwdfield);

		TextField pwd1field = new TextField();
		pwd1field.setBounds(259, 222, 230, 23);
		frame.getContentPane().add(pwd1field);

		TextField emailfield = new TextField();
		emailfield.setBounds(259, 263, 230, 23);
		frame.getContentPane().add(emailfield);

		TextField telfield = new TextField();
		telfield.setBounds(259, 300, 230, 23);
		frame.getContentPane().add(telfield);

		JLabel lblNewLabel_1 = new JLabel(
				"\uB9CC 14\uC138 \uBBF8\uB9CC \uD68C\uC6D0\uC740 \uBC95\uC815\uB300\uB9AC\uC778(\uBD80\uBAA8\uB2D8) \uB3D9\uC758\uB97C \uBC1B\uC740\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(179, 378, 310, 23);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel(
				"\uACBD\uC6B0\uB9CC \uD68C\uC6D0\uAC00\uC785\uC774 \uAC00\uB2A5\uD569\uB2C8\uB2E4.");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(169, 397, 320, 15);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel name_lblNewLabel = new JLabel("\uC774\uB984");
		name_lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		name_lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		name_lblNewLabel.setBounds(189, 128, 56, 23);
		frame.getContentPane().add(name_lblNewLabel);

		JLabel id_lblNewLabel = new JLabel("\uC544\uC774\uB514");
		id_lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		id_lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		id_lblNewLabel.setBounds(178, 162, 67, 23);
		frame.getContentPane().add(id_lblNewLabel);

		JLabel pwd_lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638");
		pwd_lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwd_lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		pwd_lblNewLabel.setBounds(161, 193, 84, 23);
		frame.getContentPane().add(pwd_lblNewLabel);

		JLabel pwd1_lblNewLabel = new JLabel("\uBE44\uBC00\uBC88\uD638 \uD655\uC778");
		pwd1_lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		pwd1_lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		pwd1_lblNewLabel.setBounds(133, 226, 112, 23);
		frame.getContentPane().add(pwd1_lblNewLabel);

		JLabel email_lblNewLabel = new JLabel("\uC774\uBA54\uC77C");
		email_lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		email_lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		email_lblNewLabel.setBounds(178, 263, 67, 23);
		frame.getContentPane().add(email_lblNewLabel);

		JLabel tel_lblNewLabel = new JLabel("\uD734\uB300\uD3F0");
		tel_lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		tel_lblNewLabel.setFont(new Font("����", Font.BOLD, 15));
		tel_lblNewLabel.setBounds(178, 300, 67, 23);
		frame.getContentPane().add(tel_lblNewLabel);

		JButton Backbtn = new JButton("Back");
		Backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Login().getFrame().setVisible(true);
			}
		});
		Backbtn.setBounds(10, 10, 76, 33);
		frame.getContentPane().add(Backbtn);

		JButton signupbtn = new JButton("\uAC00 \uC785 \uC644 \uB8CC");
		signupbtn.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\가입완료.png"));
		signupbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberVO vo = new MemberVO(namefield.getText(), idfield.getText(), pwdfield.getText(),
						emailfield.getText(), telfield.getText(), null);
				if (idfield.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "아이디를 입력해주세요.");
				} else if (pwdfield.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "비밀번호를 입력해주세요.");
				} else if (!pwdfield.getText().equals(pwd1field.getText())) {
					JOptionPane.showMessageDialog(frame, "비밀번호가 다릅니다.");
				} else if (idfield.getText().length() > 30) {
					JOptionPane.showMessageDialog(frame, "30자 이내로 입력해주세요.");
				} else if (emailfield.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "이메일을 입력해주세요.");
				} else if (telfield.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "핸드폰 번호를 입력해주세요.");
				} else {
					boolean b = dao.SignUp(vo);
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
					frame.dispose();
					new Login().getFrame().setVisible(true);
				}
			}
		});

		signupbtn.setBounds(169, 419, 320, 33);
		frame.getContentPane().add(signupbtn);

		JRadioButton rdbtnNewRadioButton = new JRadioButton(
				"SMS, \uC774\uBA54\uC77C\uB85C \uC0C1\uD488 \uBC0F \uC774\uBCA4\uD2B8 \uC815\uBCF4\uB97C \uBC1B\uACA0\uC2B5\uB2C8\uB2E4.(\uC120\uD0DD)");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "SMS, 이메일로 상품 및 이벤트 정보를 받는 데에 동의하였습니다.");
			}
		});
		rdbtnNewRadioButton.setBackground(Color.WHITE);
		rdbtnNewRadioButton.setBounds(169, 329, 335, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\uB9CC 14\uC138 \uBBF8\uB9CC\uC774\uB2E4.");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"만 14세 미만 법정대리인(부모님) 동의를 받은 경우만 회원가입이 가능합니다.");
			}
		});
		rdbtnNewRadioButton_1.setBackground(Color.WHITE);
		rdbtnNewRadioButton_1.setBounds(169, 349, 320, 23);
		frame.getContentPane().add(rdbtnNewRadioButton_1);

		JButton btnNewButton = new JButton("중복확인");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 10));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (idfield.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "아이디를 입력해주세요.");
				} else if (!pwdfield.getText().equals(pwd1field.getText())) {
					JOptionPane.showMessageDialog(frame, "비밀번호가 다릅니다.");
				} else if (idfield.getText().length() > 30) {
					JOptionPane.showMessageDialog(frame, "30자 이내로 입력해주세요.");
				} else if (emailfield.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "이메일을 입력해주세요.");
				} else if (telfield.getText().equals("")) {
					JOptionPane.showMessageDialog(frame, "핸드폰 번호를 입력해주세요.");
				} else {
					System.out.println(namefield.getText());
					System.out.println(idfield.getText());
					System.out.println(pwdfield.getText());
					System.out.println(pwd1field.getText());
					System.out.println(emailfield.getText());
					System.out.println(telfield.getText());

				}
				MemberVO vo = new MemberVO(idfield.getText());
				boolean b = dao.IDCheck(vo);
				if (b == true) {
					JOptionPane.showMessageDialog(frame, "중복된 아이디 입니다.");
				} else {
					JOptionPane.showMessageDialog(frame, "사용 가능한 아이디 입니다.");
				}

			}
		});
		btnNewButton.setBounds(495, 162, 78, 23);
		frame.getContentPane().add(btnNewButton);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("G:\\\uB0B4 \uB4DC\uB77C\uC774\uBE0C\\Work\\2.jpg"));
		lblNewLabel.setBounds(0, 0, 660, 540);
		frame.getContentPane().add(lblNewLabel);
	}
}
