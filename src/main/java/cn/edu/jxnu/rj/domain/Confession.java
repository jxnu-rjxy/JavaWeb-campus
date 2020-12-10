package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Confession {
	private int confession_id;
	private int confession_user_id1;
	private int confession_user_id2;
	private String confession_content;
	private Date gmt_create;
	private Date gmt_modified;
	public void setConfession_id(int confession_id){
		this.confession_id = confession_id;
	}
	public int getConfession_id(){
		return confession_id;
	}
	public void setConfession_user_id1(int confession_user_id1){
		this.confession_user_id1 = confession_user_id1;
	}
	public int getConfession_user_id1(){
		return confession_user_id1;
	}
	public void setConfession_user_id2(int confession_user_id2){
		this.confession_user_id2 = confession_user_id2;
	}
	public int getConfession_user_id2(){
		return confession_user_id2;
	}
	public void setConfession_content(String confession_content){
		this.confession_content = confession_content;
	}
	public String getConfession_content(){
		return confession_content;
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
