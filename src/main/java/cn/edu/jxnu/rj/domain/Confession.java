package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Confession {
	private int confessionId;
	private int confessionUserId1;
	private int confessionUserId2;
	private String confessionContent;
	private Date gmtCreate;
	private Date gmtModified;
	private int confessionLikes;
	private int confessionComments;
	public Confession() {
	}

	public Confession(int confessionId, int confessionUserId1, int confessionUserId2, String confessionContent, Date gmtCreate, Date gmtModified, int confessionLikes, int confessionComments) {
		this.confessionId = confessionId;
		this.confessionUserId1 = confessionUserId1;
		this.confessionUserId2 = confessionUserId2;
		this.confessionContent = confessionContent;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.confessionLikes = confessionLikes;
		this.confessionComments = confessionComments;
	}

	//发布表白
	public Confession(int confessionUserId1, int confessionUserId2, String confessionContent) {
		this.confessionUserId1 = confessionUserId1;
		this.confessionUserId2 = confessionUserId2;
		this.confessionContent = confessionContent;
	}

	public int getConfessionComments() {
		return confessionComments;
	}

	public void setConfessionComments(int confessionComments) {
		this.confessionComments = confessionComments;
	}

	public int getConfessionId() {
		return confessionId;
	}

	public void setConfessionId(int confessionId) {
		this.confessionId = confessionId;
	}

	public int getConfessionUserId1() {
		return confessionUserId1;
	}

	public void setConfessionUserId1(int confessionUserId1) {
		this.confessionUserId1 = confessionUserId1;
	}

	public int getConfessionUserId2() {
		return confessionUserId2;
	}

	public void setConfessionUserId2(int confessionUserId2) {
		this.confessionUserId2 = confessionUserId2;
	}

	public String getConfessionContent() {
		return confessionContent;
	}

	public void setConfessionContent(String confessionContent) {
		this.confessionContent = confessionContent;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public int getConfessionLikes() {
		return confessionLikes;
	}

	public void setConfessionLikes(int confessionLikes) {
		this.confessionLikes = confessionLikes;
	}
}
