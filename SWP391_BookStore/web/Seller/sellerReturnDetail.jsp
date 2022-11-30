<%-- 
    Document   : adImporter
    Created on : Sep 26, 2022, 11:51:04 AM
    Author     : tramy
--%>

<%@page import="com.bookstore.Format.MoneyFormat"%>
<%@page import="com.bookstore.OrderDetail.OrderDetail"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                        
                        <li class="mega-menu mega-menu-sm">
                            <a href="sellerOrder" aria-expanded="false">
                                <i class="icon-list"></i><span class="nav-text">Order Management</span>
                            </a>

                        </li>
                        <li class="mega-menu mega-menu-sm">
                            <a class="active" href="sellerReturn" aria-expanded="false">
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

                            <li class="breadcrumb-item "><a href="sellerOrder">Return Management</a></li>
                            <li class="breadcrumb-item active">Return Detail</li>

                        </ol>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-12">
                            <div class="card">
                                <div class="card-body">
                                    <span class="card-title">Return Detail</span>

                                    <c:if test='${mess!=null}'>
                                        <div class="alert alert-success">${mess}</div>
                                    </c:if>

                                    <div class="form-group row" style="margin-top: 10px">
                                        <label class="col-sm-2 col-form-label">Order ID:</label>
                                        <div class="col-sm-10">
                                            <input type="type" name="text" class="form-control" value='${order.getOrderID()}' readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Customer Name:</label>
                                        <div class="col-sm-10">
                                            <input type="type" name="text" class="form-control" value='${order.getAccName()}'  readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Email:</label>
                                        <div class="col-sm-10">
                                            <input type="email" name="email" class="form-control" value='${order.getEmail()}'  readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Phone:</label>
                                        <div class="col-sm-10">
                                            <input type="type" name="text" class="form-control"  value='${order.getPhone()}' readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Address:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="email" class="form-control" value='${order.getAddress()}'  readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Order Date:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="email" class="form-control"  value='${order.getOrderDate()}' readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Total Price:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="email" class="form-control"  value='${order.getTotal()}' readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Order Note:</label>
                                        <div class="col-sm-10">

                                            <textarea class="form-control h-150px" rows="4" id="comment" readonly>${order.getNote()}</textarea>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Request Date:</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="email" class="form-control"  value='${order.getRequestDate()}' readonly>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label"> Return Reason:</label>
                                        <div class="col-sm-10">

                                            <textarea class="form-control h-150px" rows="4" id="comment" readonly>${order.getReturnReason()}</textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-2 col-form-label">Status:</label>
                                        <div  class="col-sm-10">
                                            <c:if test='${order.getStatus().equals("returning")}'>
                                                <input style="color: #c96" type="text"  class="form-control"  value='Returning' readonly>
                                            </c:if>
                                            <c:if test='${order.getStatus().equals("wait to approve")}'>
                                                <input style="color: #c96" type="text"  class="form-control"  value='Wait to approve' readonly>
                                            </c:if>
                                            <c:if test='${order.getStatus().equals("reject")}'>
                                                <input style="color: red" type="text"  class="form-control"  value='Reject' readonly>
                                            </c:if>
                                            <c:if test='${order.getStatus().equals("returned")}'>
                                                <input style="color: #14CF43" type="text"  class="form-control"  value='Returned' readonly>
                                            </c:if>
                                            <c:if test='${order.getStatus().equals("out of date")}'>
                                                <input style="color: red" type="text"  class="form-control"  value='Expired returned' readonly>
                                            </c:if>

                                        </div>
                                    </div>

                                    <div class="table-responsive">
                                        <table class="table table-striped table-bordered zero-configuration">
                                            <thead>
                                                <tr>
                                                    <th>Detail ID</th>
                                                    <th>BookCode</th>
                                                    <th>BookName</th>
                                                    <th>Image</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    List<OrderDetail> detail = (List<OrderDetail>) request.getAttribute("detail");
                                                    for (OrderDetail o : detail) {
                                                        MoneyFormat fm = new MoneyFormat();
                                                        String foString = fm.formatMoney(o.getPrice());
                                                        out.print("<tr>"
                                                                + "<td>" + o.getDetailID() + "</td>"
                                                                + "<td>" + o.getBookcode() + "</td>"
                                                                + "<td>" + o.getbName() + "</td>"
                                                                + "<td><img width='80px' src='" + o.getImg() + "'></td>"
                                                                + " <td>" + o.getQuantity() + "</td>"
                                                                + "<td>" + foString + "</td>"
                                                                + "</tr>");
                                                    }
                                                %>

                                            </tbody>
                                        </table>
                                    </div>


                                    <c:if test='${order.getStatus().equals("reject")||order.getStatus().equals("returned")||order.getStatus().equals("out of date")}'>    
                                        <div style="margin-top: 18px" class="form-group row">

                                            <a style="margin-left: 415px" href="sellerReturn"><button style="margin-left: 5px;margin-right: 5px" class="btn mb-1 btn-warning">Cancel</button></a>
                                        </div>

                                    </c:if>

                                    <c:if test='${order.getStatus().equals("wait to approve")}'>    
                                        <form action="selleApp">
                                            <div style="margin-top: 18px" class="form-group row">
                                                <label class="col-sm-2 col-form-label">Update status:</label>
                                                <div  class="col-sm-10">

                                                    <div class="input-group">
                                                        <select name='check' class="custom-select">
                                                            <option value="returning" style="color: green">Approve</option>
                                                            <option value="reject" style="color: red">Reject</option>   
                                                        </select>
                                                    </div>
                                                </div>
                                                <input type="hidden" name="orderid" value='${order.getOrderID()}'>

                                            </div>
                                            <div class="form-group row">
                                                <table style="border: none">
                                                    <td>
                                                        <button style="margin-left: 350px" type="submit" class="btn mb-1 btn-warning" >Update</button>
                                                    </td>
                                            </div>
                                        </form>
                                        <td>
                                            <a style="margin-left: 70px" href="sellerReturn" class="btn mb-1 btn-warning">Cancel</a>
                                        </td>
                                        </table>
                                    </c:if>
                                    <c:if test='${order.getStatus().equals("returning")}'>    
                                        <div class="form-group row">
                                            <input type="hidden" name="orderid" value='${order.getOrderID()}'>

                                            <table style="border: none">
                                                <td>
                                                    <a href="selleApp?check=returned&orderid=${order.getOrderID()}"><button style="margin-left: 350px" type="submit" class="btn mb-1 btn-warning" >Received</button></a>
                                                </td>
                                        
                                        <td>
                                            <a style="margin-left: 70px" href="sellerReturn" class="btn mb-1 btn-warning">Cancel</a>
                                        </td>
                                        </form>
                                        </table>
                                        
                                </c:if>

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
