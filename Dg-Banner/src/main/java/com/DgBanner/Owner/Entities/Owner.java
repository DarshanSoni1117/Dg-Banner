package com.DgBanner.Owner.Entities;

import java.util.List;

import com.DgBanner.Entities.Screen;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "user_detail")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message ="name should not be null")
	private String name;

	@Email(message="enter a valid email address")
	private String mailId;

	@Pattern(regexp = "^(\\+?[01])?[-.\\s]?\\(?[1-9]\\d{2}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$" , message = "invalid contact number")
	private String contactNumber;

	@OneToMany(cascade = CascadeType.ALL,mappedBy ="owner")
	private List<Screen> screen;

	// add in application Properties
	private int roleId=1;

	private boolean isActive=true;

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

	public void setScreen(List<Screen> screen) {
		this.screen = screen;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getRoleId() {
		return roleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public List<Screen> getScreen() {
		return screen;
	}

	public Owner() {

	}

	public Owner(Integer id, @NotEmpty(message = "name should not be null") String name,
			@Email(message = "enter a valid email address") String mailId,
			@Pattern(regexp = "^(\\+?[01])?[-.\\s]?\\(?[1-9]\\d{2}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$", message = "invalid contact number") String contactNumber,
			List<Screen> screen, int roleId, boolean isActive) {
		super();
		this.id = id;
		this.name = name;
		this.mailId = mailId;
		this.contactNumber = contactNumber;
		this.screen = screen;
		this.roleId = roleId;
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", mailId=" + mailId + ", contactNumber=" + contactNumber
				+ ", screen=" + screen + ", roleId=" + roleId + ", isActive=" + isActive + "]";
	}



}
