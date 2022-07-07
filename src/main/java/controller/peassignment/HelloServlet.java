package controller.peassignment;

import DAO.DAO;
import Model.Account;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Lmao", value = "/Lmao")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        Account account = new DAO().login(username, password);
        System.out.println(username+password);
        if (account != null) {
            session.setAttribute("account", account);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else{
            request.setAttribute("error", "Username or password is incorrect");
            request.getRequestDispatcher("sign.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("name");
        String password = request.getParameter("password");
        String Fullname= request.getParameter("fullname");
        String role="user";
        Account acc = new Account(username,password,role,Fullname);
        DAO accd = new DAO();
        System.out.println(acc.getFullName());
        System.out.println(acc);
        accd.signUp(acc);
        System.out.println("brum brum");
        request.getRequestDispatcher("sign.jsp").forward(request, response);
    }
}
