<%-- 
    Document   : adImporter
    Created on : Sep 26, 2022, 11:51:04 AM
    Author     : tramy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
                               <i class="fa fa-home"></i><span class="nav-text">Home</span>
                            </a>

                        </li>
                        <li>
                            <a class="active" href="adbook" aria-expanded="false">
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

                        <li>
                            <a  href="adseller" aria-expanded="false">
                                <i class="fa fa-cart-plus menu-icon"></i> <span class="nav-text">Seller Management</span>
                            </a>

                        </li>
                        <li>
                            <a  class="" href="adimporter" aria-expanded="false">
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

            <!--**********************************
                Content body start
            ***********************************-->
            <div class="content-body">
                <div class="row page-titles mx-0">
                    <div class="col p-md-0">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Home</li>
                            <li class="breadcrumb-item active">Book Management</li>
                        </ol>
                    </div>
                </div>


                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <span class="card-title">Book Management</span>
                                    <c:if test='${check != null}'>
                                        <div class="alert alert-success">${check}</div>
                                    </c:if>
                                        <form  action="AdbookFilter" style="margin-top:15px ">
                                    <label>Choose Status</label>
                                        <div class="input-group">
                                            <select name='postid' class="custom-select">
                                                <c:if test="${temp.equals('All')}">
                                                    <option selected="" value="All">All</option>
                                                    <option  value="1">Posted</option>
                                                    <option value="2">New</option>
                                                    <option value="4">Unpost</option>
                                                </c:if>
                                                <c:if test="${temp.equals('1')}">
                                                    <option value="All">All</option>
                                                    <option selected="" value="1">Posted</option>
                                                    <option value="2">New</option>
                                                    <option value="4">Unpost</option>
                                                </c:if>
                                                <c:if test="${temp.equals('2')}">
                                                    <option value="All">All</option>
                                                    <option  value="1">Posted</option>
                                                    <option selected="" value="2">New</option>
                                                    <option value="4">Unpost</option>
                                                </c:if>
                                                <c:if test="${temp.equals('4')}">
                                                    <option value="All">All</option>
                                                    <option  value="1">Posted</option>
                                                    <option value="2">New</option>
                                                    <option selected="" value="3">Unpost</option>
                                                </c:if>
                                                
                                            </select>
                                            <div class="input-group-append">
                                                <button class="btn btn-outline-dark" type="submit">Filter
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered zero-configuration">
                                            <thead>
                                                <tr>
                                                    <th>Book Code</th>
                                                    <th>Book Name</th>
                                                    <th>Image</th>
                                                    <th>Category</th>

                                                    <th>Author</th>
                                                    <th>Publish Company</th>
                                                    <th>Qty</th>
                                                    <th>Description</th>
                                                    <th>Import Price</th>
                                                    <th>Sale Price</th>
                                                    <th>Status</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach items="${listB}" var="b">

                                                    <tr>
                                                        <td>${b.bookCode}</td>
                                                        <td>${b.bookName}</td>
                                                        <td><img width="30px" class="card-img-top" src="${b.image}" alt="Card image cap"></td>
                                                        <td>${b.cateName}</td>
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
                                                <td><fmt:formatNumber value="${b.importPrice}" pattern=" #,##0 VND" /></td>
                                                <td><fmt:formatNumber value="${b.buyPrice}" pattern=" #,##0 VND" /></td>
                                                <td>
                                                    <c:if test="${b.postName == 'posted'}">
                                                        <span class="badge badge-success px-2">Posted</span>
                                                    </c:if>
                                                    <c:if test="${b.postName == 'new'}">
                                                        <span class="badge badge-danger px-2">New</span>
                                                    </c:if>
                                                    <c:if test="${b.postName == 'unpost'}">
                                                        <span class="badge badge-warning px-2">Unpost</span>
                                                    </c:if>
                                                </td>
                                                <td>
                                                    <c:if test="${b.postName == 'new'}">
                                                        <a href="adUploadnav?id=${b.bookCode}" data-toggle="tooltip" data-placement="bottom" title="Upload"><i   class="fa fa-upload"></i></a>
                                                        </c:if>
                                                        <c:if test="${b.postName == 'posted'}">
                                                        <a href="editbooknav?id=${b.bookCode}" data-toggle="tooltip" data-placement="bottom" title="Edit"><i   class="icon-pencil"></i></a>
                                                        </c:if>
                                                        <c:if test="${b.postName == 'posted'}">
                                                        <a onclick='showMess2(${b.bookCode})'   data-toggle="tooltip" data-placement="bottom" title="Unpost"><i   class="fa fa-undo"></i></a>
                                                        </c:if>
                                                        <c:if test="${b.postName == 'unpost'}">
                                                        <a onclick='showMess3(${b.bookCode})' data-toggle="tooltip" data-placement="bottom" title="Upload"><i   class="fa fa-upload"></i></a>
                                                        </c:if>

                                                    <a onclick='showMess1(${b.bookCode})'   data-toggle="tooltip" data-placement="bottom" title="Delete"><i   class="icon-close"></i></a>

                                                </td>


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

                                                        function showMess1(id) {
                                                            var option = confirm("Are you sure to delete book have id = " + id + " ?");
                                                            if (option === true) {
                                                                window.location.href = "addeleteBook?id=" + id;
                                                            }
                                                        }
                                                        function showMess2(id) {
                                                            var option = confirm("Are you sure to unpost book have id = " + id + "?");
                                                            if (option === true) {
                                                                window.location.href = "adUnpost?id=" + id;
                                                            }
                                                        }
                                                        function showMess3(id) {
                                                            var option = confirm("Do you want to edit information of book befor upload?");
                                                            if (option === true) {
                                                                window.location.href = "editbooknav?id=" + id;
                                                            }
                                                            if (option===false){
                                                                window.location.href = "adUploadnav?id=" + id;
                                                            }
                                                        }
        </script>


    </body>

</html>
