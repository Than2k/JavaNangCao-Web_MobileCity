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
       <title>Cửa hàng điện thoại MobileCity</title>

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
            <jsp:include page="header.jsp"></jsp:include>
            <!-- header -->

            <!--content-->
            <div  class="container">
               
               <div class="row">
		           <div class="col-sm-12 col-md-10 col-md-offset-1">
		           	<h3 style="color: rgb(10, 64, 119)">Giỏ hàng ></h3>
		              <form id="fromCart" action="/MobileCity/cart/deleteCheck" method="get">

                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>Tên điện thoại</th>
                                    <th>Số lượng</th>
                                    <th class="text-center">Giá</th>
                                    <th class="text-center">Thành tiền</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody id="container1">
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
                              
                            </tbody>
                            <tfoot>
                            	  <tr>
                                    <td></td>
                                    <td></td>
                                    <td></td>
                                    <td>
                                        <button id="delete" type="submit"
                                            class="btn
                                            btn-danger">
                                            <span
                                                class="glyphicon
                                                glyphicon-shopping-cart"></span>
                                            Delete check
                                        </button>
                                    </td>
                                    <td>
                                        <a href="/MobileCity/mobile"><button type="button"
                                            class="btn
                                            btn-default">
                                            <span
                                                class="glyphicon
                                                glyphicon-shopping-cart"></span>
                                            Continue Shopping
                                        </button></a>
                                    </td>
                                    <td>
                                        <button id="pay" type="submit"
                                            class="btn
                                            btn-success">
                                            Checkout <span
                                                class="glyphicon
                                                glyphicon-play"></span>
                                        </button>
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                      </form>
		           </div>
		       </div>
            </div>
            <!--content-->

            <!-- footer-->
            <jsp:include page="footer.jsp"></jsp:include>
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
                    jQuery("#container1").html(data)
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
                    jQuery("#container1").html(data)
                   }
               });
           };
           jQuery('#pay').click(function(){
               console.log("pay");
        	   jQuery('#fromCart').prop('action', '/MobileCity/cart/pay');
       		});
           jQuery('#delete').click(function(){
                console.log("delete");
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