package commands;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CurrencyModel;
import utils.CurrencyClient;
/**
 *
 * @author krismaini
 */
@WebServlet(name = "CurrencyInfoServlet", urlPatterns = {"/CurrencyInfoServlet"})
public class CurrencyInfoServlet extends HttpServlet {
    
    CurrencyModel currencyMod;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           
            throws ServletException, IOException {
         
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        
        try {
        
        List<String> currencies = new ArrayList<>();
            currencies.add("EUR");
            currencies.add("USD");
            currencies.add("GBP");
            currencies.add("SEK");
            currencies.add("NOK");
            currencies.add("CHF");
            currencies.add("JPY");
        
        out.println("<table>");
        for(String curr:currencies){
            printCurrency(curr);
            out.println("<tr><td>"+currencyMod.getCurrency()+"</td>"
                    +"<td>"+currencyMod.getIso()+"</td>"
                    +"<td>"+currencyMod.getRate()+"</td>"+"</tr>");
            System.out.println(currencyMod.getCurrency());
            System.out.println(currencyMod.getIso());
            System.out.println(currencyMod.getRate());
        }
        out.println("</table>");
            
        } finally {
            out.close();
        }
    }
    
    public void printCurrency(String key){
        CurrencyClient client = new CurrencyClient();
        String jsonCurr = client.find_JSON(String.class, key);
        System.out.println(jsonCurr);
        Gson gson = new Gson();
        this.currencyMod = gson.fromJson(jsonCurr, CurrencyModel.class);
        
        client.close();
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
