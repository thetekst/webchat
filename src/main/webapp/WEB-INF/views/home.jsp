<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<spring:url value="/resources/js/lib/sockjs.min.js" var="sockjs"/>
<spring:url value="/resources/js/lib/stomp.min.js" var="stomp"/>
<spring:url value="/resources/js/script.js" var="script"/>
<title>Web chat</title>
</head>
<body onload="disconnect()">

<div>
    <div>
        <input type="text" id="from" placeholder="Choose a nickname"/>
    </div>
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
<script src="${sockjs}"></script>
<script src="${stomp}"></script>
<script src="${script}"></script>
</body>
</html>
