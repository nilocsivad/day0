<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!//////////////////////////////////////////////////
	//////////
	//////////
	//////////
	String URL = null;
	String HTP = null;
	//////////
	//////////
	//////////
	//////////////////////////////////////////////////%>
<%
	URL = request.getAttribute("URL") == null ? null : request.getAttribute("URL") + "";
	if (URL == null) {

		String path = request.getContextPath();
		request.setAttribute("URL", path);

		int port = request.getServerPort();
		String scheme = request.getScheme() + "://";
		String serverNamePort = request.getServerName() + (port == 80 ? "" : ":" + port);
		HTP = scheme + serverNamePort;

		URL = scheme + (serverNamePort + "/" + path).replace("//", "/");
		if (URL.endsWith("/"))
			URL = URL.substring(0, URL.length() - 1);

		request.setAttribute("FURL", URL);
		request.setAttribute("HTP", HTP);
	}
%>