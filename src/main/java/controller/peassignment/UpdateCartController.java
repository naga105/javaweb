package controller.peassignment;

import DAO.DAO;
import Model.Account;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "delete", value = "/delete")
public class UpdateCartController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String productid = request.getParameter("id");
        Account acc= (Account) session.getAttribute("account");
        System.out.println(acc);
        System.out.println(productid);
        DAO dao = new DAO();
        dao.deleteformCart(productid, acc.getUserName());
        request.getRequestDispatcher("Cart").forward(request, response);
    }
}
