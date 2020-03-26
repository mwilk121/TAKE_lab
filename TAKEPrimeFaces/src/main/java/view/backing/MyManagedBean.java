/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.backing;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author mw121
 */
@Named(value = "myManagedBean")
@RequestScoped

public class MyManagedBean {

    /*private final int size = 4;
    private List<Student> students;*/
    private double a, b, res;
    //Random rand;

    /**
     * Creates a new instance of MyManagedBean
     */
    public MyManagedBean() {
        a = b = res = 0;

    }

    public void doAdd() {
        res = a + b;
        displayMessage();
    }

    public String getCurrentDate() {
        //SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        SimpleDateFormat formatter = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    public void displayMessage() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Add:", Double.toString(a) + "+" + Double.toString(b) + "=" + Double.toString(res)));
    }

    /**
     * @return the a
     */
    public double getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public double getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * @return the res
     */
    public double getRes() {
        return res;
    }

    /**
     * @param res the res to set
     */
    public void setRes(double res) {
        this.res = res;
    }

}
