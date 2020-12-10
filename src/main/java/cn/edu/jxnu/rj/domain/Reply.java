package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Reply {
	private int reply_id;
	private int comment_id;
	private String reply_content;
	private int user_id;
	private Date gmt_create;
	private Date gmt_modified;
	public void setReply_id(int reply_id){
		this.reply_id = reply_id;
	}
	public int getReply_id(){
		return reply_id;
	}
	public void setComment_id(int comment_id){
		this.comment_id = comment_id;
	}
	public int getComment_id(){
		return comment_id;
	}
	public void setReply_content(String reply_content){
		this.reply_content = reply_content;
	}
	public String getReply_content(){
		return reply_content;
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
