package controller.peassignment;

import DAO.DAO;
import Model.Account;
import Model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Product", value = "/Product")
public class ProductServlet extends HttpServlet {

    protected void  processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            DAO atd = new DAO();
        String catagory = "";

         if(request.getParameter("product") != null ) {
            System.out.println("request:"+request.getParameter("product"));
            catagory = request.getParameter("product");
            session.setAttribute("ctg",catagory);
       }
          else if ((String) session.getAttribute("ctg") != null) {
                catagory = (String) session.getAttribute("ctg");
             System.out.println("session:"+catagory);
            }
            int page = 1;
if(session.getAttribute("page")!=null){
    page= (int) session.getAttribute("page");
        }
        final int PAGE_SIZE = 6;
        String pageStr = request.getParameter("page");
            System.out.println(pageStr);
        if (pageStr != null) {
            page = Integer.parseInt(pageStr);
            request.setAttribute("pageStr", page);
        }
        System.out.println((page - 1) * PAGE_SIZE + " : " + page * PAGE_SIZE);
        ArrayList<Product> listAll = atd.displayAll(catagory);

        List<Product> listProduct = new ArrayList<>();
        listProduct = atd.displayEachPage(catagory,(page - 1) * PAGE_SIZE,  PAGE_SIZE);

        int pageNum = listAll.size() / PAGE_SIZE;
        if (listAll.size() % PAGE_SIZE < 6) {
            pageNum++;
        }

        List<Integer> listInteger = new ArrayList<>();
        for(int i =1; i<=pageNum; i++) {
            listInteger.add(i);
        }

        System.out.println(listInteger);
            System.out.println("Pages:"+pageNum);
            System.out.println(listProduct);
        session.setAttribute("page",page);
        request.setAttribute("PageSize",pageNum);
        request.setAttribute("listAll", listAll);
        request.setAttribute("listPage", listInteger);
        request.setAttribute("listProduct", listProduct);
        session.setAttribute("catagories",catagory);

        request.getRequestDispatcher("ShowProduct.jsp").forward(request, response);
    } }

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
