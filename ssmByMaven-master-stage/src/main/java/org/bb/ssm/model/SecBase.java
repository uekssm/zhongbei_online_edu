package org.bb.ssm.model;

public class SecBase {
	private Integer id;
	private Integer user_id;

	private String overtime;

	public SecBase() {
		super();
	}

	public SecBase(Integer id, Integer user_id, String overtime) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.overtime = overtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getOvertime() {
		return overtime;
	}

	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}

	@Override
	public String toString() {
		return "SecBase [id=" + id + ", user_id=" + user_id + ", overtime="
				+ overtime + "]";
	}

}