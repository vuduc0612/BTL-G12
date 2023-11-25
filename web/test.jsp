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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
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
        <h1>Rất tiếc, phòng bạn đặt trong thời gian này không còn</h1>
        <h1>Vui lòng đặt ngoài những khoảng thời gian dưới đây:</h1>
        <ul>
            <li><h2><%= arr.get(0) %></h2></li> 
        </ul>
    </body>

</html>
