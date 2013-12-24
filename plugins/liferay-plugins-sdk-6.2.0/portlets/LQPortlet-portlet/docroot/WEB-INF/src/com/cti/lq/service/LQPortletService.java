/**
 * 
 */
package com.cti.lq.service;

import javax.portlet.RenderRequest;

import com.cti.lq.beans.LoggedUserBean;
import com.cti.lq.exceptions.LQPortalException;

/**
 * @author senthil
 * Date Created : 20/12/2013.
 * Function : This is service layer class for header portlet. 
 */
public interface LQPortletService {
	
	public LoggedUserBean populateHeaderPortlet(LoggedUserBean loggedUserBean, RenderRequest renderRequest) throws LQPortalException;


}
