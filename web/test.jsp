<%-- 
    Document   : test
    Created on : Nov 19, 2023, 7:30:49 AM
    Author     : huuduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Room"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Không thành công</title>
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
        <script>
            function sendData() {
                var dataToSend = "Du lieu can gui";

                $.ajax({
                    type: "POST",
                    url: "test",
                    data: {data: dataToSend},
                    success: function (response) {
                        // Xử lý phản hồi từ Servlet
                        console.log(response);
                    },
                    error: function (error) {
                        console.log("Error:", error);
                    }
                });
            }
        </script>
    </head>
    <body>
        <%ArrayList<String> arr = (ArrayList<String>) request.getAttribute("data");%>
        <div class="alert alert-danger" role="alert" style="margin-top: 30px;max-width: 576px;width: 100%;padding-right: 15px;padding-left: 15px;margin-left: auto;margin-right: auto;border: 1px solid #ccc">
            <h4 class="alert-heading">Error!</h4>
            <p>Rất tiếc, phòng bạn đặt trong thời gian này không còn</p>
            <p>Vui lòng đặt ngoài những khoảng thời gian dưới đây:</p>
            <ul>
                <li><p><%= arr.get(0) %></p></li> 
            </ul>
            <hr>
            <p><a href="/hotel/" class="btn btn-primary btn-sm">Trở về trang chủ</a></p>
        </div>
    </body>

</html>
