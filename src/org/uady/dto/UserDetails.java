package org.uady.dto;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="USER_DETAILS")
public class UserDetails {
	
	@Id 
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment") 
	private int userId;
	
	private String userName;
	
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	
	@Embedded 
	@AttributeOverrides({
	@AttributeOverride(name="street", column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride(name="city", column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride(name="state", column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride(name="code", column=@Column(name="HOME_CODE_NAME"))
			
	})
	private Address homeaddress;
	
	@Embedded
	private Address officeAdrees;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getJoinedDate() {
		return joinedDate;
	}

	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Address getHomeaddress() {
		return homeaddress;
	}

	public void setHomeaddress(Address homeaddress) {
		this.homeaddress = homeaddress;
	}

	public Address getOfficeAdrees() {
		return officeAdrees;
	}

	public void setOfficeAdrees(Address officeAdrees) {
		this.officeAdrees = officeAdrees;
	}


	

}
