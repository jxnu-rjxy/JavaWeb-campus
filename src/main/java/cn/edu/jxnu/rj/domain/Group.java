package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Group {
	private int group_id;
	private String group_name;
	private Date gmt_create;
	private Date gmt_modified;
	public void setGroup_id(int group_id){
		this.group_id = group_id;
	}
	public int getGroup_id(){
		return group_id;
	}
	public void setGroup_name(String group_name){
		this.group_name = group_name;
	}
	public String getGroup_name(){
		return group_name;
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
