package pojo;

public class spouse {
	
	String name;
	String phno;
	String email;
	String address;
	
	public spouse(String name, String phno, String email, String address) {
		super();
		this.name = name;
		this.phno = phno;
		this.email = email;
		this.address = address;
	}
	
	public spouse() {
		
		
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}