package org.bb.ssm.model;

public class Position {
	private Integer id;
	private String name;
	private String duty;
	private Integer department_id;
	private Integer parent_id;
	private Integer role_id;
	
	public Position() {
		super();
	}

	public Position(Integer id, String name, String duty,
			Integer department_id, Integer parent_id, Integer role_id) {
		super();
		this.id = id;
		this.name = name;
		this.duty = duty;
		this.department_id = department_id;
		this.parent_id = parent_id;
		this.role_id = role_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public Integer getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	public Integer getRole_id() {
		return role_id;
	}

	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", duty=" + duty
				+ ", department_id=" + department_id + ", parent_id="
				+ parent_id + ", role_id=" + role_id + "]";
	}

	
}