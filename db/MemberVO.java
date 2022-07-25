package db;

public class MemberVO {
	private String id;
	private String password;

	private String name;
	private String email;
	private String phoneNumber;
	private String concertname;
	private String day;
	private String starttime;
	private String seat;
	private String price;
	
	public MemberVO() {
		
	}
	
	public MemberVO(String id) {
		this.id = id;
	} // set메소드 역활
	
	public MemberVO(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public MemberVO(String name, String id, String password, String email, String phoneNumber, String seat) {
		this.name = name;
		this.id = id;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.seat = seat;
	}
	
	
	public MemberVO(String concertname, String day, String starttime, String seat, String price) {
		this.concertname = concertname;
		this.day = day;
		this.starttime = starttime;
		this.seat = seat;
		this.price = price;
	}

	public String getConcertname() {
		return concertname;
	}

	public void setConcertname(String concertname) {
		this.concertname = concertname;
	}
	
	public void setDay(String day) {
		this.day = day;
	}
	
	
	public void setPrice(String price) {
		this.price = price;
	}


	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}


	public void setId(String id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getDay() {
		return day;
	}

	public String getStarttime() {
		return starttime;
	}

	public String getSeat() {
		return seat;
	}
	
	public String getPrice() {
		return price;
	}

	
}
