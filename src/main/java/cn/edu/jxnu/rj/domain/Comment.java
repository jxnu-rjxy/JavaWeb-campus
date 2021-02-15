package	cn.edu.jxnu.rj.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
	private int commentId;
	private int workId;
	private int workType;
	private int userId;
	private String userName;
	private String commentContent;
	private Date gmtCreate;
	private int commentLikes;
	private boolean isLike = false;
	private List<Reply> replyList = new ArrayList<>();
	public Comment() {
	}


	public Comment(int workId, int workType, int userId, String commentContent) {
		this.workId = workId;
		this.workType = workType;
		this.userId = userId;
		this.commentContent = commentContent;
	}

	public List<Reply> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<Reply> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "Comment{" +
				"commentId=" + commentId +
				", workId=" + workId +
				", workType=" + workType +
				", userId=" + userId +
				", userName='" + userName + '\'' +
				", commentContent='" + commentContent + '\'' +
				", gmtCreate=" + gmtCreate +
				", commentLikes=" + commentLikes +
				", isLike=" + isLike +
				", replyList=" + replyList +
				'}';
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean like) {
		isLike = like;
	}


	public Comment(int workId, int workType, int userId, String userName, String commentContent) {
		this.workId = workId;
		this.workType = workType;
		this.userId = userId;
		this.userName = userName;
		this.commentContent = commentContent;
	}


	public Comment(int commentId, int workId, int workType, int userId, String userName, String commentContent, Date gmtCreate, int commentLikes, boolean isLike) {
		this.commentId = commentId;
		this.workId = workId;
		this.workType = workType;
		this.userId = userId;
		this.userName = userName;
		this.commentContent = commentContent;
		this.gmtCreate = gmtCreate;
		this.commentLikes = commentLikes;
		this.isLike = isLike;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getWorkId() {
		return workId;
	}

	public void setWorkId(int workId) {
		this.workId = workId;
	}

	public int getWorkType() {
		return workType;
	}

	public void setWorkType(int workType) {
		this.workType = workType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public int getCommentLikes() {
		return commentLikes;
	}

	public void setCommentLikes(int commentLikes) {
		this.commentLikes = commentLikes;
	}
}
