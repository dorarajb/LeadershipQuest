/**
 * 
 */
package com.cti.lq.service.impl;

import javax.portlet.RenderRequest;

import com.cti.lq.beans.LoggedUserBean;
import com.cti.lq.exceptions.LQPortalException;
import com.cti.lq.service.LQPortletService;
import com.cti.lq.util.LQPortalUserServiceUtil;
import com.liferay.portal.model.User;

/**
 * @author senthil Date Created : 20/12/2013. Function : This class is a service
 *         implementation class for "Header portlet".
 */
public class LQPortletServiceImpl implements LQPortletService {

	@Override
	public LoggedUserBean populateHeaderPortlet(LoggedUserBean lbean,
			RenderRequest renderRequest) throws LQPortalException {

		int userId = LQPortalUserServiceUtil.getUserId(renderRequest);
		if (userId != 0) {
			User user = LQPortalUserServiceUtil.getUser(userId);
			lbean.setFirstName(user.getFirstName());
			lbean.setLastName(user.getLastName());
			lbean.setSignedIn(true);
		}
        return lbean;
	}

}
