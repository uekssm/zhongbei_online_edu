package org.bb.ssm.model;

public class Course {
	private int id;
	
	private String num;
	
	private String name;
	
	private String about;
	
	private String cover_image;

	public Course() {
		super();
	}

	public Course(int id, String num, String name, String about,
			String cover_image) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.about = about;
		this.cover_image = cover_image;
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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", num=" + num + ", name=" + name
				+ ", about=" + about + ", cover_image=" + cover_image + "]";
	}

}
