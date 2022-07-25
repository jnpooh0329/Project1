package db;

import java.util.*;

import java.sql.*;

public class MemberDAO {
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "c##green";
	String password = "green1234";

	private Connection con;
	private Statement stmt;
	private ResultSet rs; // 우리가 저장하는 값

	public MemberVO list(String id, String password) {

		try {
			connDB();

			String query = "SELECT * FROM login WHERE id='" + id + "' AND password='" + password + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last(); 
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) { // 우리가 저장한 값의 마지막이 0이면 
				System.out.println("0 row selected.....");
			} else {
				String id1 = rs.getString("id");
				return new MemberVO(id1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return new MemberVO();
	}

	public boolean SignUp(MemberVO p) {

		try {
			connDB();

			String query = "insert into login(name,id,password,email,phonenumber)values('" + p.getName() + "','"
					+ p.getId() + "','" + p.getPassword() + "','" + p.getEmail() + "','" + p.getPhoneNumber() + "')";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean IDCheck(MemberVO p) {

		try {
			connDB();

			String query = "SELECT * FROM login WHERE id = '" + p.getId() + "'";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();
			System.out.println("rs.getRow() : " + rs.getRow());

			if (rs.getRow() == 0) {
				System.out.println("0 row selected.....");
			} else {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public Object[][] buyer() {
		try {
			connDB();

			String query = "select * from buyer order by id";
			System.out.println("\nSQL : " + query);
			rs = stmt.executeQuery(query);
			rs.last();

			int n = rs.getRow();
			int i = 0;

			Object[][] object = new Object[n][6];

			rs = stmt.executeQuery(query);

			while (rs.next()) {
				object[i][0] = rs.getString("name");
				object[i][1] = rs.getString("id");
				object[i][2] = rs.getString("email");
				object[i][3] = rs.getString("phone");
				object[i][4] = rs.getString("birth");

				i++;
			}

			return object;
		} catch (Exception e) {
			e.printStackTrace();
		}

		Object[][] temp = {};
		return temp;
	}
	
	public boolean CONCERT(MemberVO p) {

		try {
			connDB();

			String query = "insert into Concert values ('"+p.getConcertname()+"','"+p.getDay()+"','"+p.getStarttime()+"','"+p.getSeat()+"','"+p.getPrice()+"')";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	public boolean SEAT(MemberVO p) {

		try {
			connDB();

			String query = "insert into SEAT values ('"+p.getSeat()+"')";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean CALENDAR(MemberVO p) {

		try {
			connDB();

			String query = "insert into CALENDAR values ('"+p.getDay()+"','"+p.getStarttime()+"')";
			System.out.println("SQL : " + query);
			rs = stmt.executeQuery(query);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void connDB() {
		try {
			Class.forName(driver);
			System.out.println("jdbc driver loading success.");
			con = DriverManager.getConnection(url, user, password);
			System.out.println("oracle connection success.");
			stmt = con.createStatement();
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println("statement create success.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}