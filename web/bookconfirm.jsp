<%-- 
    Document   : bookcofirm
    Created on : Nov 23, 2023, 1:49:26 PM
    Author     : huuduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Room"%>
<%@page import="model.Customer"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comfirm</title>

        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <link href="https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900|Rubik:300,400,700" rel="stylesheet">

        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">

        <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
        <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/magnific-popup.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/css/bootstrap-datepicker.min.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <%Room room = (Room) request.getAttribute("room");
        Customer customer = (Customer) request.getAttribute("customer");
        String checkInDate = (String) request.getAttribute("checkInDate");
        String checkOutDate = (String) request.getAttribute("checkOutDate");
        int totalDate = (int) request.getAttribute("totalDate");
        if(request.getAttribute("mess") != null){
            String message = (String) request.getAttribute("mess");%>
            <h2><%= message %></h2>
        <%}%>
        
        
        <div class="book-form" style="margin-top: 30px;max-width: 576px;width: 100%;padding-right: 15px;padding-left: 15px;margin-left: auto;margin-right: auto;border: 1px solid #ccc">
            <div class="">
                <h2 style="text-align: center" class="mb-5">Booking Details</h2>
                <form action="/hotel/confirm" method="post">
                    <div>
                        <p>Thông tin khách hàng:</p>
                        <p style="color:black;font-weight: 500"><strong><%= customer.getName()%> - <%= customer.getEmail()%></strong> </p>
                    </div>
                    <div>
                        <p>Phòng đã chọn:</p>
                    </div>
                    <div>
                        <p style="color:black;font-weight: 600"><strong>Phòng <%= room.getType()%></strong></p>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <p>Arrival Date</p>
                            <p style="color:black;font-weight: 600"><strong><%= checkInDate%></strong></p>
                        </div>

                        <div class="col-sm-6 form-group">
                            <p>Departure Date</p>
                            <p style="color:black;font-weight: 600"><strong><%= checkOutDate%></strong></p>

                        </div>

                    </div>

                    <div class=""><p>Tổng thời gian lưu trú: <strong style="color:black; font-weight: 800"><%= totalDate%> ngày</strong></p></div>


                    <div style="background: rgba(10,10,170,0.2); align-items: center" class="row">
                        <div  class="col-sm-6">
                            <p style="color: black; font-size: 1.5rem;"><strong>Tổng cộng</strong></p>
                        </div>
                        <div  class="col-sm-6">
                            <p style="color: black;font-size: 1.5rem;margin-bottom: 0.1rem;"><strong>VND <%= (int)room.getGia()*totalDate%></strong></p>
                            <!--                            <p>Đã bao gồm thuế</p>-->
                        </div>
                    </div>
                    <%
                    session.setAttribute("room", room);
                    session.setAttribute("customer", customer);
                    session.setAttribute("checkInDate", checkInDate);
                    session.setAttribute("checkOutDate", checkOutDate);
                    session.setAttribute("totalDate", totalDate);  
                    %>
                    
                    <div style="display: flex;margin-top: 15px; justify-content: center; text-align: center">
                         <div class="col-md-6 form-group">
                            <input type="submit" value="Confirm" class="btn btn-primary">
                        </div>
                    </div>
                    
                     
                </form>
            </div>
        </div>

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
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.8.0/js/bootstrap-datepicker.min.js"></script>

        <script>

            $('#arrival_date, #departure_date').datepicker({});

        </script>
        <script src="js/main.js"></script>
    </body>
</html>
