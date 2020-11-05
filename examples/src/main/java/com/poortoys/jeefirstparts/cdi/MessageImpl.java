package com.poortoys.jeefirstparts.cdi;

import java.io.Serializable;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Named
@Dependent
public class MessageImpl implements Message, Serializable {
    private static final long serialVersionUID = 1L;

    @Override
    public String getMessage() {
        return "Hello!";
    }

}
