package com.poortoys.jeefirstparts.examples;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CdiBean2 {

    public String execute() {
        return "executed by CdiBean2";
    }

}
