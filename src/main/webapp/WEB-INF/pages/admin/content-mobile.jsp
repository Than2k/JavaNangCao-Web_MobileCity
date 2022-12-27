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
	  		<a  href="/MobileCity/mobile/add"><button  class="btn btn-success" >Add mobile</button></a>
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
                <th>Ảnh</th>
                <th>Tên </th>

                <th>giá</th>
                <th>Số lượng</th>
                <th>Ngày nhập</th>

              </tr>
            </thead>
            <tbody>
              <c:forEach var="m" items="${listMobile }">
                <tr>
                  <td><img style="width: 72px; height: 72px" alt="#"
                      src="../images_mobile/${m.anh }"> </td>
                   <td><a style="color: blue" href="/MobileCity/mobile/detail?id=${m.id }">${m.ten }</a></td>
                  <td>${m.giaBan }đ</td>
                  <td>${m.soluong }</td>
                  <td>${m.ngaynhap }</td>
                 
                  <td>  <a  href="/MobileCity/mobile/edit?idMobile=${m.id }"><button  class="btn btn-warning" >Edit</button></a></td>
                  <c:if test="${admin.quyen == 'admin' }">
                  	<td>  <a  href="/MobileCity/mobile/delete?id=${m.id }&anh=${m.anh}"><button  class="btn btn-danger" >Delete</button></a></td>
                  </c:if>
                </tr>
              </c:forEach>



            </table>

           
              <div style="text-align: center;" class="container-view-more">
                <nav aria-label="...">
                  <ul class="pagination">
                    <li class="page-item">
                      <a class="page-link" href="#" tabindex="-1">Previous</a>
                    </li>
                    <c:forEach var="p" items="${listPage }">
                      <c:choose>
                        <c:when test="${p == pagination.page }">
                          <li class="page-item active"><a class="page-link"
                              href="/MobileCity/admin/mobile?ml=${pagination.maLoai
                              }&value=${pagination.searchValues}&page=${p }"
                              class="active">${p}</a></li>
                        </c:when>
                        <c:when test="${p == -1 }">
                          <span style="margin-top: 7px">...</span>
                        </c:when>
                        <c:otherwise>
                          <li class="page-item"><a class="page-link"
                              href="/MobileCity/admin/mobile?ml=${pagination.maLoai
                              }&value=${pagination.searchValues}&page=${p }"
                              class="active">${p}</a></li>
                        </c:otherwise>
                      </c:choose>

                    </c:forEach>

                    <li class="page-item">
                      <a class="page-link" href="">Next</a>
                    </li>
                  </ul>
                </nav>
              </div>
           
          </div>
          <!-- /.box-body -->
          <!--------------------------
      | Your Page Content Here |
      -------------------------->
        </section>
        <!-- /.content -->
      </div>