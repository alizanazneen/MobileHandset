/* 
* @author  Nazneen
* @version 1.0
* @since   2020-10-01 
*/
package com.mobilehandset.service;

public interface MobileHandsetService {
 
	String getPriceEur(double priceEur) throws Exception;
	String getSim(String sim) throws Exception;
	String getAnnounceDate(String announceDate, double price) throws Exception;
}
