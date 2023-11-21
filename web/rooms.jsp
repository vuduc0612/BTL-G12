<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.Room"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LuxuryHotel a Hotel Template</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900|Rubik:300,400,700" rel="stylesheet">

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">

        <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">

        <!-- Theme Style -->
        <link rel="stylesheet" href="css/style.css">
    </head>

    <body>
        <header role="banner">

            <nav class="navbar navbar-expand-md navbar-dark bg-light">
                <div class="container">
                    <a class="navbar-brand" href="index.html">LuxuryHotel</a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample05" aria-controls="navbarsExample05" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse navbar-light" id="navbarsExample05">
                        <ul class="navbar-nav ml-auto pl-lg-5 pl-0">
                            <li class="nav-item">
                                <a class="nav-link" href="index.html">Home</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="rooms.html">Rooms</a> 
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="blog.html">Blog</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link " href="about.html">About</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="contact.html">Contact</a>
                            </li>

                            <li class="nav-item cta">
                                <a class="nav-link" href="booknow.html"><span>Book Now</span></a>
                            </li>
                        </ul>

                    </div>
                </div>
            </nav>
        </header>

        <section class="site-hero site-hero-innerpage overlay" data-stellar-background-ratio="0.5" style="background-image: url(images/big_image_1.jpg);">
            <div class="container">
                <div class="row align-items-center site-hero-inner justify-content-center">
                    <div class="col-md-12 text-center">
                        <div class="mb-5 element-animate">
                            <h1>Our Rooms</h1>
                            <p>Discover our world's - Luxury Room For VIP.</p>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <!--Present-->
        
        
        <% ArrayList<Room> arr = (ArrayList<Room>)request.getAttribute("data");%>
        
        <section class="site-section">
            <div class="container">
                <div class="row">
                    <%for(int idx = 0; idx < arr.size(); idx += 3){%>
                    <!-- 1 -->
                    <div class="col-md-4 mb-4">
                        <div class="media d-block room mb-0">
                            <figure>
                                <%String urlImg = arr.get(idx).getImg();%>
                                <div>
                                    <img style="position: relative" src="<%= urlImg%>" alt="Generic placeholder image" class="img-fluid">
                                    <span style="margin:30px 60px 5px 30px; padding:10px 15px 10px; background: #3c3c3c; position: absolute; left: -18px; bottom: 10px; z-index: 20; white-space: nowrap; line-height: 1">
                                        <span style="font-size: 15px;color: #f0ca7f;"><%= arr.get(idx).getPrice()%> <bdi><span style="font-size: 24px;color: #f0ca7f;">₫ </span></bdi></span>
                                        <span style="font-size: 15px; color: #fff">/ night</span>
                                    </span>
                                </div>

                            </figure>
                            <div class="media-body" style="position: relative;">
                                <h3 style="font-size: 1.5rem" class="mt-0"><a href= <%= "/hotel/detail?type=" + arr.get(idx).getType()%>><%= arr.get(idx).getType()%> Room</a></h3>
                                <div class="overlap-text", style="position: absolute; top:255px; left: 225px">
                                    <span>
                                        Rate
                                        <% int stars = arr.get(idx).getRate();
                                           for(int i = 0; i < stars; i++){%>
                                        <span class="ion-ios-star"></span>
                                        <%}%>
                                    </span>
                                </div> 
                                <ul class="room-specs">
                                    <li><span class="ion-ios-people-outline"></span> <%= arr.get(idx).getGuest()%> Guests</li>
                                    <li><span class="ion-ios-crop"></span> <%= arr.get(idx).getSquare()%> ft <sup>2</sup></li>
                                </ul>
                                <p><%= arr.get(idx).getDes()%></p>
                                <p><a href="#" class="btn btn-primary btn-sm">Xem thêm</a></p>
                            </div>
                        </div>

                    </div>
                    <!<!-- 2 -->
                    <div class="col-md-4 mb-4">
                        <div class="media d-block room mb-0">
                            <figure>
                                <%String urlImg1 = arr.get(idx + 1).getImg();%>
                                <div>
                                    <img style="position: relative" src="<%= urlImg1%>" alt="Generic placeholder image" class="img-fluid">
                                    <span style="margin:30px 60px 5px 30px; padding:10px 15px 10px; background: #3c3c3c; position: absolute; left: -18px; bottom: 10px; z-index: 20; white-space: nowrap; line-height: 1">
                                        <span style="font-size: 15px;color: #f0ca7f;"><%= arr.get(idx + 1).getPrice()%> <bdi><span style="font-size: 24px;color: #f0ca7f;">₫ </span></bdi></span>
                                        <span style="font-size: 15px; color: #fff">/ night</span>
                                    </span>
                                </div>

                            </figure>
                            <div class="media-body" style="position: relative;">
                                <h3 style="font-size: 1.5rem" class="mt-0"><a href= <%= "/hotel/detail?type=" + arr.get(idx + 1).getType()%>><%= arr.get(idx + 1).getType()%> Room</a></h3>
                                <div class="overlap-text", style="position: absolute; top:255px; left: 230px">
                                    <span>
                                        Rate
                                        <% int stars1 = arr.get(idx + 1).getRate();
                                           for(int i = 0; i < stars1; i++){%>
                                        <span class="ion-ios-star"></span>
                                        <%}%>
                                    </span>
                                </div> 
                                <ul class="room-specs">
                                    <li><span class="ion-ios-people-outline"></span> <%= arr.get(idx + 1).getGuest()%> Guests</li>
                                    <li><span class="ion-ios-crop"></span> <%= arr.get(idx + 1).getSquare()%> ft <sup>2</sup></li>
                                </ul>
                                <p><%= arr.get(idx + 1).getDes()%></p>
                                <p><a href="#" class="btn btn-primary btn-sm">Xem thêm</a></p>
                            </div>
                        </div>
                    </div>
                    <!<!-- 3 -->
                    <div class="col-md-4 mb-4">
                        <div class="media d-block room mb-0">
                            <figure>
                                <%String urlImg2 = arr.get(idx + 2).getImg();%>
                                <div>
                                    <img style="position: relative" src="<%= urlImg2%>" alt="Generic placeholder image" class="img-fluid">
                                    <span style="margin:30px 60px 5px 30px; padding:10px 15px 10px; background: #3c3c3c; position: absolute; left: -18px; bottom: 10px; z-index: 20; white-space: nowrap; line-height: 1">
                                        <span style="font-size: 15px;color: #f0ca7f;"><%= arr.get(idx + 2).getPrice()%> <bdi><span style="font-size: 24px;color: #f0ca7f;">₫ </span></bdi></span>
                                        <span style="font-size: 15px; color: #fff">/ night</span>
                                    </span>
                                </div>

                            </figure>
                            <div class="media-body" style="position: relative;">
                                <h3 style="font-size: 1.5rem" class="mt-0"><a href= <%= "/hotel/detail?type=" + arr.get(idx + 2).getType()%>><%= arr.get(idx + 2).getType()%> Room</a></h3>
                                <div class="overlap-text", style="position: absolute; top:255px; left: 230px">
                                    <span>
                                        Rate
                                        <% int stars2 = arr.get(idx + 2).getRate();
                                           for(int i = 0; i < stars2; i++){%>
                                        <span class="ion-ios-star"></span>
                                        <%}%>
                                    </span>
                                </div> 
                                <ul class="room-specs">
                                    <li><span class="ion-ios-people-outline"></span> <%= arr.get(idx + 2).getGuest()%> Guests</li>
                                    <li><span class="ion-ios-crop"></span> <%= arr.get(idx + 2).getSquare()%> ft <sup>2</sup></li>
                                </ul>
                                <p><%= arr.get(idx + 2).getDes()%></p>
                                <p><a href="#" class="btn btn-primary btn-sm">Xem thêm</a></p>
                            </div>
                        </div>

                    </div>  
                    <%}%>
                </div>
            </div>

        </section>

        <!--footer-->
        <footer class="site-footer">
            <div class="container">
                <div class="row mb-5">
                    <div class="col-md-4">
                        <h3>Phone Support</h3>
                        <p>24/7 Call us now.</p>
                        <p class="lead"><a href="tel://">+ 1 332 3093 323</a></p>
                    </div>
                    <div class="col-md-4">
                        <h3>Connect With Us</h3>
                        <p>We are socialized. Follow us</p>
                        <p>
                            <a href="#" class="pl-0 p-3"><span class="fa fa-facebook"></span></a>
                            <a href="#" class="p-3"><span class="fa fa-twitter"></span></a>
                            <a href="#" class="p-3"><span class="fa fa-instagram"></span></a>
                            <a href="#" class="p-3"><span class="fa fa-vimeo"></span></a>
                            <a href="#" class="p-3"><span class="fa fa-youtube-play"></span></a>
                        </p>
                    </div>
                    <div class="col-md-4">
                        <h3>Connect With Us</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Maxime, odio.</p>
                        <form action="#" class="subscribe">
                            <div class="form-group">
                                <button type="submit"><span class="ion-ios-arrow-thin-right"></span></button>
                                <input type="email" class="form-control" placeholder="Enter email">
                            </div>

                        </form>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-md-7 text-center">
                        &copy; <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart-o" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </div>
                </div>
            </div>
        </footer>
        <!-- END footer -->

        <!-- loader -->
        <div id="loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#f4b214"/></svg></div>

        <script src="js/jquery-3.2.1.min.js"></script>
        <script src="js/jquery-migrate-3.0.0.js"></script>
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/jquery.waypoints.min.js"></script>
        <script src="js/jquery.stellar.min.js"></script>

        <script src="js/jquery.magnific-popup.min.js"></script>
        <script src="js/magnific-popup-options.js"></script>

        <script src="js/main.js"></script>
    </body>
</html>