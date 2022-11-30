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
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <script>
            function myfun() {
                var a = document.getElementById("phone").value;
                if (a.length < 10) {
                    alert("Phone number must be 10 digit!");
                    return false;

                }
                if (a.length > 10) {
                    alert("Phone number must be 10 digit!");
                    return false;

                }
            }

            function validatephone(phone)
            {

                phone = phone.replace(/[^0-9]/g, '');
                $("#phone").val(phone);
                if (phone == '' || !phone.match(/^0[0-9]{9}$/))
                {
                    $("#phone").css({'background': '#FFEDEF', 'border': 'solid 1px red'});

                    return false;
                } else
                {
                    $("#phone").css({'background': '#99FF99', 'border': 'solid 1px #99FF99'});
                    return true;
                }
            }
        </script>
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
                            </ol>
                        </div><!-- End .container -->
                    </nav><!-- End .breadcrumb-nav -->

                    <div class="login-page bg-image pt-8 pb-8 pt-md-12 pb-md-12 pt-lg-17 pb-lg-17" style="background-image: url('assets/images/backgrounds/login-bg.jpg')">
                        <div class="container">
                            <div class="form-box">
                                <div class="form-tab">
                                    <ul class="nav nav-pills nav-fill" role="tablist">
                                        <li class="nav-item">
                                            <a class="nav-link active" id="signin-tab-2" href="register.jsp">Sign Up</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" id="register-tab-2" href="login.jsp">Sign In</a>
                                        </li>
                                    </ul>
                                    <div class="tab-content">
                                        <div class="tab-pane fade show active" id="register-2" role="tabpanel" aria-labelledby="register-tab-2">

                                            <form action="register" method="POST" onsubmit="return myfun()">

                                            <c:if test='${mess !=null}'>
                                                <label for="singin-email-2" style="color: red;">${mess}</label>
                                            </c:if>

                                            <div class="form-group">
                                                <label for="register-email-2">Your email address *</label>
                                                <c:if test='${mess == "Username alreadly existed!"}'>
                                                    <input type="email" class="form-control" id="register-email-2" name="email" value='${email}' required>
                                                </c:if>
                                                <c:if test='${mess == null}'>
                                                    <input type="email" class="form-control" id="register-email-2" name="email" required>
                                                </c:if>
                                                <c:if test='${mess == "Confirmation password is incorrect!"}'>
                                                    <input type="email" class="form-control" id="register-email-2" name="email" value='${email}' required>
                                                </c:if>
                                                <c:if test='${mess == "Email was registered!"}'>
                                                    <input type="email" class="form-control" id="register-email-2" name="email" required>
                                                </c:if>
                                                <c:if test='${mess == "Phone Number alreadly used!"}'>
                                                    <input type="email" class="form-control" id="register-email-2" name="email" value='${email}' required>

                                                </c:if>

                                            </div><!-- End .form-group -->

                                            <div class="form-group">
                                                <label for="register-password-2">Username *</label>
                                                <c:if test='${mess == "Username alreadly existed!"}'>
                                                    <input type="text" class="form-control" id="register-password-2" name="username" required>
                                                </c:if>
                                                <c:if test='${mess == null}'>
                                                    <input type="text" class="form-control" id="register-password-2" name="username" required>
                                                </c:if>
                                                <c:if test='${mess == "Confirmation password is incorrect!"}'>
                                                    <input type="text" class="form-control" id="register-password-2" name="username" value='${username}' required>
                                                </c:if>
                                                <c:if test='${mess == "Email was registered!"}'>
                                                    <input type="text" class="form-control" id="register-password-2" name="username" value='${username}' required>
                                                </c:if>

                                                <c:if test='${mess == "Phone Number alreadly used!"}'>
                                                    <input type="text" class="form-control" id="register-password-2" name="username" value='${username}' required>
                                                </c:if>

                                            </div><!-- End .form-group -->
                                            <div class="form-group">
                                                <label for="register-password-2">Phone Number *</label>
                                                <c:if test='${mess == null}'>
                                                    <input id="phone" type="number" class="form-control" id="register-password-2" name="phone" required onkeyup=" return validatephone(this.value); ">
                                                </c:if>
                                                <c:if test='${mess == "Username alreadly existed!"}'>
                                                    <input id="phone" type="number" class="form-control" id="register-password-2" name="phone" value='${phone}' onkeyup=" return validatephone(this.value); " required>
                                                </c:if>

                                                <c:if test='${mess == "Confirmation password is incorrect!"}'>
                                                    <input id="phone" type="number" class="form-control" id="register-password-2" name="phone" value='${phone}' onkeyup=" return validatephone(this.value); " required>
                                                </c:if>
                                                <c:if test='${mess == "Email was registered!"}'>
                                                    <input id="phone" type="number" class="form-control" id="register-password-2" name="phone" value='${phone}' onkeyup=" return validatephone(this.value); " required>
                                                </c:if>

                                                <c:if test='${mess == "Phone Number alreadly used!"}'>
                                                    <input id="phone" type="number" class="form-control" id="register-password-2" name="phone" required>
                                                </c:if>



                                            </div><!-- End .form-group -->

                                            <div class="form-group">
                                                <label for="register-password-2">Password *</label>
                                                <c:if test='${mess == null}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="password" required>
                                                </c:if>
                                                <c:if test='${mess != null}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="password" value='${pass}' required>
                                                </c:if>

                                            </div><!-- End .form-group -->
                                            <div class="form-group">
                                                <label for="register-password-2">Confirm Password *</label>
                                                <c:if test='${mess == "Username alreadly existed!"}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="confirm-password" value='${confirm}' required>
                                                </c:if>
                                                <c:if test='${mess == null}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="confirm-password" required>                                                </c:if>
                                                <c:if test='${mess == "Confirmation password is incorrect!"}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="confirm-password" required>
                                                </c:if>
                                                <c:if test='${mess == "Email was registered!"}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="confirm-password" value='${confirm}' required>
                                                </c:if>
                                                <c:if test='${mess == "Username was existed!"}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="confirm-password" value='${confirm}' required>
                                                </c:if>
                                                <c:if test='${mess == "Phone Number alreadly used!"}'>
                                                    <input type="password" class="form-control" id="register-password-2" name="confirm-password" value='${confirm}' required>

                                                </c:if>

                                            </div><!-- End .form-group -->

                                            <div class="form-footer">
                                                <button type="submit" class="btn btn-outline-primary-2">
                                                    <span>SIGN UP</span>
                                                    <i class="icon-long-arrow-right"></i>
                                                </button>
                                                <div class="custom-control custom-checkbox">

                                                </div><!-- End .custom-checkbox -->

                                                <a href="loginnav" class="forgot-link">Back to Login</a>


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