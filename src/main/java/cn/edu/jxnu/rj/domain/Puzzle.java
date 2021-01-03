package	cn.edu.jxnu.rj.domain;

import java.util.Date;


public class Puzzle {
	private int puzzleId;
	private int userId;
	private String puzzleTitle;
	private String puzzleContent;
	private Date gmtCreate;
	private Date gmtModified;
	private int puzzleLikes;

	public Puzzle() {
	}

	public Puzzle(int puzzleId, int userId, String puzzleTitle, String puzzleContent, Date gmtCreate, Date gmtModified, int puzzleLikes) {
		this.puzzleId = puzzleId;
		this.userId = userId;
		this.puzzleTitle = puzzleTitle;
		this.puzzleContent = puzzleContent;
		this.gmtCreate = gmtCreate;
		this.gmtModified = gmtModified;
		this.puzzleLikes = puzzleLikes;
	}

	public Puzzle(int userId, String puzzleTitle, String puzzleContent) {
		this.userId = userId;
		this.puzzleTitle = puzzleTitle;
		this.puzzleContent = puzzleContent;
	}

	public int getPuzzleId() {
		return puzzleId;
	}

	public void setPuzzleId(int puzzleId) {
		this.puzzleId = puzzleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPuzzleTitle() {
		return puzzleTitle;
	}

	public void setPuzzleTitle(String puzzleTitle) {
		this.puzzleTitle = puzzleTitle;
	}

	public String getPuzzleContent() {
		return puzzleContent;
	}

	public void setPuzzleContent(String puzzleContent) {
		this.puzzleContent = puzzleContent;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public int getPuzzleLikes() {
		return puzzleLikes;
	}

	public void setPuzzleLikes(int puzzleLikes) {
		this.puzzleLikes = puzzleLikes;
	}
}
