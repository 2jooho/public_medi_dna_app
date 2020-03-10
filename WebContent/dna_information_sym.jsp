<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="androidjsp.ConnectDB_result3" %>

<%
	request.setCharacterEncoding("UTF-8");

	String disease = request.getParameter("disease");

	ConnectDB_result3 connectdb_result=ConnectDB_result3.getInstance();
		String returns3 = connectdb_result.sym(disease);
		
		out.print(returns3);
		
	
%>
    
