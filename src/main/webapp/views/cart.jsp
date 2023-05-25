<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    .medium_img {
        width: 80px;
    }
</style>

<div class="col-sm-8 text-left">
    <div class="row content">
        <div class="col-sm-9 text-left">
            <h3>CART</h3>
            <c:set var = "total" value = "0"/>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>IMG</th>
                    <th>ITEM_ID</th>
                    <th>NAME</th>
                    <th>PRICE</th>
                    <th>COUNT</th>
                    <th>TOTAL PRICE</th>
                    <th>RDATE</th>
                    <th>DELETE</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="obj" items="${allcart}">
                    <tr>
                        <td><img class="medium_img" src="/uimg/${obj.item_imgname}"></td>
                        <td><a href="/item/get?id=${obj.item_id}">${obj.item_id}</a></td>
                        <td>${obj.item_name}</td>
                        <td><fmt:formatNumber value="${obj.item_price}" pattern="###,###¿ø"/></td>
                        <td>${obj.cnt}</td>
                        <td><fmt:formatNumber value="${obj.cnt * obj.item_price}" pattern="###,###¿ø"/></td>
                        <td><fmt:formatDate value="${obj.rdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><a href="/item/delcart?id=${obj.id}" class="btn btn-basic" role="button">DELETE</a></td>
                    </tr>
                    <c:set var = "total" value = "${total + (obj.cnt * obj.item_price)}"></c:set>
                </c:forEach>
                </tbody>
            </table>
            <h4 style = "text-align: right"><fmt:formatNumber value="${total}" pattern="###,###¿ø"/></h4>

        </div>
    </div>
</div>
