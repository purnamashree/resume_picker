package com.sagarsoft.entity;

import java.io.Serializable;

public class User implements Serializable{
	
	private String firstName;
	private String lastName;
    private String emailId;
    private String createdDate;
    private String modifiedDate;
    private String createdBy;
    private String modifiedBy="----";
    private int roleId;
    private int userId;

    public User(){}
    public User(int userId) {
    	this.userId=userId;
    }
 /*   public User(int user_id){
        this.user_id = user_id;
    }

    public User(String firstName, String emailid, String password, int user_id) {
        this(firstName, emailid, password);
        this.user_id = user_id;
    }

    public User(String firstName, String emailid, String password) {
        this.firstName = firstName;
        this.emailid = emailid;
      //  this.password = password;
    }
*/
   
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String EmailId) {
        this.emailId = EmailId;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    public int getUserId() {
        return userId;
    }

    public void setUserId(int user_id) {
        this.userId = user_id;
    }
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int role_id) {
        this.roleId = role_id;
}

}
