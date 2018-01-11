package org.bb.ssm.model;

public class Role {
	private Integer id;

	private String name;

	private String about;

	
	
	public Role() {
		super();
	}

	public Role(Integer id, String name, String about) {
		super();
		this.id = id;
		this.name = name;
		this.about = about;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", about=" + about + "]";
	}

	
	

}