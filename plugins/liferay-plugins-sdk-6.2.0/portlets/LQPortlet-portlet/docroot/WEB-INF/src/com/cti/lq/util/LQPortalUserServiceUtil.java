package com.cti.lq.util;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class LQPortalUserServiceUtil {
	
	public static int getUserId (PortletRequest req)  {
		if (req.getUserPrincipal() != null) {
			return new Integer(req.getUserPrincipal().getName()).intValue();
		}
		else {
			return 0;
		}
	} 
	
	
	public static User getUser(long userId) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUser(userId);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}


	public static User getUser(String emailAddress, long companyId) {
		User user = null;
		try {
			user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
		
	}
	

}
