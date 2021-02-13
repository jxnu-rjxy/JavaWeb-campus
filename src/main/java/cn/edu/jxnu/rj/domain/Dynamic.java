package	cn.edu.jxnu.rj.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


public class Dynamic {
	//所有参数：dynamic_id,user_id,dynamic_content,dynamic_status,gmt_create,gmt_modified
	private int dynamicId;
	private int userId;
	private String userName;
	private String userSchool;
	private String userImage;
	private String dynamicContent;
	private int dynamicStatus;
	private Timestamp gmtCreate;
	private List<String> imagePath;
	private int dynamicLikes;
	private int dynamicForwards;
	private int dynamicComments;
	private boolean isLike = false;
	public Dynamic() {
	}
	//用户发表动态

	public Dynamic(int userId,String dynamicContent,int dynamicStatus, List<String> imagePath) {
		this.userId = userId;
		this.dynamicContent = dynamicContent;
		this.dynamicStatus = dynamicStatus;
		this.imagePath = imagePath;
	}


	//全构造器
	public Dynamic(int dynamicId,
				   int userId,
				   String userName,
				   String userSchool,
				   String userImage,
				   String dynamicContent,
				   int dynamicStatus,
				   Timestamp gmtCreate,
				   List<String> imagePath,
				   int dynamicLikes,
				   int dynamicForwards,
				   int dynamicComments) {
		this.dynamicId = dynamicId;
		this.userId = userId;
		this.userName = userName;
		this.userSchool = userSchool;
		this.userImage = userImage;
		this.dynamicContent = dynamicContent;
		this.dynamicStatus = dynamicStatus;
		this.gmtCreate = gmtCreate;
		this.imagePath = imagePath;
		this.dynamicLikes = dynamicLikes;
		this.dynamicForwards = dynamicForwards;
		this.dynamicComments = dynamicComments;
	}

	public int getDynamicId() {
		return dynamicId;
	}

	public void setDynamicId(int dynamicId) {
		this.dynamicId = dynamicId;
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

	public String getUserSchool() {
		return userSchool;
	}

	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}

	public String getDynamicContent() {
		return dynamicContent;
	}

	public void setDynamicContent(String dynamicContent) {
		this.dynamicContent = dynamicContent;
	}

	public int getDynamicStatus() {
		return dynamicStatus;
	}

	public void setDynamicStatus(int dynamicStatus) {
		this.dynamicStatus = dynamicStatus;
	}

	public Timestamp getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Timestamp gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public List<String> getImagePath() {
		return imagePath;
	}

	public void setImagePath(List<String> imagePath) {
		this.imagePath = imagePath;
	}

	public int getDynamicLikes() {
		return dynamicLikes;
	}

	public void setDynamicLikes(int dynamicLikes) {
		this.dynamicLikes = dynamicLikes;
	}

	public int getDynamicForwards() {
		return dynamicForwards;
	}

	public void setDynamicForwards(int dynamicForwards) {
		this.dynamicForwards = dynamicForwards;
	}

	public int getDynamicComments() {
		return dynamicComments;
	}

	public void setDynamicComments(int dynamicComments) {
		this.dynamicComments = dynamicComments;
	}

	public boolean isLike() {
		return isLike;
	}

	public void setLike(boolean like) {
		isLike = like;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	@Override
	public String toString() {
		return "Dynamic{" +
				"dynamicId=" + dynamicId +
				", userId=" + userId +
				", userName='" + userName + '\'' +
				", userSchool='" + userSchool + '\'' +
				", dynamicContent='" + dynamicContent + '\'' +
				", dynamicStatus=" + dynamicStatus +
				", gmtCreate=" + gmtCreate +
				", imagePath=" + imagePath +
				", dynamicLikes=" + dynamicLikes +
				", dynamicForwards=" + dynamicForwards +
				", dynamicComments=" + dynamicComments +
				", isLike=" + isLike +
				'}';
	}
}
