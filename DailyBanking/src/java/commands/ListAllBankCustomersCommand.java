
package commands;

import DTO.CustomerDTO;
import com.google.gson.Gson;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import static javax.ws.rs.client.Entity.json;
import security.SecurityRole;
import servlets.Factory;
import shared.Customer;
import utils.CreditChecker;
import utils.CreditModel;

/**
 *
 * @author Aaron, Kris, Lars, Timea, @08/11/2013
 */
public class ListAllBankCustomersCommand extends TargetCommand {
  
    
    
    public ListAllBankCustomersCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    

    @Override
    public String execute(HttpServletRequest request) {
        Collection<CustomerDTO> custs = Factory.getInstance().getBankController().getCustomers();
        request.setAttribute("customers", custs);
      
        return super.execute(request); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
