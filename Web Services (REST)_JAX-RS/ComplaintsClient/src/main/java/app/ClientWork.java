package app;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import org.json.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, cohose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mw121
 */
public class ClientWork {

    public ClientWork() {
    }

    public void Test(Client client) {
        String count
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/count")
                        .request(
                                MediaType.TEXT_PLAIN)
                        .get(String.class);

        System.out.println("Test: Count=" + count);
    }

    public void AllComplaints(Client client) {
        String allComplaints
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints")
                        .request(
                                MediaType.APPLICATION_JSON)
                        .get(String.class);
        //System.out.println("AllComplaints:\n " + allComplaints);
        JSONArray obj = new JSONArray(allComplaints);
        System.out.println("All complaints:\n"+obj.toString(4));
    }

    public void GetComplaintById(Client client, String id) {
        String compl
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/" + id)
                        .request(
                                MediaType.APPLICATION_JSON)
                        .get(String.class);
        JSONObject obj = new JSONObject(compl);
        System.out.println("GetComplaintById:\nId:"+id+"\n"+ obj.toString(4));
    }

    public void ChangeComplaintById(Client client, String id) {
        String compl
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints/" + id)
                        .request(
                                MediaType.APPLICATION_JSON)
                        .get(String.class);
        
        JSONObject obj = new JSONObject(compl);
        System.out.println("ChangeComplaintById:\nId:"+id+"\nGot: \n" + obj.toString(4));
        obj.put("status", "closed");
        System.out.println("ChangeComplaintById:\n Putting: \n" + obj.toString(4));

        client.target("http://localhost:8080/Complaints/resources/complaints/" + id)
                .request(MediaType.APPLICATION_JSON_TYPE).put(Entity.entity(obj.toString(), MediaType.APPLICATION_JSON_TYPE));
    }

    public void AllOpenComplaints(Client client) {
        String allComplaints
                = client.target("http://localhost:8080/Complaints/"
                        + "resources/complaints?status=open")
                        .request(
                                MediaType.APPLICATION_JSON)
                        .get(String.class);
        //System.out.println("AllOpenComplaints:\n " + allComplaints);
        JSONArray obj = new JSONArray(allComplaints);
        System.out.println("All open complaints:\n"+obj.toString(4));
    }

}
