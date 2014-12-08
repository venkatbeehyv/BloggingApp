// creats a Employee objects, provides getters and setters for it's field
package com.beehyv.blogging.modal;


public class Employee {
	public  String email;
	public  String name;
	public  String password;
	public  String designation;
	public  String mobile_no;
	public  String created_at;
	public  String updated_at;
	public  String lastLoggedIn;
	public  long roleID;
	public long employee_id;
	
	
	public String getLastLoggedIn() {
		return lastLoggedIn;
	}
	public void setLastLoggedIn(String lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}
	public long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	/**
	 * @return the mobile_no
	 */
	public String getMobile_no() {
		return mobile_no;
	}
	/**
	 * @param mobile_no the mobile_no to set
	 */
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the updated_at
	 */
	public String getUpdated_at() {
		return updated_at;
	}
	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(String updated_at) {
		this.updated_at = updated_at;
	}
	/**
	 * @return the lastLoggedIn
	 */
	public String getlastLoggedIn() {
		return lastLoggedIn;
	}
	/**
	 * @param lastLoggedIn the lastLoggedIn to set
	 */
	public void setlastLoggedIn(String lastLoggedIn) {
		this.lastLoggedIn = lastLoggedIn;
	}
	/**
	 * @return the role_id
	 */
	public long getRoleID() {
		return roleID;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRoleID(long roleID) {
		this.roleID = roleID;
	}
	
	@Override
	public String toString() {
		String employee = "Name: " + this.name +"\n" 
		+ "Designation: " + this.designation +"\n"
		+ "Email: " + this.email +"\n" 
		+ "Mobile: " + this.mobile_no +"\n" ;
		
		return employee;
	}
	
}
