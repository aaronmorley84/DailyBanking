/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import DTO.CustomerDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author krismaini
 */
public class CustomerChatCommand extends TargetCommand {

    public CustomerChatCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
        
        String idAsstr= request.getParameter("custemail");
        CustomerDTO cust = Factory.getInstance().getBankController().getCustomerByEmail(idAsstr);
        request.setAttribute("customer", cust);
        return super.execute(request);
    }
    
}
