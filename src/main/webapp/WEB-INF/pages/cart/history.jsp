<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport"
            content="width=device-width,
            initial-scale=1.0">
        <title>Document</title>

        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css">
        <link rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
        <link rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <link rel="stylesheet"
            href="./assets/fonts/fontawesome-free-5.15.3-web/css/all.min.css">
        <link
            href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap"
            rel="stylesheet">

		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link rel="stylesheet" href="./css/base.css">
        <link rel="stylesheet" href="./css/grid.css">
        <link rel="stylesheet" href="./css/cart.css">
        <link rel="stylesheet" href="./css/main.css">
        <link rel="stylesheet" href="./css/responsive.css">
       
    </head>
    <body>

		<c:if test="${err != null }">
			<script type="text/javascript">
				alert('${err}');
			</script>
		</c:if>
		
        <div class="main">
            <!-- header -->
            <jsp:include page="../mobile/header.jsp"></jsp:include>
            <!-- header -->

            <!--content-->
            <div style="margin-bottom: 20px; margin-top: 15px" id="container" class="container">
            	  <h3 style="color: rgb(45, 45, 240);">Chào a/c ${kh.hoten}-${kh.sdt}</h3><hr>
                  
				      
				  <table cellpadding="0" cellspacing="0" class="table ">
				  <p style="font-size: 18px;">Lịch sử mua hàng gần đây của quý khách!</p> <br>
				    <thead>
				      <tr>
				      	<th>#maHD</th>
				        <th>Ảnh</th>
				        <th>Tên</th>
				        <th>Giá</th>
				          <th>Số lượng</th>
				        <th>Thành tiền</th>
				        <th>Ngày mua</th>
				        <th>Trạng thái</th>
				      </tr>
				    </thead>
				    <tbody>
				     
				     	<c:forEach var="l" items="${listLichSu }">
			     		 <tr>
			     		 <td> ${l.maHD }</td>
					        <td><img style="width: 72px;height: 72px" alt="#" src="./images_mobile/${l.anh }"></td>
					        <td>${l.ten }
					        	
					        </td>
					       <td><fmt:formatNumber type="currency" value="${l.gia }" /></td>
					       <td>${l.soLuong }</td>
					       <td> <fmt:formatNumber type="currency" value="${l.gia* l.soLuong }" /></td>
					        <td>${l.ngayMua }</td>
					        <td>${l.status?"đã duyệt":"chờ duyệt"}</td>
					      </tr>
					      
				     	</c:forEach>
				    </tbody>
				  </table>
             </div>
            <!--content-->

            <!-- footer-->
            <jsp:include page="../mobile/footer.jsp"></jsp:include>
            <!-- footer-->


            <!-- Button -->
            <a href="#" class="go-to-top"> <i
                    class="go-to-top__icon fas fa-chevron-circle-up"></i>
            </a> <a href="#" class="go-to-chat"> <i
                    class="go-to-chat__icon fab fa-facebook-messenger"></i>
            </a>
        </div>

        <script src="./js/phone.js"></script>
        <script src="./js/tool.js"></script>
        <script src="./js/fix.js"></script>
        <script src="./js/unlock.js"></script>
        <script>
        function update(ten){
            console.log(ten);
        };
		
        function edit(id) {
			   
               var url = "http://localhost:8080/MobileCity/cart/update";        
               const soluong = parseInt(document.getElementById(id).value);
               console.log('so luong:'+ soluong);
               console.log('id:'+ id);
               
               jQuery.ajax({
                   type: "GET",
                   url: url,
                   data:{'id':id,'soLuong':soluong},
                   success: function (data) {
                    jQuery("#container").html(data)
                   }
               });
           };
           function xoa(id) {
			   
               var url = "http://localhost:8080/MobileCity/cart/delete";        
               console.log('id:'+ id);
               
               jQuery.ajax({
                   type: "GET",
                   url: url,
                   data:{'id':id},
                   success: function (data) {
                    jQuery("#container").html(data)
                   }
               });
           };
           jQuery('#pay').click(function(){
        	   jQuery('#fromCart').prop('action', '/MobileCity/cart/pay');
       		});
           jQuery('#delete').click(function(){
        	   jQuery('#fromCart').prop('action', '/MobileCity/cart/deleteCheck');
       		});
        
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
    </body>
</html>