package controller.peassignment;

import DAO.DAO;
import Model.Product;

import javax.servlet.annotation.WebServlet;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductPage", value = "/ProductPage")
public class ProductPageServlet extends HttpServlet  {
    protected void  processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String id =  request.getParameter("productId");
        System.out.println(id);
        DAO dao = new DAO();
        Product prd = dao.getProduct(id);
        session.setAttribute("pdId",id);
        request.setAttribute("product",prd);
        request.getRequestDispatcher("Product.jsp").forward(request, response);
        }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
