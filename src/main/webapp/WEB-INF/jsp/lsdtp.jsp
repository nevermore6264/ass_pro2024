<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">



<!-- từ thời gian này đến thời gian kia -->
<%-- <div class="container">
<div class="container">
    <div class="row" style="float: right">
           <form action="timlsdtp" >
           <div class="form-group row">
            <div class="col-xs-2">
            <input class="form-control" type="text" onfocus="(this.type='date')" onblur="if(this.value==''){this.type='text'}" name="tungay" placeholder="Từ ngày" value="${tungay }"/></div> <b>&nbsp;_&nbsp;</b>
            <div class="col-xs-2">
            <input class="form-control" type="text" onfocus="(this.type='date')" onblur="if(this.value==''){this.type='text'}" name="denngay" placeholder="Đến ngày" value="${denngay }"/>
            </div>
            
           <span class="input-group-btn">
             <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><span style="margin-left:2px;"><i class="fa fa-search"></i> Tìm</span></button>
             </span>
            </div>
            </form>
            </div>
           </div>
           </div> --%>
            <!-- từ thời gian này đến thời gian kia -->
            
            <div class="container">
           <form action="timlsdtp" >
           
           <div class="row" style="float: right">
           <div class="form-group">
           <div class="input-group">
            <input class="form-control" type="text" name="data" placeholder="Nhập thông tin cần tìm" required/>
            <span class="input-group-btn">
             <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><span style="margin-left:2px;"><i class="fa fa-search"></i> Tìm</span></button>
             </span>
             </div>
            </div>
            </div>
            
            </form>
            </div>
            
            
             <div style="overflow: auto;height: auto;width: 100%;box-shadow: 1px 1px 5px #888888;">
           <table class="table table-striped" style="font-size: 15px;white-space: nowrap;">
           
           <thead style="vertical-align: middle;">
					<tr>
           <th>Mã</th><th>Người thuê</th><th>Số ĐT</th><th>Số CMND</th><th>Tiền cọc</th><th>Phòng</th><th>Thời gian đặt</th><th>Thời gian trả</th><th>Nhân viên</th>
           </tr>
           <tbody>
           <c:forEach var="u" items="${l }">
           <tr>
          <td>${u.maDatPhong }</td> 
          <td>${u.hoTen }</td> 
          <td>${u.soDT }</td> 
          <td>${u.soCMND }</td> 
          <td><fmt:formatNumber value="${u.tienCoc }" type="number" pattern="###,###"/> VNĐ</td> 
          <td>${u.phong.soPhong }</td> 
          <td> <fmt:formatDate pattern="HH:mm" value="${u.gioDat }"/> - <fmt:formatDate pattern="d/M/yyyy" value="${u.ngayDat }"/></td> 
          
          <td><c:if test="${empty u.traPhongs }">Chưa trả</c:if><c:forEach var="i" items="${u.traPhongs }"> <fmt:formatDate pattern="HH:mm" value="${i.gioTra }"/> - <fmt:formatDate pattern="d/M/yyyy" value="${i.ngayTra }"/></c:forEach></td> 
          
          <td>${u.taiKhoan.tenDangNhap }</td>
          </tr>
           </c:forEach>
           </tbody>
           </table>
           
</div>

           <c:if test="${danhsach!=0}">
<br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="lsdtppage?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="lsdtppage?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="lsdtppage?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="lsdtppage?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="lsdtppage?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>

 <c:if test="${ not empty danhsachtim}">
 <br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="lsdtppagetim?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="lsdtppagetim?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="lsdtppagetim?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="lsdtppagetim?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="lsdtppagetim?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>
            </div>

          
            
         

       