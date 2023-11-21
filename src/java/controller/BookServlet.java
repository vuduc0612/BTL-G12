/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.BookingDAO;
import dao.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Booking;
import model.Customer;
import model.Room;

/**
 *
 * @author huuduc
 */
public class BookServlet extends HttpServlet {

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

        /* TODO output your page here. You may use following sample code. */
        String checkIn = request.getParameter("arrival_date");
        String checkOut = request.getParameter("departure_date");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");
//        System.out.println(name + " " + email + " " + tel);
        
        HttpSession session = request.getSession();
        Room room = (Room) session.getAttribute("room");
        System.out.println(room);

        CustomerDAO cd = new CustomerDAO();
        if (name != null && email != null && tel != null && name != "" && email != "" && tel != "") {
            
            BookingDAO bkd = new BookingDAO();
            if (bkd.check(checkIn, checkOut, room.getId())) {
                System.out.println("Co the dat phong");
                Customer customer = cd.insertCus(name, email, tel);
                //Booking bk = new Booking(room, customer, checkIn, checkOut);
                bkd.insertBooking(room.getId(), customer.getId(), checkIn, checkOut);
                
            } else {
                System.out.println("Khong the dat phong");
            }
           
            System.out.println(checkIn + " " + checkOut);
            //System.out.println(name + " " + email + " " + tel);
        } else {
            System.out.println("Khong nhan duoc du lieu");
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
