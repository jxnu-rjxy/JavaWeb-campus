package cn.edu.jxnu.rj.domain;
public class Db_campus_city {
	private int id;
	private int province_id;
	private String city_name;
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	public void setProvince_id(int province_id){
		this.province_id = province_id;
	}
	public int getProvince_id(){
		return province_id;
	}
	public void setCity_name(String city_name){
		this.city_name = city_name;
	}
	public String getCity_name(){
		return city_name;
	}
}
