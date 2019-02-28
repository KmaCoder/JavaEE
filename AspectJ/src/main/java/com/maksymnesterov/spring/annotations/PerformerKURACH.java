package com.maksymnesterov.spring.annotations;

public class PerformerKURACH implements IPerformer {

    public void perform() throws Exception {
        System.out.println("Kurach performed!");
        throw new Exception();
    }
}