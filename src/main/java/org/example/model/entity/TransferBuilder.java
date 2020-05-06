package org.example.model.entity;

import java.sql.Date;

public class TransferBuilder {
    private int i;
    private int s;
    private int d;
    private int a;
    private Date dt;
    private TransferData.TYPE t;

    public TransferBuilder id(int i){
        this.i = i;
        return this;
    }

    public TransferBuilder sourceId(int s){
        this.s = s;
        return this;
    }
    public TransferBuilder destId(int d){
        this.d = d;
        return this;
    }
    public TransferBuilder amount(int a){
        this.a = a;
        return this;
    }
    public TransferBuilder date(Date dt){
        this.dt = dt;
        return this;
    }
    public TransferBuilder type(TransferData.TYPE t){
        this.t = t;
        return this;
    }

    public TransferData build(){
        TransferData transferData = new TransferData();
        transferData.setId(i);
        transferData.setSourceId(s);
        transferData.setDestId(d);
        transferData.setAmount(a);
        transferData.setDate(dt);
        transferData.setType(t);
        return transferData;
    }

}
