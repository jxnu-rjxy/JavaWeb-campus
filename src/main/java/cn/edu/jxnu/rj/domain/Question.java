package	cn.edu.jxnu.rj.domain;
public class Question {
	private int question_id;
	private int test_id;
	private String question_name;
	private int question_type;
	private String question_A;
	private String question_B;
	private String question_C;
	private String question_D;
	public void setQuestion_id(int question_id){
		this.question_id = question_id;
	}
	public int getQuestion_id(){
		return question_id;
	}
	public void setTest_id(int test_id){
		this.test_id = test_id;
	}
	public int getTest_id(){
		return test_id;
	}
	public void setQuestion_name(String question_name){
		this.question_name = question_name;
	}
	public String getQuestion_name(){
		return question_name;
	}
	public void setQuestion_type(int question_type){
		this.question_type = question_type;
	}
	public int getQuestion_type(){
		return question_type;
	}
	public void setQuestion_A(String question_A){
		this.question_A = question_A;
	}
	public String getQuestion_A(){
		return question_A;
	}
	public void setQuestion_B(String question_B){
		this.question_B = question_B;
	}
	public String getQuestion_B(){
		return question_B;
	}
	public void setQuestion_C(String question_C){
		this.question_C = question_C;
	}
	public String getQuestion_C(){
		return question_C;
	}
	public void setQuestion_D(String question_D){
		this.question_D = question_D;
	}
	public String getQuestion_D(){
		return question_D;
	}
}
