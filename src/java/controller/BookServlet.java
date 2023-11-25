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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        //Lay du lieu tu form
        String checkIn = request.getParameter("arrival_date");
        String checkOut = request.getParameter("departure_date");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String tel = request.getParameter("tel");

        if (name != null && email != null && tel != null && !name.equals("") && !email.equals("") && !tel.equals("")){
            //Lay phong tu room.jsp thông qua session
            HttpSession session = request.getSession();
            Room room = (Room) session.getAttribute("room");
            //tao bdk de check phong vua lay ve con trong trong hay khong
            BookingDAO bkd = new BookingDAO();
            if (bkd.check(checkIn, checkOut, room.getId())) {
                //Co the dat phong
                System.out.println("Co the dat phong");
                Customer customer = new Customer(name, email, tel);
                //Tinh ngay luu trus
                SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
                int totalDate = 0;
                try {
                    Date date1 = sdf.parse(checkIn);
                    Date date2 = sdf.parse(checkOut);
                    totalDate = (int) ((date2.getTime() - date1.getTime()) / 86400000);

                } catch (ParseException ex) {
                    Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                //Chuyen du lieu sang comfirm.jsp
                System.out.println(totalDate);
                request.setAttribute("room", room);
                request.setAttribute("customer", customer);
                request.setAttribute("checkInDate", checkIn);
                request.setAttribute("checkOutDate", checkOut);
                request.setAttribute("totalDate", totalDate);
                request.getRequestDispatcher("bookconfirm.jsp").forward(request, response);   
            } 
            else{
                System.out.println("Khong the dat phong");
                //System.out.println(room.getId());
                ArrayList<String> arr = bkd.getBookedDate(room.getId());
                if(arr != null){
                    for(String x : arr){
                        System.out.println(x);
                    }
                }
                else{
                    System.out.println("Error");
                }
                request.setAttribute("data", arr);
                request.getRequestDispatcher("test.jsp").forward(request, response); 
            }
        } 
        else{
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
