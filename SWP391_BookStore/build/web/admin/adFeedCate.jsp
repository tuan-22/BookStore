<%-- 
    Document   : adImporter
    Created on : Sep 26, 2022, 11:51:04 AM
    Author     : tramy
--%>

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

                        <li>
                            <a  href="adseller" aria-expanded="false">
                                <i class="fa fa-cart-plus menu-icon"></i> <span class="nav-text">Seller Management</span>
                            </a>

                        </li>
                        <li>
                            <a class="" href="adimporter" aria-expanded="false">
                                <i class="fa fa-arrow-circle-right menu-icon"></i><span class="nav-text">Importer Management</span>
                            </a>

                        </li>


                        <li>
                            <a href="blacklist" aria-expanded="false">
                                <i class="icon-close"></i> <span class="nav-text">Blacklist Management</span>
                            </a>

                        </li>
                    <li>
                        <a class="active" href="feedback" aria-expanded="false">
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
                            
                                        <li class="breadcrumb-item"><a href="feedback">Feedback Management</a></li></li>
                                        <li class="breadcrumb-item active"><a href="feedback">Feedback Management By Category</a></li></li>
                        </ol>
                    </div>
                </div>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <span class="card-title">Feedback Management By Category</span>
                               <form  style="margin-top:15px ">
                                    <label>Choose Category:</label>
                                        <div class="input-group">
                                            <select name='cate' class="custom-select">
                                                <option value="All">All Book</option>
                                                <c:forEach items="${listC}" var="o">
                                                    <c:if test="${select==o.getId()}">
                                                        <option selected="selected" value="${o.getId()}">${o.getName()}</option>
                                                    </c:if>
                                                    <c:if test="${!select.equals(o.getId())}">
                                                        <option  value="${o.getId()}">${o.getName()}</option>
                                                    </c:if>
                                                </c:forEach>
                                            </select>
                                            <input type="hidden" value="feedbackCate">
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
                                                <th>Bookcode</th>
                                                <th>Bookname</th>
                                                <th>Category</th>
                                                <th>Total Feedback</th>
                                                <th>Average Star</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach items="${listFeedback}" var="o">
                                            <tr>
                                                <td>${o.getBookcode()}</td>
                                                <td>${o.getBookName()}</td>
                                                <td>${o.getCateName()}</td>
                                                <td>${o.getTotalFeed()}</td>
                                                <td>${o.getAveStar()}  <a style="color: #f4c01e;" class="fa fa-star"></a></td>
                                                <td>
                                                    <c:if test="${o.getTotalFeed()!=0}">
                                                    <a href='feedbackDetail?code=${o.getBookcode()}' data-toggle="tooltip" data-placement="bottum" title="View Feedback Detail"><i style="margin-left: 20px" class="icon-eye"></i></a>
                                                    </c:if>
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
        <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018</p>
            </div>
        </div>
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

</body>

</html>
