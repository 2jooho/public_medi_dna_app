<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="androidjsp.ConnectDB" %>

<%
	ConnectDB connectDB = ConnectDB.getInstance();
	String returns = connectDB.connectionDB("aaa", "1233");
	System.out.println("요청 결과 : " + returns);
%>

