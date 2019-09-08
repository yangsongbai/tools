package com.dingding.alarm.dingding;

/**
 * TextMassage 的主要职责:
 *
 * @ClassName TextMassage
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/8/27 17:53
 * @Version V1.0
 **/
public class TextMassage extends AbstractMassage {

    private String content;

    public TextMassage() {
    }

    public TextMassage(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "TextMassage{" +
                "content='" + content + '\'' +
                '}';
    }
}
