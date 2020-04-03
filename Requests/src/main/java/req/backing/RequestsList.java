/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package req.backing;

import java.time.LocalDate;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.inject.Inject;
import javax.validation.constraints.Size;
import req.entities.Request;
import req.facade.RequestFacadeLocal;

/**
 *
 * @author mw121
 */
@Named(value = "requestsList")
@RequestScoped
public class RequestsList {

    @Inject
    private RequestFacadeLocal requestFacade;

    /**
     * Creates a new instance of RequestsList
     */
    public RequestsList() {
    }

    public List<Request> getAllRequests() {
        return this.requestFacade.findAll();
    }
    
    @Size(min=3, max=60, message="{request.size}")
    private String newRequest;

    /**
     * Get the value of newRequest
     *
     * @return the value of newRequest
     */
    public String getNewRequest() {
        return newRequest;
    }

    /**
     * Set the value of newRequest
     *
     * @param newRequest new value of newRequest
     */
    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    private HtmlDataTable requestDataTable;

    /**
     * Get the value of requestDataTable
     *
     * @return the value of requestDataTable
     */
    public HtmlDataTable getRequestDataTable() {
        return requestDataTable;
    }

    /**
     * Set the value of requestDataTable
     *
     * @param requestDataTable new value of requestDataTable
     */
    public void setRequestDataTable(HtmlDataTable requestDataTable) {
        this.requestDataTable = requestDataTable;
    }

    public String addRequest() {
        Request req = new Request();
        req.setRequestDate(LocalDate.now());
        req.setRequestText(this.newRequest);
        this.requestFacade.create(req);
        //setNewRequest("");
        return null;
    }

    public String deleteRequest() {
        Request req = (Request) getRequestDataTable().getRowData();
        this.requestFacade.remove(req);
        return null;
    }
}
