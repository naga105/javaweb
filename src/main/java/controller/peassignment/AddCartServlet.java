package controller.peassignment;

import DAO.DAO;
import Model.Account;
import Model.Cart;
import Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

@WebServlet(name = "addCart", value = "/addCart")
public class AddCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("account") ==null){
            request.getRequestDispatcher("sign.jsp").forward(request,response);
        }else{
            Account acc = (Account)session.getAttribute("account");
            String id =  request.getParameter("productId");
            System.out.println(id);
            int page = (int) session.getAttribute("page");
            Random random = new Random();
            String user = acc.getUserName();
            DAO dao = new DAO();
            ArrayList<String> cartList = dao.getAllCart();
            System.out.println("Account:"+user);
            Product prd = dao.getProduct(id);
            String rand=String.valueOf(random.nextInt(100));
            for(int i=0; i<cartList.size();i++){
                for(int l=0; l<cartList.size();l++){
                    if(cartList.get(i) == rand){
                        rand=String.valueOf(random.nextInt(100));
                    }
                }
            }
            dao.addCart(rand,user,prd.getId(),1, prd.getProductImg());
            System.out.println(rand+'\n'+user+'\n'+prd.getId());
            ArrayList<Cart> ctr = new DAO().showCart(user);
            System.out.println("cart size:"+ctr.size());
            session.setAttribute("cartsize",ctr.size());

            getServletContext().getRequestDispatcher("/Product").forward(request, response);}
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session =  request.getSession();
        String id = (String) session.getAttribute("pdId");
        Account acc = (Account)session.getAttribute("account");
        String quantity= request.getParameter("quantity");
        int qtt = Integer.parseInt(quantity);
        System.out.println("id:"+id+'\n'+"quantity:"+quantity);
        Random random = new Random();
        String user = acc.getUserName();
        DAO dao = new DAO();
        ArrayList<String> cartList = dao.getAllCart();
        System.out.println("Account:"+user);
        Product prd = dao.getProduct(id);
        String rand=String.valueOf(random.nextInt(100));
        for(int i=0; i<cartList.size();i++){
            for(int l=0; l<cartList.size();l++){
                if(cartList.get(i) == rand){
                    rand=String.valueOf(random.nextInt(100));
                }
            }
        }
        dao.addCart(rand,user,prd.getId(),qtt, prd.getProductImg());
        System.out.println(rand+'\n'+user+'\n'+prd.getId());
        ArrayList<Cart> ctr = new DAO().showCart(user);
        System.out.println("cart size:"+ctr.size());
        session.setAttribute("cartsize",ctr.size());
        getServletContext().getRequestDispatcher("/Product").forward(request, response);
        }
    }

