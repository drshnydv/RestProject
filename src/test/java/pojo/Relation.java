package pojo;

public class Relation {
	
	String first;
	String last;
	long[] phno;
	String address;
	
	public Relation(String first, String last, long[] phno, String address) {
		super();
		this.first = first;
		this.last = last;
		this.phno = phno;
		this.address = address;
	}
	
	public Relation() {
		
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public long[] getPhno() {
		return phno;
	}

	public void setPhno(long[] phno) {
		this.phno = phno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
