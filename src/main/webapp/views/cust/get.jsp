<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    $(function () {
        // register_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="page-header">
        <h1>VIEW DETAIL and UPDATE at once</h1>
    </div>
    <p>WELCOME</p>
    <p>DIGI Campus 2nd</p>
    <form id="update_form">
        <div class="form-group">
            <input type="text" name="id" class="form-control" id="id" value="${gcust.id}" readonly>
        </div>
        <div class="form-group">
            <input type="password" class="form-control" id="pwd" name="pwd" value="${gcust.pwd}">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" id="name" name="name" value="${gcust.name}">
        </div>
        <button type="button" id="remove_btn" class="btn btn-block">REMOVE</button>
        <button type="button" id="update_btn" class="btn btn-block">UPDATE</button>
    </form>
</div>

