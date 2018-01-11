package org.bb.ssm.model;

public class University {
	private int id;
	
	private String num;
	
	private String name;
	
	private String summary;
	
	private int pageIndex;
	
	private int limit;

	public University() {
		super();
	}

	public University(int id, String num, String name, String summary,
			int pageIndex, int limit) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.summary = summary;
		this.pageIndex = pageIndex;
		this.limit = limit;
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

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", num=" + num + ", name=" + name
				+ ", summary=" + summary + ", pageIndex=" + pageIndex
				+ ", limit=" + limit + "]";
	}

}
