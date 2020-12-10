package cn.edu.jxnu.rj.domain;

import java.util.Date;


public class User {
	private int user_id;
	private String user_name;
	private String user_phone;
	private int user_gender;
	private Date user_borthday;
	private String user_password;
	private int user_province;
	private int user_city;
	private int user_emotion_status;
	private int user_match_status;
	private String user_signature;
	private String user_realname;
	private String user_school;
	private String user_dept;
	private String user_major;
	private String user_grade;
	private Date gmt_create;
	private Date gmt_modified;

	public User(int user_id, String user_name, String user_phone, int user_gender, Date user_borthday, String user_password, int user_province, int user_city, int user_emotion_status, int user_match_status, String user_signature, String user_realname, String user_school, String user_dept, String user_major, String user_grade, Date gmt_create, Date gmt_modified) {
	}

	public void setUser_id(int user_id){
		this.user_id = user_id;
	}
	public int getUser_id(){
		return user_id;
	}
	public void setUser_name(String user_name){
		this.user_name = user_name;
	}
	public String getUser_name(){
		return user_name;
	}
	public void setUser_phone(String user_phone){
		this.user_phone = user_phone;
	}
	public String getUser_phone(){
		return user_phone;
	}
	public void setUser_gender(int user_gender){
		this.user_gender = user_gender;
	}
	public int getUser_gender(){
		return user_gender;
	}
	public void setUser_borthday(Date user_borthday){
		this.user_borthday = user_borthday;
	}
	public Date getUser_borthday(){
		return user_borthday;
	}
	public void setUser_password(String user_password){
		this.user_password = user_password;
	}
	public String getUser_password(){
		return user_password;
	}
	public void setUser_province(int user_province){
		this.user_province = user_province;
	}
	public int getUser_province(){
		return user_province;
	}
	public void setUser_city(int user_city){
		this.user_city = user_city;
	}
	public int getUser_city(){
		return user_city;
	}
	public void setUser_emotion_status(int user_emotion_status){
		this.user_emotion_status = user_emotion_status;
	}
	public int getUser_emotion_status(){
		return user_emotion_status;
	}
	public void setUser_match_status(int user_match_status){
		this.user_match_status = user_match_status;
	}
	public int getUser_match_status(){
		return user_match_status;
	}
	public void setUser_signature(String user_signature){
		this.user_signature = user_signature;
	}
	public String getUser_signature(){
		return user_signature;
	}
	public void setUser_realname(String user_realname){
		this.user_realname = user_realname;
	}
	public String getUser_realname(){
		return user_realname;
	}
	public void setUser_school(String user_school){
		this.user_school = user_school;
	}
	public String getUser_school(){
		return user_school;
	}
	public void setUser_dept(String user_dept){
		this.user_dept = user_dept;
	}
	public String getUser_dept(){
		return user_dept;
	}
	public void setUser_major(String user_major){
		this.user_major = user_major;
	}
	public String getUser_major(){
		return user_major;
	}
	public void setUser_grade(String user_grade){
		this.user_grade = user_grade;
	}
	public String getUser_grade(){
		return user_grade;
	}
	public void setGmt_create(Date gmt_create){
		this.gmt_create = gmt_create;
	}
	public Date getGmt_create(){
		return gmt_create;
	}
	public void setGmt_modified(Date gmt_modified){
		this.gmt_modified = gmt_modified;
	}
	public Date getGmt_modified(){
		return gmt_modified;
	}
}
