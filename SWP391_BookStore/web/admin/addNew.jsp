<%-- 
    Document   : addNewSeller
    Created on : Sep 27, 2022, 12:10:56 AM
    Author     : tramy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>THE5 BookStore</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
        <!-- Custom Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        
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

        <!--*******************
            Preloader start
        ********************-->
        <div id="preloader">
            <div class="loader">
                <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
                </svg>
            </div>
        </div>
        <!--*******************
            Preloader end
        ********************-->


        <!--**********************************
            Main wrapper start
        ***********************************-->
        <div id="main-wrapper">
            <jsp:include page="adHeader.jsp"></jsp:include>
                <!--**********************************
                    Sidebar start
                ***********************************-->
                <div class="nk-sidebar">           
                    <div class="nk-nav-scroll">
                        <ul class="metismenu" id="menu">
                            <li class="nav-label" style="background-color: #c96;">Hello Admin ${acc.getUsername()}</li>
                        <li>
                            <a href="home" aria-expanded="false">
                               <i class="fa fa-home"></i><span class="nav-text">Home</span>
                            </a>

                        </li>
                        <li>
                            <a href="adbook" aria-expanded="false">
                                <i class="icon-book-open"></i><span class="nav-text">Book Management</span>
                            </a>
                        </li>
                        <li>
                            <a href="addiscount" aria-expanded="false">
                                <i class="fa fa-percent"></i><span class="nav-text">Discount Management</span>
                            </a>
                        </li>
                        <li class="mega-menu mega-menu-sm">
                            <a href="adcustomer" aria-expanded="false">
                                <i class="icon-user"></i><span class="nav-text">Customer Management</span>
                            </a>

                        </li>
                        <c:if test='${role == "seller"}'>
                            <li>
                                <a class="active" href="adseller" aria-expanded="false">
                                    <i class="fa fa-cart-plus menu-icon"></i> <span class="nav-text">Seller Management</span>
                                </a>

                            </li>
                            <li>
                                <a  href="adimporter" aria-expanded="false">
                                    <i class="fa fa-arrow-circle-right menu-icon"></i><span class="nav-text">Importer Management</span>
                                </a>

                            </li>
                        </c:if>
                        <c:if test='${role == "importer"}'>
                            <li>
                                <a  href="adseller" aria-expanded="false">
                                    <i class="fa fa-cart-plus menu-icon"></i> <span class="nav-text">Seller Management</span>
                                </a>

                            </li>
                            <li>
                                <a class="active" href="adimporter" aria-expanded="false">
                                    <i class="fa fa-arrow-circle-right menu-icon"></i><span class="nav-text">Importer Management</span>
                                </a>

                            </li>
                        </c:if>


                        <li>
                            <a href="blacklist" aria-expanded="false">
                                <i class="icon-close"></i> <span class="nav-text">Blacklist Management</span>
                            </a>

                        </li>
                        <li>
                            <a href="feedback" aria-expanded="false">
                                <i class="icon-envelope menu-icon"></i><span class="nav-text">Feedback Management</span>
                            </a>

                        </li>
                        <li>
                            <a href="adprofit" aria-expanded="false">
                                <i class="fa fa-money menu-icon"></i><span class="nav-text">Profit Management</span>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
            <!--**********************************
                Sidebar end
            ***********************************-->
            <div class="content-body">
                <div class="row page-titles mx-0">
                    <div class="col p-md-0">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Home</li>
                                <c:if test='${role == "seller"}'>
                                <li class="breadcrumb-item ">Seller Management</li>

                            </c:if>
                            <c:if test='${role == "importer"}'>
                                <li class="breadcrumb-item ">Importer Management</li>
                                </c:if>


                            <c:if test='${role == "seller"}'>
                                <li class="breadcrumb-item active">Add New Seller</li>

                            </c:if>
                            <c:if test='${role == "importer"}'>
                                <li class="breadcrumb-item active">Add New Importer</li>
                                </c:if>
                        </ol>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <c:if test='${role == "seller"}'>
                                        <h4 class="card-title">Add New Seller</h4>
                                    </c:if>
                                    <c:if test='${role == "importer"}'>
                                        <h4 class="card-title">Add New Importer</h4>
                                    </c:if>
                                    <c:if test='${temMess == "This username already existed!"}'>
                                        <h5  style="color: red ;">${temMess}</h5>
                                    </c:if>
                                    <c:if test='${temMess == "This email is registered!"}'>
                                        <h5 style="color: red" >${temMess}</h5>
                                    </c:if>
                                    <div class="basic-form">
                                        <c:if test='${role == "seller"}'>
                                            <form action="addnewseller" method="POST">
                                            </c:if>
                                            <c:if test='${role == "importer"}'>
                                                <form action="addnewimp" method="POST" onsubmit="return myfun()">
                                                </c:if>


                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Email</label>
                                                    <div class="col-sm-10">
                                                        <input type="email" name="email" class="form-control" placeholder="Email" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Username</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="username" class="form-control" placeholder="Username" required>
                                                    </div>
                                                </div>
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Phone</label>
                                                    <div class="col-sm-10">
                                                        <input id="phone" type="number" name="phone" class="form-control" placeholder="Phone" onkeyup=" return validatephone(this.value); " required>
                                                    </div>
                                                </div>


                                                <div class="form-group row">
                                                    <div class="col-sm-10">
                                                        <div class="basic-form">
                                                            <c:if test='${role == "seller"}'>
                                                                <input type="hidden" name="rolename" class="form-control" value="seller">
                                                                <button type="submit" class="btn mb-1 btn-warning">Add New Seller</button>
                                                            </c:if>
                                                            <c:if test='${role == "importer"}'>
                                                                <input type="hidden" name="rolename" class="form-control" value="importer">
                                                                <button type="submit" class="btn mb-1 btn-warning">Add New Importer</button>
                                                            </c:if>

                                                        </div>
                                                    </div>
                                            </form>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
                <!-- #/ container -->
            </div>
            <!--**********************************
                Content body end
            ***********************************-->



        </div>
        <!--**********************************
            Main wrapper end
        ***********************************-->

        <!--**********************************
            Scripts
        ***********************************-->
        <script src="plugins/common/common.min.js"></script>
        <script src="js/custom.min.js"></script>
        <script src="js/settings.js"></script>
        <script src="js/gleek.js"></script>
        <script src="js/styleSwitcher.js"></script>

    </body>

</html>
