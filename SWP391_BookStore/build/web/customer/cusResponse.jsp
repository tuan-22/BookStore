<%@page import="com.bookstore.Book.BookDAO"%>
<%@page import="com.bookstore.Cart.Cart"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.bookstore.Order.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.bookstore.Order.OrderDAO"%>
<%@page import="com.bookstore.Cart.Config"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="com.bookstore.Account.Account"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>\
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">


    <!-- molla/checkout.html  22 Nov 2019 09:55:06 GMT -->
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
                                                                <!--href giúp truy?n ???ng d?n--> 
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
                               if ("00".equals(request.getParameter("vnp_ResponseCode"))) {
                                   
                                   List<Cart> cart = null;
                                    session.setAttribute("cart", cart);
                                } else {
                                    
                                }
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
                        <h1 class="page-title">Checkout<span>Shop</span></h1>
                    </div><!-- End .container -->
                </div><!-- End .page-header -->
                <nav aria-label="breadcrumb" class="breadcrumb-nav">
                    <div class="container">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="index.html">Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Shop</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Checkout</li>
                        </ol>
                    </div><!-- End .container -->
                </nav><!-- End .breadcrumb-nav -->

                <%
                    //Begin process return from VNPAY
                    Map fields = new HashMap();
                    for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
                        String fieldName = (String) params.nextElement();
                        String fieldValue = request.getParameter(fieldName);
                        if ((fieldValue != null) && (fieldValue.length() > 0)) {
                            fields.put(fieldName, fieldValue);
                        }
                    }

                    String vnp_SecureHash = request.getParameter("vnp_SecureHash");
                    if (fields.containsKey("vnp_SecureHashType")) {
                        fields.remove("vnp_SecureHashType");
                    }
                    if (fields.containsKey("vnp_SecureHash")) {
                        fields.remove("vnp_SecureHash");
                    }
                    String signValue = Config.hashAllFields(fields);

                %>
                <div class="page-content">
                    <div class="checkout">
                        <div class="container">

                            <form action="payment" method="post">

                                <div class="row">
                                    <div class="col-lg-9">
                                        <h2 class="checkout-title">Bill Responce</h2><!-- End .checkout-title -->
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <label>OrderID:</label>
                                                <input type="text" value="<%=request.getParameter("vnp_TxnRef")%>" class="form-control" readonly>
                                            </div><!-- End .col-sm-6 -->

                                            <div class="col-sm-6">
                                                <label>Total Price:</label>
                                                <input type="email" value="<%=Integer.parseInt(request.getParameter("vnp_Amount"))/100%>" class="form-control" readonly>
                                            </div><!-- End .col-sm-6 -->
                                        </div><!-- End .row -->

                                        <label>Transaction code:</label>
                                        <input type="text" value="<%=request.getParameter("vnp_TransactionNo")%>" class="form-control" name="txtAddress" readonly >
                                        <label>Order Information:</label>
                                        <input type="text" value="<%=request.getParameter("vnp_OrderInfo")%>" class="form-control" name="txtAddress" readonly >

                                        <div class="row">

                                            <div class="col-sm-6">
                                                <label>Paymnet Time:</label>
                                                <input type="tel" class="form-control" value="<%=request.getParameter("vnp_PayDate")%>" readonly>
                                            </div><!-- End .col-sm-6 -->
                                        </div><!-- End .row -->

                                        <label>Result:</label>
                                        <label>
                                            <%
                                                    if ("00".equals(request.getParameter("vnp_ResponseCode"))) {
                                                        
                                                        OrderDAO odao = new OrderDAO();
                                                        List<Order> list = odao.getOrderManage();
                                                        
                                                        
                                                        int orderID = Integer.parseInt(request.getParameter("vnp_TxnRef"));

                                                        Account account = (Account) session.getAttribute("acc");
                                                        int accountID = account.getAccID();
                                                        
                                                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
                                                        LocalDateTime now = LocalDateTime.now();
                                                        String orderDate = dtf.format(now);
                                                        
                                                        String address = (String) session.getAttribute("tempAddress");
                                                        
                                                        List<Cart> cart = (List<Cart>) session.getAttribute("tempcart");
                                                        int total = Integer.parseInt(request.getParameter("vnp_Amount"))/100;
                                                        
                                                        String note = (String) session.getAttribute("tempNote");
                                                        
                                                        if (note.equals("")) {
                                                            note = "(empty)";
                                                        }

                                                        String status = "confirming";
                                                        
                                                        odao.addNewOrder(orderID, accountID, orderDate, address, total, note, status);
                                                        
                                                        for (Cart c : cart) {
                                                            // lay id tiep theo trong orderDetail
                                                            List<Order> list2 = odao.getOrderDetailManage();
                                                            // gan id
                                                            int oDetailID=1;
                                                            if (list2.size() > 0) {
                                                                int lastOrderDetailID;
                                                                int sizeList2 = list2.size() - 1;
                                                                lastOrderDetailID = (int) (list2.get(sizeList2).getoDetailID() + 1);
                                                                oDetailID=lastOrderDetailID;
                                                            }
                                                            
                                                            // lay ma sach
                                                            long bookCode = c.getBook().getBookCode();
                                                            // lay quantity cua 1 quyen sach trong cart
                                                            int oDetailQty = c.getQty();
                                                            // lay gia sach
                                                            int buyPrice = c.getBuyPrice();
                                                            // sach chua dc danh gia
                                                            String statusFeed = "not yet";
                                                            //lay so luong 1 quyen sach trong cart
                                                            int quantityBookInCart = c.getQty();
                                                            //goi book dao
                                                            BookDAO bdao = new BookDAO();
                                                            //lay so luong sach co san trong kho
                                                            int quanityBookAvailable = bdao.getQuantityByBookCode(bookCode);
                                                            //tinh so luong sach con lai trong kho sau khi thanh toan
                                                            int quanityBookAvailableAfter = quanityBookAvailable - quantityBookInCart;
                                                            //cap nhat so luong quyen sach do trong kho
                                                            bdao.updateQuantityBookByBookCode(quanityBookAvailableAfter, bookCode);
                                                            // in hoa don xuong database
                                                            odao.addNewOrderDetail(oDetailID, bookCode, oDetailQty, buyPrice, orderID, statusFeed);
                                                        }
                                                        // lam rong cart
                                                        cart = null;
                                                        // set cart lai
                                                        session.setAttribute("cart", cart);
                                                        out.print("<br><input type='tel' style='color: green;' class='form-control' value='Payment Successful!' readonly>");

                                                    } else {
                                                        out.print("<input type='tel' style='color: red;' class='form-control' value='Payment Fail!' readonly>");
                                                    }

                                            %></label>

                                       <br> <a href="cusorderhome" class="btn btn-outline-primary-2">
                                            <span>ORDER MANAGEMENT</span>
                                            <i class="icon-arrow-left"></i>
                                        </a>
                                    </div><!-- End .col-lg-9 -->



                                </div><!-- End .row -->
                            </form>

                        </div><!-- End .container -->
                    </div><!-- End .checkout -->
                </div><!-- End .page-content -->


            </main><!-- End .main -->

            <jsp:include page="cusFooter.jsp"></jsp:include>
        </div><!-- End .page-wrapper -->
        <button id="scroll-top" title="Back to Top"><i class="icon-arrow-up"></i></button>



        <!-- Plugins JS File -->
        <script src="assets/js/jquery.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/jquery.hoverIntent.min.js"></script>
        <script src="assets/js/jquery.waypoints.min.js"></script>
        <script src="assets/js/superfish.min.js"></script>
        <script src="assets/js/owl.carousel.min.js"></script>
        <!-- Main JS File -->
        <script src="assets/js/main.js"></script>
    </body>


    <!-- molla/checkout.html  22 Nov 2019 09:55:06 GMT -->
</html>