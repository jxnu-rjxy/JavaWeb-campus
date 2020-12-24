package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Group_member {
	private int group_id;
	private int user_id;
	private Date gmt_create;
	private Date gmt_modified;

	public Group_member(int mutual_id, int user_id, String group_card, Date gmt_create, Date gmt_modified) {

	}

	public void setGroup_id(int group_id){
		this.group_id = group_id;
	}
	public int getGroup_id(){
		return group_id;
	}
	public void setUser_id(int user_id){
		this.user_id = user_id;
	}
	public int getUser_id(){
		return user_id;
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
