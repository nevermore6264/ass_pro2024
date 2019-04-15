<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

          
        
      <div class="container" style="margin-top: 15px;display: inline-block;">
      
      
      
      <div style="width: 43%;float: left;box-shadow: 1px 1px 2px #888888;border-radius: .40rem;">
      
      <table class="table" style="font-size: 15px;">
      <tr><th colspan="2" style="text-align: center;font-size: 18px;">Bảng tính tiền</th></tr>
      <tr>
      <th>Tiền cọc</th>
      <th><fmt:formatNumber type="number" pattern="###,###" value="${tiencoc }"/> VNĐ</th>
      </tr>
      <tr>
      <th>Tiền phòng</th>
      <th><fmt:formatNumber type="number" pattern="###,###" value="${tongTiendp }"/> VNĐ</th>
      </tr>
       <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ngày đặt</td>
      <td><fmt:formatDate pattern="d/M/yyyy" value="${getdatphong.ngayDat }"/></td>
      </tr>
       <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ngày trả</td>
      <td><fmt:formatDate pattern="d/M/yyyy" value="${ngayhientaii }"/></td>
      </tr>
      
      <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Số ngày thuê</td>
      <td>${songaythue } ngày</td>
      </tr>
      
      <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Đã giảm giá</td>
      <td>${giamgia } %</td>
      </tr>
      
      <tr>
      <th>Tiền dịch vụ</th>
      <th><fmt:formatNumber type="number" pattern="###,###" value="${tongTiendv }"/> VNĐ</th>
      </tr>
      
      <c:forEach var="u" items="${listdv }">
      <tr>
      <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${u.dichVu.tenDichVu } x${u.soLuong }</td>
      <td><fmt:formatNumber type="number" pattern="###,###" value="${u.dichVu.giaDichVu*u.soLuong }" /> VNĐ</td>
      </tr>
      </c:forEach>
      
      <tr style="color: red;">
      <th>Tổng tiền cần thanh toán</th>
      <th><fmt:formatNumber type="number" pattern="###,###" value="${tongTien }"/> VNĐ</th>
      </tr>
      </table>
      
      </div>
      
         <div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;width: 55%;float: right;">
         <frm:form action="actiontraphong" modelAttribute="traphong">
         <frm:hidden path="datPhong.maDatPhong" value="${maDatPhong }"/>
         <frm:hidden path="tongTien" value="${tongTien }"/>
       	<input type="hidden" name="maPhong" value="${maPhong }">
        
         
         <div class="form-group">
		<label for="gioTra" style="font-weight: bold;">Giờ trả:</label>
			<frm:input id="gioTra" class="form-control" path="gioTra" type="time" placeholder="Nhập họ và tên" value="${giohientai }" required="required"/>
		</div>
         <div class="form-group">
		<label for="ngayTra" style="font-weight: bold;">Ngày trả:</label>
		
			<frm:input id="ngayTra" class="form-control" path="ngayTra" type="date" placeholder="Nhập họ và tên" value="${ngayhientai }" required="required"/>	
		</div>
         <div class="form-group">
		<label for="tongtien" style="font-weight: bold;color: red;font-size: 18px;">Tổng tiền cần thanh toán:&nbsp;&nbsp;&nbsp;<fmt:formatNumber type="number" pattern="###,###" value="${tongTien }"/> VNĐ</label>
		</div>
		
		
		
		<button type="button" class="btn btn-success btn-xs float-right" data-toggle="modal" data-target="#myModala">Hoàn tất</button>
	
		
		
		 <!-- Modal submit tra phong -->
  <div class="modal fade" id="myModala" role="dialog">
    <div class="modal-dialog"> 
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          
          <h4 class="modal-title" style="font-weight: bold;">Xác nhận trả phòng</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
        <h6>Bạn muốn trả phòng <strong>${sophong }</strong>?</h6>
         </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
      <button class="btn btn-success" style="submit">Đồng ý</button>
        </div>
     </div>
    </div>
  </div>
		
		
		
		
		
 </frm:form>
 </div>
            </div>
         

      