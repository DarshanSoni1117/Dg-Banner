package com.DgBanner.DTO;

import java.util.List;

// when owner want to see the details of specific screen

public class ScreenSpecificDetailDto {

	private String screenName;
	private String resolution;
	private String size;
	private String location;
	private String mediaPreview;
	private boolean activeStatus;
	private List<SlotAllDetailsDto> slotDtoList;

	public ScreenSpecificDetailDto(String screenName, String resolution, String size, String location,
			String mediaPreview,boolean activeStatus, List<SlotAllDetailsDto> slotDtoList) {

		this.screenName = screenName;
		this.resolution = resolution;
		this.size = size;
		this.location = location;
		this.mediaPreview = mediaPreview;
		this.activeStatus=activeStatus;
		this.slotDtoList = slotDtoList;
	}
	public ScreenSpecificDetailDto() {

	}

	public boolean isActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getScreenName() {
		return screenName;
	}
	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}
	public String getResolution() {
		return resolution;
	}
	public void setResolution(String resolution) {
		this.resolution = resolution;
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
	public String getMediaPreview() {
		return mediaPreview;
	}
	public void setMediaPreview(String mediaPreview) {
		this.mediaPreview = mediaPreview;
	}
	public List<SlotAllDetailsDto> getSlotDtoList() {
		return slotDtoList;
	}
	public void setSlotDtoList(List<SlotAllDetailsDto> slotDtoList) {
		this.slotDtoList = slotDtoList;
	}
	@Override
	public String toString() {
		return "ScreenDetailDto [screenName=" + screenName + ", resolution=" + resolution + ", size=" + size
				+ ", location=" + location + ", mediaPreview=" + mediaPreview + ",Active Status= "+activeStatus+", slotDtoList=" + slotDtoList + "]";
	}

}
