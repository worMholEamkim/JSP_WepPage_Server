package com.jsp.dto;

public class BbsDto {
	
	private String id;
	private String bbsId;
	private String bbsTitle;
	private String bbsDate;
	private String bbsCategory;
	private String bbsContent;
	private String bbsHit;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBbsId() {
		return bbsId;
	}
	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsDate() {
		return bbsDate;
	}
	public void setBbsDate(String bbsDate) {
		this.bbsDate = bbsDate;
	}
	public String getBbsCategory() {
		return bbsCategory;
	}
	public void setBbsCategory(String bbsCategory) {
		this.bbsCategory = bbsCategory;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public String getBbsHit() {
		return bbsHit;
	}
	public void setBbsHit(String bbsHit) {
		this.bbsHit = bbsHit;
	}
	@Override
	public String toString() {
		return "BbsDto [id=" + id + ", bbsId=" + bbsId + ", bbsTitle=" + bbsTitle + ", bbsDate=" + bbsDate
				+ ", bbsCategory=" + bbsCategory + ", bbsContent=" + bbsContent + ", bbsHit=" + bbsHit + "]";
	}
	
}
