package WebPageTesting;

public class Customers {

	public String name;

	public String dob;

	public String identification;

	public String address;

	public String mobile;

	public String email;



	public Customers()
	     
	{};


	public Customers(String name, String dob, String identification, String address, String mobile, String email) {
		this.name = name;
		this.dob = dob;
		this.identification = identification;
		this.address = address;
		this.mobile = mobile;
		this.email = email;

	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getdob() {
		return dob;
	}
	public void setdob(String dob) {
		this.dob = dob;
	}

	public String getidentification() {
		return identification;
	}
	public void setidentification(String identification) {
		this.identification = identification;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getaddress() {
		return address;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public String getmobile() {
		return mobile;
	}
	public void setmobile(String mobile) {
		this.mobile = mobile;
	}
}
