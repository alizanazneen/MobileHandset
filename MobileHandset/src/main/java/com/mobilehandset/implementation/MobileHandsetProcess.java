/* 
* @author  Nazneen
* @version 1.0
* @since   2020-10-01 
*/
package com.mobilehandset.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobilehandset.model.MobileHandset;
import com.mobilehandset.utility.MobileHandsetJsonFactory;

@Service
public class MobileHandsetProcess {

	@Autowired
	MobileHandsetJsonFactory factory;
	
	 MobileHandset[] mobileHandsetList; 
	 ObjectMapper mapper = new ObjectMapper();
	 
	 /**
	   * This method is used list of device based on given two parameters 
	   * @param announceDate
	   * @param price
	   * @return List<MobileHandset> This returns list of selected devices 
	   */
	 public List<MobileHandset> getAnnounceDate(String announceDate, double price) throws Exception {
		 
		 mobileHandsetList = factory.getMobileHandsetList();

		 ArrayList<MobileHandset> simList = new ArrayList<MobileHandset>();

		 for (MobileHandset mobileHandset : mobileHandsetList) {
			 if(mobileHandset.getRelease().getPriceEur() == price && 
					 mobileHandset.getRelease().getAnnounceDate().contains(announceDate)) {
				 simList.add(mobileHandset);
			 } 		  	
		 }		
		 return simList;
	}
	
	 /**
	   * This method is used list of device based on given parameter 
	   * @param sim
	   * @return List<MobileHandset> This returns list of selected devices 
	   */
	public List<MobileHandset> getSim(String sim) throws Exception  {
		
		mobileHandsetList = factory.getMobileHandsetList();		
		
		ArrayList<MobileHandset> simList = new ArrayList<MobileHandset>();
		
		for (MobileHandset mobileHandset : mobileHandsetList) {
			if(mobileHandset.getSim()!=null && mobileHandset.getSim().toLowerCase().contains(sim.toLowerCase())) {
				simList.add(mobileHandset);
				} 		  	
		}				
		
		return simList;
	}	
	
	/**
	   * This method is used list of device based on given parameter 
	   * @param priceEur
	   * @return List<MobileHandset> This returns list of selected devices 
	   */
	public List<MobileHandset> getPriceEur(double priceEur) throws Exception {		
		
		mobileHandsetList = factory.getMobileHandsetList();		
		ArrayList<MobileHandset> priceEurList = new ArrayList<MobileHandset>();		
		for (MobileHandset mobileHandset : mobileHandsetList) {
			if(mobileHandset.getRelease().getPriceEur() == priceEur) {
				priceEurList.add(mobileHandset);
				} 		  	
		}		
		
		return priceEurList;
	}	

}
