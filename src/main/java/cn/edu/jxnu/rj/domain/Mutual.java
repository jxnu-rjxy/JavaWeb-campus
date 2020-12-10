package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Mutual {
	private int mutual_id;
	private int user_id;
	private String mutual_title;
	private String mutual_content;
	private Date gmt_create;
	private Date gmt_modified;
	public void setMutual_id(int mutual_id){
		this.mutual_id = mutual_id;
	}
	public int getMutual_id(){
		return mutual_id;
	}
	public void setUser_id(int user_id){
		this.user_id = user_id;
	}
	public int getUser_id(){
		return user_id;
	}
	public void setMutual_title(String mutual_title){
		this.mutual_title = mutual_title;
	}
	public String getMutual_title(){
		return mutual_title;
	}
	public void setMutual_content(String mutual_content){
		this.mutual_content = mutual_content;
	}
	public String getMutual_content(){
		return mutual_content;
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
