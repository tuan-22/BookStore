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
                        <a href="feedback" aria-expanded="false">
                            <i class="icon-envelope menu-icon"></i><span class="nav-text">Feedback Management</span>
                        </a>
                       
                    </li>
                    <li>
                        <a  class="active" href="adprofit" aria-expanded="false">
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
                            
                                        <li class="breadcrumb-item"><a href="feedback">Profit Management</a></li></li>
                                       
                        </ol>
                    </div>
                </div>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-12">
                        <div class="card">
                            <div class="card-body">
                                <span class="card-title">Profit Management</span>
                               <form  action="profitFilter" style="margin-top:15px ">
                                    <label>Choose Category:</label>
                                        <div class="input-group">
                                            <select name='cate' class="custom-select">
                                                <c:if test="${temp.equals('Week')}">
                                                    <option selected="" value="Week">Week</option>
                                                    <option value="Month">Month</option>
                                                    <option value="Year">Year</option>
                                                </c:if>
                                                <c:if test="${temp.equals('Month')}">
                                                    <option  value="Week">Week</option>
                                                    <option selected="" value="Month">Month</option>
                                                    <option value="Year">Year</option>
                                                </c:if>
                                                <c:if test="${temp.equals('Year')}">
                                                    <option  value="Week">Week</option>
                                                    <option value="Month">Month</option>
                                                    <option selected="" value="Year">Year</option>
                                                </c:if>
                                                
                                            </select>
                                            <input type="hidden" value="profitFilter">
                                            <div class="input-group-append">
                                                <button class="btn btn-outline-dark" type="submit">Filter
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                

                                    <div>
                                        <canvas id="myChart"></canvas>
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
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <script>
        const ctx = document.getElementById('myChart');
      
        new Chart(ctx, {
          type: 'bar',
          data: {
            labels: [${date}],
            datasets: [{
              label: 'Profit',
              data: [${profit}],
              backgroundColor: [
                'rgba(70,99,132,1)',
                'rgba(54,162,235,1)',
                'rgba(255,206,86,1)',
                'rgba(75,192,192,1)',
                'rgba(153,102,255,1)',
                'rgba(255,159,64,1)',
                'rgba(255,99,132,1)',
              ],
            }]
          },
          options: {
            scales: {
              y: {
                beginAtZero: true
              }
            }
          }
        });
      </script>

    <script src="./plugins/tables/js/jquery.dataTables.min.js"></script>
    <script src="./plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
    <script src="./plugins/tables/js/datatable-init/datatable-basic.min.js"></script>

</body>

</html>
