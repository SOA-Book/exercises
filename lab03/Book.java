package au.edu.unsw.soacourse.books.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Book {

    private String id;
    private String title;
    private String detail;

    public Book(){

    }
    public Book (String id, String title){
        this.id = id;
        this.title = title;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDetail() {
        return detail;
    }
    public void setDetail(String detail) {
        this.detail = detail;
    }
}
