package com.dingding.alarm.dingding;

/**
 * Massage 的主要职责:
 *
 * @ClassName Massage
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/8/27 17:55
 * @Version V1.0
 **/
public class Massage {
    private String msgtype;
    private AbstractMassage text;
    private SomeBodyAt at;

    public Massage() {

    }

    public Massage(String msgtype, AbstractMassage text, SomeBodyAt at) {
        this.msgtype = msgtype;
        this.text = text;
        this.at = at;
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }

    public AbstractMassage getText() {
        return text;
    }

    public void setText(AbstractMassage text) {
        this.text = text;
    }

    public SomeBodyAt getAt() {
        return at;
    }

    public void setAt(SomeBodyAt at) {
        this.at = at;
    }
}
