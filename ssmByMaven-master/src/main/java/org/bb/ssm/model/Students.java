package org.bb.ssm.model;

public class Students {
	private int id;
	private String name;
	private String student_number;
	private int pro_team_id;
	private int status;
	private int gender;
	private String nation;
	private String school;
	private String major;
	private int class_id;
	
	private String teamname;
	private String classname;
	
	public Students() {
		super();
	}

	public Students(int id, String name, String student_number,
			int pro_team_id, int status, int gender, String nation,
			String school, String major, int class_id, String teamname,
			String classname) {
		super();
		this.id = id;
		this.name = name;
		this.student_number = student_number;
		this.pro_team_id = pro_team_id;
		this.status = status;
		this.gender = gender;
		this.nation = nation;
		this.school = school;
		this.major = major;
		this.class_id = class_id;
		this.teamname = teamname;
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

	public String getStudent_number() {
		return student_number;
	}

	public void setStudent_number(String student_number) {
		this.student_number = student_number;
	}

	public int getPro_team_id() {
		return pro_team_id;
	}

	public void setPro_team_id(int pro_team_id) {
		this.pro_team_id = pro_team_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getClass_id() {
		return class_id;
	}

	public void setClass_id(int class_id) {
		this.class_id = class_id;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", student_number="
				+ student_number + ", pro_team_id=" + pro_team_id + ", status="
				+ status + ", gender=" + gender + ", nation=" + nation
				+ ", school=" + school + ", major=" + major + ", class_id="
				+ class_id + ", teamname=" + teamname + ", classname="
				+ classname + "]";
	}

	
}
