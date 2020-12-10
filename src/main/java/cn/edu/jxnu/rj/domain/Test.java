package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Test {
	private int test_id;
	private int user_id;
	private Date gmt_create;
	private Date gmt_modified;
	public void setTest_id(int test_id){
		this.test_id = test_id;
	}
	public int getTest_id(){
		return test_id;
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
