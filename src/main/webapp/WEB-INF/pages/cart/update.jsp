<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


       <c:forEach var="c" items="${cart}">
  <tr>
  	<td><input name="check" value="${c.id}" type="checkbox"></td>
      <td class="col-sm-8 col-md-6">
          <div class="media">
              <a class="thumbnail
                  pull-left" href="#">
                  <img
                      class="media-object"
                      src="/MobileCity/images_mobile/${c.anh }"
                      style="width: 72px;
                      height: 72px;">
              </a>
              <div style="padding-left: 3px" class="media-body">
                  <h4
                      class="media-heading">
                      <a href="/MobileCity/mobile/detail?id=${c.id }"> ${c.ten }</a>
                  </h4>
                  <h5
                      class="media-heading">
                      by <a href="#">
                          sumsung</a>
                  </h5>
                  <span>Status: </span><span
                      class="text-success"><strong>In
                          Stock</strong></span>
              </div>
          </div>
      </td>
       <td class="col-sm-1 col-md-1"
                   style="text-align: center">
                  
                   <input min=1 id="${c.id}" onchange="edit('${c.id }')"
                       type="number"
                       class="form-control"
                       id="exampleInputEmail1"
                       value="${c.soLuong }">
                   
                </td>
      <td class="col-sm-1 col-md-1 text-center">
          <strong> <fmt:formatNumber type="currency" value="${c.gia }" /></strong>                                       
      </td>
          
      <td
          class="col-sm-1 col-md-1
          text-center"><strong> <fmt:formatNumber type="currency" value="${c.getThanhTien()}" /></strong></td>
      <td class="col-sm-1 col-md-1">
          <button onclick="xoa('${c.id}')"  type="button"
              class="btn
              btn-danger">
              <span
                  class="glyphicon
                  glyphicon-remove"></span>
              Remove
          </button>
      </td>
  </tr>
  </c:forEach>
   <!--thành tiền------------------------>
  <tr>
      <td></td>
      <td></td>
      <td></td>
      <td></td>
      <td><h3>Total</h3></td>
      <td class="text-right"><h3>
            <strong>  <fmt:formatNumber type="currency" value="${tongTien }" /> </strong>
          </h3>
      </td>
  </tr>