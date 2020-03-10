<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="androidjsp.ConnectDB_dna" %>

<%
	request.setCharacterEncoding("UTF-8");
	String disease = request.getParameter("disease");
	String user_num = request.getParameter("user_num");

		ConnectDB_dna connectdb_dna=ConnectDB_dna.getInstance();
		String returns = connectdb_dna.disese_level(disease, user_num);
		out.print(returns);
%>
    
