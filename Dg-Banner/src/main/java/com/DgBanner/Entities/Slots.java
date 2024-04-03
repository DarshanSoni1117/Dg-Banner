package com.DgBanner.Entities;

import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;

import com.DgBanner.Advertiser.Entities.Advertiser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;


@Entity
@Table(name = "slots_detail")
public class Slots {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	private String interval;

	@Min(0)
	@NumberFormat
	private BigDecimal price;

	private boolean available=true;

	private boolean isActive=true;

	private String contentType;

	@OneToOne(mappedBy = "slots",cascade = CascadeType.ALL)
	private MediaContent mediaContent;

	@ManyToOne
	@JoinColumn(name="screen_id")
	private Screen screen;

	@ManyToOne
	@JoinColumn(name = "user_id",referencedColumnName = "id")
	private Advertiser advertiser;

	public Slots() {
	}

	public Slots(Integer id, @NotEmpty String interval, @Min(0) BigDecimal price, boolean available, boolean isActive,
			String contentType, MediaContent mediaContent, Screen screen) {
		super();
		this.id = id;
		this.interval = interval;
		this.price = price;
		this.available = available;
		this.isActive = isActive;
		this.contentType = contentType;
		this.mediaContent = mediaContent;
		this.screen = screen;
	}




	public Advertiser getAdvertiser() {
		return advertiser;
	}

	public void setAdvertiser(Advertiser advertiser) {
		this.advertiser = advertiser;
	}

	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public MediaContent getMediaContent() {
		return mediaContent;
	}

	public void setMediaContent(MediaContent mediaContent) {
		this.mediaContent = mediaContent;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
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
		return "Slots [id=" + id + ", interval=" + interval + ", price=" + price + ", available=" + available
				+ ", isActive=" + isActive + ", mediaContent=" + mediaContent + ", contentType=" + contentType + "]";
	}





}
