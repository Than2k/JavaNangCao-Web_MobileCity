<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">
    
    
        <link rel="stylesheet" href="./css/base.css">
        <link rel="stylesheet" href="./css/grid.css">
        <link rel="stylesheet" href="./css/main.css">
        <link rel="stylesheet" href="./css/responsive.css">
    </head>
    <body>
   		<c:if test="${cartNull !=null }">
   			<script type="text/javascript">
   				alert('${cartNull}');
   			</script>
   		</c:if>
   		
   		<c:if test="${errTimKiem !=null }">
   			<script type="text/javascript">
   				alert('${errTimKiem}');
   			</script>
   		</c:if>
   
        <div class="main">
            <!-- header -->
           <jsp:include page="header.jsp"></jsp:include>
            <!-- header -->
            
            <!--content-->
           <jsp:include page="content.jsp"></jsp:include>
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
    </body>
    </html>