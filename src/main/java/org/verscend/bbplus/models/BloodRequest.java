package org.verscend.bbplus.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class BloodRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bloodRequestId;
	@OneToOne
	@JoinColumn(name = "bloodGroupId")
	private BloodGroup bloodGroup;
	private long pint;
	private boolean status;

	public BloodRequest() {
	}

	public BloodRequest(Integer bloodRequestId, BloodGroup bloodGroup, long pint, boolean status) {
		super();
		this.bloodRequestId = bloodRequestId;
		this.bloodGroup = bloodGroup;
		this.pint = pint;
		this.status = status;
	}

	public Integer getBloodRequestId() {
		return bloodRequestId;
	}

	public void setBloodRequestId(Integer bloodRequestId) {
		this.bloodRequestId = bloodRequestId;
	}

	public BloodGroup getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(BloodGroup bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public long getPint() {
		return pint;
	}

	public void setPint(long pint) {
		this.pint = pint;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
