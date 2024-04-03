package com.DgBanner.Owner.DTO;

public class OwnerResponseDto {

	private String name;
	private String contactNumber;
	private String mailId;

	public OwnerResponseDto() {
	}

	public OwnerResponseDto(String name, String contactNumber, String mailId) {

		this.name = name;
		this.contactNumber = contactNumber;
		this.mailId = mailId;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	@Override
	public String toString() {
		return "OwnerResponseDto [name=" + name + ", contactNumber=" + contactNumber + ", mailId=" + mailId + "]";
	}


}
