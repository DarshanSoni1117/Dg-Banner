package com.DgBanner.Advertiser.DTO;

public class AdvertiserDto {

	private String name;
	private String contactNumber;
	private String mailId;
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

	public  AdvertiserDto() {

	}
	public  AdvertiserDto(String name, String contactNumber, String mailId) {

		this.name = name;
		this.contactNumber = contactNumber;
		this.mailId = mailId;
	}
	@Override
	public String toString() {
		return "AdvertiserDto [name=" + name + ", contactNumber=" + contactNumber + ", mailId=" + mailId + "]";
	}


}
