package com.study.member.vo;

@SuppressWarnings("serial")
public class MemberSearchVO {
	private String searchJob;
	private String searchLike;
	private String searchType;
	private String searchWord;
	
	
//	public String toString() {
//		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
//	}
	
	public String getSearchJob() {
		return searchJob;
	}
	public void setSearchJob(String searchJob) {
		this.searchJob = searchJob;
	}
	public String getSearchLike() {
		return searchLike;
	}
	public void setSearchLike(String searchLike) {
		this.searchLike = searchLike;
	}
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	
	
}
