package org.bb.ssm.model;

public class Team {

	private int id;
	
	private String name;
	
	private int class_id;
	
	private int headman;
	
	private String headstu;
	
	private String classname;

	public Team() {
		super();
	}

	public Team(int id, String name, int class_id, int headman, String headstu,
			String classname) {
		super();
		this.id = id;
		this.name = name;
		this.class_id = class_id;
		this.headman = headman;
		this.headstu = headstu;
		this.classname = classname;
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

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public int getHeadman() {
		return headman;
	}

	public void setHeadman(int headman) {
		this.headman = headman;
	}

	public String getHeadstu() {
		return headstu;
	}

	public void setHeadstu(String headstu) {
		this.headstu = headstu;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", class_id=" + class_id
				+ ", headman=" + headman + ", headstu=" + headstu
				+ ", classname=" + classname + "]";
	}

	
}
