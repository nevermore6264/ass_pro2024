<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
           <!-- thông báo lỗi ngoại lệ form -->
<frm:form modelAttribute="phong">
           <c:if test="${not empty errors|| not empty errorimg }">
           <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Lỗi!</strong>
    
    <p><frm:errors path="*" ></frm:errors><br>${errorimg }</p>
    
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
  
          </div>
          
          <div class="container">

<div class="breadcrumb" style="box-shadow: 1px 1px 5px #888888;">
<div>
          <frm:form action="actionaddqlp" modelAttribute="phong" enctype="multipart/form-data">
				<div class="form-group">
				<div class="col-sm-10">
    <label for="sophong" style="font-weight: bold;">Số phòng:</label>
    <frm:input path="soPhong" class="form-control input-sm" id="sophong" type="number" placeholder="Nhập số phòng"/>
  </div>
</div>
 <div class="form-group">
 <div class="col-sm-10">
    <label for="tang" style="font-weight: bold;">Tầng</label>
    <frm:input path="tang" class="form-control input-sm" id="tang" type="number" placeholder="Nhập số  tầng"/>
  </div>
  </div>
  <div class="form-group">
  <div class="col-sm-10">
    <label for="tienNghi" style="font-weight: bold;">Tiện Nghi:</label>
    <frm:label path="tienNghi" id="tienNghi"></frm:label>
    <br>
    <table><tr><td width="120px;"><frm:checkbox path="tienNghi" value="Điều hòa" label="  Điều hòa"/></td><td><frm:checkbox path="tienNghi" value="Quạt" label="  Quạt"/></td></tr><tr><td><frm:checkbox path="tienNghi" value="Tivi" label="  Tivi"/></td><td><frm:checkbox path="tienNghi" value="Nước nóng lạnh" label="  Nước nóng lạnh"/></td></tr><tr><td><frm:checkbox path="tienNghi" value="Vị trí tốt" label="  Vị trí tốt"/></td><td></td></tr></table>
  
   </div>
  </div>
  
  <div class="form-group">
  <div class="col-sm-10">
    <label for="loaiPhong" style="font-weight: bold;">Loại Phòng:</label>
    <frm:select path="loaiPhong.maLoaiPhong" class="form-control input-sm" id="loaiPhong">
   <frm:options items="${itemloaiphong }" itemLabel="tenLoaiPhong" itemValue="maLoaiPhong"  />
    </frm:select>
  </div></div>
  
  <div class="form-group">
  <div class="col-sm-10">
    <label for="hinhAnh" style="font-weight: bold;">Hình Ảnh:</label>
    <input type="file" class="form-control" id="file" name="file" accept=".jpg,.JPG,.png,.PNG"/>
  </div></div>
  
 <div class="form-group">
 <div class="col-sm-10">
    <label for="giaPhong" style="font-weight: bold;">Giá phòng:</label>
    <frm:input path="giaPhong" class="form-control input-sm" id="giaPhong" type="number" placeholder="Nhập giá phòng"/>
  </div></div>
 
 <div class="form-group">
 <div class="col-sm-10">
    <label for="khuyenMai" style="font-weight: bold;">Giảm giá:</label>
    <frm:input path="khuyenMai" class="form-control input-sm" id="khuyenMai" type="number" placeholder="Nhập phần trăm giảm giá" min="0" max="100"/>
  </div></div>
  <div class="container">
<frm:button type="submit" class="btn btn-success btn-xs">Thêm</frm:button></div>
						</frm:form>
				</div>
</div>
</div>
<script>
	 $(function () {        
    $('#file').change(function () {

        //because this is single file upload I use only first index
        var f = this.files[0]

        //here I CHECK if the FILE SIZE is bigger than 8 MB (numbers below are in bytes)
        if (f.size > 8388608 || f.fileSize > 8388608)
        {
           //show an alert to the user
           alert("Dung lượng ảnh vượt quá giới hạn 8 MB");

           //reset file upload control
           this.value = null;
        }
    })
});
</script>
