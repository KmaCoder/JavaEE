package com.maksymnesterov.spring.annotations;

public class PerformerKURACH implements IPerformer {

    public void perform() throws Exception {
        System.out.println("Bad person performed!");
        throw new Exception();
    }
}