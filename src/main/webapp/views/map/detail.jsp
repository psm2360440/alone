<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>

</script>
<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Map Center</h3>
        <img src = "/uimg/${gmarker.img}">
        <h4>${gmarker.id}</h4>
        <h4><a href = "${gmarker.target}">${gmarker.title}</a></h4>

        <div class="row content">
            <div class="col-sm-6 text-left">
                <h3>MENU</h3>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>IMG</th>
                        <th>ITEM</th>
                        <th>PRICE</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="m" items="${mlist}">
                        <tr>
                            <td><img src = "/uimg/${m.imgname}"></td>
                            <td>${m.item}</td>
                            <td>${m.price}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
