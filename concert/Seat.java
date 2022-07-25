package concert;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import concert.CalendarTicket;
import db.MemberVO;

import java.awt.Color;
import java.awt.Font;

public class Seat {

	private JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public Seat(MemberVO vo) {
		initialize(vo);
	}

	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(MemberVO vo) {
		frame = new JFrame();
		frame.setBounds(100, 100, 680, 580);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton ga_btn = new JButton("");
		ga_btn.setForeground(Color.WHITE);
		ga_btn.setBackground(Color.WHITE);
		ga_btn.setOpaque(true);
		ga_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SeatTicket(vo).getFrame().setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton("\uC88C\uC11D \uC120\uD0DD \uC644\uB8CC >");
		btnNewButton_1.setFont(new Font("����", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SeatTicket(vo).getFrame().setVisible(true);

			}
		});
		btnNewButton_1.setBounds(494, 443, 158, 27);
		panel.add(btnNewButton_1);

		ga_btn.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\ga.png"));
		ga_btn.setBounds(102, 158, 129, 101);
		panel.add(ga_btn);

		JButton na_btn = new JButton("");
		na_btn.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\ga.png"));
		na_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SeatTicket(vo).getFrame().setVisible(true);
			}
		});
		na_btn.setOpaque(true);
		na_btn.setForeground(Color.WHITE);
		na_btn.setBackground(Color.WHITE);
		na_btn.setBounds(257, 158, 129, 101);
		panel.add(na_btn);

		JButton da_btn = new JButton("");
		da_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SeatTicket(vo).getFrame().setVisible(true);
			}
		});
		da_btn.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\da.png"));
		da_btn.setOpaque(true);
		da_btn.setForeground(Color.WHITE);
		da_btn.setBackground(Color.WHITE);
		da_btn.setBounds(102, 279, 129, 101);
		panel.add(da_btn);

		JButton ra_btn = new JButton("");
		ra_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new SeatTicket(vo).getFrame().setVisible(true);
			}
		});
		ra_btn.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\da.png"));
		ra_btn.setOpaque(true);
		ra_btn.setForeground(Color.WHITE);
		ra_btn.setBackground(Color.WHITE);
		ra_btn.setBounds(257, 279, 129, 101);
		panel.add(ra_btn);

		JButton btnNewButton = new JButton("< \uC774\uC804 \uB2E8\uACC4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new CalendarTicket(vo).getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("����", Font.BOLD, 12));
		btnNewButton.setBounds(522, 478, 105, 23);
		panel.add(btnNewButton);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, 0, 660, 541);
		lblNewLabel.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\seat1.jpg"));
		panel.add(lblNewLabel);

	}
}
