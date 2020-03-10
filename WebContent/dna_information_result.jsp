<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="androidjsp.ConnectDB_result" %>

<%
	request.setCharacterEncoding("UTF-8");
	String gene_name = request.getParameter("gene_name");
	String user_num = request.getParameter("user_num");
	String disease = request.getParameter("disease");
	
	ConnectDB_result connectdb_result=ConnectDB_result.getInstance();
		String returns = connectdb_result.level(gene_name, user_num);

		out.print(returns);
	
%>
    
