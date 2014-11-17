// creats a Employee objects, provides getters and setters for it's field
package com.beehyv.blogging.modal;

public class Employee {
	private  String email;
	private  String name;
	private  String password;
	private  String designation;
	private  String mobile_no;
	private  String created_at;
	private  String updated_at;
	private  String lastLoggedIn;
	private  long roleID;
	/**
	 * @return the email
	 */
	private String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	private void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	private String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	private void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	private String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	private void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the designation
	 */
	private String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	private void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the mobile_no
	 */
	private String getMobile_no() {
		return mobile_no;
	}
	/**
	 * @param mobile_no the mobile_no to set
	 */
	private void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	/**
	 * @return the created_at
	 */
	private String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	private void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the updated_at
	 */
	private String getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	private void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	/**
	 * @return the lastLoggedIn
	 */
	private String getlastLoggedIn() {
		return lastLoggedIn;
	}
	/**
	 * @param lastLoggedIn the lastLoggedIn to set
	 */
	private void setlastLoggedIn(String lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}
	/**
	 * @return the role_id
	 */
	private long getRoleID() {
		return roleID;
	}
	/**
	 * @param role_id the role_id to set
	 */
	private void setRoleID(long roleID) {
		this.roleID = roleID;
	}
	
}
