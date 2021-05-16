package com.teamyostrik.efrip.models;

import java.util.Date;

public class Payment {
	private String id;
	private Date paidDate;
	private float totalPaid;
	private String details;
	public Payment(Date paidDate, float totalPaid, String details) {
		super();
		this.paidDate = paidDate;
		this.totalPaid = totalPaid;
		this.details = details;
	}
	public Payment() {
		super();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(Date	 paidDate) {
		this.paidDate = paidDate;
	}
	public float getTotalPaid() {
		return totalPaid;
	}
	public void setTotalPaid(float totalPaid) {
		this.totalPaid = totalPaid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
}
