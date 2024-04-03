package com.DgBanner.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "media_preview")
public class MediaPreview {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private Integer id;

	// for now storing adding only string not the media itself
	private String preview;
	
	@OneToOne
	@JoinColumn(name="screen_id",referencedColumnName = "id")
	private Screen screen;



	public Screen getScreen() {
		return screen;
	}

	public void setScreen(Screen screen) {
		this.screen = screen;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPreview() {
		return preview;
	}

	public void setPreview(String preview) {
		this.preview = preview;
	}

	public MediaPreview(Integer id, String preview) {
		this.id = id;
		this.preview = preview;

	}

	public MediaPreview() {

	}

	private MediaPreview(Integer id, String preview, Screen screen) {
		super();
		this.id = id;
		this.preview = preview;
		this.screen = screen;
	}


	@Override
	public String toString() {
		return "MediaPreview [previewId=" + id + ", preview=" + preview + "]";
	}



}
