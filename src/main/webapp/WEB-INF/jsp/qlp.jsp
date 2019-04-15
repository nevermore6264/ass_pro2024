<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="container">
          <frm:form modelAttribute="phong">
            
            
            <!-- thông báo lỗi ngoại lệ form -->
           <c:if test="${not empty errors|| not empty errorimg }">
           <div class="alert alert-danger">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    <strong>Lỗi!</strong>
     <p><frm:errors path="*" ></frm:errors><br>${errorimg }</p>
  </div>
  </c:if>
  
  <!-- thông báo khi sửa hoặc xóa thành công -->
  <c:if test="${not empty message }">
           <div class="alert alert-success">
    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
    
    <strong>${message }</strong>
  </div>
  </c:if>
  
  </frm:form>
  
         <div class="container">
           <form action="timqlp" >
           
           <div class="row" style="float: right">
           <div class="form-group">
           <div class="input-group">
            <input class="form-control" type="number" name="data" placeholder="Tìm theo mã, số, tầng" required/>
            <span class="input-group-btn">
             <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-search" aria-hidden="true"></span><span style="margin-left:2px;"><i class="fa fa-search"></i> Tìm</span></button>
             </span>
             </div>
            </div>
            </div>
            
            </form>
            </div>
       
       
          <div style="overflow: auto;height: auto;width: 100%;box-shadow: 1px 1px 5px #888888;">
			<table class="table table-striped" style="font-size: 15px;white-space: nowrap;" >
					<thead style="vertical-align: middle;">
					<tr>
					<th width="200px;">Hình Ảnh</th>
						<th style="min-width: 80px;vertical-align: middle;">Mã Phòng</th>
						<th style="min-width: 80px;vertical-align: middle;">Số Phòng</th>
						<th style="min-width: 80px;vertical-align: middle;">Loại Phòng</th>
						<th style="min-width: 80px;vertical-align: middle;">Tầng</th>
						<th width="100px;" style="vertical-align: middle;">Tiện Nghi</th>
						
						<th style="min-width: 80px;vertical-align: middle;">Giá Phòng</th>
						<th style="min-width: 80px;vertical-align: middle;">Giảm giá</th>
						<th style="min-width: 80px;vertical-align: middle;">Trạng Thái</th>
						<th style="width: auto;vertical-align: middle;">Hành động</th>
					</tr>
					</thead>
					<tbody>
					
					<c:forEach var="u" items="${lPhongs}">
						<tr>
						<td style="vertical-align: middle;"><img alt="" id="myImg${u.maPhong}" src="hinh/phong/${u.hinhAnh}" width="60px" height="60px"></td>
							<td style="vertical-align: middle;">${u.maPhong}</td>
							<td style="vertical-align: middle;">${u.soPhong}</td>
							<td style="vertical-align: middle;">${u.loaiPhong.tenLoaiPhong}</td>
							<td style="vertical-align: middle;">${u.tang}</td>
							<td style="vertical-align: middle;">${u.tienNghi}</td>
							<td style="vertical-align: middle;"><fmt:formatNumber type="number" pattern="###,###" value="${u.giaPhong}" /> VNĐ</td>
							<td style="vertical-align: middle;">${u.khuyenMai} %</td>
							<td style="vertical-align: middle;"><c:if test="${u.trangThai==0}">Trống</c:if><c:if test="${u.trangThai==1}">Đã thuê</c:if></td>
							<td style="vertical-align: middle;"><button type="button" class="btn btn-warning btn-sm" data-toggle="modal" data-target="#myModalsua${u.maPhong}"><i class="fa fa-edit"></i> Sửa</button>  <button type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModalxoa${u.maPhong}"><i class="fa fa-trash-o"></i> Xóa</button></td>
						</tr>
						
						
						<style>
#myImg${u.maPhong} {
    border-radius: 5px;
    cursor: pointer;
    transition: 0.3s;
}

#myImg${u.maPhong}:hover {opacity: 0.7;}

/* The Modal (background) */
.modal${u.maPhong} {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 99; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal${u.maPhong}-content {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
}

/* Caption of Modal Image */
#caption${u.maPhong} {
    margin: auto;
    display: block;
    width: 80%;
    max-width: 700px;
    text-align: center;
    color: #ccc;
    padding: 10px 0;
    height: 150px;
}

/* Add Animation */
.modal${u.maPhong}-content, #caption${u.maPhong} {    
    -webkit-animation-name: zoom;
    -webkit-animation-duration: 0.6s;
    animation-name: zoom;
    animation-duration: 0.6s;
}

@-webkit-keyframes zoom {
    from {-webkit-transform:scale(0)} 
    to {-webkit-transform:scale(1)}
}

@keyframes zoom {
    from {transform:scale(0)} 
    to {transform:scale(1)}
}

/* The Close Button */
.close${u.maPhong} {
    position: absolute;
    top: 15px;
    right: 35px;
    color: #f1f1f1;
    font-size: 40px;
    font-weight: bold;
    transition: 0.3s;
}

.close${u.maPhong}:hover,
.close${u.maPhong}:focus {
    color: #bbb;
    text-decoration: none;
    cursor: pointer;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px){
    .modal-content {
        width: 100%;
    }
}
</style>

<!-- The Modal image -->
<div id="myModal${u.maPhong}" class="modal${u.maPhong}">
  <span class="close${u.maPhong}">&times;</span>
  <img class="modal${u.maPhong}-content" id="${u.maPhong}">
  <div id="caption${u.maPhong}"></div>
</div>

 <!-- script image -->
<script>
// Get the modal
var modal = document.getElementById('myModal${u.maPhong}');

// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById('myImg${u.maPhong}');
var modalImg = document.getElementById("${u.maPhong}");
var captionText = document.getElementById("caption${u.maPhong}");
img.onclick = function(){
    modal.style.display = "block";
    modalImg.src = this.src;
    captionText.innerHTML = this.alt;
}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close${u.maPhong}")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
    modal.style.display = "none";
}
</script>

						          <!-- Modal xoa -->
  <div class="modal fade" id="myModalxoa${u.maPhong}" role="dialog">
    <div class="modal-dialog"> 
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          
          <h4 class="modal-title" style="font-weight: bold;">Xóa phòng</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <div class="modal-body">
        <h6>Bạn muốn xóa phòng có mã là <strong>${u.maPhong}?</strong></h6>
         </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Hủy</button>
      <a href="deletephong?maphong=${u.maPhong}" class="btn btn-success">Đồng ý</a>
        </div>
     </div>
    </div>
  </div>
  
  
   <frm:form action="actionsuaqlp" modelAttribute="phong" enctype="multipart/form-data">
 					          <!-- Modal sua -->
  <div class="modal fade" id="myModalsua${u.maPhong}" role="dialog">
    <div class="modal-dialog"> 
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          
          <h4 class="modal-title" style="font-weight: bold;">Sửa phòng có mã là <strong>${u.maPhong }</strong></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <div class="modal-body">
        <frm:hidden path="maPhong" value="${u.maPhong }"/>
       <frm:hidden path="trangThai" value="${u.trangThai }"/>
       
       <input type="hidden" name="checktiennghi" value="${u.tienNghi }"/>
       
        <div class="form-group">	
    <label for="sophong" style="font-weight: bold;">Số phòng:</label>
    <frm:input path="soPhong" class="form-control input-sm" id="sophong" type="number" placeholder="Nhập số phòng" value="${u.soPhong }" />
</div>
        
        <div class="form-group">
    <label for="tang" style="font-weight: bold;">Tầng</label>
    <frm:input path="tang" class="form-control input-sm" id="tang" type="number" placeholder="Nhập số  tầng" value="${u.tang }" />
  </div>



	  <div class="form-group">
    <label for="tienNghi" style="font-weight: bold;">Tiện Nghi:</label>
    <frm:label path="tienNghi" id="tienNghi"></frm:label>
    <br>
   <frm:checkbox id="dieuhoa${u.maPhong }" path="tienNghi" value="Điều hòa" label="  Điều hòa" />&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
   <frm:checkbox id="quat${u.maPhong }" path="tienNghi" value="Quạt" label="  Quạt"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
   <frm:checkbox id="tivi${u.maPhong }" path="tienNghi" value="Tivi" label="  Tivi"/>
   <br>
   
   <frm:checkbox id="nuocnonglanh${u.maPhong }" path="tienNghi" value="Nước nóng lạnh" label="  Nước nóng lạnh"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
   <frm:checkbox id="vitritot${u.maPhong }" path="tienNghi" value="Vị trí tốt" label="  Vị trí tốt"/>
   
   
   <script>
   <c:if test="${u.tienNghi.contains('Điều hòa')}">document.getElementById("dieuhoa${u.maPhong }").checked = true;</c:if>
   <c:if test="${u.tienNghi.contains('Quạt')}">document.getElementById("quat${u.maPhong }").checked = true;</c:if>
   <c:if test="${u.tienNghi.contains('Tivi')}">document.getElementById("tivi${u.maPhong }").checked = true;</c:if>
   <c:if test="${u.tienNghi.contains('Nước nóng lạnh')}">document.getElementById("nuocnonglanh${u.maPhong }").checked = true;</c:if>
   <c:if test="${u.tienNghi.contains('Vị trí tốt')}">document.getElementById("vitritot${u.maPhong }").checked = true;</c:if>
   

</script>
   </div>
 			
 			
 	<div class="form-group">
 
    <label for="loaiPhong" style="font-weight: bold;">Loại Phòng:</label>
    <frm:select path="loaiPhong.maLoaiPhong" class="form-control input-sm" id="loaiPhong">
    <option value="1" label="Vip" <c:if test="${u.loaiPhong.maLoaiPhong == 1 }">selected="selected"</c:if> />
    <option value="2" label="Thường" <c:if test="${u.loaiPhong.maLoaiPhong == 2 }">selected="selected"</c:if> />
    </frm:select>
    
  </div>
						
       
         <div class="form-group">
 
    <label for="hinhAnh" style="font-weight: bold;">Hình Ảnh:</label>
    <input type="file" class="form-control" id="file" name="file" accept=".jpg,.JPG,.png,.PNG"/>
  </div>
  
 <div class="form-group">

    <label for="giaPhong" style="font-weight: bold;">Giá phòng:</label>
    <frm:input path="giaPhong" class="form-control input-sm" id="giaPhong" type="number" placeholder="Nhập giá phòng" value="${u.giaPhong }" />
  </div>
 
 <div class="form-group">

    <label for="khuyenMai" style="font-weight: bold;">Giảm giá:</label>
    <frm:input path="khuyenMai" class="form-control input-sm" id="khuyenMai" type="number" placeholder="Nhập phần trăm giảm giá" min="0" max="100" value="${u.khuyenMai }" />
  </div>
        
        
        
        
         </div>
      <div class="modal-footer">
      
      
      
      
        <button type="submit" class="btn btn-success" >Hoàn tất</button>
      
      
      
      
      
        </div>
        
     </div>
    </div>
  </div>
  </frm:form>
  
  
  
					</c:forEach>
					
					
					</tbody>
				</table>
				</div>

<c:if test="${danhsach!=0}">
<br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="qlppage?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="qlppage?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="qlppage?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="qlppage?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="qlppage?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>


 <c:if test="${ not empty danhsachtim}">
 <br>
<ul class="pagination" id="pagination" style="float: right;box-shadow: 1px 1px 5px #888888;">
	<li class="page-item first"><a href="qlppagetim?page=${trangdau }" class="page-link">Trang đầu</a></li>
	<li class="page-item prev"><a href="qlppagetim?page=<c:if test="${vitrihientai==1 }">${vitrihientai }</c:if><c:if test="${vitrihientai>1 }">${vitrihientai-1 }</c:if>" class="page-link"><</a></li>
	
	<c:forEach items="${listSoLuongTrang }" var="u">
	<li class="page-item"><a <c:if test="${u == vitrihientai}">style="background-color: rgba(0,0,0,.15);"</c:if> href="qlppagetim?page=${u }" class="page-link">${u }</a></li>
	</c:forEach>
	
	<li class="page-item next"><a href="qlppagetim?page=<c:if test="${vitrihientai==trangcuoi }">${vitrihientai }</c:if><c:if test="${vitrihientai<trangcuoi }">${vitrihientai+1 }</c:if>" class="page-link">></a></li>
	<li class="page-item last"><a href="qlppagetim?page=${trangcuoi }" class="page-link">Trang cuối</a></li>
</ul>
<br><br>
</c:if>
          
         
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
         
            </div>
         

       