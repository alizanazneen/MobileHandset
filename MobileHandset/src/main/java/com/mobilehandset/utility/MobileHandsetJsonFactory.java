/* 
* @author  Nazneen
* @version 1.0
* @since   2020-10-01 
*/
package com.mobilehandset.utility;

import java.io.IOException;
import java.net.URL;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mobilehandset.model.MobileHandset;

@Component
@Scope("singleton")
public class MobileHandsetJsonFactory implements InitializingBean {

	private MobileHandset[] mobileHandsetList = null;

	@Override
	public void afterPropertiesSet() throws Exception {
		loadJsonContentOnStartup();
	}

	/*
	 * 
	 */
	public void loadJsonContentOnStartup()  throws Exception{
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mobileHandsetList = mapper.readValue(
					new URL("https://a511e938-a640-4868-939e-6eef06127ca1.mock.pstmn.io/handsets/list"),
					MobileHandset[].class);
			
		} catch (IOException e) { 
			e.printStackTrace();
		}

	}

	public MobileHandset[] getMobileHandsetList() {
		return mobileHandsetList;
	}

	public void setMobileHandsetList(MobileHandset[] mobileHandsetList) {
		this.mobileHandsetList = mobileHandsetList;
	}
	

}
