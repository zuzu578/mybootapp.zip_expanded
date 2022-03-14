package com.mybootapp.mybootapp.dto;

public class Insert {
	
	private String userId;
	private String boardTopic;
	private String boardComment;
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
		return "Insert [userId=" + userId + ", boardTopic=" + boardTopic + ", boardComment=" + boardComment
				+ ", getUserId()=" + getUserId() + ", getBoardTopic()=" + getBoardTopic() + ", getBoardComment()="
				+ getBoardComment() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
