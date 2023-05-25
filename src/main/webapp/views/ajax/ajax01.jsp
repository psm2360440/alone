<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script>
    let ajax01 = {
        init: function(){

            setInterval(function(){
                $.ajax({
                    url: '/getservertime',
                    success: function(data){
                        ajax01.display(data); //alert창은 되도록 쓰지 않도록(console.log를 차라리...)
                    },
                    error: function(){
                        alert('Error...');
                    }
                });
            }, 3000);
        },
        display: function(data){
            $('#server_time').text(data);
        }
    };
    $(function(){
        ajax01.init();
    })

</script>

<div class="col-sm-8 text-left">
    <div class = "container">
        <h3>AJAX01</h3>
        <h4>Server Time</h4>
        <h5 id = "server_time"></h5>
    </div>
</div>
