package org.bb.ssm.model;

public class FirstBase {
	private Integer id;
	private Integer user_id;
	private Integer role_id;
	private Integer menu_id;
	
	public FirstBase() {
		super();
	}

	public FirstBase(Integer id, Integer user_id, Integer role_id,
			Integer menu_id) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.role_id = role_id;
		this.menu_id = menu_id;
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

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	public Integer getMenu_id() {
		return menu_id;
	}

	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}

	@Override
	public String toString() {
		return "FirstBase [id=" + id + ", user_id=" + user_id + ", role_id="
				+ role_id + ", menu_id=" + menu_id + "]";
	}

}