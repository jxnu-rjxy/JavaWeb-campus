package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Puzzle {
	private int puzzle_id;
	private int user_id;
	private String puzzle_title;
	private String puzzle_content;
	private Date gmt_create;
	private Date gmt_modified;
	public void setPuzzle_id(int puzzle_id){
		this.puzzle_id = puzzle_id;
	}
	public int getPuzzle_id(){
		return puzzle_id;
	}
	public void setUser_id(int user_id){
		this.user_id = user_id;
	}
	public int getUser_id(){
		return user_id;
	}
	public void setPuzzle_title(String puzzle_title){
		this.puzzle_title = puzzle_title;
	}
	public String getPuzzle_title(){
		return puzzle_title;
	}
	public void setPuzzle_content(String puzzle_content){
		this.puzzle_content = puzzle_content;
	}
	public String getPuzzle_content(){
		return puzzle_content;
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
