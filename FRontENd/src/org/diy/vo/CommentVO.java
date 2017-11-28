package org.diy.vo;

public class CommentVO {
	private int id;
	private String content;
	private String date;
	private String userid;
	private int ok;
	private int fkid;
	public CommentVO(int id, String content, String date, String userid, int ok, int fkid) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
		this.userid = userid;
		this.ok = ok;
		this.fkid = fkid;
	}
	public CommentVO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getFkid() {
		return fkid;
	}
	public void setFkid(int fkid) {
		this.fkid = fkid;
	}
	
}
