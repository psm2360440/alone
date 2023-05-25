<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
</script>

<div class="col-sm-8 text-left">
    <div class="container">
        <div class="col-sm-6 text-left">
            <h1>CFR2</h1>
            <h2>${result.emotion}</h2>
            <h2>${result.pose}</h2>
            <h2>${result.age}</h2>
            <h2>${result.gender}</h2>

            <form id="cfr2_form" action = "/cfr2impl" enctype = "multipart/form-data" method = "post" class="form-horizontal well">
                <div class="input-group">
                    <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                    <input id="img" type="file" class="form-control" name="img" placeholder="Input Image">
                </div>

                <div class="form-group" style="margin-top: 10px; text-align: center;">
                    <button type="submit" id="cfr2_btn" class="btn btn-default">SEND</button>
                </div>
            </form>

        </div>
    </div>
</div>