package com.oracle.jp.jpa;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity(name = "Item")
@Table(name = "ITEMS")
@Access(AccessType.FIELD)
@NamedQueries({
    @NamedQuery(name = "getItemById", query = "SELECT i FROM Item i WHERE i.id = :id"),
    @NamedQuery(name = "getAllItems", query = "SELECT i FROM Item i")
})
public class Item {
    @Id
    @Column(name = "ITEM_ID", nullable = false, updatable = false)
    private int id;

    @Basic(optional = false)
    @Column(name = "ITEM_TITLE")
    private String name;

    @Basic(optional = false)
    @Column(name = "ITEM_DESC")
    private String desc;

    @Basic(optional = false)
    @Column(name = "ITEM_POST_DATE")
    private String date;

    @Basic(optional = false)
    @Column(name = "ITEM_POSTED_BY")
    private String postedBy;

    @Basic(optional = false)
    @Column(name = "ITEM_BOUGHT_BY")
    private String boughtBy;

    @Basic(optional = false)
    @Column(name = "ITEM_PRICE")
    private String price;

    @Basic(optional = false)
    @Column(name = "ITEM_STATUS")
    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getBoughtBy() {
        return boughtBy;
    }

    public void setBoughtBy(String boughtBy) {
        this.boughtBy = boughtBy;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", name=" + name + ", desc=" + desc + ", date=" + date + ", postedBy=" + postedBy
                + ", boughtBy=" + boughtBy + ", price=" + price + ", status=" + status + "]";
    }
    
}
