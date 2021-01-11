package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Givelike {
	private int givelike_id;
	private int work_id;
	private int work_type;
	private int user_id;
	private Date gmt_create;
	private Date gmt_modified;

	@Override
	public String toString() {
		return "Givelike{" +
				"givelike_id=" + givelike_id +
				", work_id=" + work_id +
				", work_type=" + work_type +
				", user_id=" + user_id +
				", gmt_create=" + gmt_create +
				", gmt_modified=" + gmt_modified +
				'}';
	}

	public Givelike(int givelike_id, int work_id, int work_type, int user_id, Date gmt_create, Date gmt_modified) {
		this.givelike_id = givelike_id;
		this.work_id = work_id;
		this.work_type = work_type;
		this.user_id = user_id;
		this.gmt_create = gmt_create;
		this.gmt_modified = gmt_modified;
	}

	public Givelike(int work_id, int work_type, int user_id) {
		this.work_id = work_id;
		this.work_type = work_type;
		this.user_id = user_id;
	}

	public Givelike() {
	}

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
