package org.bb.ssm.model;

public class Boutique {
	private int id;
	private String num;
	private int teacher_id;
	private int course_id;
	private String addtime;
	private String examine_time;
	private String cname;
	private String tname;
	private int status;
	
	public Boutique() {
		super();
	}

	public Boutique(int id, String num, int teacher_id, int course_id,
			String addtime, String examine_time, String cname, String tname,
			int status) {
		super();
		this.id = id;
		this.num = num;
		this.teacher_id = teacher_id;
		this.course_id = course_id;
		this.addtime = addtime;
		this.examine_time = examine_time;
		this.cname = cname;
		this.tname = tname;
		this.status = status;
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

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getAddtime() {
		return addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getExamine_time() {
		return examine_time;
	}

	public void setExamine_time(String examine_time) {
		this.examine_time = examine_time;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Boutique [id=" + id + ", num=" + num + ", teacher_id="
				+ teacher_id + ", course_id=" + course_id + ", addtime="
				+ addtime + ", examine_time=" + examine_time + ", cname="
				+ cname + ", tname=" + tname + ", status=" + status + "]";
	}

}
