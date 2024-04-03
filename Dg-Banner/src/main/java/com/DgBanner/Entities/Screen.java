package com.DgBanner.Entities;

import java.util.ArrayList;
import java.util.List;

import com.DgBanner.Owner.Entities.Owner;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "screen_detail")
public class Screen{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message="name is needed")
	private String name;

	@NotEmpty(message = "resolution is needed")
	private String resolution;

	@NotEmpty(message = "dimension is needed")
	private String size;

	@NotEmpty(message = "location is needed")
	private String location;

	//add in application properties
	private boolean isActive=true;

	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	private List<MediaPreview> mediaPreview = new ArrayList<>();

	@OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
	private List<Slots> slots = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Owner owner;

	public Screen() {
	}

	public Screen(Integer id, @NotEmpty(message = "name is needed") String name,
			@NotEmpty(message = "resolution is needed") String resolution,
			@NotEmpty(message = "dimension is needed") String size,
			@NotEmpty(message = "location is needed") String location, boolean isActive, Owner owner,
			List<MediaPreview> mediaPreview, List<Slots> slots) {
		super();
		this.id = id;
		this.name = name;
		this.resolution = resolution;
		this.size = size;
		this.location = location;
		this.isActive = isActive;
		this.owner = owner;
		this.mediaPreview = mediaPreview;
		this.slots = slots;
	}



	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Slots> getSlots() {
		return slots;
	}

	public void setSlots(List<Slots> slots) {
		this.slots = slots;
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

	public List<MediaPreview> getMediaPreview() {
		return mediaPreview;
	}

	public void setMediaPreview(List<MediaPreview> mediaPreview) {
		this.mediaPreview = mediaPreview;
	}

	@Override
	public String toString() {
		return "Screen [id=" + id + ", name=" + name + ", resolution=" + resolution + ", size=" + size + ", location="
				+ location + ", isActive=" + isActive + ", mediaPreview=" + mediaPreview + ", slots=" + slots + "]";
	}


}
