package com.DgBanner.DTO;

import java.math.BigDecimal;

public class SlotsDto {

	private String interval;

	private BigDecimal price;

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

	public SlotsDto() {
	}

	public SlotsDto( String interval, BigDecimal price) {

		this.interval = interval;
		this.price = price;

	}

	@Override
	public String toString() {
		return "Slots [ interval=" + interval + ", price=" + price + "]";
	}



}
