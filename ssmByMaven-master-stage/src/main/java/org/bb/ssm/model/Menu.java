package org.bb.ssm.model;

public class Menu {
	private Integer id;

	private String name;

	private String target_href;

	private Integer parent_id;

	public Menu() {
		super();
	}

	public Menu(Integer id, String name, String target_href, Integer parent_id) {
		super();
		this.id = id;
		this.name = name;
		this.target_href = target_href;
		this.parent_id = parent_id;
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

	public String getTarget_href() {
		return target_href;
	}

	public void setTarget_href(String target_href) {
		this.target_href = target_href;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", target_href="
				+ target_href + ", parent_id=" + parent_id + "]";
	}

}