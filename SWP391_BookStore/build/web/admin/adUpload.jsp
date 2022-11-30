<%-- 
    Document   : addNewSeller
    Created on : Sep 27, 2022, 12:10:56 AM
    Author     : tramy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix ="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link href="css/style.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
        <style>
            #error{
                display: none;
            }
        </style>


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
            <div class="content-body">
                <div class="row page-titles mx-0">
                    <div class="col p-md-0">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">Home</li>
                            <li class="breadcrumb-item ">Book Management</li>
                            <li class="breadcrumb-item active">Upload Book</li>
                        </ol>
                    </div>
                </div>

                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <h4 class="card-title">Upload New Book</h4>
                                    <div id="error" class="alert alert-danger"></div>
                                    <div class="basic-form">
                                        <form name='myform' action="adUpload" method="Post" enctype="multipart/form-data" onsubmit="return validation()">
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Bookcode :</label>
                                                <div class="col-sm-10">
                                                    <input type="email" name="code" class="form-control"  value="${book.bookCode}" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Bookname :</label>
                                                <div class="col-sm-10">
                                                    <input type="text" class="form-control" value="${book.bookName}"  readonly>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Category :</label>
                                                <div class="col-sm-10">
                                                    <div class="input-group mb-3">
                                                        <select name='cate' class="custom-select">
                                                            <c:forEach items="${listC}" var="o">
                                                                <option value="${o.id}">${o.name}</option>
                                                            </c:forEach>

                                                        </select>

                                                    </div>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Image Link:</label>

                                                <div class="col-sm-10">
                                                    <input id="fileUpload" type="file" name='image' class="form-control" onchange="return fileValidation()"  required>
                                                </div>

                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Quantity :</label>
                                                <div class="col-sm-10">
                                                    <input type="text"  class="form-control"  value="${book.qty}" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Imported Price :</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="import" class="form-control"  value="${book.importPrice}" readonly>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Sell Price :</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="sell" class="form-control" placeholder="Sell Price"  required>
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Publish Company :</label>
                                                <div class="col-sm-10">
                                                    <input type="text" name="company" class="form-control" value="${book.publish}"  readonly>
                                                </div>
                                            </div>

                                            <div id="wap" class="basic-form">
                                                <div class="form-group row">
                                                    <label class="col-sm-2 col-form-label">Author :</label>
                                                    <div class="col-sm-10">
                                                        <div class="input-group mb-3">
                                                            <input name="author" type="text" class="form-control" required>
                                                            <div class="input-group-append">
                                                                <button id="add" class="btn btn-outline-dark" type="button"><i
                                                                        class="fa fa-plus"></i></button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>

                                            </div>


                                            <div class="form-group row">
                                                <label class="col-sm-2 col-form-label">Description :</label>
                                                <div class="col-sm-10">

                                                    <textarea name="des" class="form-control h-150px" rows="4" id="comment" required></textarea>
                                                </div>
                                            </div>




                                            <div class="form-group row">
                                                <div class="form-group row">
                                                    <table style="border: none">
                                                        <tr>
                                                        <button type="submit" style="margin-left: 370px;"class="btn mb-1 btn-warning" ><span >Upload</span></button>
                                                        </tr>
                                                </div>

                                                <tr>
                                                <a style="margin-left: 70px" href="adbook" class="btn mb-1 btn-warning">Cancel</a>
                                                <td>
                                                    </table>

                                            </div>

                                    </div>
                                    </form>



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
    <script>
                                                            var numb = document.forms['myform']['sell'];
                                                            var err = document.getElementById('error');
                                                            function validation() {

                                                                if (numb.value <= ${book.importPrice}) {
                                                                    err.innerHTML = "Sell Price must be larger than imported Price. Please input again!";
                                                                    err.style.display = "block";
                                                                    return false;
                                                                }
                                                                return true;
                                                            }

    </script>
    <script>
        function fileValidation() {
            var fileInput = document.getElementById('fileUpload');
            var filePath = fileInput.value;
            var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
            if (!allowedExtensions.exec(filePath)) {
                alert('Please upload file having extensions .jpeg/.jpg/.png/.gif only.');
                fileInput.value = '';
                return false;
            } else {
                //Image preview
                if (fileInput.files && fileInput.files[0]) {
                    var reader = new FileReader();
                    reader.onload = function (e) {
                        document.getElementById('imagePreview').innerHTML = '<img src="' + e.target.result + '"/>';
                    };
                    reader.readAsDataURL(fileInput.files[0]);
                }
            }
        }
    </script>

    <script type="text/javascript">
    $(document).ready(function () {

    var max_fields = 10;
            var wrapper = $("#wap");
            var add_button = $("#add");
            var x = 1;
            $(add_button).click(function (e) {
    e.preventDefault();
            if (x < max_fields) {
    x++;
            $(wrapper).append('<div class="form-group row" ><label  class="col-sm-2 col-form-label">Author ' + x + ' :</label><div class="col-sm-10"><div class="input-group mb-3"><input name="author" type="text" class="form-control" required><div class="input-group-append"> <button class="btn btn-outline-dark" type="button"><a href="#" class="remove_field"><i class="icon-close"></i></a></button></div></div></div></div>');
    }
    });
            $(wrapper).on("click", ".remove_field", function (e) { //user click on remove text

    e.preventDefault();
            $(this).parent().parent().parent().parent().parent().remove();
            x--;
    });
            maxFileSize = 10 * 1024 * 1024;
            $("#fileUpload").change(function(){
    fileSize = this.files[0].size;
            if (fileSize > maxFileSize){
    this.setCustomValidity("You can upload only files under 10MB");
            this.reportValidity();
    } else{
    his.setCustomValidity("");
    }
    });
    });
                        </script >
                        
                        
                            </body>
                            
                            </html>
