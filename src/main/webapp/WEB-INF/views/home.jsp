<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<spring:url value="/resources/js/lib/bootstrap/css/bootstrap.min.css" var="bootstrapCSS"/>
<spring:url value="/resources/js/lib/jquery/jquery.min.js" var="jquery"/>
<spring:url value="/resources/js/lib/sockjs.min.js" var="sockjs"/>
<spring:url value="/resources/js/lib/stomp.min.js" var="stomp"/>
<spring:url value="/resources/js/script.js" var="script"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${bootstrapCSS}">
    <title>Web chat</title>
</head>
<body onload="disconnect()">
<div class="container">
    <div class="row">
        <div class="col-sm-9">
            <div>
                <input type="text" id="from" placeholder="Choose a nickname"/>
            </div>
            <select class="form-control" name="color" id="color">
                <option value="000" selected="selected">Black</option>
                <option value="ff0000">Red</option>
            </select>
            <br/>
            <div>
                <button id="connect" onclick="connect();">Connect</button>
                <button id="disconnect" disabled="disabled" onclick="disconnect();">Disconnect</button>
            </div>
            <br/>
            <div id="conversationDiv">
                <input type="text" id="text" placeholder="Write a message..."/>
                <button id="sendMessage" onclick="sendMessage();">Send</button>
                <p id="response"></p>
            </div>
        </div>
        <div class="col-sm-3">
            <ul id="user-list" class="list-unstyled"></ul>
        </div>
    </div>
</div>
<script src="${jquery}"></script>
<script src="${sockjs}"></script>
<script src="${stomp}"></script>
<script src="${script}"></script>
</body>
</html>
