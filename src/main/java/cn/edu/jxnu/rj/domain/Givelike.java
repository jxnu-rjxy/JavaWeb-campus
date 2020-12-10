package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Givelike {
	private int givelike_id;
	private int work_id;
	private int work_type;
	private int user_id;
	private int dynamic_status;
	private Date gmt_create;
	private Date gmt_modified;
	public void setGivelike_id(int givelike_id){
		this.givelike_id = givelike_id;
	}
	public int getGivelike_id(){
		return givelike_id;
	}
	public void setWork_id(int work_id){
		this.work_id = work_id;
	}
	public int getWork_id(){
		return work_id;
	}
	public void setWork_type(int work_type){
		this.work_type = work_type;
	}
	public int getWork_type(){
		return work_type;
	}
	public void setUser_id(int user_id){
		this.user_id = user_id;
	}
	public int getUser_id(){
		return user_id;
	}
	public void setDynamic_status(int dynamic_status){
		this.dynamic_status = dynamic_status;
	}
	public int getDynamic_status(){
		return dynamic_status;
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
