<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<style>
    #map02 > #map{
        width: 400px;
        height: 400px;
        border: 2px solid lightpink;
    }
</style>

<script>

    let map02 = {
        map:null,
        init: function(){
            this.display();
            $('#s_btn').click(function(){
                map02.go(37.5208119, 126.9278776);
            });
            $('#d_btn').click(function(){
                map02.go(36.3171959, 127.4094206);
            });
            $('#j_btn').click(function(){
                map02.go(33.243829, 126.5386304);
            });
        },
        display: function(){
            var mapContainer = document.querySelector('#map02 > #map');
            var mapOption = {
                center: new kakao.maps.LatLng(37.5444568, 127.0572981), // 지도의 중심좌표
                level: 5 // 지도의 확대 레벨
            };
            map = new kakao.maps.Map(mapContainer, mapOption);
            var mapTypeControl = new kakao.maps.MapTypeControl();

            map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

            var zoomControl = new kakao.maps.ZoomControl();
            map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

            var markerPosition  = new kakao.maps.LatLng(37.5444568, 127.0572981);

            var marker = new kakao.maps.Marker({
                position: markerPosition
            });

            marker.setMap(map);
        },
        go:function(lat, lng){
            var moveLatLon = new kakao.maps.LatLng(lat, lng);
            map.panTo(moveLatLon);

            var markerPosition  = new kakao.maps.LatLng(lat, lng);

            var marker = new kakao.maps.Marker({
                position: markerPosition
            });
            marker.setMap(map);

        }
    };
    $(function(){
        map02.init();
    })

</script>

<div class="col-sm-8 text-left">
      <div class = "container" id = "map02">
          <h3>MAP02</h3>
          <button id = "s_btn" type="button" class="btn btn-default">Seoul</button>
          <button id = "d_btn" type="button" class="btn btn-default">Daejeon</button>
          <button id = "j_btn" type="button" class="btn btn-default">Jeju</button>
          <div id = "map"></div>

    </div>
</div>
