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

            <!--**********************************
                Content body start
            ***********************************-->
            <div class="content-body">
                <div class="row page-titles mx-0">
                    <div class="col p-md-0">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Home</li>
                            <li class="breadcrumb-item active">Receipt Management</li>
                        </ol>
                    </div>
                </div>


                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <span class="card-title">Receipt Management</span>
                                    <br>
                                    <c:if test='${check!=null}'>
                                        <div class="alert alert-success">${check}</div>
                                    </c:if>
                                    <c:if test='${temptemp!=null}'>
                                        <div class="alert alert-success">${temptemp}</div>
                                    </c:if>

                                    <a href="impaddnav" style="margin-top: 10px"><button  class="btn btn-outline-dark" >Add New Receipt</button></a>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered zero-configuration">
                                            <thead>
                                                <tr>
                                                    <th>Receipt ID</th>
                                                    <th>Company Name</th>
                                                    <th>Employee</th>
                                                    <th>Receipt Date</th>
                                                    <th>Total Imported Price</th> 
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items ="${listR}" var="r">
                                                    <tr>
                                                        <td>${r.receiptID}</td>
                                                        <td>${r.companyName}</td> 
                                                        <td>${r.accName}</td> 
                                                        <td>${r.orderDate}</td>
                                                        
                                                        <td><fmt:formatNumber value="${r.totalImportPrice}" pattern=" #,##0 VND" /></td>
                                                        
                                                        <td><a href="receiptDetail?id=${r.receiptID}"><i class="icon-eye menu-icon"></i></a></td>
                                                    </tr>
                                                </c:forEach>

                                            </tbody>

                                        </table>
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
        <script>
                                                                    $(document).ready(function () {
                                                                        // Activate tooltip
                                                                        $('[data-toggle="tooltip"]').tooltip();

                                                                        // Select/Deselect checkboxes
                                                                        var checkbox = $('table tbody input[type="checkbox"]');
                                                                        $("#selectAll").click(function () {
                                                                            if (this.checked) {
                                                                                checkbox.each(function () {
                                                                                    this.checked = true;
                                                                                });
                                                                            } else {
                                                                                checkbox.each(function () {
                                                                                    this.checked = false;
                                                                                });
                                                                            }
                                                                        });
                                                                        checkbox.click(function () {
                                                                            if (!this.checked) {
                                                                                $("#selectAll").prop("checked", false);
                                                                            }
                                                                        });
                                                                    });

                                                                    function showMess(id) {
                                                                        var option = confirm("Are you sure to remove the publish company have id = " + id + " to BlackList ?");
                                                                        if (option === true) {
                                                                            window.location.href = "removeComp?companyID=" + id;
                                                                        }
                                                                    }
        </script>

    </body>

</html>
