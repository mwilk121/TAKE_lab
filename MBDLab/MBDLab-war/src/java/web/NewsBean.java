/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import ejb.NewsItem;
import ejb.NewsItemFacadeLocal;
import java.util.List;
import javax.annotation.Resource;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

/**
 *
 * @author mw121
 */
@Named(value = "newsBean")
@RequestScoped
public class NewsBean {

    @Inject
    private NewsItemFacadeLocal facade;
    @Inject
    private JMSContext context;
    @Resource(lookup = "java:app/jms/NewsQueue")
    private javax.jms.Queue queue;

    private String headingText;
    private String bodyText;

    /**
     * Creates a new instance of NewsBean
     */
    public NewsBean() {
    }

    void sendNewsText(String heading, String body) {
        TextMessage message = context.createTextMessage(heading + "|" + body);
        context.createProducer().send(queue, message);
    }

    void sendNewsItem(String heading, String body) {
        try {
            ObjectMessage message = context.createObjectMessage();
            NewsItem e = new NewsItem();
            e.setHeading(heading);
            e.setBody(body);
            message.setObject(e);
            context.createProducer().send(queue, message);
        } catch (JMSException ex) {
            ex.printStackTrace();
        }
    }

    public String submitNews() {
        sendNewsItem(headingText, bodyText);
        return null;
    }

    public String submitNewsAsText() {
        sendNewsText(headingText, bodyText);
        return null;
    }

    public List<NewsItem> getNewsItems() {
        return this.facade.getAllNewsItems();
    }

    /**
     * @return the heaindText
     */
    public String getHeadingText() {
        return headingText;
    }

    /**
     * @param heaindText the heaindText to set
     */
    public void setHeadingText(String headingText) {
        this.headingText = headingText;
    }

    /**
     * @return the bodyText
     */
    public String getBodyText() {
        return bodyText;
    }

    /**
     * @param bodyText the bodyText to set
     */
    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

}
