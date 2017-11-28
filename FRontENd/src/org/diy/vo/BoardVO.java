package org.diy.vo;

public class BoardVO {
	private int bdID;
	private String bdTitle;
	private String userID;
	private String bdDate;
	private String bdContent;
	private int bdLikes;
	private int bdViews;
	private int bdAvail;
	private int cnt;




	public BoardVO() {
		
	}


	public BoardVO(int bdID, String bdTitle, String userID, String bdDate, String bdContent, int bdLikes, int bdViews,
			int bdAvail) {
		super();
		this.bdID = bdID;
		this.bdTitle = bdTitle;
		this.userID = userID;
		this.bdDate = bdDate;
		this.bdContent = bdContent;
		this.bdLikes = bdLikes;
		this.bdViews = bdViews;
		this.bdAvail = bdAvail;
	}


	public int getBdID() {
		return bdID;
	}
	public void setBdID(int bdID) {
		this.bdID = bdID;
	}
	public int getBdLikes() {
		return bdLikes;
	}
	public void setBdLikes(int bdLikes) {
		this.bdLikes = bdLikes;
	}
	public int getBdViews() {
		return bdViews;
	}
	public void setBdViews(int bdViews) {
		this.bdViews = bdViews;
	}
	public String getBdDate() {
		return bdDate;
	}
	public void setBdDate(String bdDate) {
		this.bdDate = bdDate;
	}
	public String getBdTitle() {
		return bdTitle;
	}
	public void setBdTitle(String bdTitle) {
		this.bdTitle = bdTitle;
	}
	public String getBdContent() {
		return bdContent;
	}
	public void setBdContent(String bdContent) {
		this.bdContent = bdContent;
	}
	public int isBdAvail() {
		return bdAvail;
	}
	public void setBdAvail(int bdAvail) {
		this.bdAvail = bdAvail;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getCnt() {
		return cnt;
	}


	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	
}
