/**
 * 
 */
package com.cti.lq.controller;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cti.lq.util.LQPortalUserServiceUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author senthil
 * Date : 22/12/2013.
 */
public class ForgetPassword extends MVCPortlet{
	
	private String viewJSP;
	final Log LOG = LogFactory.getLog(Header.class);

	public void init() throws PortletException {
		viewJSP = getInitParameter("view-template");
	}
	
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		LOG.info("Entering doView()");

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(viewJSP);
		
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(renderRequest);
		HttpSession session = httpRequest.getSession();
		
		Boolean validUser = (Boolean) (session.getAttribute("validUser") != null ? session.getAttribute("validUser") : null);
		renderRequest.setAttribute("validUser", validUser);
		session.removeAttribute("validUser");

		if (portletRequestDispatcher == null) {
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}

		LOG.info("Leaving doView()");
	}
	
	
	public void submitForgetPassword (ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {	
		LOG.info(" Entering submitForgetPassword()");		
		
		
		HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(actionRequest);
		HttpSession session = httpRequest.getSession();
		ThemeDisplay themeDisplay = (ThemeDisplay) httpRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		try {
			String emailAddress1 = (String) actionRequest.getParameter("emailId");
			String emailAddress2 = (String) httpRequest.getParameter("emailId");
			
			
			System.out.print("EmailAddress=1==" + emailAddress1);
			System.out.print("EmailAddress==2=" + emailAddress2);
			emailAddress1 = emailAddress1 != null ? emailAddress1.trim() : null;
			
			
			
			User u = LQPortalUserServiceUtil.getUser(emailAddress1,themeDisplay.getCompanyId());
			if(u!=null) {
				session.setAttribute("validUser", true);
			} else {
				session.setAttribute("validUser", false);
			}
		} catch (Exception e) {
			session.setAttribute("validUser", false);
			e.printStackTrace();
		}

	}
	
}
