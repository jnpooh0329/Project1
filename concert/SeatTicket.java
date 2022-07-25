package concert;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.MemberDAO;
import db.MemberVO;

public class SeatTicket {

	private JFrame frame;
	private MemberDAO dao;
	Color Color1 = new Color(139, 0, 255);

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public SeatTicket(MemberVO vo) {
		initialize(vo);
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	int i = 0, j = 0;
	private JTextField textField;

	private void initialize(MemberVO vo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		textField = new JTextField();
		textField.setBounds(509, 387, 132, 21);
		panel.add(textField);
		textField.setColumns(10);

		JButton[][] btn = new JButton[25][20];

		for (i = 0; i < btn.length; i++) {
			for (j = 0; j < btn[i].length; j++) {
				btn[i][j] = new JButton();

				btn[i][j].setBackground(Color.LIGHT_GRAY);
				btn[i][j].setBounds(80 + (i * 15), 121 + (j * 15), 10, 10);
				panel.add(btn[i][j]);
				
				btn[i][j].addMouseListener(new MouseAdapter() {
					boolean flag = false; // ��ư�� on/off����
					int x = i + 1, y = j + 1;

					@Override
					public void mousePressed(MouseEvent e) {
						JButton btn = (JButton) e.getSource();
						flag = !flag;
						if (flag == true) {
							btn.setBackground(Color.LIGHT_GRAY);
							textField.setText("E1 " + y + "열 " + x);
						} else {
							btn.setBackground(Color1);

						}
					}
				});
			}
		}
		
		JButton nextbtn = new JButton("\uC88C\uC11D \uC120\uD0DD \uC644\uB8CC >");
		nextbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MemberVO vo = new MemberVO(textField.getText());
				vo.setSeat(textField.getText());
				vo.setName("Concert");
				vo.setPrice("121,000원");
				frame.dispose();
				new Check6(vo).getFrame().setVisible(true);
			}
		});
		nextbtn.setFont(new Font("����", Font.BOLD, 12));
		nextbtn.setBounds(492, 445, 160, 27);
		panel.add(nextbtn);
		
		JButton btnNewButton_1 = new JButton("< \uC774\uC804 \uB2E8\uACC4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Seat(vo).getFrame().setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 12));
		btnNewButton_1.setBounds(522, 477, 105, 27);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\seatTicket1.jpg"));
		lblNewLabel.setBounds(0, 0, 660, 540);
		panel.add(lblNewLabel);
		

	}
}
