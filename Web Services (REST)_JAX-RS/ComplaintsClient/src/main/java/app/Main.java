/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author mw121
 */
public class Main {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        ClientWork cw = new ClientWork();
        cw.Test(client);
        System.out.println("\n\n");
        cw.AllComplaints(client);
        System.out.println("\n\n");
        String id = "1";
        cw.GetComplaintById(client, id);
        System.out.println("\n\n");
        cw.ChangeComplaintById(client, id);
        System.out.println("\n\n");
        cw.AllOpenComplaints(client);
        client.close();
        ;
    }
}
