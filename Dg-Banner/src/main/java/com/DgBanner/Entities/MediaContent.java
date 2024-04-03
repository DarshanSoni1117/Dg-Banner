package com.DgBanner.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mediaContent")
public class MediaContent {

		@Id
		@GeneratedValue(strategy =GenerationType.IDENTITY )
		private Integer id;

		// for now storing adding only string not the media itself
		private String content;
		
		@OneToOne
		@JoinColumn(name = "slot_id" ,referencedColumnName  = "id")
		private Slots slots;

		public Integer getContentId() {
			return id;
		}

		public void setContentId(Integer id) {
			this.id = id;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public MediaContent(Integer id, String content) {
			this.id = id;
			this.content = content;
		}

		public MediaContent() {

		}

		@Override
		public String toString() {
			return "MediaContent [contentId=" + id + ", content=" + content + "]";
		}

	}



