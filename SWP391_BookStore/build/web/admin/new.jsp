<%-- 
    Document   : adImporter
    Created on : Sep 26, 2022, 11:51:04 AM
    Author     : tramy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
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
        <link href="./plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

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
                                <i class="icon-speedometer menu-icon"></i><span class="nav-text">Dashboard</span>
                            </a>

                        </li>
                        <li>
                            <a href="adbook" aria-expanded="false">
                                <i class="icon-book-open"></i><span class="nav-text">Book Management</span>
                            </a>
                        </li>
                        <li>
                            <a href="widgets.html" aria-expanded="false">
                                <i class="icon-pencil"></i><span class="nav-text">Author Management</span>
                            </a>
                        </li>
                        <li class="mega-menu mega-menu-sm">
                            <a href="adcustomer" aria-expanded="false">
                                <i class="icon-user "></i><span class="nav-text">Customer Management</span>
                            </a>

                        </li>
                        <li>
                            <a href="adseller" aria-expanded="false">
                                <i class="fa fa-cart-plus menu-icon"></i> <span class="nav-text">Seller Management</span>
                            </a>

                        </li>
                        <li>
                            <a href="adimporter" aria-expanded="false">
                                <i class="fa fa-arrow-circle-right menu-icon"></i><span class="nav-text">Importer Management</span>
                            </a>

                        </li>
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
                            <a href="widgets.html" aria-expanded="false">
                                <i class="fa fa-money menu-icon"></i><span class="nav-text">Profit Management</span>
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
                            <li class="breadcrumb-item active">Importer Management</li>
                        </ol>
                    </div>
                </div>


                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Data Table</h4>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered zero-configuration">
                                            <thead>
                                                <tr>
                                                    <th>Book Code</th>
                                                    <th>Book Name</th>
                                                    <th>Image</th>
                                                    <th>Author</th>
                                                    <th>Publish Company</th>
                                                    <th>Quantity</th>
                                                    <th>Description</th>
                                                    <th>Imported Price</th>
                                                    <th>Sale Price</th>
                                                    <th>Post Status</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <c:forEach items="${listB}" var="b">
                                                <tbody>
                                                    <tr>
                                                        <td>${b.bookCode}</td>
                                                        <td>${b.bookName}</td>
                                                        <td><img class="card-img-top" src="${b.image}" alt="Card image cap"></td>
                                                        <td>
                                                            <c:forTokens var="token" items="${b.authorName}" delims=",">
                                                    <li><span style="color : #c96;">- </span><c:out value="${token}"/><li>
                                                            </c:forTokens>
                                                            
                                                        </td>
                                                        <td>${b.companyName}</td>
                                                        <td>${b.qty}</td>
                                                        <td>

                                                            ${fn:substring(b.description, 0, 20 )}... </br>

                                                            <input type="button" id="btn1-${b.bookCode}" value="Hide"/>
                                                            <input type="button" id="btn2-${b.bookCode}" value="Show All"/>
                                                            <div id="b-${b.bookCode}" style="border: solid 1px; padding: 20px; background: #ddd;">
                                                                ${b.description}
                                                                <script>
                                                                        document.getElementById("b-${b.bookCode}").style.display = 'none';
                                                                </script>
                                                                <br/>

                                                                <script language="javascript">
                                                                 document.getElementById("btn1-${b.bookCode}").onclick = function () {
                                                                     document.getElementById("b-${b.bookCode}").style.display = 'none';
                                                                 };

                                                                 document.getElementById("btn2-${b.bookCode}").onclick = function () {
                                                                     document.getElementById("b-${b.bookCode}").style.display = 'block';
                                                                 };
                                                                </script> 
                                                            </div> 
                                                        </td>
                                                        <td>${b.importPrice}</td>
                                                        <td>${b.buyPrice}</td>
                                                        <td>
                                                            <c:if test="${b.postName == 'posted'}">
                                                                <span class="badge badge-success px-2">Posted</span>
                                                            </c:if>
                                                            <c:if test="${b.postName == 'new'}">
                                                                <span class="badge badge-danger px-2">New</span>
                                                            </c:if>
                                                        </td>
                                                        <td>
                                                            <a style="margin-left: 43px ;" href="" class="fa fa-minus-circle"></a>

                                                        </td>


                                                    </tr>
                                                </tbody>

                                            </c:forEach>
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

        <script src="./plugins/tables/js/jquery.dataTables.min.js"></script>
        <script src="./plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
        <script src="./plugins/tables/js/datatable-init/datatable-basic.min.js"></script>
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
                                                                         var option = confirm("Are you sure to add Import Manager have id = " + id + " to BlackList ?");
                                                                         if (option === true) {
                                                                             window.location.href = "addBlacklist?page=importer&id=" + id;
                                                                         }
                                                                     }
        </script>

    </body>

</html>
