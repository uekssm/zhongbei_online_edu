package org.bb.ssm.model;

public class Department {
	private Integer id;
	private String number;
	private String name;
	private String description;
	private Integer parent_id;
	private String pname;
	
	public Department() {
		super();
	}

	public Department(Integer id, String number, String name,
			String description, Integer parent_id, String pname) {
		super();
		this.id = id;
		this.number = number;
		this.name = name;
		this.description = description;
		this.parent_id = parent_id;
		this.pname = pname;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", number=" + number + ", name=" + name
				+ ", description=" + description + ", parent_id=" + parent_id
				+ ", pname=" + pname + "]";
	}

	
}