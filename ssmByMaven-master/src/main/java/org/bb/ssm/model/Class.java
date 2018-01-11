package org.bb.ssm.model;

public class Class {
	private int id;
	
	private String name;
	
	private String num;
	
	private int room_id;
	
	private int major_id;

	public Class() {
		super();
	}

	public Class(int id, String name, String num, int room_id, int major_id) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.room_id = room_id;
		this.major_id = major_id;
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

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getRoom_id() {
		return room_id;
	}

	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}

	public int getMajor_id() {
		return major_id;
	}

	public void setMajor_id(int major_id) {
		this.major_id = major_id;
	}

	@Override
	public String toString() {
		return "Class [id=" + id + ", name=" + name + ", num=" + num
				+ ", room_id=" + room_id + ", major_id=" + major_id + "]";
	}

	
}
