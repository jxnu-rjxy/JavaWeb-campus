package cn.edu.jxnu.rj.domain;

import java.util.Date;


public class User {
	private int userId;
	private String userName;
	private String userPhone;
	private int userGender;
	private Date userBirthday;
	private String userPassword;
	private String userProvince;
	private String userCity;
	private int userEmotionStatus;
	private int userMatchStatus;
	private String userSignature;
	private String userRealName;
	private String userSchool;
	private String userDept;
	private String userMajor;
	private String userGrade;
	private String userImage = "default/headImage.jpg";
	private Date gmtCreate;
	private Date gmtModified;
	private int userFriendsNum = 0;
	private int userFollowsNum = 0;
	private int userFollowersNum = 0;


	//通过手机号和密码
	public User(String userPhone, String userPassword) {
		this.userPhone = userPhone;
		this.userPassword = userPassword;
	}

	//通过用户id
	public User(int userId) {
		this.userId = userId;
	}

	//无参构造器
	public User() {
	}

	//用户基本信息：不可更改的
	public User(int userId, String userName, String userPhone, String userRealName, String userSchool) {
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userRealName = userRealName;
		this.userSchool = userSchool;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				", userPhone='" + userPhone + '\'' +
				", userGender=" + userGender +
				", userBirthday=" + userBirthday +
				", userPassword='" + userPassword + '\'' +
				", userProvince='" + userProvince + '\'' +
				", userCity='" + userCity + '\'' +
				", userEmotionStatus=" + userEmotionStatus +
				", userMatchStatus=" + userMatchStatus +
				", userSignature='" + userSignature + '\'' +
				", userRealName='" + userRealName + '\'' +
				", userSchool='" + userSchool + '\'' +
				", userDept='" + userDept + '\'' +
				", userMajor='" + userMajor + '\'' +
				", userGrade='" + userGrade + '\'' +
				", userImage='" + userImage + '\'' +
				", gmtCreate=" + gmtCreate +
				", gmtModified=" + gmtModified +
				", userFriendsNum=" + userFriendsNum +
				", userFollowsNum=" + userFollowsNum +
				", userFollowersNum=" + userFollowersNum +
				'}';
	}

	//用户注册
	public User(String userName, String userPhone, int userGender, Date userBirthday, String userPassword, String userProvince, String userCity, int userEmotionStatus, String userRealName, String userSchool, String userDept, String userMajor, String userGrade) {
		this.userName = userName;
		this.userPhone = userPhone;
		this.userGender = userGender;
		this.userBirthday = userBirthday;
		this.userPassword = userPassword;
		this.userProvince = userProvince;
		this.userCity = userCity;
		this.userEmotionStatus = userEmotionStatus;
		this.userRealName = userRealName;
		this.userSchool = userSchool;
		this.userDept = userDept;
		this.userMajor = userMajor;
		this.userGrade = userGrade;
	}


	//全参构造器


	public User(int userId, String userName, String userPhone, int userGender, Date userBirthday, String userPassword, String userProvince, String userCity, int userEmotionStatus, int userMatchStatus, String userSignature, String userRealName, String userSchool, String userDept, String userMajor, String userGrade, String userImage, Date gmtCreate, Date gmtModified, int userFriendsNum, int userFollowsNum, int userFollowersNum) {
		this.userId = userId;
		this.userName = userName;
		this.userPhone = userPhone;
		this.userGender = userGender;
		this.userBirthday = userBirthday;
		this.userPassword = userPassword;
		this.userProvince = userProvince;
		this.userCity = userCity;
		this.userEmotionStatus = userEmotionStatus;
		this.userMatchStatus = userMatchStatus;
		this.userSignature = userSignature;
		this.userRealName = userRealName;
		this.userSchool = userSchool;
		this.userDept = userDept;
		this.userMajor = userMajor;
		this.userGrade = userGrade;
		this.userImage = userImage;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.userFriendsNum = userFriendsNum;
		this.userFollowsNum = userFollowsNum;
		this.userFollowersNum = userFollowersNum;
	}

	//用户修改资料
	public User(int userId, String userName, Date userBirthday, String userProvince, String userCity, int userEmotionStatus, String userSignature, String userDept, String userMajor,String userImage) {
		this.userId = userId;
		this.userName = userName;
		this.userBirthday = userBirthday;
		this.userProvince = userProvince;
		this.userCity = userCity;
		this.userEmotionStatus = userEmotionStatus;
		this.userSignature = userSignature;
		this.userDept = userDept;
		this.userMajor = userMajor;
		this.userImage = userImage;
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

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public int getUserGender() {
		return userGender;
	}

	public void setUserGender(int userGender) {
		this.userGender = userGender;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserProvince() {
		return userProvince;
	}

	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public int getUserEmotionStatus() {
		return userEmotionStatus;
	}

	public void setUserEmotionStatus(int userEmotionStatus) {
		this.userEmotionStatus = userEmotionStatus;
	}

	public int getUserMatchStatus() {
		return userMatchStatus;
	}

	public void setUserMatchStatus(int userMatchStatus) {
		this.userMatchStatus = userMatchStatus;
	}

	public String getUserSignature() {
		return userSignature;
	}

	public void setUserSignature(String userSignature) {
		this.userSignature = userSignature;
	}

	public String getUserRealName() {
		return userRealName;
	}

	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}

	public String getUserSchool() {
		return userSchool;
	}

	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}

	public String getUserDept() {
		return userDept;
	}

	public void setUserDept(String userDept) {
		this.userDept = userDept;
	}

	public String getUserMajor() {
		return userMajor;
	}

	public void setUserMajor(String userMajor) {
		this.userMajor = userMajor;
	}

	public String getUserGrade() {
		return userGrade;
	}

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public void setUserGrade(String userGrade) {
		this.userGrade = userGrade;
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

	public int getUserFriendsNum() {
		return userFriendsNum;
	}

	public void setUserFriendsNum(int userFriendsNum) {
		this.userFriendsNum = userFriendsNum;
	}

	public int getUserFollowsNum() {
		return userFollowsNum;
	}

	public void setUserFollowsNum(int userFollowsNum) {
		this.userFollowsNum = userFollowsNum;
	}

	public int getUserFollowersNum() {
		return userFollowersNum;
	}

	public void setUserFollowersNum(int userFollowersNum) {
		this.userFollowersNum = userFollowersNum;
	}
}
