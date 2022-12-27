<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
    <!DOCTYPE html>
    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section  class="content-header">
        <h1>
          ${title }
          <small>Optional description</small>
        </h1>
        <ol class="breadcrumb">
         
        </ol>
      </section>
	  <div style=" margin:20px;display: flex;     justify-content: space-between;">
	  	<div>
	  		
	  	</div>
	  		 <!-- search form (Optional) -->
          <form action="/MobileCity/admin/mobile" style="width: ;margin: 0px ; background: white"
            method="get" class="sidebar-form">
            <div class="input-group">
              <input name="value" style="background: white" type="text" 
                class="form-control"
                placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit"id="search-btn" class="btn
                  btn-flat"><i class="fa fa-search"></i>
                </button>
              </span>
            </div>
          </form>
          <!-- /.search form -->
          
	  </div>
      <!-- Main content -->
      <section class="content container-fluid">
        <!-- /.box-header -->
        <div class="box-body">
          <table id="example2" class="table table-bordered table-hover">
            <thead>
              <tr>
               <th>#HD</th>
                <th>Thông tin</th>
                <th>Ngày mua</th>
                 <th>Tổng tiền </th>
                 <th></th>
                 <th></th>

              </tr>
            </thead>
            <tbody>
             
              <c:forEach var="m" items="${listHoaDon }">
               	<c:if test="${m.damua == 0 }">
               		 <tr>
	                <td>${m.id }</td>
	                  <td>
	                 	 <img style="width: 72px; height: 72px" alt="#"
	                      	src="../images_mobile/${m.chiTietHD[0].anh }"> 
	                      ${m.chiTietHD[0].ten }  
	                      <c:if test="${m.chiTietHD.size() >1}">
	                      	<b>và ${m.chiTietHD.size()-1} khác</b>
	                      </c:if>
	                      <br>
	                      <a href="#"> xem chi tiết</a>
	                  </td>
	                  <td>${m.ngayMua }</td>
	                  <td>${m.tongTien() }</td>
	                  
	                  <td><a href="/MobileCity/admin/confirm?id=${m.id }"> <button> xác nhận</button> </a></td>
	                   
	                 
	                 
	                </tr>
               	</c:if>
              </c:forEach>



            </table>

           
            
           
          </div>
          <!-- /.box-body -->
          <!--------------------------
      | Your Page Content Here |
      -------------------------->
        </section>
        <!-- /.content -->
      </div>