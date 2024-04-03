package com.DgBanner.Owner.DTO;

// Only required information are shown related to screen in this dto

public class OwnerScreenDto {

	private Integer screenId;
	private String screenName;
	private String size;
	private String location;

	public OwnerScreenDto() {

	}

	public OwnerScreenDto(Integer screenId, String screenName, String size, String location) {
		super();
		this.screenId = screenId;
		this.screenName = screenName;
		this.size = size;
		this.location = location;
	}

	public Integer getScreenId() {
		return screenId;
	}

	public void setScreenId(Integer screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "OwnerScreenDto [screenId=" + screenId + ", screenName=" + screenName + ", size=" + size + ", location="
				+ location + "]";
	}





}
