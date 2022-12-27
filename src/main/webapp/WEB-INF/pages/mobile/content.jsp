<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
    <div class="container">
        <div class="grid wide">
            <!-- Product Phone -->
            <div class="row container__item">
                <div class="col l-8 m-12 c-12">
                    <div class="banner">
                        <div class="row">
                            <div class="phone-banner__wrap">
                                <i class="fas fa-arrow-left phone-banner__btn-prev"></i>
                                <i class="fas fa-arrow-right phone-banner__btn-next"></i>
                                <div class="phone-banner__list">
                                    <!-- Thêm danh sách Banner -->
                                    
                                </div>
                                <div class="phone-banner-pagination">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col l-4 m-0 c-0">
                    <iframe src="https://www.youtube.com/embed/aAiPZw_OrkQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen class="video1"></iframe>
                    <iframe src="https://www.youtube.com/embed/9HHpOjCya40" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen class="video2"></iframe>
                </div>

                <div class="col l-12 m-12 c-12">
                    <div class="container-nav">
                        <h2 class="container-nav__heading">Hãng:</h2>
                        <ul style="margin-top: 10px" class="container-nav__list">
                            <!-- List loai -->
                            <li class="container-nav__item">
                                	<a href="/MobileCity/mobile" class="container-nav__item-link">All</a>
                            	</li>
                            <c:forEach var="l" items="${listLoai }">
                            	<li class="container-nav__item">
                                	<a href="/MobileCity/mobile?ml=${l.id }" class="container-nav__item-link">${l.tenLoai}</a>
                            	</li>
                            </c:forEach>
                            <!-- List loai -->
                        </ul>
                    </div>
                </div>

                <div class="col l-12 m-12 c-12">
                    <div class="container-filter">
                        <div class="container-filter__item">
                            Sắp xếp theo giá
                            <i class="container-filter__icon-down fas fa-chevron-down"></i>
                            <ul class="container-filter__list">
                                <a href="/MobileCity/mobile?sapxep=giam-dan">
                                	<li class="container-filter__list-item">
                                    Giá từ cao đến thấp
                                </li>
                                </a>
                                <a href="/MobileCity/mobile?sapxep=tang-dan">
                                	 <li class="container-filter__list-item">
                                    Giá từ thấp đến cao
                                </li>
                                </a>
                            </ul>
                        </div>
						<!-- 
                        <div class="container-filter__item">
                            Bán chạy
                            <i class="container-filter__icon-down fas fa-chevron-down"></i>
                            <ul class="container-filter__list">
                                <li class="container-filter__list-item">
                                    Bán chạy
                                </li>
                                <li class="container-filter__list-item">
                                    Phổ biến
                                </li>
                                <li class="container-filter__list-item">
                                    Khuyến mãi
                                </li>
                                <li class="container-filter__list-item">
                                    Hàng mới về
                                </li>
                            </ul>
                        </div>
                    </div> -->
                </div>

                <div class="col l-12 m-12 c-12">
                    <div class="container-product">
                        <div class="row no-gutters phone-products">
                            <!-- Thêm từng điện thoại vào -->
                            <c:forEach var="m" items="${ listMobile}">
                            
                            	<div class="col l-2-4 l-3-m m-4 c-6">
                                <div class="container-product__item">
                                    <div class="container-product__item-heading">
                                        <div class="container-product__item-img" style="background-image: url(images_mobile/${m.anh});"></div>
                                
                                        <div class="container-product-guarantee">
                                            <a href= class="container-product__item-link">
                                                <div class="container-product-guarantee__heading">
                                                    <img src="https://mobilecity.vn/public/assets/img/icon-mobilecity-care.png" alt="Guarantee" class="container-product-guarantee__heading-img">
                                                    <h3 class="container-product-guarantee__heading-text">MobileCity Care</h3>
                                                </div>
            
                                                <ul class="container-product-guarantee__list">
                                                    <li class="container-product-guarantee__item">BH 12 tháng nguồn, màn hình</li>
                                                    <li class="container-product-guarantee__item">Đổi mới 30 ngày đầu tiên</li>
                                                    <li class="container-product-guarantee__item">Tặng ốp lưng, dán cường lực</li>
                                                    <li class="container-product-guarantee__item">Hỗ trợ phần mềm trọn đời máy</li>
                                                </ul>
                                            </a>
                                            <a href=# class="container-product-guarantee__btn">Bảo hành vàng</a>
                                        </div>
                                    </div>
                                    <div class="container-product__item-wrap">
                                        <div class="container-product__item-info">
                                            <a href="/MobileCity/mobile/detail?id=${m.id }" class="container-product__item-name">
                                                ${m.ten }
                                            </a>
                                            <i class="container-product__item-sale-icon fas fa-gift"></i>
                                        </div>
                                        <div class="container-product__item-buy">
                                            <span class="container-product__item-price">
                                                <strong> <fmt:formatNumber type="currency" value="${m.giaBan}" /></strong>
                                            </span>
                                            <a href="/MobileCity/cart/add?id=${m.id}&anh=${m.anh}&gia=${m.giaBan}&ten=${m.ten}" class="container-product__item-btn">MUA</a>
                                        </div>
                                    </div>
                                    <ul class="container-product__item-gifts-list">
                                        <li class="container-product__item-gift">
                                            1. Tặng: 
                                            <span class="container-product__item-gift--highlight">
                                                Cường lực - Ốp lưng - Tai nghe
                                            </span>
                                            khi mua BHV
                                        </li>
                                        <li class="container-product__item-gift">
                                            2. Giảm: 
                                            <span class="container-product__item-gift--highlight">
                                                100K
                                            </span>
                                            áp dụng HSSV mua BHV tại 
                                            <span class="container-product__item-gift--highlight">
                                                42 phố Vọng
                                            </span>
                                        </li>
                                    </ul>
                                    <ul class="container-product-marker__list ">
                                        <li class="container-product-marker__item container-product-marker__item--new">Mới</li>
                                        <li class="container-product-marker__item container-product-marker__item--hot">Hot</li>
                                    </ul>
                                </div>
                            </div>
                            </c:forEach>
                            
                        </div>
                    </div>
                </div>

                <div class="col l-12 m-12 c-12">
                    <div class="container-view-more">
                        <nav aria-label="...">
						  <ul class="pagination">
						    <li class="page-item ">
						      <a class="page-link" href="#" tabindex="-1">Previous</a>
						    </li>
						    <c:forEach var="p" items="${listPage }">
						    	<c:choose>
									<c:when test="${p == pagination.page }">
										<li class="page-item active"><a class="page-link" href="/MobileCity/mobile?ml=${pagination.maLoai }&value=${pagination.searchValues}&page=${p }&sapxep=${pagination.sapXep}" class="active">${p}</a></li>
									</c:when>
									<c:when test="${p == -1 }">
										<span style="margin-top: 7px">...</span>
									</c:when>
									<c:otherwise>
										<li class="page-item "><a class="page-link" href="/MobileCity/mobile?ml=${pagination.maLoai }&value=${pagination.searchValues}&page=${p }&sapxep=${pagination.sapXep}" class="active">${p}</a></li>
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
            </div>

            <!-- Product Tool -->
           

            <!-- Product Fix -->
           

            <!-- Product Unlock -->
           
        </div>

        <!-- Container News -->
        <div class="grid wide">
            <div class="container-new">
                <div class="row">
                    <div class="col l-6 l-12-m m-12 c-12">
                        <div class="container-new__item">
                            <a href="#" class="container-new__item-link">
                                <img src="https://cdn.mobilecity.vn/mobilecity-vn/images/2020/02/w150/doi-may-moi.jpg" alt="" class="container-new__img">
                                <div class="container-new__text">
                                    <h2 class="container-new__text-heading">MobileCity đổi máy CŨ lên máy MỚI năm 2020</h2>
                                    <p class="container-new__text-disc">MobileCity kính chào Quý khách! Cám ơn Quý khách đã ủng hộ và yêu quý MobileCity! Với mong muốn luôn luôn cải tiến và phục vụ Khách hàng tốt hơn, MobileCity mở chương trình "Đổi máy CŨ để lấy máy MỚI"</p>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col l-6 l-12-m m-12 c-12">
                        <div class="container-new__item">
                            <a href="#" class="container-new__item-link">
                                <img src="https://cdn.mobilecity.vn/mobilecity-vn/images/2020/02/w150/doi-may-moi.jpg" alt="" class="container-new__img">
                                <div class="container-new__text">
                                    <h2 class="container-new__text-heading">MobileCity đổi máy CŨ lên máy MỚI năm 2020</h2>
                                    <p class="container-new__text-disc">MobileCity kính chào Quý khách! Cám ơn Quý khách đã ủng hộ và yêu quý MobileCity! Với mong muốn luôn luôn cải tiến và phục vụ Khách hàng tốt hơn, MobileCity mở chương trình "Đổi máy CŨ để lấy máy MỚI"</p>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

 