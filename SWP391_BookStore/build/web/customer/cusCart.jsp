<%@page import="com.bookstore.Account.Account"%>
<%@page import="com.bookstore.Book.BookDAO"%>
<%@page import="com.bookstore.Book.Book"%>
<%@page import="com.bookstore.Cart.Cart"%>
<%@page import="java.util.List"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">


    <!-- molla/cart.html  22 Nov 2019 09:55:06 GMT -->
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>THE5 BookStore</title>
        <meta name="keywords" content="HTML5 Template">
        <meta name="description" content="Molla - Bootstrap eCommerce Template">
        <meta name="author" content="p-themes">
        <!-- Favicon -->
        <link rel="apple-touch-icon" sizes="180x180" href="assets/images/icons/apple-touch-icon.png">
        <link rel="icon" type="image/png" sizes="32x32" href="assets/images/icons/favicon-32x32.png">
        <link rel="icon" type="image/png" sizes="16x16" href="assets/images/icons/favicon-16x16.png">
        <link rel="manifest" href="assets/images/icons/site.html">
        <link rel="mask-icon" href="assets/images/icons/safari-pinned-tab.svg" color="#666666">
        <link rel="shortcut icon" href="assets/images/icons/favicon.ico">
        <meta name="apple-mobile-web-app-title" content="Molla">
        <meta name="application-name" content="Molla">
        <meta name="msapplication-TileColor" content="#cc9966">
        <meta name="msapplication-config" content="assets/images/icons/browserconfig.xml">
        <meta name="theme-color" content="#ffffff">
        <!-- Plugins CSS File -->
        <link rel="stylesheet" href="assets/css/bootstrap.min.css">
        <!-- Main CSS File -->
        <link rel="stylesheet" href="assets/css/style.css">
    </head>

    <style>
        .navigation-item.active {
            color:red
        }
    </style>

    <body>
        <div class="page-wrapper">
            <header class="header">
                <div class="header-top">
                    <div class="container">
                        <div class="header-left">

                        </div><!-- End .header-left -->

                        <div class="header-right">
                            <ul class="top-menu">
                                <li>
                                    <ul>
                                        <li><a href="/SWP391_BookStore/logout">Logout</a></li>
                                        <li><a href="about.html">About Us</a></li>
                                        <li><a href="contact.html">Contact Us</a></li>

                                        <li><a href="editprofile">Hello ${acc.getUsername()}</a></li>

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

                            <a href="cushome" class="logo">
                                <img src="assets/images/logo.png" alt="Molla Logo" width="105" height="25">
                            </a>

                            <nav class="main-nav" >
                                <ul class="menu sf-arrows" id="menu-active-Class">
                                    <li>
                                        <a href="cushome" class="navigation-item ">Home</a>
                                    </li>
                                    <li>
                                        <a href="cusshopping?index=1" class="navigation-item">Shopping</a>
                                    </li>
                                    <li>
                                        <a href="" id="sf-with-ul" class="navigation-item">Category</a>
                                        <div class="megamenu megamenu-sm">
                                            <div class="row no-gutters">
                                                <div class="col-md-12">
                                                    <div class="menu-col">
                                                        <ul>
                                                            <c:forEach items="${listC}" var="o">
                                                                <li><a href="cuscategory?categoryName=${o.name}">${o.name}</a></li>
                                                                <!--href gi?p truy?n ???ng d?n--> 
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
                                            case "cushome":
                                            {
                                                navList[0].classList.toggle("active")
                                                break;
                                            }
                                            case "cusshopping":
                                            {
                                                navList[1].classList.toggle("active")
                                                break;
                                            }
                                            case "cusdetail":
                                            {
                                                navList[2].classList.toggle("")
                                                break;
                                            }
                                            case "cuscategory?categoryName=Art%20-%20Literary":
                                            {
                                                navList[3].classList.toggle("active")
                                                break;
                                            }
                                            case "cuscategory?categoryName=Comics":
                                            {
                                                navList[4].classList.toggle("active")
                                                break;
                                            }
                                            case "cuscategory?categoryName=Textbook%20-%20Syllabus":
                                            {
                                                navList[5].classList.toggle("active")
                                                break;
                                            }
                                            case "cuscategory?categoryName=Novel":
                                            {
                                                navList[6].classList.toggle("active")
                                                break;
                                            }
                                            case "cuscategory?categoryName=Foreign%20language":
                                            {
                                                navList[7].classList.toggle("active")
                                                break;
                                            }
                                            case "cuscategory?categoryName=Science":
                                            {
                                                navList[8].classList.toggle("active")
                                                break;
                                            }
                                            case "cuscategory?categoryName=Horror":
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
                                <form action="cusSearchController?index=1" method="post">
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
                                        <a href="cusCartNav" class="btn btn-outline-primary-2"><span>View Cart</span><i class='fas'>&#xf07a;</i></a>
                                        <a href="cusCheckOut" class="btn btn-outline-primary-2"><span>Checkout</span><i class='fas'>&#xf53d;</i></a>
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
                                                        <span class="cart-product-qty">${cart.qty} x
                                                            <fmt:formatNumber value="${cart.book.buyPrice}" pattern=" #,##0 VND" />   
                                                        </span>
                                                    </span>
                                                </div><!-- End .product-cart-details -->

                                                <figure class="product-image-container">
                                                    <a href="product.html" class="product-image">
                                                        <img src="${cart.book.image}" alt="product">
                                                    </a>
                                                </figure>
                                                <a href="${pageContext.request.contextPath }/customer/cuscart?action=remove&bookCode=${cart.book.bookCode}" class="btn-remove"><i class="icon-close"></i></a>
                                            </div><!-- End .product -->

                                        </div><!-- End .cart-product -->    
                                    </c:forEach>

                                    <div class="dropdown-cart-action">
                                        <a href="cusCartNav" class="btn btn-outline-primary-2"><span>View Cart</span><i class='fas'>&#xf07a;</i></a>
                                        <a href="cusCheckOut" class="btn btn-outline-primary-2"><span>Checkout</span><i class='fas'>&#xf53d;</i></a>
                                    </div><!-- End .dropdown-cart-total -->
                                </div><!-- End .dropdown-menu -->
                            </div><!-- End .cart-dropdown -->
                            <%}%>
                        </div><!-- End .header-right -->
                    </div><!-- End .container -->
                </div><!-- End .header-middle -->
            </header><!-- End .header -->


            <main class="main">
                <div class="page-header text-center" style="background-image: url('assets/images/page-header-bg.jpg')">
                    <div class="container">
                        <h1 class="page-title">Shopping Cart<span>Shop</span></h1>
                    </div><!-- End .container -->
                </div><!-- End .page-header -->
                <nav aria-label="breadcrumb" class="breadcrumb-nav">
                    <div class="container">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="home">Home</a></li>
                            <li class="breadcrumb-item"><a href="shopping">Shop</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Shopping Cart</li>
                        </ol>
                    </div><!-- End .container -->
                    <c:if test='${checkQuanityAddCart2 == "Store has no more quantity of this book left. We apologize for the inconvenience."}'>
                        <div class="alert2">
                            <span class="closebtn" onclick="this.parentElement.style.display = 'none';">&times;</span>
                            <p align="center" style="color: white">${checkQuanityAddCart2}</p>
                        </div>
                    </c:if>
                </nav><!-- End .breadcrumb-nav -->

                <style>
                    p {
                        text-align: center;
                    }
                </style>
                
                <c:if test='${cart == null}'>
                    <div class="page-content">
                        <div class="cart">
                            <div class="container">
                                <div class="row">
                                    <div class="col-lg-9">
                                        <img style="width: 600px; height: 350px;" src="assets/images/cart-empty.png" alt="Product image">
                                    </div>
                                    <aside class="col-lg-3">
                                        <div class="summary summary-cart">
                                            <a class="logo" style="color: orange">
                                                <img src="assets/images/logo.png" alt="Molla Logo" width="105" height="25">
                                                <h9 class="right-parent"><i class="icon-phone"></i>Call: +0123 456 789</h9>
                                                <h9>(Tra My)</h9>
                                            </a>
                                            <h5 class="center-parent">BILL</h5><!-- End .summary-title -->
                                            <h7>Guess Name: ${acc.getUsername()}</h7><br>
                                            <h7>Guess Phone Number: ${acc.getPhone()}</h7>
                                            <h1 class="summary-title"></h1>
                                            <table class="table table-summary">
                                                <tbody>                                              
                                                    <tr class="summary-subtotal">
                                                        <td>Quantity</td>
                                                        <td class="center-parent">Name</td>
                                                        <td>Price</td>
                                                    </tr><!-- End .summary-subtotal -->
                                                </tbody>
                                                <tr>
                                                    <td class="total-col">Total:</td>

                                                    <td class="total-col">                                    
                                                    </td>
                                                </tr><!-- End .summary-total -->
                                            </table><!-- End .table table-summary -->    
                                            <a href="cushome" class="btn btn-outline-primary-2 btn-block mb-3"><span>CONTINUE SHOPPING</span><i style='font-size:24px' class='fas'>&#xf217;</i></a>
                                        </div><!-- End .summary -->
                                    </aside><!-- End .col-lg-3 -->
                                </div><!-- End .row -->
                            </div><!-- End .container -->
                        </div><!-- End .cart -->
                    </div><!-- End .page-content -->
                </c:if>

                <div class="page-content">
                    <div class="cart">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-9">
                                    <c:if test='${cart != null}'>
                                        <table class="table table-cart table-mobile">
                                            <thead>
                                                <tr>
                                                    <th>Product</th>
                                                    <th>Price</th>
                                                    <th></th>
                                                    <th>Quantity</th>
                                                    <th>Total</th>
                                                    <th></th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${cart}" var="cart">
                                                    <tr>
                                                        <td class="product-col">
                                                            <div class="product">
                                                                <figure class="product-media">
                                                                    <img src="${cart.book.image}" alt="Product image" class="product-image">
                                                                </figure>
                                                                <h3 class="product-title">
                                                                    <a href="product.jsp">${cart.book.bookName}</a>
                                                                </h3> 
                                                            </div> 
                                                        </td>
                                                        <c:if test='${cart.book.buyPrice == cart.buyPrice}'>
                                                            <td class="price-col">
                                                                <fmt:formatNumber value="${cart.book.buyPrice}" pattern=" #,##0 VND" /> 
                                                            </td>
                                                            <td></td>
                                                        </c:if>
                                                        <c:if test='${cart.book.buyPrice != cart.buyPrice}'>
                                                            <td class="price-col">
                                                                <fmt:formatNumber value="${cart.buyPrice}" pattern=" #,##0 VND" />
                                                            </td>
                                                            <td class="line-through">
                                                                <fmt:formatNumber value="${cart.book.buyPrice}" pattern=" #,##0 VND" />  
                                                            </td>
                                                        </c:if>
                                                        <td class="quantity-col">
                                                            <div class="cart-product-quantity">
                                                                <a href="${pageContext.request.contextPath }/customer/cuscart?action=decre&bookCode=${cart.book.bookCode}">-</a>
                                                                <a class="alert">
                                                                    ${cart.qty}                                                     
                                                                </a>
                                                                <a href="${pageContext.request.contextPath }/customer/cuscart?action=incre&bookCode=${cart.book.bookCode}">+</a>
                                                            </div>
                                                        </td>
                                                        <td class="total-col">
                                                            <fmt:formatNumber value="${cart.buyPrice * cart.qty}" pattern=" #,##0 VND" /> 
                                                        </td>
                                                        <td class="remove-col">
                                                            <a href="${pageContext.request.contextPath }/customer/cuscart?action=remove&bookCode=${cart.book.bookCode}" class="btn-remove">
                                                                <i class="icon-close"></i>
                                                            </a>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table><!-- End .table table-wishlist -->
                                    </c:if>
                                </div><!-- End .col-lg-9 -->
                                <aside class="col-lg-3">
                                    <c:if test='${cart != null}'>
                                        <div class="summary summary-cart">
                                            <a class="logo" style="color: orange">
                                                <img src="assets/images/logo.png" alt="Molla Logo" width="105" height="25">
                                                <h9 class="right-parent"><i class="icon-phone"></i>Call: +0123 456 789</h9>
                                                <h9>(Tra My)</h9>
                                            </a>
                                            <h5 class="center-parent">BILL</h5><!-- End .summary-title -->
                                            <h7>Guess Name: ${acc.getUsername()}</h7><br>
                                            <h7>Guess Phone Number: ${acc.getPhone()}</h7>
                                            <h1 class="summary-title"></h1>
                                            <table class="table table-summary">
                                                <tbody>                                              
                                                    <tr class="summary-subtotal">
                                                        <td>Quantity</td>
                                                        <td class="center-parent">Name</td>
                                                        <td>Price</td>
                                                    </tr><!-- End .summary-subtotal -->
                                                    <c:forEach items="${cart}" var="cart">
                                                        <tr class="summary-subtotal">
                                                            <td>X ${cart.qty}</td>
                                                            <td>${cart.book.bookName}</td>
                                                            <td>
                                                                <fmt:formatNumber value="${cart.buyPrice * cart.qty}" pattern=" #,##0 VND" />  
                                                            </td>
                                                        </tr><!-- End .summary-subtotal -->
                                                    </c:forEach>
                                                </tbody>
                                                <tr>
                                                    <td class="total-col">Total:</td>
                                                    <c:forEach items="${cart}" var="cart">
                                                    <script>
                                                        int total += ${cart.buyPrice * cart.qty};
                                                    </script>
                                                </c:forEach>
                                                <c:set value="${total}" var="totalAll"></c:set>

                                                    <td class="total-col">
                                                    <fmt:formatNumber value="${totalPrice}" pattern=" #,##0 VND" />                                       
                                                </td>
                                                </tr><!-- End .summary-total -->
                                            </table><!-- End .table table-summary -->
                                            <a href="cusCheckOut.jsp" class="btn btn-outline-primary-2 btn-order btn-block">PROCEED TO CHECKOUT</a>
                                        </div><!-- End .summary -->
                                    </c:if>
                                </aside><!-- End .col-lg-3 -->
                            </div><!-- End .row -->
                        </div><!-- End .container -->
                    </div><!-- End .cart -->
                </div><!-- End .page-content -->
            </main><!-- End .main -->

            <jsp:include page="cusFooter.jsp"></jsp:include>
        </div><!-- End .page-wrapper -->
        <button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>

        <!-- Mobile Menu -->
        <div class="mobile-menu-overlay"></div><!-- End .mobil-menu-overlay -->

        <div class="mobile-menu-container">
            <div class="mobile-menu-wrapper">
                <span class="mobile-menu-close"><i class="icon-close"></i></span>

                <form action="#" method="get" class="mobile-search">
                    <label for="mobile-search" class="sr-only">Search</label>
                    <input type="search" class="form-control" name="mobile-search" id="mobile-search" placeholder="Search in..." required>
                    <button class="btn btn-primary" type="submit"><i class="icon-search"></i></button>
                </form>

                <nav class="mobile-nav">
                    <ul class="mobile-menu">
                        <li class="active">
                            <a href="index.html">Home</a>

                            <ul>
                                <li><a href="index-1.html">01 - furniture store</a></li>
                                <li><a href="index.html">02 - furniture store</a></li>
                                <li><a href="index-3.html">03 - electronic store</a></li>
                                <li><a href="index-4.html">04 - electronic store</a></li>
                                <li><a href="index-5.html">05 - fashion store</a></li>
                                <li><a href="index-6.html">06 - fashion store</a></li>
                                <li><a href="index-7.html">07 - fashion store</a></li>
                                <li><a href="index-8.html">08 - fashion store</a></li>
                                <li><a href="index-9.html">09 - fashion store</a></li>
                                <li><a href="index-10.html">10 - shoes store</a></li>
                                <li><a href="index-11.html">11 - furniture simple store</a></li>
                                <li><a href="index-12.html">12 - fashion simple store</a></li>
                                <li><a href="index-13.html">13 - market</a></li>
                                <li><a href="index-14.html">14 - market fullwidth</a></li>
                                <li><a href="index-15.html">15 - lookbook 1</a></li>
                                <li><a href="index-16.html">16 - lookbook 2</a></li>
                                <li><a href="index-17.html">17 - fashion store</a></li>
                                <li><a href="index-18.html">18 - fashion store (with sidebar)</a></li>
                                <li><a href="index-19.html">19 - games store</a></li>
                                <li><a href="index-20.html">20 - book store</a></li>
                                <li><a href="index-21.html">21 - sport store</a></li>
                                <li><a href="index-22.html">22 - tools store</a></li>
                                <li><a href="index-23.html">23 - fashion left navigation store</a></li>
                                <li><a href="index-24.html">24 - extreme sport store</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="category.html">Shop</a>
                            <ul>
                                <li><a href="category-list.html">Shop List</a></li>
                                <li><a href="category-2cols.html">Shop Grid 2 Columns</a></li>
                                <li><a href="category.html">Shop Grid 3 Columns</a></li>
                                <li><a href="category-4cols.html">Shop Grid 4 Columns</a></li>
                                <li><a href="category-boxed.html"><span>Shop Boxed No Sidebar<span class="tip tip-hot">Hot</span></span></a></li>
                                <li><a href="category-fullwidth.html">Shop Fullwidth No Sidebar</a></li>
                                <li><a href="product-category-boxed.html">Product Category Boxed</a></li>
                                <li><a href="product-category-fullwidth.html"><span>Product Category Fullwidth<span class="tip tip-new">New</span></span></a></li>
                                <li><a href="cart.jsp">Cart</a></li>
                                <li><a href="checkOut.jsp">Checkout</a></li>
                                <li><a href="wishlist.html">Wishlist</a></li>
                                <li><a href="#">Lookbook</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="product.html" class="sf-with-ul">Product</a>
                            <ul>
                                <li><a href="product.html">Default</a></li>
                                <li><a href="product-centered.html">Centered</a></li>
                                <li><a href="product-extended.html"><span>Extended Info<span class="tip tip-new">New</span></span></a></li>
                                <li><a href="product-gallery.html">Gallery</a></li>
                                <li><a href="product-sticky.html">Sticky Info</a></li>
                                <li><a href="product-sidebar.html">Boxed With Sidebar</a></li>
                                <li><a href="product-fullwidth.html">Full Width</a></li>
                                <li><a href="product-masonry.html">Masonry Sticky Info</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="#">Pages</a>
                            <ul>
                                <li>
                                    <a href="about.html">About</a>

                                    <ul>
                                        <li><a href="about.html">About 01</a></li>
                                        <li><a href="about-2.html">About 02</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="contact.html">Contact</a>

                                    <ul>
                                        <li><a href="contact.html">Contact 01</a></li>
                                        <li><a href="contact-2.html">Contact 02</a></li>
                                    </ul>
                                </li>
                                <li><a href="login.html">Login</a></li>
                                <li><a href="faq.html">FAQs</a></li>
                                <li><a href="404.html">Error 404</a></li>
                                <li><a href="coming-soon.html">Coming Soon</a></li>
                            </ul>
                        </li>
                        <li>
                            <a href="blog.html">Blog</a>

                            <ul>
                                <li><a href="blog.html">Classic</a></li>
                                <li><a href="blog-listing.html">Listing</a></li>
                                <li>
                                    <a href="#">Grid</a>
                                    <ul>
                                        <li><a href="blog-grid-2cols.html">Grid 2 columns</a></li>
                                        <li><a href="blog-grid-3cols.html">Grid 3 columns</a></li>
                                        <li><a href="blog-grid-4cols.html">Grid 4 columns</a></li>
                                        <li><a href="blog-grid-sidebar.html">Grid sidebar</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Masonry</a>
                                    <ul>
                                        <li><a href="blog-masonry-2cols.html">Masonry 2 columns</a></li>
                                        <li><a href="blog-masonry-3cols.html">Masonry 3 columns</a></li>
                                        <li><a href="blog-masonry-4cols.html">Masonry 4 columns</a></li>
                                        <li><a href="blog-masonry-sidebar.html">Masonry sidebar</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Mask</a>
                                    <ul>
                                        <li><a href="blog-mask-grid.html">Blog mask grid</a></li>
                                        <li><a href="blog-mask-masonry.html">Blog mask masonry</a></li>
                                    </ul>
                                </li>
                                <li>
                                    <a href="#">Single Post</a>
                                    <ul>
                                        <li><a href="single.html">Default with sidebar</a></li>
                                        <li><a href="single-fullwidth.html">Fullwidth no sidebar</a></li>
                                        <li><a href="single-fullwidth-sidebar.html">Fullwidth with sidebar</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </li>
                        <li>
                            <a href="elements-list.html">Elements</a>
                            <ul>
                                <li><a href="elements-products.html">Products</a></li>
                                <li><a href="elements-typography.html">Typography</a></li>
                                <li><a href="elements-titles.html">Titles</a></li>
                                <li><a href="elements-banners.html">Banners</a></li>
                                <li><a href="elements-product-category.html">Product Category</a></li>
                                <li><a href="elements-video-banners.html">Video Banners</a></li>
                                <li><a href="elements-buttons.html">Buttons</a></li>
                                <li><a href="elements-accordions.html">Accordions</a></li>
                                <li><a href="elements-tabs.html">Tabs</a></li>
                                <li><a href="elements-testimonials.html">Testimonials</a></li>
                                <li><a href="elements-blog-posts.html">Blog Posts</a></li>
                                <li><a href="elements-portfolio.html">Portfolio</a></li>
                                <li><a href="elements-cta.html">Call to Action</a></li>
                                <li><a href="elements-icon-boxes.html">Icon Boxes</a></li>
                            </ul>
                        </li>
                    </ul>
                </nav><!-- End .mobile-nav -->

                <div class="social-icons">
                    <a href="#" class="social-icon" target="_blank" title="Facebook"><i class="icon-facebook-f"></i></a>
                    <a href="#" class="social-icon" target="_blank" title="Twitter"><i class="icon-twitter"></i></a>
                    <a href="#" class="social-icon" target="_blank" title="Instagram"><i class="icon-instagram"></i></a>
                    <a href="#" class="social-icon" target="_blank" title="Youtube"><i class="icon-youtube"></i></a>
                </div><!-- End .social-icons -->
            </div><!-- End .mobile-menu-wrapper -->
        </div><!-- End .mobile-menu-container -->

        <!-- Sign in / Register Modal -->
        <div class="modal fade" id="signin-modal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-body">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true"><i class="icon-close"></i></span>
                        </button>

                        <div class="form-box">
                            <div class="form-tab">
                                <ul class="nav nav-pills nav-fill" role="tablist">
                                    <li class="nav-item">
                                        <a class="nav-link active" id="signin-tab" data-toggle="tab" href="#signin" role="tab" aria-controls="signin" aria-selected="true">Sign In</a>
                                    </li>
                                    <li class="nav-item">
                                        <a class="nav-link" id="register-tab" data-toggle="tab" href="#register" role="tab" aria-controls="register" aria-selected="false">Register</a>
                                    </li>
                                </ul>
                                <div class="tab-content" id="tab-content-5">
                                    <div class="tab-pane fade show active" id="signin" role="tabpanel" aria-labelledby="signin-tab">
                                        <form action="#">
                                            <div class="form-group">
                                                <label for="singin-email">Username or email address *</label>
                                                <input type="text" class="form-control" id="singin-email" name="singin-email" required>
                                            </div><!-- End .form-group -->

                                            <div class="form-group">
                                                <label for="singin-password">Password *</label>
                                                <input type="password" class="form-control" id="singin-password" name="singin-password" required>
                                            </div><!-- End .form-group -->

                                            <div class="form-footer">
                                                <button type="submit" class="btn btn-outline-primary-2">
                                                    <span>LOG IN</span>
                                                    <i class="icon-long-arrow-right"></i>
                                                </button>

                                                <div class="custom-control custom-checkbox">
                                                    <input type="checkbox" class="custom-control-input" id="signin-remember">
                                                    <label class="custom-control-label" for="signin-remember">Remember Me</label>
                                                </div><!-- End .custom-checkbox -->

                                                <a href="#" class="forgot-link">Forgot Your Password?</a>
                                            </div><!-- End .form-footer -->
                                        </form>
                                        <div class="form-choice">
                                            <p class="text-center">or sign in with</p>
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <a href="#" class="btn btn-login btn-g">
                                                        <i class="icon-google"></i>
                                                        Login With Google
                                                    </a>
                                                </div><!-- End .col-6 -->
                                                <div class="col-sm-6">
                                                    <a href="#" class="btn btn-login btn-f">
                                                        <i class="icon-facebook-f"></i>
                                                        Login With Facebook
                                                    </a>
                                                </div><!-- End .col-6 -->
                                            </div><!-- End .row -->
                                        </div><!-- End .form-choice -->
                                    </div><!-- .End .tab-pane -->
                                    <div class="tab-pane fade" id="register" role="tabpanel" aria-labelledby="register-tab">
                                        <form action="#">
                                            <div class="form-group">
                                                <label for="register-email">Your email address *</label>
                                                <input type="email" class="form-control" id="register-email" name="register-email" required>
                                            </div><!-- End .form-group -->

                                            <div class="form-group">
                                                <label for="register-password">Password *</label>
                                                <input type="password" class="form-control" id="register-password" name="register-password" required>
                                            </div><!-- End .form-group -->

                                            <div class="form-footer">
                                                <button type="submit" class="btn btn-outline-primary-2">
                                                    <span>SIGN UP</span>
                                                    <i class="icon-long-arrow-right"></i>
                                                </button>

                                                <div class="custom-control custom-checkbox">
                                                    <input type="checkbox" class="custom-control-input" id="register-policy" required>
                                                    <label class="custom-control-label" for="register-policy">I agree to the <a href="#">privacy policy</a> *</label>
                                                </div><!-- End .custom-checkbox -->
                                            </div><!-- End .form-footer -->
                                        </form>
                                        <div class="form-choice">
                                            <p class="text-center">or sign in with</p>
                                            <div class="row">
                                                <div class="col-sm-6">
                                                    <a href="#" class="btn btn-login btn-g">
                                                        <i class="icon-google"></i>
                                                        Login With Google
                                                    </a>
                                                </div><!-- End .col-6 -->
                                                <div class="col-sm-6">
                                                    <a href="#" class="btn btn-login  btn-f">
                                                        <i class="icon-facebook-f"></i>
                                                        Login With Facebook
                                                    </a>
                                                </div><!-- End .col-6 -->
                                            </div><!-- End .row -->
                                        </div><!-- End .form-choice -->
                                    </div><!-- .End .tab-pane -->
                                </div><!-- End .tab-content -->
                            </div><!-- End .form-tab -->
                        </div><!-- End .form-box -->
                    </div><!-- End .modal-body -->
                </div><!-- End .modal-content -->
            </div><!-- End .modal-dialog -->
        </div><!-- End .modal -->

        <!-- Plugins JS File -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/jquery.hoverIntent.min.js"></script>
        <script src="assets/js/jquery.waypoints.min.js"></script>
        <script src="assets/js/superfish.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <script src="assets/js/bootstrap-input-spinner.js"></script>
        <!-- Main JS File -->
        <script src="assets/js/main.js"></script>
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <script>
                                                        // Get all elements with class="closebtn"
                                                        var close = document.getElementsByClassName("closebtn");
                                                        var i;

                                                        // Loop through all close buttons
                                                        for (i = 0; i < close.length; i++) {
                                                            // When someone clicks on a close button
                                                            close[i].onclick = function () {

                                                                // Get the parent of <span class="closebtn"> (<div class="alert">)
                                                                var div = this.parentElement;

                                                                // Set the opacity of div to 0 (transparent)
                                                                div.style.opacity = "0";

                                                                // Hide the div after 600ms (the same amount of milliseconds it takes to fade out)
                                                                setTimeout(function () {
                                                                    div.style.display = "none";
                                                                }, 600);
                                                            }
                                                        }
        </script>
    </body>


    <style>
        .alert2 {
            padding: 20px;
            background-color: #f44336; /* Red */
            color: white;
            margin-bottom: 15px;
        }

        /* The close button */
        .closebtn {
            margin-left: 15px;
            color: white;
            font-weight: bold;
            float: right;
            font-size: 22px;
            line-height: 20px;
            cursor: pointer;
            transition: 0.3s;
        }

        /* When moving the mouse over the close button */
        .closebtn:hover {
            color: black;
        }

    </style>

    <style>
        .alert {
            opacity: 1;
            transition: opacity 0.6s; /* 600ms to fade out */
        }
    </style>
    <!-- molla/cart.html  22 Nov 2019 09:55:06 GMT -->
</html>