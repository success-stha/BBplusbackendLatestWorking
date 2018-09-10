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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long bloodreqestId;
	@OneToOne
	@JoinColumn(name="bloodGroupId")
	private BloodGroup bloodGroup;
	private long pint;

	public BloodRequest() {

	}

	public BloodRequest(Long bloodreqestId, BloodGroup bloodGroup, long pint) {
		super();
		this.bloodreqestId = bloodreqestId;
		this.bloodGroup = bloodGroup;
		this.pint = pint;
	}

	public Long getBloodreqestId() {
		return bloodreqestId;
	}

	public void setBloodreqestId(Long bloodreqestId) {
		this.bloodreqestId = bloodreqestId;
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

}
