package org.bb.ssm.model;

public class Knowledge {
	private int id;
	private String num;
	private String name;
	private int is_difficult;
	private int is_important;
	private String video;
	private int course_id;

	private String course_name;
	
	public Knowledge() {
		super();
	}

	public Knowledge(int id, String num, String name, int is_difficult,
			int is_important, String video, int course_id) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.is_difficult = is_difficult;
		this.is_important = is_important;
		this.video = video;
		this.course_id = course_id;
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

	public int getIs_difficult() {
		return is_difficult;
	}

	public void setIs_difficult(int is_difficult) {
		this.is_difficult = is_difficult;
	}

	public int getIs_important() {
		return is_important;
	}

	public void setIs_important(int is_important) {
		this.is_important = is_important;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	
	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	@Override
	public String toString() {
		return "Knowledge [id=" + id + ", num=" + num + ", name=" + name
				+ ", is_difficult=" + is_difficult + ", is_important="
				+ is_important + ", video=" + video + ", course_id="
				+ course_id + ", course_name=" + course_name + "]";
	}

	

}
