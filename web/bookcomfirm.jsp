<%-- 
    Document   : bookcofirm
    Created on : Nov 23, 2023, 1:49:26 PM
    Author     : huuduc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comfirm</title>
    </head>
    <body>
        <div class="book-form" style="margin-top: 30px;max-width: 576px;width: 100%;padding-right: 15px;padding-left: 15px;margin-left: auto;margin-right: auto;border: 1px solid #ccc">
            <div class="">
                <h2 style="text-align: center" class="mb-5">Booking Details</h2>
                <form action="#" method="post">
                    <div>
                        <p>Thông tin khách hàng:</p>
                        <p style="color:black;font-weight: 500"><strong>Linh Nguyen- linh2k3@gmail.com</strong> </p>
                    </div>
                    <div>
                        <p>Bạn đã chọn:</p>
                    </div>
                    <div>
                        <p style="color:black;font-weight: 600"><strong>1 phòng Deluxe</strong></p>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 form-group">
                            <p>Arrival Date</p>
                            <p style="color:black;font-weight: 600"><strong>20/11/2023</strong></p>
                        </div>

                        <div class="col-sm-6 form-group">
                            <p>Departure Date</p>
                            <p style="color:black;font-weight: 600"><strong>22/11/2023</strong></p>

                        </div>

                    </div>

                    <div class=""><p>Tổng thời gian lưu trú: <strong style="color:black; font-weight: 800">2 ngày</strong></p></div>


                    <div style="background: rgba(10,10,170,0.2); align-items: center" class="row">
                        <div  class="col-sm-6">
                            <p style="color: black; font-size: 1.5rem;"><strong>Tổng cộng</strong></p>
                        </div>
                        <div  class="col-sm-6">
                            <p style="color: black;font-size: 1.5rem;margin-bottom: 0.1rem;"><strong>VND 2.500.000</strong></p>
                            <p>Đã bao gồm thuế</p>
                        </div>
                    </div>

                    <div style="display: flex;margin-top: 15px; justify-content: center; text-align: center">
                        <div class="col-md-6 form-group">
                            <input type="submit" value="Confirm" class="btn btn-primary">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
