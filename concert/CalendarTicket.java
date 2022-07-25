package concert;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.Window;
import java.awt.Canvas;
import javax.swing.JTable;
import com.toedter.calendar.JCalendar;

import db.MemberDAO;
import db.MemberVO;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class CalendarTicket {

	private JFrame frame;
	private MemberDAO dao;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public CalendarTicket(MemberVO vo) {
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

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JButton resbtn1 = new JButton("예 매 하 기");
		resbtn1.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\예매하기.png"));
		resbtn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Seat(vo).getFrame().setVisible(true);

			}
		});
		resbtn1.setBounds(83, 452, 503, 41);
		panel.add(resbtn1);

		UtilDateModel model = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(model);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
		datePicker.setBounds(76, 94, 510, 23);
		datePicker.setVisible(true);
		panel.add(datePicker);

		JButton strtime = new JButton("");
		strtime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vo.setDay(model.getYear() + "-" + (model.getMonth() + 1) + "-" + model.getDay());
				vo.setStarttime("15:00");
				boolean b = dao.CALENDAR(vo);
			}
		});
		strtime.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\start.png"));
		strtime.setBounds(105, 367, 126, 59);
		panel.add(strtime);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\3.jpg"));
		lblNewLabel.setBounds(0, 0, 664, 541);
		panel.add(lblNewLabel);

	}
}
