/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import restClient.UserRestClient;

/**
 *
 * @author Aaron
 */
public class test {

    public static void main(String[] args) {
        UserRestClient client = new UserRestClient();
        System.out.println(client.countREST());
        String json = client.findAll_JSON(String.class);
        System.out.println(json);
        client.close();
    }
}
