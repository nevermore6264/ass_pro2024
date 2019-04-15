<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>


             <h1>Sửa thông tin dịch vụ</h1>
             <hr>
             
             <c:if test="${not empty nltendv}">${nltendv}</c:if>
             <c:if test="${not empty nlgiadv}">${nlgiadv}</c:if>
             <frm:form action="actionsuadsqldv" modelAttribute="dichvu">
             <table>
             <frm:hidden path="maDichVu"/>
             <tr><td>Tên dịch vụ:</td> <td><frm:input path="tenDichVu"/></td></tr>
             <tr><td>Loại dịch vụ:</td> <td><frm:select path="loaiDichVu">
            <frm:option value="0" >Ăn uống</frm:option>
            <frm:option value="1" >Giặt ủi</frm:option>
            <frm:option value="2" >Thư giãn</frm:option>
             </frm:select></td></tr>
             <tr><td>Giá dịch vụ:</td> <td><frm:input path="giaDichVu" type="number"/></td></tr>
             <tr><td></td> <td><frm:button>Sửa</frm:button></td></tr>
             
             </table>
             
             
             </frm:form>
             
               

            

           
            
         
