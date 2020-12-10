package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Visit {
	private int visit_user_id1;
	private int visit_user_id2;
	private int visit_count;
	private Date gmt_create;
	private Date gmt_modified;
	public void setVisit_user_id1(int visit_user_id1){
		this.visit_user_id1 = visit_user_id1;
	}
	public int getVisit_user_id1(){
		return visit_user_id1;
	}
	public void setVisit_user_id2(int visit_user_id2){
		this.visit_user_id2 = visit_user_id2;
	}
	public int getVisit_user_id2(){
		return visit_user_id2;
	}
	public void setVisit_count(int visit_count){
		this.visit_count = visit_count;
	}
	public int getVisit_count(){
		return visit_count;
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
