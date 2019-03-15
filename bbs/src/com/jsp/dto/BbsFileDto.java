package com.jsp.dto;

public class BbsFileDto {
	
	String fileId;
	String bbsId;
	String orgn_File_Nm;
	String save_File_Nm;
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getBbsId() {
		return bbsId;
	}
	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}
	public String getOrgn_File_Nm() {
		return orgn_File_Nm;
	}
	public void setOrgn_File_Nm(String orgn_File_Nm) {
		this.orgn_File_Nm = orgn_File_Nm;
	}
	public String getSave_File_Nm() {
		return save_File_Nm;
	}
	public void setSave_File_Nm(String save_File_Nm) {
		this.save_File_Nm = save_File_Nm;
	}
	@Override
	public String toString() {
		return "BbsFileDto [fileId=" + fileId + ", bbsId=" + bbsId + ", orgn_File_Nm=" + orgn_File_Nm
				+ ", save_File_Nm=" + save_File_Nm + "]";
	}
	
	
}
