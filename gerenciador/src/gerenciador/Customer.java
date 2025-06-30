//feito por Maria Eduarda Fodor CB3025063 e Pedro Xavier Oliveira CB3027376

package gerenciador;

public class Customer {
	protected int customer_id;
	protected String cust_name;
	protected String city;
	protected int grade;
	protected int salesman_id;
	
	public Customer() {}
	
	public Customer(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public Customer(int customer_id, String cust_name, String city, int grade, int salesman_id) {
		this(cust_name, city, grade, salesman_id);
		this.customer_id = customer_id;
	}
	
	public Customer(String cust_name, String city, int grade, int salesman_id) {
		this.cust_name = cust_name;
		this.city = city;
		this.salesman_id = salesman_id;
	}
	
	public int getCustomerId() {
		return customer_id;
	}
	
	public String getCustName() {
		return cust_name;
	}
	
	public String getCity() {
		return city;
	}
	
	public int getGrade() {
		return grade;
	}
	
	public int getSalesmanId() {
		return salesman_id;
	}
	
	public void setCustomerId(int customer_id) {
		this.customer_id = customer_id;
	}
	
	public void setCustName(String cust_name) {
		this.cust_name = cust_name;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public void setSalesmanId(int salesman_id) {
		this.salesman_id = salesman_id;
	}
}