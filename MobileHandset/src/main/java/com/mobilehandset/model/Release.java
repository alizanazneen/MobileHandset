/* 
* @author  Nazneen
* @version 1.0
* @since   2020-10-01 
*/
package com.mobilehandset.model;

public class Release {

	private String announceDate;
	private double priceEur;
	
	public String getAnnounceDate() {
		return announceDate;
	}
	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	public double getPriceEur() {
		return priceEur;
	}
	
	public void setPriceEur(int priceEur) {
		this.priceEur = priceEur;
	}	
}
