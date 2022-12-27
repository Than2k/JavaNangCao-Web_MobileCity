<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cửa hàng điện thoại MobileCity</title>
    
    	<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
    	 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="./assets/fonts/fontawesome-free-5.15.3-web/css/all.min.css">
        <link href="https://fonts.googlea=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    
    	<link rel="stylesheet"
        href="../bower_components/bootstrap/dist/css/bootstrap.min.css">
      <!-- Font Awesome -->
      <link rel="stylesheet"
        href="../bower_components/font-awesome/css/font-awesome.min.css">
      <!-- Ionicons -->
      <link rel="stylesheet"
        href="../bower_components/Ionicons/css/ionicons.min.css">
      <!-- Theme style -->
      <link rel="stylesheet" href="../dist/css/AdminLTE.min.css">
      <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect. -->
      <link rel="stylesheet" href="../dist/css/skins/skin-blue.min.css">
      
    
        <link rel="stylesheet" href="../css/base.css">
        <link rel="stylesheet" href="../css/grid.css">
        <link rel="stylesheet" href="../css/main.css">
        <link rel="stylesheet" href="../css/responsive.css">
    </head>
    <body>
   
        <div class="main">
            <!-- header -->
           <jsp:include page="header.jsp"></jsp:include>
            <!-- header -->
            
            <!--content-->
            <div class="container" >
            	<h4 style="color: blue">Điện thoại > Điện thoại ${mobile.maloai }</h4>
            	
            	<div class="row">
	            	<div class="col-lg-6">
	            		<h3>${mobile.ten }</h3>
	            		<h4>Giá bán : <strong> <fmt:formatNumber type="currency" value="${mobile.giaBan }"></fmt:formatNumber> </strong> </h4>
	            		<img style="width: 60%; height: 300px;margin-bottom: 5%;" alt="#" src="../images_mobile/${mobile.anh }"><br>
	            		<a href="/MobileCity/cart/add?id=${mobile.id}&anh=${mobile.anh}&gia=${mobile.giaBan}&ten=${mobile.ten}" style="margin-left: 9%;padding: 15px;font-size: 16px;" class="container-product__item-btn">Thêm vào giỏ</a>
	            	</div >
	            	<div  class="col-lg-6" style="margin-top : 30px ">
	            		<table class="table table-bordered">
						  <thead>
						    <tr>
						      <th scope="col">#</th>
						      <th scope="col">Thông số</th>		
						        <th scope="col">Chi tiết</th>				     
						    </tr>
						  </thead>
						  <tbody>
						    <tr>
						      <th scope="row">1</th>
						      <td>Màu sắc</td>
						      <td>${mobile.mausac }</td>
						    
						    </tr>
						    <tr>
						      <th scope="row">2</th>
						      <td>Camera Trước</td>
						      <td>${mobile.cameraTruoc }</td>
						    
						    </tr>
						    <tr>
						      <th scope="row">3</th>
						      <td>Camera Sau</td>
						      <td>${mobile.cameraSau}</td>
						    
						    </tr>
						    <tr>
						      <th scope="row">4</th>
						      <td>Pin</td>
						      <td>${mobile.pin}</td>
						    
						    </tr>
						    <tr>
						      <th scope="row">5</th>
						      <td>Ram</td>
						      <td>${mobile.ram }</td>
						    
						    </tr>
						    <tr>
						      <th scope="row">6</th>
						      <td>Cpu</td>
						      <td>${mobile.cpu}</td>
						    
						    </tr>
						    <tr>
						      <th scope="row">7</th>
						      <td>Bộ nhớ</td>
						      <td>${mobile.bonho}</td>
						    
						    </tr>
						     <tr>
						      <th scope="row">8</th>
						      <td>Màn hình</td>
						      <td>${mobile.manhinh}</td>
						    
						    </tr>
						   
						  </tbody>
						</table>
	            	</div>
	            </div>
                <div class="col-md-12 " style="margin-top: 25px ; margin-bottom: 120px;">
                    <!-- DIRECT CHAT -->
                    <div class="box box-warning direct-chat direct-chat-warning">
                      <div class="box-header with-border">
                        <h3 class="box-title">Bình luận sản phẩm</h3>
      
                        <div class="box-tools pull-right">
                          <span data-toggle="tooltip" title="3 New Messages" class="badge bg-yellow">${listComment.size()}</span>
                          <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                          </button>
                          <button type="button" class="btn btn-box-tool" data-toggle="tooltip" title="Contacts"
                                  data-widget="chat-pane-toggle">
                            <i class="fa fa-comments"></i></button>
                          <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i>
                          </button>
                        </div>
                      </div>
                      <!-- /.box-header -->
                      <div class="box-body">
                        <!-- Conversations are loaded here -->
                        <div id="comment" class="direct-chat-messages">
                         
                         <!-- duyệt bình luận -->
      					 <c:forEach var="comment" items="${listComment }">     					 	
      					 	<c:if test="${comment.hoTen ==  kh.hoten }">
      					 		 <!-- Message to the right -->
		                          <div class="direct-chat-msg right">
		                            <div class="direct-chat-info clearfix">
		                              <span class="direct-chat-name pull-right">${comment.hoTen }</span>
		                              <span class="direct-chat-timestamp pull-left">
		                              	${comment.ngayBinhLuan }
		                              </span>
		                            </div>
		                            <!-- /.direct-chat-info -->
		                             <img class="direct-chat-img" src="../dist/img/user3-128x128.jpg" alt="message"> 
		                            <!-- /.direct-chat-img -->
		                            <div class="direct-chat-text">
		                              ${comment.noiDung }
		                            </div>
		                            <!-- /.direct-chat-text -->
		                          </div>
		                          <!-- /.direct-chat-msg -->
      					 	</c:if>
      					 	<c:if test="${comment.hoTen !=  kh.hoten }">
      					 		  <!-- Message. Default to the left -->
		                          <div class="direct-chat-msg">
		                            <div class="direct-chat-info clearfix">
		                              <span class="direct-chat-name pull-left">${comment.hoTen }</span>
		                              
		                              <span class="direct-chat-timestamp pull-right">
		                              	${comment.ngayBinhLuan }
		                              </span>
		                            </div>
		                            <!-- /.direct-chat-info -->
		                            <img class="direct-chat-img" src="../dist/img/user1-128x128.jpg" alt="message user image">
		                            <!-- /.direct-chat-img -->
		                            <div class="direct-chat-text">
		                              ${comment.noiDung }
		                            </div>
		                            <!-- /.direct-chat-text -->
		                          </div>
		                          <!-- /.direct-chat-msg -->
      
      					 	</c:if>
      					 </c:forEach>
                        
                         
      
                        </div>
                        <!--/.direct-chat-messages-->
      
      
      					
                        <!-- Contacts are loaded here -->
                        <div class="direct-chat-contacts">
                          <ul class="contacts-list">
                            <li>
                              <a href="#">
                                <img class="contacts-list-img" src="dist/img/user1-128x128.jpg" alt="User Image">
      
                                <div class="contacts-list-info">
                                      <span class="contacts-list-name">
                                        Count Dracula
                                        <small class="contacts-list-date pull-right">2/28/2015</small>
                                      </span>
                                  <span class="contacts-list-msg">How have you been? I was...</span>
                                </div>
                                <!-- /.contacts-list-info -->
                              </a>
                            </li>
                            <!-- End Contact Item -->
                            <li>
                              <a href="#">
                                <img class="contacts-list-img" src="dist/img/user7-128x128.jpg" alt="User Image">
      
                                <div class="contacts-list-info">
                                      <span class="contacts-list-name">
                                        Sarah Doe
                                        <small class="contacts-list-date pull-right">2/23/2015</small>
                                      </span>
                                  <span class="contacts-list-msg">I will be waiting for...</span>
                                </div>
                                <!-- /.contacts-list-info -->
                              </a>
                            </li>
                            <!-- End Contact Item -->
                            <li>
                              <a href="#">
                                <img class="contacts-list-img" src="dist/img/user3-128x128.jpg" alt="User Image">
      
                                <div class="contacts-list-info">
                                      <span class="contacts-list-name">
                                        Nadia Jolie
                                        <small class="contacts-list-date pull-right">2/20/2015</small>
                                      </span>
                                  <span class="contacts-list-msg">I'll call you back at...</span>
                                </div>
                                <!-- /.contacts-list-info -->
                              </a>
                            </li>
                            <!-- End Contact Item -->
                            <li>
                              <a href="#">
                                <img class="contacts-list-img" src="dist/img/user5-128x128.jpg" alt="User Image">
      
                                <div class="contacts-list-info">
                                      <span class="contacts-list-name">
                                        Nora S. Vans
                                        <small class="contacts-list-date pull-right">2/10/2015</small>
                                      </span>
                                  <span class="contacts-list-msg">Where is your new...</span>
                                </div>
                                <!-- /.contacts-list-info -->
                              </a>
                            </li>
                            <!-- End Contact Item -->
                            <li>
                              <a href="#">
                                <img class="contacts-list-img" src="dist/img/user6-128x128.jpg" alt="User Image">
      
                                <div class="contacts-list-info">
                                      <span class="contacts-list-name">
                                        John K.
                                        <small class="contacts-list-date pull-right">1/27/2015</small>
                                      </span>
                                  <span class="contacts-list-msg">Can I take a look at...</span>
                                </div>
                                <!-- /.contacts-list-info -->
                              </a>
                            </li>
                            <!-- End Contact Item -->
                            <li>
                              <a href="#">
                                <img class="contacts-list-img" src="dist/img/user8-128x128.jpg" alt="User Image">
      
                                <div class="contacts-list-info">
                                      <span class="contacts-list-name">
                                        Kenneth M.
                                        <small class="contacts-list-date pull-right">1/4/2015</small>
                                      </span>
                                  <span class="contacts-list-msg">Never mind I found...</span>
                                </div>
                                <!-- /.contacts-list-info -->
                              </a>
                            </li>
                            <!-- End Contact Item -->
                          </ul>
                          <!-- /.contatcts-list -->
                        </div>
                        <!-- /.direct-chat-pane -->
                      </div>
                      <!-- /.box-body -->
                      <div class="box-footer">
                        <form action="#" method="post">
                          <div class="input-group">
                            <input type="text" id="message" name="message" placeholder="Type Message ..." class="form-control" required="required">
                            <span class="input-group-btn">
                                  <button onclick="addComment('${mobile.id}')" id="comment" type="button" class="btn btn-warning btn-flat">Send</button>
                                </span>
                          </div>
                        </form>
                        <p style="margin-top: 3px; color: red ; font-style: italic;" id="err"></p>
                      </div>
                      <!-- /.box-footer-->
                    </div>
                    <!--/.direct-chat -->
                  </div>
            	</div>
           	<!--content-->
           	
            <!-- footer-->
            <jsp:include page="footer.jsp"></jsp:include>
            <!-- footer-->
           
    
            <!-- Button -->
            <a href="#" class="go-to-top">
                <i class="go-to-top__icon fas fa-chevron-circle-up"></i>
            </a>
    
            <a href="#" class="go-to-chat">
                <i class="go-to-chat__icon fab fa-facebook-messenger"></i>
            </a>
        </div>
    	<script type="text/javascript">
    	
   			function addComment(idMobile) {
			   
               var url = "http://localhost:8080/MobileCity/comment/add";        
              
               var message = document.getElementById('message').value ;
               if(message == null || message ==''){
                document.getElementById('err').innerText ='Bạn chưa nhập nội dụng!';
               }else{
                jQuery.ajax({
                   type: "POST",
                   url: url,
                   data:{'idMobile': idMobile,'message': message,},
                   success: function (data) {
                    jQuery("#comment").html(data)
                    document.getElementById('message').value ='';
                   }
               });
               }
               console.log('id:'+ idMobile);
               console.log('message:'+ message);
              
          	 };
    	</script>
        <script src="./js/phone.js"></script>
        <script src="./js/tool.js"></script>
        <script src="./js/fix.js"></script>
        <script src="./js/unlock.js"></script>
        <script>
            const $ = document.querySelector.bind(document);
            const $$ = document.querySelectorAll.bind(document);
    
            const event = (() => {
                
                return {
                    handleEvent() {
                        // Search in mobile
                        const mobileSearchBtn = $('.header-mobile-search');
    
                        mobileSearchBtn.onclick = () => {
                            $('.header-mobile-search-box__wrap').classList.toggle('active');
                        };
    
                        // Menu nav in mobile 
                        const mobileMenuBtn = $('.header-mobile-menu');
                        const overlayMobileScreen = $('.header-mobile-nav__overlay');
                        const mobileNav = $('.header-mobile-nav');
                        const mobileCloseNavBtn = $('.header-mobile-nav__close');
    
                        function handleMobileNav() {
                            overlayMobileScreen.classList.toggle('active');
                            mobileNav.classList.toggle('active');
                        };
    
                        mobileMenuBtn.onclick = () => {
                            handleMobileNav();
                        };
    
                        overlayMobileScreen.onclick = () => {
                            handleMobileNav();
                        };
    
                        mobileCloseNavBtn.onclick = () => {
                            handleMobileNav()
                        };
    
                        // Menu subnav in mobile 
                        const mobileSubNavs = $$('.header-mobile-nav__item-select');
                        
                        Array.from(mobileSubNavs).forEach((mobileSubNav) => {
                            mobileSubNav.onclick = () => {
                                mobileSubNav.classList.toggle('active');
                                mobileSubNav.firstElementChild.classList.toggle('active');
                                if (mobileSubNav.nextElementSibling) {
                                    mobileSubNav.nextElementSibling.classList.toggle('active');
                                };
                            };
                        });
    
                        // Scroll Screen 
                        const goToTopBtn = $('.go-to-top');
                        document.onscroll = () => {
                            const scrollTop = window.scrollY || document.documentElement.scrollTop;
                            if (scrollTop > 120) {
                                goToTopBtn.classList.add('active');
                            } else {
                                goToTopBtn.classList.remove('active');
                            }
                        };
                    },
                    init() {
                        this.handleEvent();
                    }
                }
    
            })();
    
            event.init();
        </script>
         <!-- REQUIRED JS SCRIPTS -->

      <!-- jQuery 3 -->
      <script src="../bower_components/jquery/dist/jquery.min.js"></script>
      <!-- Bootstrap 3.3.7 -->
      <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
      <!-- AdminLTE App -->
      <script src="../dist/js/adminlte.min.js"></script>

      <!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
    </body>
    </html>