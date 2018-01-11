package org.bb.ssm.model;

public class Classroom {

	private int id;
	
	private String name;
	
	private int num;
	
	private int computer_num;
	
	private int station;

	public Classroom() {
		super();
	}

	public Classroom(int id, String name, int num, int computer_num, int station) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.computer_num = computer_num;
		this.station = station;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getComputer_num() {
		return computer_num;
	}

	public void setComputer_num(int computer_num) {
		this.computer_num = computer_num;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}

	@Override
	public String toString() {
		return "Classroom [id=" + id + ", name=" + name + ", num=" + num
				+ ", computer_num=" + computer_num + ", station=" + station
				+ "]";
	}

	
}
