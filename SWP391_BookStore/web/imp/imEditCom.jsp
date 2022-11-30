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
            <jsp:include page="imHeader.jsp"></jsp:include>
                <!--**********************************
                    Sidebar start
                ***********************************-->
                <div class="nk-sidebar">           
                    <div class="nk-nav-scroll">
                        <ul class="metismenu" id="menu">
                            <li class="nav-label" style="background-color: #c96;">Hello Importer ${acc.getUsername()}</li>
                        <li>
                            <a href="pcompany" aria-expanded="false">
                                <i class="icon-speedometer menu-icon"></i><span class="nav-text">Publish Company</span>
                            </a>

                        </li>
                        <li>
                            <a href="listReceipt" aria-expanded="false">
                                <i class="icon-book-open"></i><span class="nav-text">Receipt Management</span>
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
                            <li class="breadcrumb-item ">Publish Company Management</li>

                            <li class="breadcrumb-item active">Edit Publish Company</li>
                        </ol>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">

                                    <h4 class="card-title">Edit Publish Company</h4>
                                    <c:if test='${check != null&&check!="Edit Publish Company successful!"}'>
                                        <div class="alert alert-danger">${check}</div>
                                    </c:if>
                                    <c:if test='${check=="Edit Publish Company successful!"}'>
                                        <div class="alert alert-success">${check}</div>
                                    </c:if>




                                    <div class="basic-form">
                                        <form action="imEditCompany" method="POST">
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">CompanyID</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="id" class="form-control" placeholder="id" value="${com.getCompanyID()}" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Company Name</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="name" class="form-control" placeholder="name" value="${com.getCompanyName()}" required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Address</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="add" class="form-control" placeholder="address" value="${com.getComAddress()}" required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Phone</label>
                                                <div class="col-sm-10">
                                                    <input type="number" name="phone" class="form-control" placeholder="Phone" value="${com.getPhone()}" required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Email</label>
                                                <div class="col-sm-10">
                                                    <input type="email" name="mail" class="form-control" placeholder="Phone" value="${com.getComEmail()}" required>
                                                </div>
                                            </div>

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
