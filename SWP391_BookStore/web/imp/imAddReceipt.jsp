
<%@page import="com.bookstore.Order.Return"%>
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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <link href="../admin/css/style.css" rel="stylesheet">
        <script>
            $(document).ready(function () {
                var html = '<tr><td><input type="number" name="code"   required></td><td><input type="text"  name="bname"  required></td><td><input type="number" name="qty"  required></td><td><input type="number" name="price"   required></td><td><input type="button" name="remove" value="Remove" id="remove" class="btn btn-danger"></td></tr>';
                var x = 1;
                var add_button = $("#add");
                $(add_button).click(function () {
                    $("#table_field").append(html);

                });

                $("#table_field").on('click', '#remove', function (e) {
                    $(this).closest('tr').remove();

                });
            });
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
                                <form action="imCreate" method="POST">
                                    <div class="card-body">
                                        <span class="card-title">Add New Receipt</span>

                                        <br>

                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Publish Company:</label>
                                            <div class="col-sm-10">
                                                <select name="company" class="custom-select">
                                                    <c:forEach items="${listC}" var="o">
                                                        <option value="${o.companyID}">${o.companyName}</option>
                                                    </c:forEach>

                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Importer Name:</label>
                                            <div class="col-sm-10">
                                                <input type="email" name="email" class="form-control"  value="${acc.getUsername()}"  readonly>
                                                <input type="hidden" name="accid" class="form-control"  value="${acc.getAccID()}"  readonly>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-2 col-form-label">Receipted Date</label>
                                            <div class="col-sm-10">
                                                <input type="text" name="day" class="form-control"  Value="${day}" readonly>
                                            </div>
                                        </div>
                                
                                        <div class="table-responsive">
                                            <table id="table_field" class="table table-striped table-bordered zero-configuration">
                                                <thead>
                                                    <tr>
                                                        <th>BookCode</th>
                                                        <th>BookName</th>
                                                        <th>Quantity</th>
                                                        <th>Price</th>
                                                        <th>Action</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                    <tr>

                                                        <td><input  type="number" name="code"   required></td>
                                                        <td><input type="text" name="bname"    required></td>
                                                        <td><input type="number" name="qty"  required></td>
                                                        <td><input type="number" name="price"   required></td>
                                                        <td><input type="button" name="add" id="add" value="Add" class="btn btn-warning"></input></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                        </div>
                                        <table style="border: none">
                                                <td>
                                                    <button style="margin-left: 350px" type="submit" class="btn mb-1 btn-warning" >Create</button>
                                                </td>

                                                <td>
                                                    <a style="margin-left: 70px" href="listReceipt" class="btn mb-1 btn-warning">Cancel</a>
                                                </td>
                                                </form>
                                            </table>
                                        <center>
                                            
                                        </center>
                                    </div>
                                </form>
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
