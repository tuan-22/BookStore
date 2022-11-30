<%-- 
    Document   : header
    Created on : Sep 19, 2022, 6:12:02 PM
    Author     : tramy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<style>
    .navigation-item.active {
        color:red
    }
</style>
<!DOCTYPE html>
<header class="header">
    <div class="header-top">
        <div class="container">
            <div class="header-left">

            </div><!-- End .header-left -->

            <div class="header-right">
                <ul class="top-menu">
                    <li>
                        <ul>
                            <li><a href=""></a></li>
                            <li><a href="aboutUs.jsp">About Us</a></li>
                            <li><a href="contact.jsp">Contact Us</a></li>
                            <li><a href="loginnav">Login</a></li>
                        </ul>
                    </li>
                </ul><!-- End .top-menu -->
            </div><!-- End .header-right -->
        </div><!-- End .container -->
    </div><!-- End .header-top -->

    <div class="header-middle sticky-header">
        <div class="container">
            <div class="header-left">
                <button class="mobile-menu-toggler">
                    <span class="sr-only">Toggle mobile menu</span>
                    <i class="icon-bars"></i>
                </button>

                <a href="home" class="logo">
                    <img src="assets/images/logo.png" alt="Molla Logo" width="105" height="25">
                </a>

                <nav class="main-nav" >
                    <ul class="menu sf-arrows" id="menu-active-Class">
                        <li>
                            <a href="home" class="navigation-item ">Home</a>
                        </li>
                        <li>
                            <a href="shopping?index=1" class="navigation-item">Shopping</a>
                        </li>
                        <li>
                            <a href="" id="sf-with-ul" class="navigation-item">Category</a>
                            <div class="megamenu megamenu-sm">
                                <div class="row no-gutters">
                                    <div class="col-md-12">
                                        <div class="menu-col">
                                            <ul>
                                                <c:forEach items="${listC}" var="o">
                                                    <li><a href="category?categoryName=${o.name}">${o.name}</a></li>
                                                    <!--href giúp truyền đường dẫn--> 
                                                </c:forEach>
                                            </ul>
                                        </div><!-- End .menu-col -->
                                    </div><!-- End .col-md-6 -->
                                </div><!-- End .row -->
                            </div><!-- End .megamenu megamenu-sm -->
                        </li>
                        <script>
                            const navList = document.querySelectorAll('.navigation-item');
                            const path = window.location.href.replace("http://localhost:8084/SWP391_BookStore/", "");
                            switch (path) {
                                case "home":
                                {
                                    navList[0].classList.toggle("active")
                                    break;
                                }
                                case "shopping":
                                {
                                    navList[1].classList.toggle("active")
                                    break;
                                }
                                case "detail":
                                {
                                    navList[2].classList.toggle("")
                                    break;
                                }
                                case "category?categoryName=Art%20-%20Literary":
                                {
                                    navList[3].classList.toggle("active")
                                    break;
                                }
                                case "category?categoryName=Comics":
                                {
                                    navList[4].classList.toggle("active")
                                    break;
                                }
                                case "category?categoryName=Textbook%20-%20Syllabus":
                                {
                                    navList[5].classList.toggle("active")
                                    break;
                                }
                                case "category?categoryName=Novel":
                                {
                                    navList[6].classList.toggle("active")
                                    break;
                                }
                                case "category?categoryName=Foreign%20language":
                                {
                                    navList[7].classList.toggle("active")
                                    break;
                                }
                                case "category?categoryName=Science":
                                {
                                    navList[8].classList.toggle("active")
                                    break;
                                }
                                case "category?categoryName=Horror":
                                {
                                    navList[9].classList.toggle("active")
                                    break;
                                }
                                case "":
                                {
                                    navList[10].classList.toggle("")
                                    break;
                                }
                                default:
                                {
                                    navList[11].classList.toggle("")
                                    break;
                                }
                            }

                        </script>
                        <!--                        <script>
                                                    // Add active class to the current button (highlight it)
                                                    var header = document.getElementById("menu-active-Class");
                                                    var btns = header.getElementsByClassName("navigation-item");
                                                    for (var i = 0; i < btns.length; i++) {
                                                        btns[i].addEventListener("click", function () {
                                                            var current = document.getElementsByClassName("active");
                                                            current[0].className = current[0].className.replace(" active", "");
                                                            this.className += " active";
                                                        });
                                                    }
                                                </script>-->
                    </ul><!-- End .menu -->
                </nav><!-- End .main-nav -->
            </div><!-- End .header-left -->

            <div class="header-right">
                <div class="header-search">
                    <a href="#" class="search-toggle" role="button" title="Search"><i class="icon-search"></i></a>
                    <form action="SearchController?index=1" method="post">
                        <div class="header-search-wrapper">
                            <label for="q" class="sr-only">Search</label>
                            <input type="search" class="form-control" name="searchKey" 
                                   placeholder="Search in..." required>
                            <input type="submit" class="search-btn" value="Search" />

                        </div><!-- End .header-search-wrapper -->
                    </form>
                </div><!-- End .header-search -->

                <%

                    if (session.getAttribute("cart") == null) {
                %>
                <div class="dropdown cart-dropdown">
                    <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static">
                        <i class="icon-shopping-cart"></i>
                        <span class="cart-count">${cart.size()}</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <div class="dropdown-cart-products">
                            <label>
                                <img style="width: 320px; height: 200px;" src="assets/images/mini-cart-empty.png" alt="Product image">
                            </label>
                        </div>
                        <div class="dropdown-cart-action">
                            <a href="cartnav" class="btn btn-outline-primary-2"><span>View Cart</span><i class='fas'>&#xf07a;</i></a>
                            <a href="checkOutnav" class="btn btn-outline-primary-2"><span>Checkout</span><i class='fas'>&#xf53d;</i></a>
                        </div><!-- End .dropdown-cart-total -->
                    </div><!-- End .dropdown-menu -->
                </div><!-- End .cart-dropdown -->
                <%} else {%>
                <div class="dropdown cart-dropdown">
                    <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" data-display="static">
                        <i class="icon-shopping-cart"></i>
                        <span class="cart-count">${cart.size()}</span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-right">
                        <c:forEach items="${cart}" var="cart">
                            <div class="dropdown-cart-products">
                                <div class="product">
                                    <div class="product-cart-details">
                                        <h4 class="product-title">
                                            <a href="product.html">${cart.book.bookName}</a>
                                        </h4>

                                        <span class="cart-product-info">
                                            <span class="cart-product-qty">${cart.qty}</span> X
                                            <fmt:formatNumber value="${cart.buyPrice}" pattern=" #,##0 VND" />                                         
                                        </span>
                                    </div><!-- End .product-cart-details -->

                                    <figure class="product-image-container">
                                        <a href="product.html" class="product-image">
                                            <img src="${cart.book.image}" alt="product">
                                        </a>
                                    </figure>
                                    <a href="${pageContext.request.contextPath }/cart?action=removeHome&bookCode=${cart.book.bookCode}" class="btn-remove"><i class="icon-close"></i></a>
                                </div><!-- End .product -->

                            </div><!-- End .cart-product -->    
                        </c:forEach>

                        <div class="dropdown-cart-action">
                            <a href="cartnav" class="btn btn-outline-primary-2"><span>View Cart</span><i class='fas'>&#xf07a;</i></a>
                            <a href="checkOutnav" class="btn btn-outline-primary-2"><span>Checkout</span><i class='fas'>&#xf53d;</i></a>
                        </div><!-- End .dropdown-cart-total -->
                    </div><!-- End .dropdown-menu -->
                </div><!-- End .cart-dropdown -->
                <%}%>
            </div><!-- End .header-right -->
        </div><!-- End .container -->
    </div><!-- End .header-middle -->
</header><!-- End .header -->
<<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>