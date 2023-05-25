<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<style>
    a {
        color: #05f;
        text-decoration: none;
    }

    a:hover {
        text-decoration: underline;
    }

    h1, h2, h3, h4, h5, h6 {
        margin: 0;
        padding: 0;
    }

    ul, lo, li {
        margin: 0;
        padding: 0;
        list-style: none;
    }

    div#root {
        width: 900px;
        margin: 0 auto;
    }

    section#container {
    }

    section#content {
        float: right;
        width: 700px;
    }

    aside#aside {
        float: left;
        width: 180px;
    }

    section#container::after {
        content: "";
        display: block;
        clear: both;
    }

    footer#footer {
        background: #eee;
        padding: 20px;
    }

    section#container {
    }

    section#content ul li {
        display: inline-block;
        margin: 10px;
    }

    section#content div.goodsThumb img {
        width: 200px;
        height: 200px;
    }

    section#content div.goodsName {
        padding: 10px 0;
        text-align: center;
    }

    section#content div.goodsName a {
        color: #000;
    }
</style>


<div id="root">
    <section id="container">
        <div id="container_box">
            <section id="content">
                <ul>
                    <c:forEach var="obj" items="${allitem}">
                        <li>
                            <div class="goodsThumb">
                                <img src="/uimg/${obj.imgname}">
                            </div>
                            <div class="goodsName">
                                <a href="/item/get?id=${obj.id}">${obj.id}</a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </section>
        </div>
    </section>
</div>

