package pojo;

public class Emp {
	
	String ename;
	int eid;
	String phno;
	String email;
	String address;
	
	public Emp(String ename, int eid, String phno, String email, String address) {
		
		this.ename = ename;
		this.eid = eid;
		this.phno = phno;
		this.email = email;
		this.address = address;
	}
	
	public Emp() {
		
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
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
