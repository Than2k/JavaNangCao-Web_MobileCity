<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	  		<a  href="/MobileCity/category/add?btnThem=Them"><button  class="btn btn-success" >Thêm hãng</button></a>
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
                <th>#id </th>
                <th>Tên </th>
                <th></th>
                 <th></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="m" items="${listLoai }">
                <tr>                               
                  <td>${m.id }</td>
                  <td>${m.tenLoai }</td>                              
                  <td>  <a  href="/MobileCity/category/edit?btnXoa=Xoa"><button  class="btn btn-warning" >Edit</button></a></td>
                  <c:if test="${admin.quyen == 'admin' }">
                  	 <td>  <a  href="/MobileCity/category/delete?btnXoa=Xoa"><button  class="btn btn-danger" >Delete</button></a></td>
                  </c:if>
                </tr>
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