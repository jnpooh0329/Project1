package concert;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.MemberVO;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Check7 {

	private JFrame frame;
	private JTable tblData;
	private JTable table_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public Check7(MemberVO vo) {
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

		JLabel lblNewLabel_1 = new JLabel("예매내역 확인");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(207, 82, 226, 40);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("예매자 확인");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(207, 268, 226, 40);
		panel.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("data1");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##green",
							"green1234");
					Statement st = con.createStatement();
					String query = "select * from CONCERT";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) tblData.getModel();

					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for (int i = 0; i < cols; i++)
						colName[i] = rsmd.getColumnName(i + 1);
					model.setColumnIdentifiers(colName);
					String concertname, day, starttime, seat, price;
					while (rs.next()) {
						concertname = rs.getString(1);
						day = rs.getString(2);
						starttime = rs.getString(3);
						seat = rs.getString(4);
						price = rs.getString(5);
						String[] row = { concertname, day, starttime, seat, price };
						model.addRow(row);
					}
					st.close();
					con.close();

				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(99, 452, 97, 23);
		panel.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 146, 450, 92);
		panel.add(scrollPane);

		tblData = new JTable();
		tblData.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setViewportView(tblData);
		tblData.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "CONCERTNAME", "DAY", "STARTTIME", "SEAT", "PRICE" }));

		JButton btnNewButton_1 = new JButton("data2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##green",
							"green1234");
					Statement st = con.createStatement();
					String query = "select * from buyer";
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					DefaultTableModel model = (DefaultTableModel) table_1.getModel();

					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					for (int i = 0; i < cols; i++)
						colName[i] = rsmd.getColumnName(i + 1);
					model.setColumnIdentifiers(colName);
					String name, id, email, phone, birth;
					while (rs.next()) {
						name = rs.getString(1);
						id = rs.getString(2);
						email = rs.getString(3);
						phone = rs.getString(4);
						birth = rs.getString(5);
						String[] row = { name, id, email, phone, birth };
						model.addRow(row);
					}
					st.close();
					con.close();

				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(453, 452, 97, 23);
		panel.add(btnNewButton_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(101, 328, 450, 92);
		panel.add(scrollPane_1);

		table_1 = new JTable();
		table_1.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "NAME", "ID", "EMAIL", "PHONE", "BIRTH" }));
		scrollPane_1.setViewportView(table_1);

		JButton clear = new JButton("Clear");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tblData.setModel(new DefaultTableModel());
				table_1.setModel(new DefaultTableModel());
			}
		});
		clear.setBounds(275, 452, 97, 23);
		panel.add(clear);

		JButton Backbtn = new JButton("Back");
		Backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new Check6(vo).getFrame().setVisible(true);

			}
		});
		Backbtn.setFont(new Font("굴림", Font.BOLD, 12));
		Backbtn.setBounds(12, 10, 76, 33);
		panel.add(Backbtn);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("G:\\내 드라이브\\work2\\Project\\image\\6page.jpg"));
		lblNewLabel.setBounds(0, 0, 660, 540);
		panel.add(lblNewLabel);

	}
}
