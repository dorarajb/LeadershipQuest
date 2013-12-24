<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="liferay-ui" uri="/WEB-INF/tld/liferay-ui.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<script type="text/javascript">
	jQuery(document).ready(function() {

	});
</script>


<jsp:useBean id="LoggedUserBean" class="com.cti.lq.beans.LoggedUserBean"
	scope="request" />

<div id="header">
	<ul class="mainNav">
	
	     <li> <h3> Leadership Quests</h3> </li>
		<li class="logo level-1" style="float: right" id="yui_patched_v3_11_0_1_1387784257705_665">
		<a href="http://www.thecoaches.com/" id="yui_patched_v3_11_0_1_1387784257705_664">Coactive</a></li>
		
		<li class="level-1 here first" id="nav-sub-why-cti"><a
			href="http://www.thecoaches.com/why-cti">Home</a> <!--  Submenu  <ul>
				<li class="level-2 first" id="nav-sub-about-cti"><a href="http://www.thecoaches.com/why-cti/about-cti">About CTI</a></li>
				<li class="level-2" id="nav-sub-what-is-co-active"><a href="http://www.thecoaches.com/why-cti/what-is-co-active">What is Co-Active?</a></li>
			</ul> --></li>
		<li class="level-1" id="nav-sub-coach-training"><a
			href="http://www.thecoaches.com/coach-training">Quest</a></li>
		<li class="level-1" id="nav-sub-leadership"><a
			href="http://www.thecoaches.com/leadership">Leader</a></li>

		<li class="level-1" id="nav-sub-leadership" style="float: right"><a
			href="/c/portal/login" id="signinLink">Sign-in</a></li>


		<c:if test="${(isSignedIn == true)}">
			<li class="level-1" id="nav-sub-leadership1" style="float: right"><a
				href="/c/portal/logout">Sign-Out</a></li>
		</c:if>
	</ul>
</div>


<c:if test="${(isSignedIn == true)}">
	<h6 style="float: right">You are signed in as
		${LoggedUserBean.firstName} ${LoggedUserBean.lastName}</h6>
</c:if>

