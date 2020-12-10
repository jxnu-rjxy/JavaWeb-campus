package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Mutual_member {
	private int mutual_id;
	private int user_id;
	private String group_card;
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
	public void setGroup_card(String group_card){
		this.group_card = group_card;
	}
	public String getGroup_card(){
		return group_card;
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
