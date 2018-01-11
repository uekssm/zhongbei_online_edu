package org.bb.ssm.model;

public class University {
	private int id;
	
	private String num;
	
	private String name;
	
	private String summary;

	public University() {
		super();
	}

	public University(int id, String num, String name, String summary) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.summary = summary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", num=" + num + ", name=" + name
				+ ", summary=" + summary + "]";
	}
	
	
}
