<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="Shortcut Icon" href="hinh/iconhome.ico" type="image/x-icon" />  
<head>
	
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <meta name="description" content="">
    <meta name="author" content="">
    <title>Khách sạn Thăng Thiên</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- Plugin CSS -->
    <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin.css" rel="stylesheet">


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
     
    <script src="vendor/tether/tether.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/sb-admin.min.js"></script>
    
    <!-- thay đổi scroll cho đẹp -->
    <style type="text/css">
    
    
body::-webkit-scrollbar {
	width: 0.4em;
}

body::-webkit-scrollbar-track {
	background-color: #f7f7f7;
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

body::-webkit-scrollbar-thumb {
	background-color: #acacac;
	border-radius: 50px;
	outline: 1px solid slategrey;
}


div::-webkit-scrollbar {
	height: 0.6em;
}

div::-webkit-scrollbar-track {
	background-color: #f7f7f7;
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

div::-webkit-scrollbar-thumb {
	background-color: #acacac;
	border-radius: 50px;
	outline: 1px solid slategrey;
}



    
ul::-webkit-scrollbar {
	width: 0.4em;
}

ul::-webkit-scrollbar-track {
	background-color: #f7f7f7;
	-webkit-box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
}

ul::-webkit-scrollbar-thumb {
	background-color: #acacac;
	border-radius: 50px;
	outline: 1px solid slategrey;
}

</style>
     
</head>

<body id="page-top" style="font-family: Arial">

   <!-- Navigation -->
    <nav id="mainNav" class="navbar static-top navbar-toggleable-md navbar-inverse bg-inverse">
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarExample" aria-controls="navbarExample" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
       <a style="font-family: Arial; font-size: 17px;text-align: center;text-shadow: 0px 2px 10px #888888;font-weight: bold;" class="navbar-brand" href="#"><img width="100%" alt="" src="hinh/logohotel.png"></a>
	<div class="collapse navbar-collapse" id="navbarExample" >
		<ul class="sidebar-nav navbar-nav">
			
			<li class="nav-item ${activedptp }" ><a class="nav-link" href="dptp" style="text-shadow: 0px 0px 1px #888888;"><i
					class="fa fa-pencil-square-o"></i> Đặt phòng / trả phòng</a></li>
			<li class="nav-item ${activedv }"><a class="nav-link" href="pddv" style="text-shadow: 0px 0px 1px #888888;"><i
					class="fa fa-shopping-cart"></i> Dịch vụ</a></li>
			<li class="nav-item"><a
				class="nav-link nav-link-collapse collapsed${chamshowtktt }" data-toggle="collapse"
				href="#collapseComponents" style="text-shadow: 0px 0px 1px #888888;"><i class="fa fa-search"></i>
					Tìm kiếm thông tin</a>
				<ul class="sidebar-second-level collapse${chamshowtktt }" id="collapseComponents">
					<li class="nav-item ${activettkh }"><a href="ttkh">Thông tin khách hàng</a></li>
					<li class="nav-item ${activettp }"><a href="ttp">Thông tin phòng</a></li>

				</ul></li>
			<li class="nav-item"><a
				class="nav-link nav-link-collapse collapsed${chamshowtkvbc }" data-toggle="collapse"
				href="#collapseMulti1" style="text-shadow: 0px 0px 1px #888888;"><i class="fa fa-calendar-check-o"></i> Thống
					kê và báo cáo</a>
				<ul class="sidebar-second-level collapse${chamshowtkvbc }" id="collapseMulti1">
					
					<li class="nav-item ${activelsdtp }"><a href="lsdtp">Lịch sử đặt / trả phòng</a></li>
					<li class="nav-item ${activelsdv }"><a href="lsdv">Lịch sử dịch vụ</a></li>
					<li class="nav-item ${activettdt }"><a href="tkdt">Thống kê doanh thu</a></li>

				</ul></li>
				
				<c:if test="${not empty ancaidai }">
			<li class="nav-item"><a
				class="nav-link nav-link-collapse collapsed${chamshowcd }" data-toggle="collapse"
				href="#collapseMulti" style="text-shadow: 0px 0px 1px #888888;"><i class="fa fa-fw fa-wrench"></i> Cài
					đặt</a>
				<ul class="sidebar-second-level collapse${chamshowcd }" id="collapseMulti">
				
					<li class="nav-item"><a
				class="nav-link nav-link-collapse collapsed${chamshowqltk }" data-toggle="collapse"
				href="#collapseMulti10"><i class="fa fa-fw fa-sitemap"></i> Quản lý tài khoản</a>
				<ul class="sidebar-second-level collapse${chamshowqltk }" id="collapseMulti10">
				<li class="nav-item ${activedstk }"><a href="qltk">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Danh sách tài khoản</a></li>
				<li class="nav-item ${activettk }"><a href="addtk">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thêm tài khoản</a></li>
				</ul></li>
				
				<li class="nav-item"><a
				class="nav-link nav-link-collapse collapsed${chamshowqllp }" data-toggle="collapse"
				href="#collapseMulti11"><i class="fa fa-fw fa-sitemap"></i> Quản lý loại phòng</a>
				<ul class="sidebar-second-level collapse${chamshowqllp }" id="collapseMulti11">
				<li class="nav-item ${activedslp }"><a href="qllp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Danh sách loại phòng</a></li>
				<li class="nav-item ${activetlp }"><a href="addlp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thêm loại phòng</a></li>
				</ul></li>
				
				<li class="nav-item"><a
				class="nav-link nav-link-collapse collapsed${chamshowqlp }" data-toggle="collapse"
				href="#collapseMulti12"><i class="fa fa-fw fa-sitemap"></i> Quản lý phòng</a>
				<ul class="sidebar-second-level collapse${chamshowqlp }" id="collapseMulti12">
				<li class="nav-item ${activedsp }"><a href="quanlyphong">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Danh sách phòng</a></li>
				<li class="nav-item ${activetp }"><a href="addqlp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thêm phòng</a></li>
				</ul></li>
				
				<li class="nav-item"><a
				class="nav-link nav-link-collapse collapsed${chamshowdv }" data-toggle="collapse"
				href="#collapseMulti13"><i class="fa fa-fw fa-sitemap"></i> Quản lý dịch vụ</a>
				<ul class="sidebar-second-level collapse${chamshowdv }" id="collapseMulti13">
				<li class="nav-item ${activedv }"><a href="dsqldv">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Danh sách dịch vụ</a></li>
				<li class="nav-item ${activetdv }"><a href="themdsqldv">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Thêm dịch vụ</a></li>
				</ul></li>
				
				</ul></li>
				</c:if>
				
		</ul>
		
		
            <ul class="navbar-nav ml-auto">
            
                
                
                
                <li class="dropdown user user-menu" style="margin-right: 35px;">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
             <img src="hinh/iconuser.png" width="30px" height="30px" />
              <span class="hidden-xs">Hi, ${nguoidung }</span>
            </a>
            
            <ul class="dropdown-menu" >
            
              <li class="user-body" >
                <div style="text-align: center;">
                
                    <a href="doimatkhau">Đổi mật khẩu</a>
               </div>
                  
                 <div style="text-align: center;">
                    <a href="dangxuat">Đăng xuất</a>
                 </div>
                
              
              </li>
             
            </ul>
          </li>
            </ul>
            
            
        </div>
    </nav>

   
    <div class="content-wrapper py-3" style="min-height: 650px;">
    <div class="container" >
    <div class="container">
              <div style="width: 100%;height: 120px; background: url('hinh/title hotel.png');background-size: 100% 110px;background-repeat: no-repeat;padding-top: 32px;" align="center" >
              <span style="font-size: 35px;color: white;text-align: center;">${titlepage }</span>
              </div>
              </div>
              </div>
  
        <div class="container-fluid">

            <!-- Breadcrumbs -->
           
								<!-- Noi dung trong nay-->
           
           
           <jsp:include page="${param.layoutmenu }"></jsp:include>

          
            
         

        </div>
        <!-- /.container-fluid -->

    </div>
    <!-- /.content-wrapper -->

   


</body>

</html>
