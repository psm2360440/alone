<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
    item_get = {
        init: function () {
            $(cart_btn).click(function () {
                let cust_id = '${logincust.id}';
                let item_id = ${gitem.id};
                //single quotation 불필요(integer type)
                let cnt = $('#cnt').val();
                $.ajax({
                    url:'/addcart',
                    data: {cust_id:cust_id, item_id:item_id, cnt:cnt},
                    success:function(){
                        $('#myModal').modal();
                    }
                });
                //form 전송과 ajax 형태의 전송 차이 주의
                //form: 다른 페이지 로드로 이어짐
                //ajax: controller에서 전달받아 같은 페이지에서 다른 값을 뿌려줄 수 잇음
                //경우에 따라 사용할 것.
            //     $('#cart_form').attr({
            //         method: 'post',
            //         action: '/item/addcart'
            //     });
            //     $('#cart_form').submit();
            });
        }
    };
    $(function () {
        item_get.init();
    });


</script>


<div class="col-sm-8 text-left">
    <div class="container">
        <h3>Item Info</h3>
        <img src="/uimg/${gitem.imgname}">
        <h4>${gitem.id}</h4>
        <h4>${gitem.name}</h4>
        <h4>${gitem.price}</h4>
        <h4>${gitem.rdate}</h4>
        <c:if test="${logincust !=null}">
            <form id="cart_form" class="form-inline well">
                <div class="row-content">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input id="cnt" type="number" class="form-control" name="cnt" placeholder="Enter Quantity">
                    </div>
                    <div class="form-group" style="margin-top: 10px; text-align: center;">
                        <button type="button" id="cart_btn" class="btn btn-default">CART</button>
                        <input type="hidden" name="cust_id" value="${logincust.id}">
                        <input type="hidden" name="item_id" value="${gitem.id}">
                    </div>
                </div>
            </form>
        </c:if>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title"></h4>
            </div>
            <div class="modal-body">
                <a href="/item/allcart?id=${logincust.id}" class="btn btn-info" role="button">GO TO CART</a>
                <a href="/item/allpage" class="btn btn-info" role="button">CONTINUE</a>
            </div>
            <div class="modal-footer">
            </div>
        </div>

    </div>
</div>

