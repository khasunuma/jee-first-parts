package com.poortoys.jeefirstparts.examples;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CdiBean1 {

    @Inject
    CdiBean2 bean2;

    public void compute() {
        bean2.execute();
    }

}
