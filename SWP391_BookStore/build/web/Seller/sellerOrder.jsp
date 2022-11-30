<%-- 
    Document   : adImporter
    Created on : Sep 26, 2022, 11:51:04 AM
    Author     : tramy
--%>

<%@page import="java.util.List"%>
<%@page import="com.bookstore.Order.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.bookstore.Format.MoneyFormat"%>
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

            <jsp:include page="sellerHeader.jsp"></jsp:include>
                <!--**********************************
                    Sidebar start
                ***********************************-->
                <div class="nk-sidebar">           
                    <div class="nk-nav-scroll">
                        <ul class="metismenu" id="menu">
                            <li class="nav-label" style="background-color: #c96;">Hello Seller ${acc.getUsername()}</li>
                        
                        <li>
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

            <!--**********************************
                Content body start
            ***********************************-->
            <div class="content-body">
                <div class="row page-titles mx-0">
                    <div class="col p-md-0">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Home</li>
                            <li class="breadcrumb-item active">Order Management</li>
                        </ol>
                    </div>
                </div>


                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <span class="card-title">Order Management</span>
                                    <form action="adOrderStatus" style="margin-top:15px ">
                                    <label>Choose Status:</label>
                                        <div class="input-group">
                                            <select name='status' class="custom-select">
                                                <c:if test="${temp=='All'}">
                                                    <option selected value="All">All</option>
                                                <option value="confirming">Confirming</option>
                                                <option value="not confirm">Not Confirm</option>
                                                <option value="cancelled">Cancelled</option>
                                                <option value="delivering">Delivering</option>
                                                <option value="delivery fail">Delivery Fail</option>
                                                <option value="received">Received</option>
                                                </c:if>
                                                
                                                <c:if test="${temp=='confirming'}">
                                                    <option  value="All">All</option>
                                                <option selected value="confirming">Confirming</option>
                                                <option value="not confirm">Not Confirm</option>
                                                <option value="cancelled">Cancelled</option>
                                                <option value="delivering">Delivering</option>
                                                <option value="delivery fail">Delivery Fail</option>
                                                <option value="received">Received</option>
                                                </c:if>
                                                <c:if test="${temp=='not confirm'}">
                                                    <option  value="All">All</option>
                                                <option value="confirming">Confirming</option>
                                                <option selected value="not confirm">Not Confirm</option>
                                                <option value="cancelled">Cancelled</option>
                                                <option value="delivering">Delivering</option>
                                                <option value="delivery fail">Delivery Fail</option>
                                                <option value="received">Received</option>
                                                </c:if>
                                                <c:if test="${temp=='cancelled'}">
                                                    <option  value="All">All</option>
                                                <option value="confirming">Confirming</option>
                                                <option  value="not confirm">Not Confirm</option>
                                                <option selected value="cancelled">Cancelled</option>
                                                <option value="delivering">Delivering</option>
                                                <option value="delivery fail">Delivery Fail</option>
                                                <option value="received">Received</option>
                                                </c:if>
                                                <c:if test="${temp=='delivering'}">
                                                    <option  value="All">All</option>
                                                <option value="confirming">Confirming</option>
                                                <option  value="not confirm">Not Confirm</option>
                                                <option  value="cancelled">Cancelled</option>
                                                <option selected value="delivering">Delivering</option>
                                                <option value="delivery fail">Delivery Fail</option>
                                                <option value="received">Received</option>
                                                </c:if>
                                                <c:if test="${temp=='delivery fail'}">
                                                    <option  value="All">All</option>
                                                <option value="confirming">Confirming</option>
                                                <option  value="not confirm">Not Confirm</option>
                                                <option  value="cancelled">Cancelled</option>
                                                <option  value="delivering">Delivering</option>
                                                <option selected value="delivery fail">Delivery Fail</option>
                                                <option value="received">Received</option>
                                                </c:if>
                                                <c:if test="${temp=='received'}">
                                                    <option  value="All">All</option>
                                                <option value="confirming">Confirming</option>
                                                <option  value="not confirm">Not Confirm</option>
                                                <option  value="cancelled">Cancelled</option>
                                                <option  value="delivering">Delivering</option>
                                                <option  value="delivery fail">Delivery Fail</option>
                                                <option selected value="received">Received</option>
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
                                                    <th>OrderID</th>
                                                    <th>Customer</th>
                                                    <th>Email</th>
                                                    <th>Phone</th>
                                                    <th>Address</th>
                                                    <th>Order Note</th>
                                                    <th>Order Date</th>
                                                    <th>Total Order</th>
                                                    <th>Status</th>
                                                    <th>Action</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    List<Order> list = (List<Order>) request.getAttribute("listO");
                                                    for (Order elem : list) {
                                                        MoneyFormat fm = new MoneyFormat();
                                                        String foString = fm.formatMoney(elem.getTotal());
                                                        if(elem.getStatus().equals("confirming") ||elem.getStatus().equals("not confirm") || elem.getStatus().equals("cancelled")||elem.getStatus().equals("received")||elem.getStatus().equals("delivery fail")||elem.getStatus().equals("delivering")){
                                                        out.print("<tr>"
                                                                + "<td>" + elem.getOrderID() + "</td>"
                                                                + "<td>" + elem.getAccName() + "</td>"
                                                                + "<td>" + elem.getEmail() + "</td>"
                                                                + "<td>" + elem.getPhone() + "</td>"
                                                                + "<td>" + elem.getAddress() + "</td>"
                                                                + "<td>" + elem.getNote() + "</td>"
                                                                + "<td>" + elem.getOrderDate() + "</td>"
                                                                + "<td>" + foString + "</td>"
                                                                + "<td>");
                                                        if (elem.getStatus().equals("confirming")) {
                                                            out.print("<span class='badge badge-pill badge-warning'>Confirming</span></td>");
                                                        } else if (elem.getStatus().equals("delivering")) {
                                                            out.print("<span class='badge badge-pill badge-warning'>Delivering</span></td>");
                                                        } else if (elem.getStatus().equals("not confirm")) {
                                                            out.print("<span class='badge badge-pill badge-danger'>Not Confirm</span></td>");
                                                        } else if (elem.getStatus().equals("cancelled")) {
                                                            out.print("<span class='badge badge-pill badge-danger'>Cancelled</span></td>");
                                                        } else if (elem.getStatus().equals("received")) {
                                                            out.print("<span class='badge badge-pill badge-success'>Received</span></td>");
                                                        } else if (elem.getStatus().equals("delivery fail")) {
                                                            out.print("<span class='badge badge-pill badge-danger'>Delivery Fail</span></td>");
                                                        }
                                                        out.print("<td>"
                                                                + "<a style='margin-left: 25px' href='sellerOrderDetail?id=" + elem.getOrderID() + "' data-toggle='tooltip' data-placement='bottom' title='View Order Detail'><i   class='icon-eye'></i></a>"
                                                                + " </td></tr>");
                                                        }
                                                    }                                                    %>

                                                
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
                var option = confirm("Are you sure to add Import Manager have id = " + id + " to BlackList ?");
                if (option === true) {
                    window.location.href = "addBlacklist?page=importer&id=" + id;
                }
            }
        </script>

    </body>

</html>
