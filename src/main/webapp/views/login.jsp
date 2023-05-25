<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    $(function () {
        login_form.init();
    });
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <div class="col-sm-6 text-left">
            <h1>LOGIN</h1>
            <form id="login_form" class="form-horizontal well">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="id" type="text" class="form-control" name="id" placeholder="ID">
                    <!--input에서는 id 가 아니라 name이 있어야 서버에서 인식이 가능하다-->
                </div>
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                    <input id="password" type="password" class="form-control" name="pwd" placeholder="PASSWORD">
                </div>
                <div class="form-group" style="margin-top: 10px; text-align: center;">
                    <button type="button" id="join_btn" class="btn btn-default">Join</button>
                    <button type="button" id="find_btn" class="btn btn-default">Find</button>
                    <button type="button" id="login_btn" class="btn btn-default">Submit</button>
                </div>
            </form>

        </div>
    </div>
</div>