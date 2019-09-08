package com.dingding.alarm.dingding;

import java.util.Arrays;

/**
 * SomeBodyAt 的主要职责:
 *
 * @ClassName SomeBodyAt
 * @Description: TODO
 * @Author songbai yang
 * @Date 2019/8/27 17:54
 * @Version V1.0
 **/
public class SomeBodyAt {
    private String []atMobiles;
    private boolean isAtAll;

    public SomeBodyAt() {
        atMobiles = new String[0];
        isAtAll = false;
    }

    public SomeBodyAt(String[] atMobiles, boolean isAtAll) {
        this.atMobiles = atMobiles;
        this.isAtAll = isAtAll;
    }

    public String[] getAtMobiles() {
        return atMobiles;
    }

    public void setAtMobiles(String[] atMobiles) {
        this.atMobiles = atMobiles;
    }

    public boolean isAtAll() {
        return isAtAll;
    }

    public void setAtAll(boolean atAll) {
        isAtAll = atAll;
    }

    @Override
    public String toString() {
        return "at{" +
                "atMobiles=" + Arrays.toString(atMobiles) +
                ", isAtAll=" + isAtAll +
                '}';
    }
}
