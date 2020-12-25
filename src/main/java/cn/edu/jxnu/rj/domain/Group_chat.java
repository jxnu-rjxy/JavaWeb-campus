package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Group_chat {

	public Group_chat(int mutual_id, int user_id, int group_chat_id, String group_chat_conent, Date gmt_create, Date gmt_modified) {
		this.mutual_id = mutual_id;
		this.user_id = user_id;
		this.group_chat_id = group_chat_id;
		this.group_chat_conent = group_chat_conent;
		this.gmt_create = gmt_create;
		this.gmt_modified = gmt_modified;
	}

	private int mutual_id;
	private int user_id;
	private int group_chat_id;
	private String group_chat_conent;
	private Date gmt_create;
	private Date gmt_modified;

	public Group_chat(int user_id, int mutual_id, String group_chat_conent) {
		this.user_id = user_id;
		this.mutual_id = mutual_id;
		this.group_chat_conent = group_chat_conent;
	}

	public int getMutual_id() {
		return mutual_id;
	}

	public void setMutual_id(int mutual_id) {
		this.mutual_id = mutual_id;
	}

	public void setUser_id(int user_id){
		this.user_id = user_id;
	}
	public int getUser_id(){
		return user_id;
	}
	public void setGroup_chat_id(int group_chat_id){
		this.group_chat_id = group_chat_id;
	}
	public int getGroup_chat_id(){
		return group_chat_id;
	}
	public void setGroup_chat_conent(String group_chat_conent){
		this.group_chat_conent = group_chat_conent;
	}
	public String getGroup_chat_conent(){
		return group_chat_conent;
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
