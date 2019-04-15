<%@page import="DuAn2.Controller.DvController"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<frm:form action="actionthugian" modelAttribute="donDichVu">
<table>
<frm:hidden path="datPhong.maDatPhong" value="${madatphong }" />
<tr><td>Chọn vé:</td>  <td>

<frm:select class="form-control input-sm" path="dichVu.maDichVu">
<c:forEach var="u" items="${ltendichvuthugian }">  
<frm:option value="${u.maDichVu }" label="${u.tenDichVu }"  />

</c:forEach>
</frm:select>

</td></tr>
<tr><td>Số lượng:</td>  <td><frm:input class="form-control input-sm" type="number" path="soLuong" min="1" max="9999" required="required"/></td></tr>

<tr><td></td>  <td><frm:button type="submit" class="btn btn-success btn-xs">Thêm</frm:button></td></tr>

</table>


</frm:form>
