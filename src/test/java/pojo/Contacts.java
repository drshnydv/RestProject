package pojo;

public class Contacts {
	
	String first;
	String last;
	String company;
	long[] phno;
	String url;
	String email;
	String address;
	String dob;
	String relatedName;
	Object relation;
	
	public Contacts(String first, String last, String company, long[] phno, String url, String email, String address,
			String dob, String relatedName, Object relation) {
		super();
		this.first = first;
		this.last = last;
		this.company = company;
		this.phno = phno;
		this.url = url;
		this.email = email;
		this.address = address;
		this.dob = dob;
		this.relatedName = relatedName;
		this.relation = relation;
	}
	
	public Contacts() {
		
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

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public long[] getPhno() {
		return phno;
	}

	public void setPhno(long[] phno) {
		this.phno = phno;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getRelatedName() {
		return relatedName;
	}

	public void setRelatedName(String relatedName) {
		this.relatedName = relatedName;
	}

	public Object getRelation() {
		return relation;
	}

	public void setRelation(Object relation) {
		this.relation = relation;
	}
	
}
