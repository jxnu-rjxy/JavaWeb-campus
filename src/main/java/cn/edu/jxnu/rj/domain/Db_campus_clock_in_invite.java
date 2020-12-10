package cn.edu.jxnu.rj.domain;

import java.util.Date;

public class Db_campus_clock_in_invite {
	private int user_id1;
	private int user_id2;
	private int clock_in_target_id;
	private Date gmt_create;
	private Date gmt_modified;
	public void setUser_id1(int user_id1){
		this.user_id1 = user_id1;
	}
	public int getUser_id1(){
		return user_id1;
	}
	public void setUser_id2(int user_id2){
		this.user_id2 = user_id2;
	}
	public int getUser_id2(){
		return user_id2;
	}
	public void setClock_in_target_id(int clock_in_target_id){
		this.clock_in_target_id = clock_in_target_id;
	}
	public int getClock_in_target_id(){
		return clock_in_target_id;
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
