package com.cg.apartment.entities;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class UserEntity extends BaseEntity
{
	@NotNull(message ="fisrtname cannot be null")
	private String firstName;
	@NotNull(message ="lastname cannot be null")
	private String lastName;
	@NotNull(message ="loginid is must")
	private String loginId;
	@NotNull(message ="password is must")
	private String password;
	@NotNull(message ="mobileno cannot be null")
	@Min(message ="valid mobile number is must",value=999999999)
	private String mobileNo;
	@Email
	@NotNull(message ="emailID is must")
	private String emailId;
	@NotNull(message =" roleid is must")
	private long roleId;
	public UserEntity() {
		super();
	}
	public UserEntity(String firstName, String lastName, String loginId, String password, String mobileNo,
			String emailId, long roleId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.loginId = loginId;
		this.password = password;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
		this.roleId = roleId;
	}
	
	//Getters and Setters

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UserEntity [firstName=" + firstName + ", lastName=" + lastName + ", loginId=" + loginId + ", password="
				+ password + ", mobileNo=" + mobileNo + ", emailId=" + emailId + ", roleId=" + roleId + "]";
	}



}
