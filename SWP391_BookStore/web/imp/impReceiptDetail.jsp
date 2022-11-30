<%-- 
    Document   : adImporter
    Created on : Sep 26, 2022, 11:51:04 AM
    Author     : tramy
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
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
        <link href="../admin/plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet">
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
                            <li class="nav-label" style="background-color: #c96;">Hello Seller ${acc.getUsername()}</li>
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

            <!--**********************************
                Content body start
            ***********************************-->
            <div class="content-body">

                <div class="row page-titles mx-0">
                    <div class="col p-md-0">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Home</li>

                            <li class="breadcrumb-item "><a href="sellerOrder">Receipt Management</a></li>
                            <li class="breadcrumb-item active">Receipt Detail</li>

                        </ol>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <span class="card-title">Receipt Detail</span>

                                    <c:if test='${mess!=null}'>
                                        <div class="alert alert-success">${mess}</div>
                                    </c:if>

                                    <div class="form-group row" style="margin-top: 10px">
                                        <label class="col-sm-2 col-form-label">Receipt ID:</label>
                                        <div class="col-sm-10">
                                            <input type="type" name="text" class="form-control" value='${receipt.receiptID}' readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Publish Company Name:</label>
                                        <div class="col-sm-10">
                                            <input type="type" name="text" class="form-control" value='${receipt.companyName}'  readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Importer Name:</label>
                                        <div class="col-sm-10">
                                            <input type="email" name="email" class="form-control" value='${receipt.accName}'  readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Receipted Date</label>
                                        <div class="col-sm-10">
                                            <input type="type" name="text" class="form-control"  value='${receipt.orderDate}' readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Total Imported Price</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="email" class="form-control" value='${receipt.totalImportPrice}VND'  readonly>
                                        </div>
                                    </div>

                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered zero-configuration">
                                            <thead>
                                                <tr>
                                                    <th>Detail ID</th>
                                                    <th>BookCode</th>
                                                    <th>BookName</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listD}" var="o">
                                                <tr>
                                                    <td>${o.rdID}</td>
                                                    <td>${o.bookcode}</td>
                                                    <td>${o.bookName}</td>
                                                    <td>${o.qty}</td>
                                                    <td><fmt:formatNumber value="${o.price}" pattern=" #,##0 VND" /></td>
                                                </tr>
                                                
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                        <center>
                                        <a  href="listReceipt" class="btn mb-1 btn-warning">Close</a>
                                        </center>
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


            <!--**********************************
                Footer start
            ***********************************-->

            <!--**********************************
                Footer end
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

        <script src="../admin/plugins/tables/js/jquery.dataTables.min.js"></script>
        <script src="../admin/plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
        <script src="../admin/plugins/tables/js/datatable-init/datatable-basic.min.js"></script>

    </body>

</html>
