package com.mybootapp.mybootapp.dto;

public class Update {
	private int boardNum;
	private String userId;
	private String boardTopic;
	private String boardComment;
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
	@Override
	public String toString() {
		return "Update [boardNum=" + boardNum + ", userId=" + userId + ", boardTopic=" + boardTopic + ", boardComment="
				+ boardComment + ", getBoardNum()=" + getBoardNum() + ", getUserId()=" + getUserId()
				+ ", getBoardTopic()=" + getBoardTopic() + ", getBoardComment()=" + getBoardComment() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
