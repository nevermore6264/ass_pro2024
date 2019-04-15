 <%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>

.hovera {text-decoration:none;color: black;}

.hovera:hover{
text-decoration:none;
color: black;
text-shadow: 1px 1px 1px #888888;
}
</style>

           <div class="container">
   <c:if test="${not empty message }">
           <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    
    <strong>${message }</strong>
  </div>
  </c:if>
  </div>
            <div class="container" style="height: auto;margin-top: 20px;">
            <c:forEach var="i" items="${ltang }">
            
            <div style="width: 100%">
            
            <div style="width: 100%;height: 80px;">
            <img align="right" style="-webkit-filter: drop-shadow(1px 1px 2px #888888); filter: drop-shadow(1px 1px 2px #888888);margin-bottom: 10px;"
								src='hinh/title tang.png'
								width="450px" height="70px" >
								<div style="color: white;position: absolute;left: 71%;margin-top: 13px"><b style="font-size: 30px">Tầng ${i }</b></div>
								</div>
								
								
								<div style="clear: both;width: 100%;">
								<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;width: 100%;">
								  <c:forEach var="u" items="${l }">
								  
								  <c:if test="${i==u.tang }">
         
          
               <div style="float: left; width: 300px; height: 120px; margin: 10px;margin-right:15px;margin-left:20px ;display: inline-block;">
							<a class="hovera" href="actionclickdptp?maPhong=${u.maPhong }&trangThai=${u.trangThai }&soPhong=${u.soPhong }" >
							<img style="-webkit-filter: drop-shadow(1px 1px 2px #888888); filter: drop-shadow(1px 1px 2px #888888);float: left;"
								src='<c:if test="${u.trangThai==0 }">hinh/homegreen.png</c:if><c:if test="${u.trangThai==1 }">hinh/homered.png</c:if>'
								width="120px" height="120px">
								<div style="margin-top: 10px;margin-left: 130px;font-size: 15px;">
								<div><b>Phòng: </b>${u.soPhong }</div>
								<div><b>Loại: </b><c:if test="${u.loaiPhong.tenLoaiPhong=='VIP'}"><img src="hinh/vip.png" width="55px" height="23px" style="margin-bottom: 5px;-webkit-filter: drop-shadow(1px 1px 1px #fff0b6); filter: drop-shadow(1px 1px 1px #fff0b6);"></img></c:if><c:if test="${u.loaiPhong.tenLoaiPhong=='Thường'}">Thường</c:if></div>
								<div><b>Giá gốc: </b><fmt:formatNumber type="number" pattern="###,###" value="${u.giaPhong}" /> VNĐ</div>
								<div><b>Giảm giá: </b>${u.khuyenMai } %</div>
								
								
								</div>
							</a>
							
						</div>
						
						
						
						
						</c:if>
						
						
</c:forEach>
							</div>	
								</div>
								</div>
						
            </c:forEach>
            </div>

         
            
         
         
            
         

       