package org.example.model.entity;

import java.sql.Date;

public class TransferData {
    private int id;
    private int sourceId;
    private int destId;
    private int amount;
    private Date date;


    public enum TYPE{
        TRANSFER, BILL, REPLENISHMENT
    }
    private TYPE type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public int getDestId() {
        return destId;
    }

    public void setDestId(int destId) {
        this.destId = destId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TYPE getType() {
        return type;
    }

    public void setType(TYPE type) {
        this.type = type;
    }

    public String toString() {
        return "TransferData{" +
                "id=" + id +
                ", sourceId=" + sourceId +
                ", destId=" + destId +
                ", amount=" + amount +
                ", date=" + date +
                ", type=" + type +
                '}';
    }
}