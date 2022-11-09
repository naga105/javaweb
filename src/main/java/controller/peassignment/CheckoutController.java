package controller.peassignment;

import DAO.DAO;
import Model.Account;
import Model.Cart;
import vnpay.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

@WebServlet(name = "Checkout", value = "/Checkout")
public class CheckoutController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account acc= (Account) session.getAttribute("account");
        String fullname= request.getParameter("fullname");
        String email= request.getParameter("email");
        String phone= request.getParameter("phone");
        String address= request.getParameter("address");
        String method= request.getParameter("paymethod");
        String user = acc.getUserName();
        System.out.println("method:"+method);
        System.out.println(acc);
        DAO dao= new DAO();
        int total=0;
        ArrayList<Cart> ctr = new DAO().showCart(user);
        for(int i=0;i<ctr.size();++i){
            total += ctr.get(i).getPrice()*ctr.get(i).getQuantity();
        }
        if(Objects.equals(method, "Momo")){
            System.out.println("total:"+total);
            request.setAttribute("total",total);
            request.setAttribute("fullname",fullname);
         dao.checkoutCart(user);
            ctr = dao.showCart(user);
            System.out.println("cart size:"+ctr.size());
            session.setAttribute("cartsize",ctr.size());
            request.getRequestDispatcher("qrcode.jsp").forward(request,response);
        }else if(Objects.equals(method,"Paypal")){
            String vnp_Version = "2.0.0";
            String vnp_Command = "pay";
            String vnp_OrderInfo = "Thanh toan don hang 14524";
            String orderType = "billpayment";
            String vnp_TxnRef = "14524 ";
            String amount= total+"00";
            String vnp_IpAddr = Config.getIpAddress(request);
            String vnp_TmnCode = Config.vnp_TmnCode;
            Map<String, String> vnp_Params = new HashMap<>();
            vnp_Params.put("vnp_Version", vnp_Version);
            vnp_Params.put("vnp_Command", vnp_Command);
            vnp_Params.put("vnp_TmnCode", vnp_TmnCode);
            vnp_Params.put("vnp_Amount", String.valueOf(amount));
            vnp_Params.put("vnp_CurrCode", "VND");
            String bank_code = "";
            if (bank_code != null && bank_code.isEmpty()) {
                vnp_Params.put("vnp_BankCode", bank_code);
            }
            vnp_Params.put("vnp_TxnRef", vnp_TxnRef);
            vnp_Params.put("vnp_OrderInfo", vnp_OrderInfo);
            vnp_Params.put("vnp_OrderType", orderType);

            String locate = "vi";
            if (locate != null && !locate.isEmpty()) {
                vnp_Params.put("vnp_Locale", locate);
            } else {
                vnp_Params.put("vnp_Locale", "vn");
            }
            vnp_Params.put("vnp_ReturnUrl", Config.vnp_Returnurl);
            vnp_Params.put("vnp_IpAddr", vnp_IpAddr);

            Date dt = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
            String dateString = formatter.format(dt);
            String vnp_CreateDate = dateString;
            String vnp_TransDate = vnp_CreateDate;
            vnp_Params.put("vnp_CreateDate", vnp_CreateDate);

            //Build data to hash and querystring
            List fieldNames = new ArrayList(vnp_Params.keySet());
            Collections.sort(fieldNames);
            StringBuilder hashData = new StringBuilder();
            StringBuilder query = new StringBuilder();
            Iterator itr = fieldNames.iterator();
            while (itr.hasNext()) {
                String fieldName = (String) itr.next();
                String fieldValue = (String) vnp_Params.get(fieldName);
                if ((fieldValue != null) && (fieldValue.length() > 0)) {
                    //Build hash data
                    hashData.append(fieldName);
                    hashData.append('=');
                    hashData.append(fieldValue);
                    //Build query
                    query.append(URLEncoder.encode(fieldName, StandardCharsets.US_ASCII.toString()));
                    query.append('=');
                    query.append(URLEncoder.encode(fieldValue, StandardCharsets.US_ASCII.toString()));
                    if (itr.hasNext()) {
                        query.append('&');
                        hashData.append('&');
                    }
                }
            }
            String queryUrl = query.toString();
            String vnp_SecureHash = Config.Sha256(Config.vnp_HashSecret + hashData.toString());
            queryUrl += "&vnp_SecureHashType=SHA256&vnp_SecureHash=" + vnp_SecureHash;
            String paymentUrl = Config.vnp_PayUrl + "?" + queryUrl;
            dao.checkoutCart(user);
            ctr=dao.showCart(user);
            session.setAttribute("cartsize",ctr.size());
            request.setAttribute("code", "00");
            request.setAttribute("message", "success");
            request.setAttribute("data", paymentUrl);
            response.sendRedirect(paymentUrl);
            return;
        }
        else if(Objects.equals(method, "Cod")){
        dao.checkoutCart(user);
        System.out.println("cart size:"+ctr.size());
        session.setAttribute("cartsize",ctr.size());
        request.getRequestDispatcher("/Cart").forward(request,response);
    }
}
}
