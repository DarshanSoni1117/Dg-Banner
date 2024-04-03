package com.DgBanner.DTO;

import java.math.BigDecimal;
// all the details related to slot will passed
public class SlotAllDetailsDto {

	private Integer slotId;
	private String advertiserName;
	private String interval;
	private BigDecimal price;
	private boolean available;

	public SlotAllDetailsDto() {
	}

	public SlotAllDetailsDto(Integer slotId,String advertiserName, String interval, BigDecimal price, boolean available) {

		this.slotId=slotId;
		this.advertiserName = advertiserName;
		this.interval = interval;
		this.price = price;
		this.available = available;
	}
	public Integer getSlotId() {
		return slotId;
	}
	public void setSlotId(Integer slotId) {
		this.slotId=slotId;
	}
	public String getAdvertiserName() {
		return advertiserName;
	}

	public void setAdvertiserName(String advertiserName) {
		this.advertiserName = advertiserName;
	}

	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "SlotDetailDto [slotId = "+slotId +",advertiserName=" + advertiserName + ", interval=" + interval + ", price=" + price
				+ ", available=" + available + "]";
	}





}
