package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Friend {
	private int user_id1;
	private int user_id2;
	private int friend_type;
	private int is_friend;
	private String friend_name1;
	private String friend_name2;
	private Date gmt_create;
	private Date gmt_modified;

	public Friend() {
	}

	public Friend(int user_id1, int user_id2, int friend_type, int is_friend) {
		this.user_id1 = user_id1;
		this.user_id2 = user_id2;
		this.friend_type = friend_type;
		this.is_friend = is_friend;
	}

	public Friend(int user_id1, int user_id2, int friend_type, int is_friend, String friend_name1, String friend_name2, Date gmt_create, Date gmt_modified) {
		this.user_id1 = user_id1;
		this.user_id2 = user_id2;
		this.friend_type = friend_type;
		this.is_friend = is_friend;
		this.friend_name1 = friend_name1;
		this.friend_name2 = friend_name2;
		this.gmt_create = gmt_create;
		this.gmt_modified = gmt_modified;
	}

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
	public void setFriend_type(int friend_type){
		this.friend_type = friend_type;
	}
	public int getFriend_type(){
		return friend_type;
	}
	public void setIs_friend(int is_friend){
		this.is_friend = is_friend;
	}
	public int getIs_friend(){
		return is_friend;
	}
	public void setFriend_name1(String friend_name1){
		this.friend_name1 = friend_name1;
	}
	public String getFriend_name1(){
		return friend_name1;
	}
	public void setFriend_name2(String friend_name2){
		this.friend_name2 = friend_name2;
	}
	public String getFriend_name2(){
		return friend_name2;
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
