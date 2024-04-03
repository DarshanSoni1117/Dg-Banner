package com.DgBanner.Advertiser.Entities;

import java.util.List;

import com.DgBanner.Entities.Slots;

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
public class Advertiser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message ="name should not be null")
	private String name;

	@Email(message="enter a valid email address")
	private String mailId;

	@Pattern(regexp = "^(\\+?[01])?[-.\\s]?\\(?[1-9]\\d{2}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$" , message = "invalid contact number")
	private String contactNumber;

	@OneToMany(mappedBy = "advertiser",cascade = { CascadeType.PERSIST ,CascadeType.REMOVE})
	private List<Slots> slots;

	private int roleId=2;

	public Advertiser() {

		}

	public Advertiser(Integer id, @NotEmpty(message = "name should not be null") String name,
			@Email(message = "enter a valid email address") String mailId,
			@Pattern(regexp = "^(\\+?[01])?[-.\\s]?\\(?[1-9]\\d{2}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$", message = "invalid contact number") String contactNumber) {
		super();
		this.id = id;
		this.name = name;
		this.mailId = mailId;
		this.contactNumber = contactNumber;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<Slots> getSlots() {
		return slots;
	}

	public void setSlots(List<Slots> slots) {
		this.slots = slots;
	}

	@Override
	public String toString() {
		return "Advertiser [id=" + id + ", name=" + name + ", mailId=" + mailId + ", contactNumber=" + contactNumber
				+ ", slots=" + slots + ", roleId=" + roleId + "]";
	}


}
