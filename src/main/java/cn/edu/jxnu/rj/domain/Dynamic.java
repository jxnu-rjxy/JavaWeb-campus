package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Dynamic {
	//所有参数：dynamic_id,user_id,dynamic_content,media_id,dynamic_status,gmt_create,gmt_modified
	private int dynamic_id;
	private int user_id;
	private String dynamic_content;
	private int media_id;
	private int dynamic_status;
	private Date gmt_create;
	private Date gmt_modified;

	public Dynamic() {
	}

	public Dynamic(int dynamic_id, int user_id, String dynamic_content, int media_id, int dynamic_status, Date gmt_create, Date gmt_modified) {
		this.dynamic_id = dynamic_id;
		this.user_id = user_id;
		this.dynamic_content = dynamic_content;
		this.media_id = media_id;
		this.dynamic_status = dynamic_status;
		this.gmt_create = gmt_create;
		this.gmt_modified = gmt_modified;
	}

	public void setDynamic_id(int dynamic_id){
		this.dynamic_id = dynamic_id;
	}
	public int getDynamic_id(){
		return dynamic_id;
	}
	public void setUser_id(int user_id){
		this.user_id = user_id;
	}
	public int getUser_id(){
		return user_id;
	}
	public void setDynamic_content(String dynamic_content){
		this.dynamic_content = dynamic_content;
	}
	public String getDynamic_content(){
		return dynamic_content;
	}
	public void setMedia_id(int media_id){
		this.media_id = media_id;
	}
	public int getMedia_id(){
		return media_id;
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
