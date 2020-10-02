/* 
* @author  Nazneen
* @version 1.0
* @since   2020-10-01 
*/
package com.mobilehandset;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mobilehandset.implementation.MobileHandsetProcess;

import com.mobilehandset.model.MobileHandset;
import com.mobilehandset.utility.AppConstant;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = com.mobilehandset.implementation.MobileHandsetProcess.class)
@ContextConfiguration(classes = com.mobilehandset.utility.MobileHandsetJsonFactory.class)
public class MobileHandsetTests {

	@Autowired
	MobileHandsetProcess action;
	
	int expectedNoOfDevices;
	List<MobileHandset> deviceList; 
	/*
	 * First test - passing Level = null
	 */
	@Test
	public void getESimDevices() throws Exception {

		deviceList = action.getSim(AppConstant.E_SIM);
		expectedNoOfDevices = 18;
		assertEquals(expectedNoOfDevices, deviceList.size());
	}
	
	@Test
	public void getPriceEuroDevices() throws Exception {

		deviceList = action.getPriceEur(AppConstant.PRICE_EUR);
		int expectedNoOfDevices = 10;
		assertEquals(expectedNoOfDevices, deviceList.size());
	}
	
	@Test
	public void getDateAndPriceDevices() throws Exception {

		deviceList = action.getAnnounceDate(AppConstant.ANNOUNCE_DATE, AppConstant.PRICE_EUR);
		int expectedNoOfDevices = 2;
		assertEquals(expectedNoOfDevices, deviceList.size());
	}

}
