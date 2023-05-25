<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-8 text-left">
    <div class="container">
        <div class="row content">
            <div class="col-sm-6 text-left">
                <h3>CUST ALL 화면입니다</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="c" items="${clist}">
                        <tr>
                            <td><a href="/cust/get?id=${c.id}">${c.id}</a></td>
                            <td>${c.name}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
