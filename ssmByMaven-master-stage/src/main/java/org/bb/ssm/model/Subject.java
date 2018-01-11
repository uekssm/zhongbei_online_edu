package org.bb.ssm.model;

public class Subject {
	private int id;
	
	private String num;
	
	private String name;
	
	private String level;
	
	private String summary;

	public Subject() {
		super();
	}

	public Subject(int id, String num, String name, String level, String summary) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.level = level;
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

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", num=" + num + ", name=" + name
				+ ", level=" + level + ", summary=" + summary + "]";
	}

	

}
