package com.cti.lq.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.cti.lq.beans.LoggedUserBean;
import com.cti.lq.exceptions.LQPortalException;
import com.cti.lq.service.LQPortletService;
import com.cti.lq.service.impl.LQPortletServiceImpl;
import com.cti.lq.util.LQPortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sunrun.crportal.persistence.DBConnectionFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Header extends MVCPortlet {

	private String viewJSP;
	final Log LOG = LogFactory.getLog(Header.class);

	public void init() throws PortletException {
		viewJSP = getInitParameter("view-template");
	}

	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		LOG.info("Entering doView()");

		LoggedUserBean lbean = new LoggedUserBean();
		LQPortletService lqServiceLayer = new LQPortletServiceImpl();

		try {

			lbean = lqServiceLayer.populateHeaderPortlet(lbean, renderRequest);

		} catch (LQPortalException le) {
			LQPortalUtil.processException(le, renderRequest);
		}

		renderRequest.setAttribute("isSignedIn", lbean.getIsSignedIn());
		renderRequest.setAttribute("LoggedUserBean", lbean);

		PortletRequestDispatcher portletRequestDispatcher = getPortletContext()
				.getRequestDispatcher(viewJSP);

		if (portletRequestDispatcher == null) {
		} else {
			portletRequestDispatcher.include(renderRequest, renderResponse);
		}
		
		Connection con  = DBConnectionFactory.getPostgresDBConnection();
		if(con==null) {
			System.out.println("Connection null---------------------------------------------");
		} else {
			System.out.println("Connection not null-------------------------------------");
		}

		LOG.info("Leaving doView()");
	}

}
