package com.woori.BAM.dto;

public class Article {

	private int id;
	private String regDate;
	private String title;
	private String body;
	private int viewCnt;
	
    // 순서 수정 
	public Article(int id, String regDate, String title, String body, int viewCnt) {
		this.setId(id);
		this.setRegDate(regDate);
		this.setTitle(title);
		this.setBody(body);
		this.setViewCnt(viewCnt);
	}
	
	public void increaseViewCnt() {
		this.setViewCnt(this.getViewCnt() + 1);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
}
