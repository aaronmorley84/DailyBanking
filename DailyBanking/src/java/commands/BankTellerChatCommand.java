/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commands;

import DTO.UserDTO;
import javax.servlet.http.HttpServletRequest;
import security.SecurityRole;
import servlets.Factory;

/**
 *
 * @author krismaini
 */
public class BankTellerChatCommand extends TargetCommand{

    public BankTellerChatCommand(String target, String title, SecurityRole role) {
        super(target, title, role);
    }

    @Override
    public String execute(HttpServletRequest request) {
String idAsstr= request.getParameter("custemail");
        UserDTO user = Factory.getInstance().getBankController().getUser(idAsstr);
        request.setAttribute("user", user);
        return super.execute(request);    }
    
}
