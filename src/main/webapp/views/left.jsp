<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-2 sidenav">
    <p><a href="/pic">Pic</a></p>
    <c:if test ="${logincust != null}">
        <p><a href="/websocket">WebSocket</a></p>
    </c:if>
    <p><a href="/cfr1">CFR1</a></p>
    <p><a href="/cfr2">CFR2</a></p>
</div>
