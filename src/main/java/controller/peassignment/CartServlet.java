package controller.peassignment;

import DAO.DAO;
import Model.Account;
import Model.Cart;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Cart", value = "/Cart")
public class CartServlet extends HttpServlet {

    protected void  processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account acc = (Account)session.getAttribute("account");
        String user = acc.getUserName();
        System.out.println("Account:"+user);
        ArrayList<Cart> ctr = new DAO().showCart(user);
        System.out.println(ctr);
        int total=0;
        for(int i=0;i<ctr.size();++i){
            total += ctr.get(i).getPrice()*ctr.get(i).getQuantity();
        }
        request.setAttribute("total",total);
        request.setAttribute("cart",ctr);
        request.getRequestDispatcher("Cart.jsp").forward(request,response);
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
