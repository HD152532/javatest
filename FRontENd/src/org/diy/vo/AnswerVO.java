package org.diy.vo;

public class AnswerVO {
	private int id;
	private String title;
	private String content;
	private String date;
	private String userid;
	private int ok;
	private int likes;
	private int fkid;
	public AnswerVO(int id, String title, String content, String date, String userid, int ok, int likes,
			int fkid) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
		this.userid = userid;
		this.ok = ok;
		this.likes = likes;
		this.fkid = fkid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getOk() {
		return ok;
	}
	public void setOk(int ok) {
		this.ok = ok;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getFkid() {
		return fkid;
	}
	public void setFkid(int fkid) {
		this.fkid = fkid;
	}
	public AnswerVO() {
	}
}
