<%-- 
    Document   : adHome
    Created on : Sep 26, 2022, 11:15:34 AM
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
        <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
        <!-- Pignose Calender -->
        <link href="./plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
        <!-- Chartist -->
        <link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
        <link rel="stylesheet" href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
        <!-- Custom Stylesheet -->
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

            <!--**********************************
                Nav header start
            ***********************************-->

            <!--**********************************
                Nav header end
            ***********************************-->

            <jsp:include page="adHeader.jsp"></jsp:include>

                <!--**********************************
                    Sidebar start
                ***********************************-->
                <div class="nk-sidebar">           
                    <div class="nk-nav-scroll">
                        <ul class="metismenu" id="menu">
                            <li class="nav-label" style="background-color: #c96;">Hello Admin ${acc.getUsername()}</li>
                        <li>
                            <a class="active" href="home" aria-expanded="false">
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
                        </ol>
                    </div>
                </div>
                <div class="container-fluid mt-3">
                    <div class="row">
                        <div class="col-lg-4 col-sm-6">
                            <div class="card gradient-1">
                                <div class="card-body">
                                    <center><h3 class="card-title text-white">Total Books</h3></center>
                                    <center><div class="d-inline-block">
                                            <h2 class="text-white">${book}</h2>
                                        </div></center>
                                    <!--                                <span class="float-right display-5 opacity-5"><i class="fa fa-book"></i></span>-->
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <div class="card gradient-2">
                                <div class="card-body">
                                    <center><h3 class="card-title text-white">Total Profit</h3></center>
                                    <center><div class="d-inline-block">
                                            <h2 class="text-white"><fmt:formatNumber value="${total}" pattern=" #,##0 VND" /></h2>

                                        </div></center>
                                    <!--                                <span class="float-right display-5 opacity-5"><i class="fa fa-money"></i></span>-->
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-sm-6">
                            <div class="card gradient-3">
                                <div class="card-body">
                                    <center><h3 class="card-title text-white">Total Customers</h3></center>
                                    <center><div class="d-inline-block">
                                            <h2 class="text-white">${customer}</h2>

                                        </div></center>
                                    <!--                                <span class="float-right display-5 opacity-5"><i class="fa fa-users"></i></span>-->
                                </div>
                            </div>
                        </div>

                    </div>

                    <div class="row">

                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Book Summamy</h4>
                                    <div>
                                        <canvas id="myChart2"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-6">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Discount Summary</h4>
                                    <div>
                                        <canvas id="myChart111"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="col-12">
                                    <div class="card">
                                        <div>
                                            <canvas id="myChart333"></canvas>
                                        </div>
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

        <!-- Chartjs -->
        <script src="./plugins/chart.js/Chart.bundle.min.js"></script>
        <!-- Circle progress -->
        <script src="./plugins/circle-progress/circle-progress.min.js"></script>
        <!-- Datamap -->
        <script src="./plugins/d3v3/index.js"></script>
        <script src="./plugins/topojson/topojson.min.js"></script>
        <script src="./plugins/datamaps/datamaps.world.min.js"></script>
        <!-- Morrisjs -->
        <script src="./plugins/raphael/raphael.min.js"></script>
        <script src="./plugins/morris/morris.min.js"></script>
        <!-- Pignose Calender -->
        <script src="./plugins/moment/moment.min.js"></script>
        <script src="./plugins/pg-calendar/js/pignose.calendar.min.js"></script>
        <!-- ChartistJS -->
        <script src="./plugins/chartist/js/chartist.min.js"></script>
        <script src="./plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>



        <script src="./js/dashboard/dashboard-1.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
        <script>
            const ctx = document.getElementById('myChart2');

            new Chart(ctx, {
                type: 'polarArea',
                data: {
                    labels: [${nameBook}],
                    datasets: [{
                            label: '',
                            data: [${qty}],
                            backgroundColor: [
                                'rgba(255,99,132,1)',
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
        <script>
            var ctxx = document.getElementById('myChart111');

            var mychrt = new Chart(ctxx, {
                type: 'polarArea',
                data: {
                    labels: [${nameDiscount}],
                    datasets: [{
                            label: '',
                            data: [${qtyDiscount}],
                            backgroundColor: [
                                'rgba(255,99,132,1)',
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
        
        <script>
        var ctxxxx = document.getElementById('myChart333');
      
        var mychart=new Chart(ctxxxx, {
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

    </body>

</html>
