package org.bb.ssm.model;

public class ResourceManager {
	private Integer id;
	private String name;
	private Integer pid;
	private String addtime;
	private String url;
	private Integer type;
	private String size;
	
	public ResourceManager() {
		super();
	}

	public ResourceManager(Integer id, String name, Integer pid,
			String addtime, String url, Integer type, String size) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.addtime = addtime;
		this.url = url;
		this.type = type;
		this.size = size;
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

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "ResourceManager [id=" + id + ", name=" + name + ", pid=" + pid
				+ ", addtime=" + addtime + ", url=" + url + ", type=" + type
				+ ", size=" + size + "]";
	}

}