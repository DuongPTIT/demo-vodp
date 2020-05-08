package com.viettel.democdc.Domain;

import javax.persistence.*;

@Entity
@Table(name = "rely_message")
public class RelyMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "msgcontent")
    private String msg;


    public RelyMessage() {
    }

    public RelyMessage(String msg) {
        this.msg = msg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
