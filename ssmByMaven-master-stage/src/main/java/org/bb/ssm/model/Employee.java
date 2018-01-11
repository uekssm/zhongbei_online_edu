package org.bb.ssm.model;

import java.util.Date;

public class Employee {
	private Integer id;
	private String job_number;
	private String name;
	private Date hiredate;
	private Integer status;
	private Integer position_id;
	private Integer user_id;
	private Integer sex;
	private String tel;
	private String photo;
	
	public Employee() {
		super();
	}

	public Employee(Integer id, String job_number, String name, Date hiredate,
			Integer status, Integer position_id, Integer user_id, Integer sex,
			String tel, String photo) {
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPosition_id() {
		return position_id;
	}

	public void setPosition_id(Integer position_id) {
		this.position_id = position_id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
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
		return "Employee [id=" + id + ", job_number=" + job_number + ", name="
				+ name + ", hiredate=" + hiredate + ", status=" + status
				+ ", position_id=" + position_id + ", user_id=" + user_id
				+ ", sex=" + sex + ", tel=" + tel + ", photo=" + photo + "]";
	}
	
}