/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BillDAO;
import dao.BookingDAO;
import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Bill;
import model.Booking;
import model.Customer;
import model.Room;

/**
 *
 * @author huuduc
 */
public class ConfirmSerlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        Room room = (Room) session.getAttribute("room");
        Customer customer = (Customer) session.getAttribute("customer");
        String checkInDate = (String) session.getAttribute("checkInDate");
        String checkOutDate = (String) session.getAttribute("checkOutDate");
        int totalDate = (int) session.getAttribute("totalDate");

        BookingDAO bkd = new BookingDAO();
        CustomerDAO cd = new CustomerDAO();
        int idCus = cd.insertCus(customer);
        customer.setId(idCus);

        int idRoom = room.getId();
        int idBk = bkd.insertBooking(idRoom, idCus, checkInDate, checkOutDate, totalDate);
        Booking booking = new Booking(idBk, room, customer, checkInDate, checkOutDate, totalDate);
        booking.setId(idBk);

        Bill bill = new Bill(booking, totalDate * room.getGia());
        BillDAO bd = new BillDAO();
        bd.insertBill(bill);
//        System.out.println(bill);
//        System.out.println(room);
//        System.out.println(customer);
//        System.out.println(checkInDate + " " + checkOutDate);
//        System.out.println(totalDate);
//        System.out.println(idCus + " " + idRoom + " " + idBk);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!doctype html>\n"
                    + "<html lang=\"en\">\n"
                    + "    <head>\n"
                    + "        <title>Thành công</title>\n"
                    + "        <meta charset=\"utf-8\">\n"
                    + "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                    + "        <link href=\"https://fonts.googleapis.com/css?family=Playfair+Display:400,700,900|Rubik:300,400,700\" rel=\"stylesheet\">\n"
                    + "        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"css/animate.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"css/owl.carousel.min.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"fonts/ionicons/css/ionicons.min.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"fonts/fontawesome/css/font-awesome.min.css\">\n"
                    + "        <link rel=\"stylesheet\" href=\"css/magnific-popup.css\">\n"
                    + "        <!-- Theme Style -->\n"
                    + "        <link rel=\"stylesheet\" href=\"css/style.css\">\n"
                    + "    </head>\n"
                    + "    <body>"
                    + "         <div class=\"alert alert-success\" role=\"alert\" style=\"margin-top: 30px;max-width: 576px;width: 100%;padding-right: 15px;padding-left: 15px;margin-left: auto;margin-right: auto;border: 1px solid #ccc\">\n"
                    + "             <h4 class=\"alert-heading\">Đặt phòng thành công!</h4>\n"
                    + "             <p>Chúng tôi đã gửi thông tin chi tiết đặt phòng qua email, xin vui lòng kiểm tra hòm thư điện tử của bạn.</p>\n"
                    + "             <hr>\n"
                    + "             <p><a href=\"/hotel/\" class=\"btn btn-primary btn-sm\">Trở về trang chủ</a></p>\n"
                    + "         </div>"
                    + "    </body>");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
