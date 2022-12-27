<%@ page language="java" contentType="text/html; charset=utf-8"
  pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html>
    <!-- general form elements -->

    <div class="content-wrapper">
      <!-- Content Header (Page header) -->
      <section class="content-header">
        <h1>
          ${title }
          <small>Optional description</small>
        </h1>
        <ol class="breadcrumb">

        </ol>
      </section>
     <br>
      <!-- Main content -->

      <!-- /.box-body -->
      <!--------------------------
      | Your Page Content Here |
      -------------------------->
      <!-- general form elements -->
      <div class="box box-primary">
        <div class="box-header with-border">
          <h3 class="box-title">Thông tin điện thoại</h3>
        </div>
        <!-- /.box-header -->
       
          <!-- form start -->
          <form action="/MobileCity/mobile/save" enctype='multipart/form-data' method="post" style="margin-right: 25px"  role="form">
            <div style="display: flex;">
               <!--left-->
               <div style="width: 50%;">
	              <div class="box-body">
	               <div class="form-group">
	                 
	                  <input type="text" hidden value="${mobile.id }" name="id" class="form-control" 
	                    >
	                </div>
	                <div class="form-group">
	                  <label >Tên điện thoại</label>
	                  <input type="text" value="${mobile.ten }" name="ten" class="form-control" required
	                    >
	                </div>
	               
	               
	                 <div class="form-group">
	                  <label for="exampleInputPassword1">Màn hình</label>
	                  <input type="text" value="${mobile.manhinh }" name ="manhinh" class="form-control"
                    required >
	                </div>
                 
                   <!--bbbb-->
                   <div style="display: flex;">
                    <div style="width: 50%;" class="form-group">
                      <label for="exampleInputPassword1">Số lượng</label>
                      <input type="number" value="${mobile.soluong }" name ="soluong" class="form-control"
	                    id="exampleInputPassword1" >
                    </div>
                    <div style="width: 50%; padding-left: 10px;" class="form-group">
                      <label for="exampleInputPassword1">Ngày nhập</label>
                      <input type="date" value="${mobile.ngaynhap }" name ="ngaynhap" class="form-control"
                      required >
                    </div>                         
                  </div>
                  <!--bbbb-->
                  <!--bbbb-->
                  <div style="display: flex;">
                    <div style="width: 50%;" class="form-group">
                      <label for="exampleInputPassword1">Giá nhập</label>
                      <input type="number" value="${mobile.giaNhap }" name ="giaNhap" class="form-control"
	                    id="exampleInputPassword1" >
                    </div>
                    <div style="width: 50%; padding-left: 10px;" class="form-group">
                      <label for="exampleInputPassword1">giá bán</label>
                      <input type="number" value="${mobile.giaBan }" name ="giaBan" class="form-control"
	                    id="exampleInputPassword1" >
                    </div>                         
                  </div>
                  <!--bbbb-->
                   <div class="form-group">
	                  <label for="exampleInputFile">Chọn ảnh</label>
	                  <input  name="txtfile"  type="file"  onchange="document.getElementById('Photo').src = window.URL.createObjectURL(this.files[0])">	            
	                </div>
                  <!--anh-->
                  <div class="form-group">
                    <div class="col-lg-offset-2 col-sm-10">
                      <input type="hidden"  name="anh"  value="${mobile.anh }" /> 
                      <img  id="Photo" src="../images_mobile/${mobile.anh }" class="img img-bordered"  style="width: 250px" />                                                
                  </div>
	                 	            
	                </div>
                  
	              </div>
              </div>
	            <!--right-->
	            <div style="width: 50%;">
	              <div class="box-body">
                  <div class="form-group">
	                  <label for="exampleInputPassword1">Camera Trước</label>
	                  <input type="text" value="${mobile.cameraTruoc }" name ="cameraTruoc" class="form-control"
	                    >
	                </div>
	                <div class="form-group">
	                  <label for="exampleInputPassword1">Camera sau</label>
	                  <input type="text" value="${mobile.cameraSau }" name ="cameraSau" class="form-control"
	                     >
	                </div>
	                <div class="form-group">
	                  <label for="exampleInputPassword1">cpu</label>
	                  <input type="text"value="${mobile.cpu }" name ="cpu" class="form-control"
	                    i >
	                </div>
	                
                   <!--bbbb-->
                   <div style="display: flex;">
                    <div style="width: 50%;" class="form-group">
                      <label for="exampleInputPassword1">Ram</label>
                      <select class="custom-select form-control" name="ram">
                        <option>---chọn---</option>
                        <option value="4GB"> 4GB</option>
                        <option value="6GB">6GB</option>
                        <option value="8GB">8GB</option>
                        <option value="12GB">12GB</option>
                      </select>
                    </div>
                    <div style="width: 50%; padding-left: 10px;" class="form-group">
                      <label for="exampleInputPassword1">Bộ nhớ</label>
                      <select class="form-control" name="bonho">
                        <option>---chọn---</option>
                        <option value="16GB">16GB</option>
                        <option value="32GB">32GB</option>
                        <option value="64GB">64GB</option>
                        <option value="128GB">128GB</option>
                        <option value="256GB">256GB</option>

                      </select>
                    </div>
                  </div>
                  <div style="display: flex;">
                    <div style="width: 50%;" class="form-group">
                      <label for="exampleInputPassword1">Màu sắc</label>
                      <select class="form-control" name="mausac">
                        <option>---chọn---</option>
                        <option value="màu xanh">màu xanh</option>
                        <option value="màu gold">màu gold</option>
                        <option value="màu vàng">màu vàng</option>
                        <option value="màu tím">màu tím</option>
                      </select>
                    </div>
                    <div style="width: 50%; padding-left: 10px;" class="form-group">
                      <label for="exampleInputPassword1">Hãng</label>
                      <select class="form-control" name="maloai">
                        <option>---chọn---</option>
                        <c:forEach var="l" items="${listLoai }">
                        	<c:if test="${ l.id == mobile.maloai}">
                        		<option selected value="${l.id }"> ${l.tenLoai }</option>
                        	</c:if>
                        	<option value="${l.id }"> ${l.tenLoai }</option>
                        </c:forEach>

                      </select>
                    </div>
                  </div>
                  <div style="display: flex;">
                    <div style="width: 50%;" class="form-group">
                      <label for="exampleInputPassword1">Pin</label>
                      <input type="text" value="${mobile.pin }" name ="pin" class="form-control"
	                    >
                    </div>
                    <div style="width: 50%; padding-left: 10px;" class="form-group">
                      <label for="exampleInputPassword1">Bảo hành</label>
                      <select class="form-control" name="baohanh">
                        <option>---chọn---</option>
                        <option value="1">có</option>
                        <option value="0">không</option>
                        

                      </select>
                    </div>
                  </div>
                   
	                
	              </div>
	              <!-- /.box-body -->
	  
	             
	            </div>
              
            </div>
            <div style=" text-align: center;" class="box-footer">
              <button type="submit" name="edit"  value="${ mobile.id }" class="btn btn-primary">Submit</button>
            </div>
          </form>
          
        
       
      </div>
      <!-- /.box -->
      <!-- /.content -->
    </div>