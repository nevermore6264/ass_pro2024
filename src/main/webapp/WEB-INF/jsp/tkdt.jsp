<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

          
          
          
          
           <div class="container">
           
           
           <c:if test="${not empty message }">
           <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Lỗi!</strong>
    
    <p>${message }</p>
    
  </div>
  </c:if>
           
           
           <!-- từ thời gian này đến thời gian kia -->
<div class="container">
<div class="container">
    <div class="row" style="float: right">
           <form action="timtkdt" >
           <div class="form-group row">
            <div class="col-xs-2">
            <input class="form-control" type="text" onfocus="(this.type='date')" onblur="if(this.value==''){this.type='text'}" name="tungay" placeholder="Từ ngày" value="${tungay }" required="required"/></div> <b>&nbsp;_&nbsp;</b>
            <div class="col-xs-2">
            <input class="form-control" type="text" onfocus="(this.type='date')" onblur="if(this.value==''){this.type='text'}" name="denngay" placeholder="Đến ngày" value="${denngay }" required="required"/>
            </div>
            
           <span class="input-group-btn">
             <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><span style="margin-left:2px;"><i class="fa fa-search"></i> Thống kê</span></button>
             </span>
            </div>
            </form>
            </div>
           </div>
           </div> 
            <!-- từ thời gian này đến thời gian kia -->
            
            
 
             <div style="overflow: auto;height: auto;width: 100%;box-shadow: 1px 1px 5px #888888;">
           <table class="table" style="white-space: nowrap;">
           
           
           <tr><th width="40%;"></th> <th width="40%;">Số tiền</th><th width="20%;">Chức năng</th></tr>
           <tr><th>Tổng doanh thu dịch vụ</th> <td><fmt:formatNumber value="${tongTienDichVu }" type="number" pattern="###,###" /> VNĐ</td><td><a href="ctdtdv">Xem chi tiết</a></td></tr>
           <tr><th>Tổng doanh thu cho thuê phòng</th> <td><fmt:formatNumber value="${tongTien }" type="number" pattern="###,###" /> VNĐ</td><td><a href="ctdtctp">Xem chi tiết</a></td></tr>
           <tr><th>Tổng cộng</th> <td><fmt:formatNumber value="${tongTienDichVu + tongTien }" type="number" pattern="###,###" /> VNĐ</td><td></td></tr>
           
           </table>
               </div>
               
<c:if test="${not empty checkctdtdv }">
<br><br>
<h2>Bảng chi tiết doanh thu dịch vụ</h2>
<hr>
 <div style="overflow: auto;height: auto;width: 100%;box-shadow: 1px 1px 5px #888888;">
           <table class="table" style="white-space: nowrap;">
           
           
          <tr><th>Tên dịch vụ</th><th>Số lượng</th><th>Tổng giá</th></tr>
          <c:forEach var="u" items="${ctdtdv }">
            <tr><td>${u.tenDichVu }</td><td><fmt:formatNumber type="number" pattern="###,###" value="${u.soLuong }"/></td><td><fmt:formatNumber type="number" pattern="###,###" value="${u.gia }"/> VNĐ</td></tr>
            </c:forEach>
           </table>
               </div>

</c:if>
            
            
            
            <c:if test="${not empty checkctdtctp }">
<br><br>
<h2>Bảng chi tiết doanh thu từng phòng</h2>
<hr>
 <div style="overflow: auto;height: auto;width: 100%;box-shadow: 1px 1px 5px #888888;">
           <table class="table" style="white-space: nowrap;">
           
           
          <tr><th>Số phòng</th><th>Lượng người đặt</th><th>Tổng tiền</th></tr>
          <c:forEach var="u" items="${ctdtctp }">
            <tr><td>${u.soPhong }</td><td><fmt:formatNumber type="number" pattern="###,###" value="${u.soLanDat }"/></td><td><fmt:formatNumber type="number" pattern="###,###" value="${u.tongGia }"/> VNĐ</td></tr>
            </c:forEach>
           </table>
               </div>

</c:if>
</div>
          
            
         
