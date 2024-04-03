package com.DgBanner.DTO;

import java.util.List;

import com.DgBanner.Entities.MediaPreview;

public class ScreenDto {

	private String name;
	private String resolution;
	private String size;
	private String location;
	private List<MediaPreview> preview;
	private List<SlotsDto> slotsDto;

	public ScreenDto(String name, String resolution, String size, String location,
			List<MediaPreview> preview, List<SlotsDto> slots) {

		this.name = name;
		this.resolution = resolution;
		this.size = size;
		this.location = location;
		this.preview = preview;
		this.slotsDto = slots;
	}

	public ScreenDto() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<MediaPreview> getPreview() {
		return preview;
	}

	public void setPreview(List<MediaPreview> preview) {
		this.preview = preview;
	}

	public List<SlotsDto> getSlots() {
		return slotsDto;
	}

	public void setSlots(List<SlotsDto> slots) {
		this.slotsDto = slots;
	}

	@Override
	public String toString() {
		return "OwnerScreenRequestDto [name=" + name + ", resolution=" + resolution + ", size=" + size + ", location="
				+ location + ", preview=" + preview + ", slots=" + slotsDto + "]";
	}



}
