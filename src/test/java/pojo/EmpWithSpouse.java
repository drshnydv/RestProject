package pojo;

public class EmpWithSpouse {
	
	String ename;
	int[] empId;
	spouse spouse;
	String address;
	
	public EmpWithSpouse(String ename, int[] a, pojo.spouse spouse, String address) {
		super();
		this.ename = ename;
		this.empId = a;
		this.spouse = spouse;
		this.address = address;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int[] getEmpId() {
		return empId;
	}
	public void setEmpId(int[] empId) {
		this.empId = empId;
	}
	public spouse getSpouse() {
		return spouse;
	}
	public void setSpouse(spouse spouse) {
		this.spouse = spouse;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}