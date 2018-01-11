package org.bb.ssm.model;

public class Ability {
	private int id;
	
	private String name;
	
	private String summary;

	public Ability() {
		super();
	}

	public Ability(int id, String name, String summary) {
		super();
		this.id = id;
		this.name = name;
		this.summary = summary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "Ability [id=" + id + ", name=" + name + ", summary=" + summary
				+ "]";
	}

}
