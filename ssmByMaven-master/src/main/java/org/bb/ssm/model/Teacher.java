package org.bb.ssm.model;

import java.util.Date;

public class Teacher {
	private int id;
	private String job_number;
	private String name;
	private String hiredate;
	private int status;
	private int position_id;
	private int user_id;
	private int sex;
	private String tel;
	private String photo;
	
	public Teacher() {
		super();
	}
	public Teacher(int id, String job_number, String name, String hiredate,
			int status, int position_id, int user_id, int sex, String tel,
			String photo) {
		super();
		this.id = id;
		this.job_number = job_number;
		this.name = name;
		this.hiredate = hiredate;
		this.status = status;
		this.position_id = position_id;
		this.user_id = user_id;
		this.sex = sex;
		this.tel = tel;
		this.photo = photo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJob_number() {
		return job_number;
	}
	public void setJob_number(String job_number) {
		this.job_number = job_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getPosition_id() {
		return position_id;
	}
	public void setPosition_id(int position_id) {
		this.position_id = position_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", job_number=" + job_number + ", name="
				+ name + ", hiredate=" + hiredate + ", status=" + status
				+ ", position_id=" + position_id + ", user_id=" + user_id
				+ ", sex=" + sex + ", tel=" + tel + ", photo=" + photo + "]";
	}

	
}
