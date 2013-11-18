
package commands;

import DTO.CustomerDTO;
import DTO.UserDTO;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;
import shared.Customer;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class LoginCommand implements Command {

    private final Map<SecurityRole, String> roleToTarget;
    private final String loginFailed;

    public LoginCommand(Map<SecurityRole, String> targetRoles, String logInFailedPage) {
        
        this.roleToTarget = targetRoles;
        this.loginFailed = logInFailedPage;
    }

    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //If something smart = bankteller. create BankTellerDTO
        
        String nextPage = loginFailed;
        try {
            //This performs a programatic login
            System.out.println("about to log in");
            request.login(username, password);
            System.out.println("just logged in");
            //Set next page depending on the users role
            for (SecurityRole role : roleToTarget.keySet()) {
                if (request.isUserInRole(role.toString())) {
                    nextPage = roleToTarget.get(role);
                    String curRole = ""+role;
                    if(curRole.equals("Customers")){
                        request.setAttribute("title", "Customer Index");
                        request.setAttribute("navigation", "<a id=\"activetab\">Menu</a>\n <a id=\"logouttab\" href=\"Controller?command=logout\">Log Out</a>");
                        CustomerDTO cust = Factory.getInstance().getBankController().getCustomerByEmail(username);
                        request.setAttribute("userid", cust.getCustomerId());
                        request.setAttribute("username", cust.getFirstName()+" "+cust.getLastName());
        
                    }
                    if(curRole.equals("BankTellers")){
                        request.setAttribute("title", "BankTellers Menu");
                       
                        request.setAttribute("navigation", "<a id=\"activetab\">Menu</a>\n <a href=\"Controller?lastName=&firstName=&email=&command=addCustomer&username="+username+"\">Add Customer</a>\n <a href=\"Controller?command=listCustomers\">Customers List</a>\n <a href=\"Controller?command=listAccounts\">Accounts List</a>\n <a id=\"logouttab\" href=\"Controller?command=logout\">Log Out</a>");
                        
                        UserDTO user = Factory.getInstance().getBankController().getUser(username);
                        request.setAttribute("userid", user.getId());
                        request.setAttribute("username", user.getUserFname());
                    }
                    break;
                }
            }
        } catch (ServletException ex) {
            request.setAttribute("loginerror", "You failed to login");
            request.setAttribute("navigation","<a id=\"activetab\">Login</a>\n <a id=\"logouttab\" href=\"Controller?command=logout\">Log Out</a>");
            Logger.getLogger(LoginCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("returning: " + nextPage);  
        return nextPage;
    }
    
    
}
