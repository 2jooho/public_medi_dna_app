<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="androidjsp.ConnectDB_result4" %>

<%
	request.setCharacterEncoding("UTF-8");

	String disease = request.getParameter("disease");
	String disease_num = request.getParameter("disease_num");
	
	ConnectDB_result4 connectdb_result=ConnectDB_result4.getInstance();
		String returns2 = connectdb_result.nutrient(disease, disease_num);
	
		out.print(returns2);
		
	
%>
    
