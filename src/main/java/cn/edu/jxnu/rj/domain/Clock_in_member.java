package	cn.edu.jxnu.rj.domain;

import java.sql.Timestamp;
import java.util.Date;


public class Clock_in_member {
	private int clock_in_target_id;
	private int user_id;
	private Date gmt_create;
	private Date gmt_modified;
	private int clock_in_times;

	public Clock_in_member(int clock_in_target_id, int user_id,int clock_in_times,Timestamp gmt_create, Timestamp gmt_modified) {
		this.clock_in_target_id = clock_in_target_id;
		this.user_id = user_id;
		this.clock_in_times = clock_in_times;
		this.gmt_create = gmt_create;
		this.gmt_modified = gmt_modified;
	}

	public Clock_in_member(int user_id, int clock_in_target_id) {
		this.clock_in_target_id = clock_in_target_id;
		this.user_id = user_id;
	}

	public void setClock_in_target_id(int clock_in_target_id){
		this.clock_in_target_id = clock_in_target_id;
	}
	public int getClock_in_target_id(){
		return clock_in_target_id;
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

	public int getClock_in_times() {
		return clock_in_times;
	}

	public void setClock_in_times(int clock_in_times) {
		this.clock_in_times = clock_in_times;
	}
}
