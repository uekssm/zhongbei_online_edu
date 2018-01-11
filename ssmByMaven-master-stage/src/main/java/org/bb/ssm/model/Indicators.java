package org.bb.ssm.model;

public class Indicators {
	private int id;
	
	private String num;
	
	private String name;
	
	private float weight;
	
	private String theme;

	public Indicators() {
		super();
	}

	public Indicators(int id, String num, String name, float weight,
			String theme) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.weight = weight;
		this.theme = theme;
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

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Indicators [id=" + id + ", num=" + num + ", name=" + name
				+ ", weight=" + weight + ", theme=" + theme + "]";
	}

}
