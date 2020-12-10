package	cn.edu.jxnu.rj.domain;


import java.util.Date;

public class Comment {
	private int comment_id;
	private int work_id;
	private int work_type;
	private int user_id;
	private String comment_content;
	private Date gmt_create;
	private Date gmt_modified;
	public void setComment_id(int comment_id){
		this.comment_id = comment_id;
	}
	public int getComment_id(){
		return comment_id;
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
	public void setComment_content(String comment_content){
		this.comment_content = comment_content;
	}
	public String getComment_content(){
		return comment_content;
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
