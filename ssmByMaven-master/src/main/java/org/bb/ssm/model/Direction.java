package org.bb.ssm.model;

public class Direction {
	private int id;
	
	private String num;
	
	private String name;
	
	private String cover_image;
	
	private String summary;

	public Direction() {
		super();
	}

	public Direction(int id, String num, String name, String cover_image,
			String summary) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.cover_image = cover_image;
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

	public String getCover_image() {
		return cover_image;
	}

	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Direction [id=" + id + ", num=" + num + ", name=" + name
				+ ", cover_image=" + cover_image + ", summary=" + summary + "]";
	}

	

}
