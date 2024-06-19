class Contact {
	private String cid;
	private String name;
	private String pn;
	private String comName;
	private double salary;
	private String bday;

	Contact(String cid, String name, String pn, String comName, double salary, String bday) {
		this.cid = cid;
		this.name = name;
		this.pn = pn;
		this.comName = comName;
		this.salary = salary;
		this.bday = bday;

	}

	public void setCid(String cid) {
		this.cid = cid;

	}

	public String getCid() {
		return cid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setPn(String pn) {
		this.pn = pn;
	}

	public String getPn() {
		return pn;
	}

	public void setComName(String comName) {
		this.comName = comName;
	}

	public String getComName() {
		return comName;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public String getBday() {
		return bday;
	}
}