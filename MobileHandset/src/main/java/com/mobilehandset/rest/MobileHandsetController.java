/*
* MobileHandsetController
* @author  Nazneen
* @version 1.0
* @since   2020-10-01 
*/
package com.mobilehandset.rest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mobilehandset.service.MobileHandsetService;

@RestController
public class MobileHandsetController {
	
	private static final Logger logger = LogManager.getLogger(MobileHandsetController.class);
	 

	@Autowired
	MobileHandsetService mobileHandsetService;

	String mobileHandsetList;

	
	@RequestMapping(value = "/mobile/search", params = "priceEur")	
	public ResponseEntity<Object> getPriceEur(@RequestParam double priceEur) {
		
		try {
			mobileHandsetList =	mobileHandsetService.getPriceEur(priceEur);
		}catch (Exception e) {
			e.printStackTrace();
			 logger.error("{}", e);
			
		}		 
		return new ResponseEntity<Object>(mobileHandsetList, HttpStatus.OK);
			

	}

	@RequestMapping(value = "/mobile/search", params = "sim")
	public ResponseEntity<Object>  getSim(@RequestParam String sim) {
		
		try {
			mobileHandsetList =	mobileHandsetService.getSim(sim);
		}catch (Exception e) {
			e.printStackTrace();
			 logger.error("{}", e);
			
		}
		 
		return new ResponseEntity<Object>(mobileHandsetList, HttpStatus.OK);
	}

	
	@RequestMapping(value = "/mobile/search", params = { "announceDate", "price" })
	public ResponseEntity<Object> getAnnounceDate(@RequestParam String announceDate, @RequestParam double price) {

		try {
			mobileHandsetList =	mobileHandsetService.getAnnounceDate(announceDate, price);
		}catch (Exception e) {
			e.printStackTrace();
			 logger.error("{}", e);
			
		}		 
		return new ResponseEntity<Object>(mobileHandsetList, HttpStatus.OK);
			

	}

}
