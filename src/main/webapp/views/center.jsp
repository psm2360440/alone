<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<style>
    #w2{
        width: 500px;
        border:2px solid lightpink;
    }
</style>

<script>
    let center = {
        init:function(){
            $.ajax({
                url:'/weather2',
                success: function(data){
                    center.display(data);
                }
            });
        },
        display: function(data){
            var result = data.response.body.items.item;
            var txt = '';
            $(result).each(function(index, item){
                txt += '<h5>';
                txt += item.tm+' '+item.ta;
                txt += '</h5>';
            });
            $('#w2').html(txt);
        }
    };
    $(function(){
         center.init();
    });
</script>

<div class="col-sm-8 text-left">
    <h1><spring:message code="site.title"/></h1>
    <p><spring:message code="site.greeting"/></p>
    <hr>
    <textarea id = "w1" cols = "80" rows = "10">${weatherinfo}</textarea>
    <hr>
    <div id = "w2"></div>
</div>
