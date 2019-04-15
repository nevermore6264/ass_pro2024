<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    	<div class="container">
<!-- thông báo lỗi ngoại lệ form -->
<frm:form modelAttribute="taikhoan">
           <c:if test="${not empty errors }">
           <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Lỗi!</strong>
     
    <p><frm:errors path="*" ></frm:errors></p>
    
  </div>
  </c:if>
  </frm:form>
  <!-- thông báo khi sửa hoặc xóa thành công -->
  <c:if test="${not empty message }">
           <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    
    <strong>${message }</strong>
  </div>
  </c:if>
  
  
  
  
   <div class="container">
           <form action="timkiemidornametk" >
           
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
		<table class="table table-striped" style="white-space: nowrap;font-size: 15px;">
		<thead>
		<tr>
		<th style="min-width: 80px;">Tên đăng nhập</th>
		
		<th style="min-width: 80px;">Họ và Tên</th>
		<th style="min-width: 80px;">Giới tính</th>
		<th style="min-width: 80px;">Ngày sinh</th>
		<th style="min-width: 80px;">CMND</th>
		<th style="min-width: 80px;">Số điện thoại</th>
        <th style="min-width: 80px;">Email</th>
        <th style="min-width: 80px;">Chức vụ</th>
        <th style="min-width: 80px;">Hoạt Động</th>
        
		</tr>	
		</thead>
	<c:forEach var="u" items="${lTaikhoans}">
		<tr>
		<td>${u.tenDangNhap}</td>
		
		<td>${u.hoTen}</td>
		<td>${u.gioiTinh}</td>
		<td><fmt:formatDate value="${u.ngaySinh }" pattern="d/M/yyyy"/></td>
		<td>${u.cmnd}</td>
		<td>${u.soDT}</td>
		<td>${u.email}</td>
		<td>${u.chucVu.tenChucVu}</td>
		<td><button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#myModalsua${u.tenDangNhap}"><i class="fa fa-edit"></i> Sửa</button>  <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModalxoa${u.tenDangNhap}"><i class="fa fa-trash-o"></i> Xóa</button></td>
		
		</tr>
		
		 <!-- Modal xoa -->
  <div class="modal fade" id="myModalxoa${u.tenDangNhap}" role="dialog">
    <div class="modal-dialog"> 
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          
          <h4 class="modal-title" style="font-weight: bold;">Xóa tài khoản</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
        <h6>Bạn muốn xóa tài khoản <strong>${u.tenDangNhap}?</strong></h6>
         </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
      <a href="delete?tenDangNhap=${u.tenDangNhap}" class="btn btn-success">Đồng ý</a>
        </div>
     </div>
    </div>
  </div>
  
  
  					          <!-- Modal sua -->
  					          <frm:form action="edittk" modelAttribute="taikhoan">
  <div class="modal fade" id="myModalsua${u.tenDangNhap }" role="dialog">
    <div class="modal-dialog"> 
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          
          <h4 class="modal-title" style="font-weight: bold;">Sửa tài khoản <strong>${u.tenDangNhap }</strong></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
          <div class="modal-body">
          
          <div class="form-group">	
    <label for="tenDangNhap" style="font-weight: bold;">Tên đăng nhập:</label>
    <input class="form-control input-sm" id="tenDangNhap" placeholder="Nhập tên đăng nhập" value="${u.tenDangNhap }" disabled/>
    <frm:hidden path="tenDangNhap" value="${u.tenDangNhap }"/>
</div>
          
          
          <div class="form-group">
		<label for="matKhau" style="font-weight: bold;">Mật khẩu:</label>
		
			<frm:input type="password" id="matKhau" class="form-control" path="matKhau" placeholder="Nhập mật khẩu" value="${u.matKhau }" />
		</div>



<div class="form-group">
		<label for="hoTen" style="font-weight: bold;">Họ và Tên:</label>
		
			<frm:input id="hoTen" class="form-control" path="hoTen" placeholder="Nhập họ và tên" value="${u.hoTen }"/>
		</div>
	

<div class="form-group">
		<label for="gioiTinh" style="font-weight: bold;">Giới Tính:</label>
		
		<frm:select id="gioiTinh" class="form-control" path="gioiTinh">
			<frm:option value="Nam">Nam</frm:option>
			<frm:option value="Nữ">Nữ</frm:option>
			</frm:select>
			</div>

	
	<div class="form-group">
		<label for="ngaySinh" style="font-weight: bold;">Ngày Sinh:</label>
		
			<frm:input type="date" id="ngaySinh" class="form-control" path="ngaySinh" placeholder="Chọn ngày sinh" value="${u.ngaySinh }"/>
		</div>
	
	
	<div class="form-group">
		<label for="CMND" style="font-weight: bold;">CMND:</label>
		
			<frm:input type="number" id="CMND" class="form-control" path="cmnd" placeholder="Nhập số chứng minh nhân dân" value="${u.cmnd }"/>
		</div>
	
	
	<div class="form-group">
		<label for="soDT" style="font-weight: bold;">Số điện thoại:</label>
		
			<frm:input type="number" id="soDT" class="form-control" path="soDT" placeholder="Nhập số điện thoại" value="${u.soDT }"/>
		</div>
	

<div class="form-group">
		<label for="Email" style="font-weight: bold;">Email:</label>
		
			<frm:input type="Email" id="Email" class="form-control" path="Email" placeholder="Nhập địa chỉ email" value="${u.email }"/>
		</div>
	
	
	<div class="form-group">
		<label for="Email" style="font-weight: bold;">Chức Vụ:</label>
		
			<frm:select class="form-control" path="chucVu.maChucVu">
			<frm:option value="1">Giám đốc</frm:option>
			<frm:option value="2">Nhân viên</frm:option>
			</frm:select>
		</div>
	



          </div>
        <div class="modal-footer">
      <button type="submit" class="btn btn-success" >Hoàn tất</button>
      </div>
       
         </div>
      </div></div></frm:form>
</c:forEach>
</table>
		
		
								
           
</div>
          

           <c:if test="${danhsach!=0}">
<br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="tkpage?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="tkpage?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="tkpage?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="tkpage?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="tkpage?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>


 <c:if test="${ not empty danhsachtim}">
 <br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="tkpagetim?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="tkpagetim?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="tkpagetim?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="tkpagetim?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="tkpagetim?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>
</div>
         
