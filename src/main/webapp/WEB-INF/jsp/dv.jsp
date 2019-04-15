<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<div class="container">
							
						
 <!-- thông báo khi sửa hoặc xóa thành công -->
  <c:if test="${not empty message }">
           <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    
    <strong>${message }</strong>
  </div>
  </c:if>
							
							
								
           <frm:form action="actionloaidichvu">
           <div align="center">
           <hr>
           <button class="btn btn-info" type="submit" name="anuong" style="width: 190px;height: 45px;box-shadow: 1px 1px 1px #888888;">Ăn uống</button> <button class="btn btn-info" type="submit" name="giatui" style="width: 190px;height: 45px;box-shadow: 1px 1px 1px #888888;" >Giặt ủi</button> <button class="btn btn-info" type="submit" name="thugian" style="width: 190px;height: 45px;box-shadow: 1px 1px 1px #888888;">Thư giãn</button>
           </div>
           </frm:form>
            <hr>
            <c:if test="${empty width }">
            <table width="100%">
            <tr>
            <td style="width: 30%;" valign="top">
            
            <jsp:include page="${param.view }"></jsp:include>
            
            </td>
            
            <td style="width: 70%;" align="center">
           </c:if>
<table class="table table-striped"  style="box-shadow: 1px 1px 5px #888888;min-width: <c:if test="${not empty width }">100%</c:if><c:if test="${empty width }">500px</c:if>;">
<thead>
<tr><th colspan="6" style="text-align: center;">Danh sách dịch vụ đã đặt</th></tr>
<tr><th>Tên DV</th> <th>Loại DV</th> <th>Số lượng</th> <th>Đơn giá</th> <th>Thành tiền</th> <th>Hành động</th></tr>
</thead>
<tbody>
<c:forEach var="u" items="${l }">

<tr><td>${u.dichVu.tenDichVu }</td> <td><c:if test="${u.dichVu.loaiDichVu==0 }">Ăn uống</c:if><c:if test="${u.dichVu.loaiDichVu==1 }">Giặt ủi</c:if><c:if test="${u.dichVu.loaiDichVu==2 }">Thư giãn</c:if></td> <td>${u.soLuong }</td> <td><fmt:formatNumber type="number" pattern="###,###" value="${u.dichVu.giaDichVu }" /> VNĐ</td> <td><fmt:formatNumber type="number" pattern="###,###" value="${u.soLuong * u.dichVu.giaDichVu }" /> VNĐ</td> 
<td><button type="button" class="btn btn-danger btn-sm" style="text-align: center;width: 89px;height: 28px" data-toggle="modal" data-target="#myModalxoa${u.maDonDichVu }"><i class="fa fa-trash-o"></i> Xóa</button></td></tr>

 <!-- Modal xoa -->
  <div class="modal fade" id="myModalxoa${u.maDonDichVu }" role="dialog">
    <div class="modal-dialog"> 
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          
          <h4 class="modal-title" style="font-weight: bold;">Xóa dịch vụ</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
        <h6>Bạn muốn xóa <strong>${u.dichVu.tenDichVu }</strong>?</h6>
         </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
      <a href="deletedvdd?id=${u.maDonDichVu }" class="btn btn-success">Đồng ý</a>
        </div>
     </div>
    </div>
  </div>
</c:forEach>
</tbody>
<tr><th colspan="4" style="text-align: right;">Tổng:</th><th colspan="2"><fmt:formatNumber type="number" pattern="###,###" value="${sum }" /> VNĐ</th></tr>
 
 </table>
 
<c:if test="${empty width }">
            </td>
            </tr>
            </table>
            </c:if>
            
			</div>
          
            
        