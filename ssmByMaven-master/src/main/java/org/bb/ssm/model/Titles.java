package org.bb.ssm.model;

public class Titles {
	private int id;
	private String num;
	private String title;
	private int category;
	private int difficulty;
	private String answer;
	private String analysis;
	private int teacher;
	private String add_time;
	private int score;
	private int complete_time;
	private int status;
	private int direction_id;
	private int stage_id;
	private int course_id;
	private int days_id;
	private int gongsi_id;
	private int zhiwei_id;
	private int type;
	private String url;
	
	public Titles() {
		super();
	}

	public Titles(int id, String num, String title, int category,
			int difficulty, String answer, String analysis, int teacher,
			String add_time, int score, int complete_time, int status,
			int direction_id, int stage_id, int course_id, int days_id,
			int gongsi_id, int zhiwei_id, int type, String url) {
		super();
		this.id = id;
		this.num = num;
		this.title = title;
		this.category = category;
		this.difficulty = difficulty;
		this.answer = answer;
		this.analysis = analysis;
		this.teacher = teacher;
		this.add_time = add_time;
		this.score = score;
		this.complete_time = complete_time;
		this.status = status;
		this.direction_id = direction_id;
		this.stage_id = stage_id;
		this.course_id = course_id;
		this.days_id = days_id;
		this.gongsi_id = gongsi_id;
		this.zhiwei_id = zhiwei_id;
		this.type = type;
		this.url = url;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public int getTeacher() {
		return teacher;
	}

	public void setTeacher(int teacher) {
		this.teacher = teacher;
	}

	public String getAdd_time() {
		return add_time;
	}

	public void setAdd_time(String add_time) {
		this.add_time = add_time;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getComplete_time() {
		return complete_time;
	}

	public void setComplete_time(int complete_time) {
		this.complete_time = complete_time;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getDirection_id() {
		return direction_id;
	}

	public void setDirection_id(int direction_id) {
		this.direction_id = direction_id;
	}

	public int getStage_id() {
		return stage_id;
	}

	public void setStage_id(int stage_id) {
		this.stage_id = stage_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getDays_id() {
		return days_id;
	}

	public void setDays_id(int days_id) {
		this.days_id = days_id;
	}

	public int getGongsi_id() {
		return gongsi_id;
	}

	public void setGongsi_id(int gongsi_id) {
		this.gongsi_id = gongsi_id;
	}

	public int getZhiwei_id() {
		return zhiwei_id;
	}

	public void setZhiwei_id(int zhiwei_id) {
		this.zhiwei_id = zhiwei_id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "Titles [id=" + id + ", num=" + num + ", title=" + title
				+ ", category=" + category + ", difficulty=" + difficulty
				+ ", answer=" + answer + ", analysis=" + analysis
				+ ", teacher=" + teacher + ", add_time=" + add_time
				+ ", score=" + score + ", complete_time=" + complete_time
				+ ", status=" + status + ", direction_id=" + direction_id
				+ ", stage_id=" + stage_id + ", course_id=" + course_id
				+ ", days_id=" + days_id + ", gongsi_id=" + gongsi_id
				+ ", zhiwei_id=" + zhiwei_id + ", type=" + type + ", url="
				+ url + "]";
	}

	
}
