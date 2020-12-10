package	cn.edu.jxnu.rj.domain;
public class Media {
	private int media_id;
	private String media_path;
	private int dynamic_id;
	public void setMedia_id(int media_id){
		this.media_id = media_id;
	}
	public int getMedia_id(){
		return media_id;
	}
	public void setMedia_path(String media_path){
		this.media_path = media_path;
	}
	public String getMedia_path(){
		return media_path;
	}
	public void setDynamic_id(int dynamic_id){
		this.dynamic_id = dynamic_id;
	}
	public int getDynamic_id(){
		return dynamic_id;
	}
}
