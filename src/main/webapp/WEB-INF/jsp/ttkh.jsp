<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

          
            <div class="container">

<div class="container">
           <form action="timttkh" >
           
           <div class="row" style="float: right">
           <div class="form-group">
           <div class="input-group">
            <input class="form-control" type="text" name="data" placeholder="Tìm theo tên, sdt, cmnd" required/>
            <span class="input-group-btn">
             <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><span style="margin-left:2px;"><i class="fa fa-search"></i> Tìm</span></button>
             </span>
             </div>
            </div>
            </div>
            
            </form>
            </div>
            
            
                   <table class="table table-striped" style="box-shadow: 1px 1px 5px #888888">
           <thead>
           <tr>
           <th>Mã đơn</th> <th>Họ và tên</th><th>Số điện thoại</th><th>Số chứng minh</th><th>Phòng</th><th>Thời gian đặt</th><th>Thời gian trả</th>
           </tr>
           </thead>
           <tbody>
           <c:forEach var="u" items="${l }">
          <tr>
          <td>${u.maDatPhong }</td><td>${u.hoTen }</td> <td>${u.soDT }</td> <td>${u.soCMND }</td> <td>${u.phong.maPhong }</td> <td><fmt:formatDate pattern="HH:mm" value="${u.gioDat }"/> - <fmt:formatDate pattern="d/M/yyyy" value="${u.ngayDat }"/></td>
          
          
           <td>
           <c:if test="${empty u.traPhongs }">
           Chưa trả
           </c:if>
           <c:forEach var="i" items="${u.traPhongs }">
           
           <fmt:formatDate pattern="HH:mm" value="${i.gioTra }"/> - <fmt:formatDate pattern="d/M/yyyy" value="${i.ngayTra }"/>
            
           
           </c:forEach>
           
           </td>
           
          </tr>
          </c:forEach>
          </tbody>
           </table>
               
               <c:if test="${danhsach!=0}">

<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="ttkhpage?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="ttkhpage?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="ttkhpage?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="ttkhpage?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="ttkhpage?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>


 <c:if test="${ not empty danhsachtim}">
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="ttkhpagetim?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="ttkhpagetim?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="ttkhpagetim?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="ttkhpagetim?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="ttkhpagetim?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>
            </div>

          
            
         
