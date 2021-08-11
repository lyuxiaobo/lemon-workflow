package com.lemon.mobile.bean;

/**
 * @author Lyubo
 * @date 2021/8/11
 * Description:
 */
public class FinishTaskRequestBean {
    private String action;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "FinishTaskRequestBean{" +
                "action='" + action + '\'' +
                '}';
    }
}
