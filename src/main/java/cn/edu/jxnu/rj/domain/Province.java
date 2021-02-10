package	cn.edu.jxnu.rj.domain;
public class Province {
	private int pid;
	private String province;

	public Province(int pid, String province) {
		this.pid = pid;
		this.province = province;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public void setProvince(String province){
		this.province = province;
	}
	public String getProvince(){
		return province;
	}
}
