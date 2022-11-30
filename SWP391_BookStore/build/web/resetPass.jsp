<%-- 
    Document   : login
    Created on : Sep 19, 2022, 6:16:47 PM
    Author     : tramy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">


    <!-- molla/login.html  22 Nov 2019 10:04:03 GMT -->
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Molla - Bootstrap eCommerce Template</title>
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
            <jsp:include page="header.jsp"></jsp:include>
                <main class="main">

                    <nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
                        <div class="container">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="home.jsp">Home</a></li>
                                <li class="breadcrumb-item active" aria-current="page">Login</li>
                                <li class="breadcrumb-item active" aria-current="page">Forgot Password</li>
                            </ol>
                        </div><!-- End .container -->
                    </nav><!-- End .breadcrumb-nav -->

                    <div class="login-page bg-image pt-8 pb-8 pt-md-12 pb-md-12 pt-lg-17 pb-lg-17" style="background-image: url('assets/images/backgrounds/login-bg.jpg')">
                        <div class="container">
                            <div class="form-box">
                                <div class="form-tab">
                                    <ul class="nav nav-pills nav-fill" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link" id="signin-tab-2" data-toggle="tab" role="tab" aria-controls="signin-2" aria-selected="false">Reset Password</a>
                                        </li>

                                    </ul>
                                    <div class="tab-content">

                                        <div class="tab-pane fade show active" id="register-2" role="tabpanel" aria-labelledby="register-tab-2">
                                            <form action="reset" method="post">
                                                <c:if test='${mess == "Confirmation password is incorrect!"}'>
                                                    <label for="singin-email-2" style="color: red;">${mess}</label>
                                                </c:if>
                                                <div class="form-group">
                                                
                                                
                                                <label for="register-email-2">New Password *</label>
                                                <c:if test='${mess == "Confirmation password is incorrect!"}'>
                                                    <input type="password" class="form-control" id="register-email-2" name="pass" value='${pass}' required>
                                                </c:if>
                                                <c:if test='${mess == "no"}'>
                                                    <input type="password" class="form-control" id="register-email-2" name="pass"  required>
                                                </c:if>
                                                <div class="form-group">
                                            </div><!-- End .form-group -->
                                            <div class="form-group">
                                                <label for="register-password-2">Confirm Password *</label>
                                                 <c:if test='${mess == "no"}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="confirm-password" required> 
                                                 </c:if>
                                                <c:if test='${mess == "Confirmation password is incorrect!"}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="confirm-password" required>
                                                </c:if>
                                                    
                                                    <c:if test='${mess == "no"}'>
                                                    <input type="hidden" value='${userResetPass.getEmail()}' name='email'>
                                                 </c:if>
                                                    <c:if test='${mess == "Confirmation password is incorrect!"}'>
                                                    <input type="hidden" value='${email}' name='email'>
                                                 </c:if>
                                                    
                                                
                                            </div><!-- End .form-group -->


                                            <div class="form-footer">
                                                <button type="submit" class="btn btn-outline-primary-2">
                                                    <span>RESET</span>
                                                    <i class="icon-long-arrow-right"></i>
                                                </button>

                                                <div class="custom-control custom-checkbox">

                                                </div><!-- End .custom-checkbox -->

                                                <a href="login.jsp" class="forgot-link">Back to Login</a>
                                            </div><!-- End .form-footer -->
                                        </form>
                                    </div><!-- .End .tab-pane -->
                                </div><!-- End .tab-content -->
                            </div><!-- End .form-tab -->
                        </div><!-- End .form-box -->
                    </div><!-- End .container -->
                </div><!-- End .login-page section-bg -->
            </main><!-- End .main -->

            <jsp:include page="footer.jsp"></jsp:include>
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


    <!-- molla/login.html  22 Nov 2019 10:04:03 GMT -->
</html>