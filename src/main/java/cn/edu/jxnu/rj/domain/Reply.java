package	cn.edu.jxnu.rj.domain;

import java.sql.Timestamp;


public class Reply {
	private int replyId;
	private int commentId;
	private String replyContent;
	private int userId1;
	private int userId2;
	private Timestamp gmtCreate;
	private Timestamp gmtModified;
	private int replyLikes;
	private String userName1;
	private String userName2;

	public Reply() {
	}

	public int getReplyId() {
		return replyId;
	}

	public void setReplyId(int replyId) {
		this.replyId = replyId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public int getUserId1() {
		return userId1;
	}

	public String getUserName1() {
		return userName1;
	}

	public void setUserName1(String userName1) {
		this.userName1 = userName1;
	}

	public String getUserName2() {
		return userName2;
	}

	public void setUserName2(String userName2) {
		this.userName2 = userName2;
	}

	public void setUserId1(int userId1) {
		this.userId1 = userId1;
	}

	public int getUserId2() {
		return userId2;
	}

	public void setUserId2(int userId2) {
		this.userId2 = userId2;
	}

	public Timestamp getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Timestamp getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Timestamp gmtModified) {
		this.gmtModified = gmtModified;
	}

	public int getReplyLikes() {
		return replyLikes;
	}

	public void setReplyLikes(int replyLikes) {
		this.replyLikes = replyLikes;
	}

	public Reply(int commentId, String replyContent, int userId1, int userId2, String userName1, String userName2) {
		this.commentId = commentId;
		this.replyContent = replyContent;
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.userName1 = userName1;
		this.userName2 = userName2;
	}

	public Reply(int replyId, int commentId, String replyContent, int userId1, int userId2, Timestamp gmtCreate, Timestamp gmtModified, int replyLikes, String userName1, String userName2) {
		this.replyId = replyId;
		this.commentId = commentId;
		this.replyContent = replyContent;
		this.userId1 = userId1;
		this.userId2 = userId2;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.replyLikes = replyLikes;
		this.userName1 = userName1;
		this.userName2 = userName2;
	}
}
