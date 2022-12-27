<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
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
                <th>Họ tên</th>
               
                <th>Số điện thoại</th>
                <th>Số tiền chuyển</th>
                <th>Nội dung</th>
               

              </tr>
            </thead>
            <tbody>
              <c:forEach var="m" items="${listCustomerPay }">
                <tr>
                 
                  <td>${m.hoTen }</td>
                  <td>${m.sdt }</td>
                  <td><fmt:formatNumber type="currency" value="${m.thanhTien }" /></td>
                   <td> Thanh toán hóa đơn #id: ${m.idCT }</td>
                 
                  
                </tr>
              </c:forEach>
              <tr> 
              	 <td></td>
				   <td></td>
				   	<td></td>
				   	<td></td>
               </tr>
			   <tr>
			   		<td>  <a  href="/MobileCity/admin"><button  class="btn btn-warning" >Quay lại Admin</button></a></td>
				   <td></td>
				   <td></td>
				   	<td></td>
			   	 	
			   </tr>


            </table>

           
             
           
          </div>
          <!-- /.box-body -->
          <!--------------------------
      | Your Page Content Here |
      -------------------------->
        </section>
        <!-- /.content -->
      </div>
