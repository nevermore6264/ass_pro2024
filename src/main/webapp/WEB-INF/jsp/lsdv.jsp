<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

            	  <div class="container">
             <div class="container">
           <form action="timlsdv" >
           
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
           <thead>
           <tr>
           <th>Mã đơn dịch vụ</th><th>Mã đơn đặt phòng</th><th>Tên dịch vụ</th><th>Loại</th><th>Số lượng</th><th>Ngày đặt</th>
           </tr>
           </thead>
           <c:forEach var="u" items="${l }">
           <tr>
          <td>${u.maDonDichVu }</td> 
          <td>${u.datPhong.maDatPhong }</td> 
          <td>${u.dichVu.tenDichVu }</td> 
          <td>
<c:if test="${u.dichVu.loaiDichVu ==0}">Ăn uống</c:if>
<c:if test="${u.dichVu.loaiDichVu ==1}">Giặt ủi</c:if>
<c:if test="${u.dichVu.loaiDichVu ==2}">Thư giãn</c:if>
</td> 
         
          <td>${u.soLuong }</td> 
          <td><fmt:formatDate value="${u.ngayDat }" pattern="d/M/yyyy"/></td>
         
          </tr>
           </c:forEach>
           </table>
           
           
               </div>
 <c:if test="${danhsach!=0}">
<br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="lsdvpage?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="lsdvpage?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="lsdvpage?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="lsdvpage?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="lsdvpage?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>



 <c:if test="${ not empty danhsachtim}">
 <br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="lsdvpagetim?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="lsdvpagetim?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="lsdvpagetim?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="lsdvpagetim?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="lsdvpagetim?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>
            </div>

          
            
         

       