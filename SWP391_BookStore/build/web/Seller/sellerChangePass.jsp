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
        <link rel="icon" type="image/png" sizes="16x16" href="../admin/images/favicon.png">
        <!-- Custom Stylesheet -->
        <link href="../admin/css/style.css" rel="stylesheet">

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
            <jsp:include page="sellerHeader.jsp"></jsp:include>
                <!--**********************************
                    Sidebar start
                ***********************************-->
                <div class="nk-sidebar">           
                    <div class="nk-nav-scroll">
                        <ul class="metismenu" id="menu">
                            <li class="nav-label" style="background-color: #c96;">Hello Admin ${acc.getUsername()}</li>
                        
                        <li class="mega-menu mega-menu-sm">
                            <a href="sellerOrder" aria-expanded="false">
                                <i class="icon-list"></i><span class="nav-text">Order Management</span>
                            </a>

                        </li>
                        <li class="mega-menu mega-menu-sm">
                        <a href="sellerReturn" aria-expanded="false">
                            <i class="icon-list"></i><span class="nav-text">Return Management</span>
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
                            <li class="breadcrumb-item ">My Account</li>
                            <a href="sellerProfile"><li class="breadcrumb-item ">Profile</li></a>
                            <li class="breadcrumb-item active">Change Password</li>
                        </ol>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">

                                    <h4 class="card-title">Change Password</h4>
                                    <c:if test='${check == "Password update success!"}'>
                                        <div class="alert alert-success">${check}</div>
                                        
                                    </c:if>
                                    <c:if test='${check == "Confirm password do not match!!!"}'>
                                        <div class="alert alert-danger">${check}</div>
                                    </c:if>
                                    <c:if test='${check == "Current password incorrect!!!"}'>
                                        <div class="alert alert-danger">${check}</div>
                                    </c:if>



                                    <div class="basic-form">
                                        <form action="sellerChangePass" method="POST">
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Current Password:</label>
                                                <div class="col-sm-10">
                                                    <input type="password" name="txtCurrentPassword" class="form-control" placeholder="Current Password"  required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">New Password:</label>
                                                <div class="col-sm-10">
                                                    <input type="password" name="txtNewPassword" class="form-control" placeholder="New Password"  required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Confirm Password:</label>
                                                <div class="col-sm-10">
                                                    <input type="password" name="txtComfirmPassword" class="form-control" placeholder="Confirm Password" required>
                                                </div>
                                            </div>

                                            <input type="hidden" name="accID" class="form-control" value="${acc.getAccID()}" required>

                                            <div class="form-group row">
                                                <div class="col-sm-10">
                                                    <div class="basic-form">
                                                        <button type="submit" class="btn mb-1 btn-warning" ><span style="margin-left: 23px;margin-right: 22px">Save Change</span></button>
                                                    </div>

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
        <script src="../admin/plugins/common/common.min.js"></script>
        <script src="../admin/js/custom.min.js"></script>
        <script src="../admin/js/settings.js"></script>
        <script src="../admin/js/gleek.js"></script>
        <script src="../admin/js/styleSwitcher.js"></script>

    </body>

</html>
