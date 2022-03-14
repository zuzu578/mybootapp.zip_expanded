package com.mybootapp.mybootapp.dto;

public class TestDto {
	private int boardNum;
	private String userId;
	private String boardTopic;
	private String boardComment;
	private String rDate;
	private int nClick;
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBoardTopic() {
		return boardTopic;
	}
	public void setBoardTopic(String boardTopic) {
		this.boardTopic = boardTopic;
	}
	public String getBoardComment() {
		return boardComment;
	}
	public void setBoardComment(String boardComment) {
		this.boardComment = boardComment;
	}
	public String getrDate() {
		return rDate;
	}
	public void setrDate(String rDate) {
		this.rDate = rDate;
	}
	public int getnClick() {
		return nClick;
	}
	public void setnClick(int nClick) {
		this.nClick = nClick;
	}
	
	
}
