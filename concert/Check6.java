package concert;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import com.toedter.calendar.JDateChooser;

import db.MemberDAO;
import db.MemberVO;

public class Check6 extends JFrame {

	private JFrame J_Frame;
	private JTextField name_text;
	private JTextField seat_text;
	private JTextField price_text;
	private JTable jTable1;
	protected JLabel dateChooser;
	private JTextField J_Text_Field;
	private JTextField J_Button1;
	private Component JPanel;
	private JComboBox comboBox_1;
	protected String Concertname;
	protected String Day;
	protected String Starttime;
	protected String Price;
	protected String Seat;
	protected Object rs;
	protected Statement st;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Check6(MemberVO vo) {
		initialize(vo);
	}

	public JFrame getFrame() {
		return J_Frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public Check6() {

		JPanel jPanel = new JPanel();
		jPanel.setLayout(null);

		Container container = new Container();
		container.add(JPanel);

//	      J_Frame.pack();
		J_Frame.setLocationRelativeTo(null);
		J_Frame.setVisible(true);
		J_Frame.setSize(680, 580);
		J_Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				J_Text_Field.setText(new DatePick2(J_Frame).Set_Picked_Date());
			}
		});
	}

	public void Check6() {
		JPanel panel = new JPanel();
		panel.setLayout(null);
		final JFrame J_Frame = new JFrame();
		J_Frame.getContentPane().add(panel);
	}

	private void initialize(MemberVO vo) {
		J_Frame = new JFrame();
		J_Frame.setBounds(100, 100, 680, 580);
		J_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel J_Panel = new JPanel();
		J_Frame.getContentPane().add(J_Panel, BorderLayout.CENTER);
		J_Panel.setLayout(null);

		JLabel name = new JLabel("Name");
		name.setFont(new Font("굴림", Font.PLAIN, 15));
		name.setBounds(65, 185, 90, 24);
		J_Panel.add(name);

		JLabel J_Label = new JLabel("Date");
		J_Label.setFont(new Font("굴림", Font.PLAIN, 15));
		J_Label.setBounds(65, 239, 90, 24);
		J_Panel.add(J_Label);

		JLabel starttime = new JLabel("StartTime");
		starttime.setFont(new Font("굴림", Font.PLAIN, 15));
		starttime.setBounds(65, 293, 90, 24);
		J_Panel.add(starttime);

		JLabel seat = new JLabel("Seat");
		seat.setFont(new Font("굴림", Font.PLAIN, 15));
		seat.setBounds(65, 348, 90, 24);
		J_Panel.add(seat);

		JLabel price = new JLabel("Price");
		price.setFont(new Font("굴림", Font.PLAIN, 15));
		price.setBounds(65, 404, 90, 24);
		J_Panel.add(price);

		name_text = new JTextField();
		name_text.setText(vo.getName());
		name_text.setBounds(175, 185, 116, 24);
		J_Panel.add(name_text);
		name_text.setColumns(10);

		J_Text_Field = new JTextField();
		J_Text_Field.setColumns(10);
		J_Text_Field.setBounds(175, 241, 116, 24);
		J_Panel.add(J_Text_Field);
		J_Frame.setLocationRelativeTo(null);
		J_Frame.setVisible(true);
		J_Frame.setSize(680, 580);
		
		
		seat_text = new JTextField();
		seat_text.setColumns(10);
		seat_text.setBounds(175, 348, 116, 24);
		seat_text.setText(vo.getSeat());
		J_Panel.add(seat_text);

		price_text = new JTextField();
		price_text.setText(vo.getPrice());
		price_text.setColumns(10);
		price_text.setBounds(175, 404, 116, 24);
		J_Panel.add(price_text);
		
		
		
		JButton J_Button1 = new JButton("날짜");
		J_Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				J_Text_Field.setText(new DatePick2(J_Frame).Set_Picked_Date());
			}
		});
		J_Button1.setBounds(110, 240, 65, 23);
		J_Panel.add(J_Button1);

		class DatePick2 {
			int DATE_MONTH = Calendar.getInstance().get(Calendar.MONTH);
			int DATE_YEAR = Calendar.getInstance().get(Calendar.YEAR);;
			JLabel J_Label = new JLabel("", JLabel.CENTER);
			String DATE_DAY = "";
			JDialog J_Dialog;
			JButton[] J_Button = new JButton[49];

			public DatePick2(JFrame J_Frame_Parent) {
				J_Dialog = new JDialog();
				J_Dialog.setModal(true);
				String[] Header = { "일", "월", "화", "수", "목", "금", "토" };
				JPanel J_Panel1 = new JPanel(new GridLayout(7, 7));
				J_Panel1.setPreferredSize(new Dimension(300, 300));

				for (int i = 0; i < J_Button.length; i++) {
					final int selection = i;
					J_Button[i] = new JButton();
					J_Button[i].setFocusPainted(false);
					J_Button[i].setBackground(Color.white);
					if (i > 6)
						J_Button[i].addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								DATE_DAY = J_Button[selection].getActionCommand();
								J_Dialog.dispose();
							}
						});
					if (i < 7) {
						J_Button[i].setText(Header[i]);
						if (i == 0) {
							J_Button[i].setForeground(Color.red);
						} else if (i == 6) {
							J_Button[i].setForeground(Color.blue);
						} else
							J_Button[i].setForeground(Color.black);
					}
					J_Panel1.add(J_Button[i]);
				}
				JPanel J_Panel2 = new JPanel(new GridLayout(1, 3));
				JButton Previous_Button = new JButton("<< Previous");
				Previous_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						DATE_MONTH--;
						Display_Date();
					}
				});
				J_Panel2.add(Previous_Button);
				J_Panel2.add(J_Label);
				JButton Next_Button = new JButton("Next >>");
				Next_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						DATE_MONTH++;
						Display_Date();
					}
				});
				J_Panel2.add(Next_Button);
				J_Dialog.add(J_Panel1, BorderLayout.CENTER);
				J_Dialog.add(J_Panel2, BorderLayout.SOUTH);
				J_Dialog.pack();
				J_Dialog.setLocationRelativeTo(J_Frame_Parent);
				Display_Date();
				J_Dialog.setVisible(true);
			}

			public void Display_Date() {
				for (int i = 7; i < J_Button.length; i++)
					J_Button[i].setText("");
				SimpleDateFormat Simple_Date_Format = new SimpleDateFormat("MMMM yyyy");
				Calendar Calendar = java.util.Calendar.getInstance();
				Calendar.set(DATE_YEAR, DATE_MONTH, 1);
				int Day_Of_Week = Calendar.get(java.util.Calendar.DAY_OF_WEEK);
				int Days_In_Month = Calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
				for (int i = 6 + Day_Of_Week, Day = 1; Day <= Days_In_Month; i++, Day++)
					J_Button[i].setText("" + Day);
				J_Label.setText(Simple_Date_Format.format(Calendar.getTime()));
				J_Dialog.setTitle("Date Picker");
			}

			public String Set_Picked_Date() {
				if (DATE_DAY.equals(""))
					return DATE_DAY;
				SimpleDateFormat Simple_Date_Format = new SimpleDateFormat("yyyy-MM-dd");
				Calendar Calendar = java.util.Calendar.getInstance();
				Calendar.set(DATE_YEAR, DATE_MONTH, Integer.parseInt(DATE_DAY));
				return Simple_Date_Format.format(Calendar.getTime());
			}
		}

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name_text.getText().equals("") || J_Text_Field.getText().equals("")
						|| comboBox_1.getSelectedItem().toString().equals("") || seat_text.getText().equals("")
						|| price_text.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "모든 데이터를 입력해주세요", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				} else {
					String data[] = { name_text.getText(), J_Text_Field.getText(),
							comboBox_1.getSelectedItem().toString(), seat_text.getText(), price_text.getText() };
					DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();

					tblModel.addRow(data);

					JOptionPane.showMessageDialog(null, "모든 데이터가 입력되었습니다", "INFORMATION_MESSAGE",
							JOptionPane.INFORMATION_MESSAGE);

					System.out.println(J_Text_Field.getText());
					MemberVO vo = new MemberVO(name_text.getText(), J_Text_Field.getText(),
							comboBox_1.getSelectedItem().toString(), seat_text.getText(), price_text.getText());
					new MemberDAO().CONCERT(vo);

				}
				DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##green",
							"green1234");
					st = con.createStatement();
				} catch (Exception e1) {
					System.out.println("데이터베이스 연결 오휴 : " + e1.getMessage());
				}
			}

			public boolean Check6(String concertname, String day, String starttime, String seat, String price) {
				try {
					String SQL = "SELECT * FROM CONCERT WHERE concertname = " + concertname + "and day = " + day
							+ "starttime = " + starttime + "seat = " + seat + "price = " + price;
					rs = st.executeQuery(SQL);
					if (((ResultSet) rs).next()) {
						return true;
					}
				} catch (Exception e1) {
					System.out.println("데이터베이스 검색 오휴 : " + e1.getMessage());
				}
				return false;
			}

		});
		btnAdd.setBounds(65, 449, 97, 23);
		J_Panel.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel) jTable1.getModel();
				if(jTable1.getSelectedRowCount()==1) {
					tblModel.removeRow(jTable1.getSelectedRow());
				}else {
					if(jTable1.getRowCount()==0) {
						JOptionPane.showMessageDialog(null, "테이블이 비었습니다.");
					}else {
						JOptionPane.showMessageDialog(null, "삭제할 행을 선택해주세요");
					}
				}
			}
		});
		btnDelete.setBounds(194, 449, 97, 23);
		J_Panel.add(btnDelete);

		JLabel lblNewLabel = new JLabel("예매 확인서");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 91, 226, 40);
		J_Panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(303, 185, 349, 243);
		J_Panel.add(scrollPane);

		jTable1 = new JTable();
		jTable1.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "콘서트 제목", "날짜", "시작 시간", "좌석", "금액" }));
		scrollPane.setViewportView(jTable1);

		comboBox_1 = new JComboBox();
		comboBox_1.addItem("15:00");
		comboBox_1.setMaximumRowCount(1);
		comboBox_1.setBounds(177, 294, 114, 23);
		J_Panel.add(comboBox_1);

		JButton Backbtn = new JButton("Back");
		Backbtn.setFont(new Font("굴림", Font.BOLD, 12));
		Backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_Frame.dispose();
				new SeatTicket(vo).getFrame().setVisible(true);
			}
		});
		Backbtn.setBounds(12, 10, 76, 33);
		J_Panel.add(Backbtn);

		JButton nextbtn = new JButton("Next");
		nextbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				J_Frame.dispose();
				new Check7(vo).getFrame().setVisible(true);
			}
		});
		nextbtn.setFont(new Font("굴림", Font.BOLD, 12));
		nextbtn.setBounds(576, 449, 76, 33);
		J_Panel.add(nextbtn);

		JLabel lbl = new JLabel("New label");
		lbl.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\check6.jpg"));
		lbl.setBounds(0, 0, 660, 540);
		J_Panel.add(lbl);
	}

	public static void main(String[] args) {
		new sd();
	}
}
