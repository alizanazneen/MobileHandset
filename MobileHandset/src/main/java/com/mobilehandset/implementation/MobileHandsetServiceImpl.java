/* 
 * @author  Nazneen
 * @version 1.0
 * @since   2020-10-01 
 */
package com.mobilehandset.implementation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobilehandset.model.MobileHandset;
import com.mobilehandset.service.MobileHandsetService;

@Service("MobileHandsetService")
public class MobileHandsetServiceImpl implements MobileHandsetService {

	private static final Logger logger = LogManager.getLogger(MobileHandsetServiceImpl.class);
	
	@Autowired
	MobileHandsetProcess action;

	/**
	 * This method is used list of device based on given two parameters
	 * 
	 * @param announceDate
	 * @param price
	 * @return List<MobileHandset> This returns list of selected devices
	 */
	@Override
	public String getAnnounceDate(String announceDate, double price) throws Exception {

		List<MobileHandset> announceDateist = action.getAnnounceDate(announceDate, price);

		return getArrayToJSON(announceDateist);
	}

	/**
	 * This method is used list of device based on given parameter
	 * 
	 * @param sim
	 * @return List<MobileHandset> This returns list of selected devices
	 */
	@Override
	public String getSim(String sim) throws Exception {

		List<MobileHandset> eSimList = action.getSim(sim);
		logger.debug("eSim Length------>" + eSimList.size());

		return getArrayToJSON(eSimList);
	}

	/**
	 * This method is used list of device based on given parameter
	 * 
	 * @param priceEur
	 * @return List<MobileHandset> This returns list of selected devices
	 */
	@Override
	public String getPriceEur(double priceEur) throws Exception {

		List<MobileHandset> priceEurList = action.getPriceEur(priceEur);
		logger.debug("priceEurList Length------>" + priceEurList.size());		

		return getArrayToJSON(priceEurList);
	}
	/*
	 * Parse data from list to Json string
	 */
	private String getArrayToJSON(List<MobileHandset> handsets) throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		String arrayToJson = mapper.writeValueAsString(handsets);
		JSONArray jsonArray = new JSONArray(arrayToJson);
		arrayToJson = jsonArray.toString(4);
		return arrayToJson; 
	}

}
