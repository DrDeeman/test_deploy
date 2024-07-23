package org.example;

import jakarta.annotation.PostConstruct;
import org.example.components.GeneratorValue;
import org.example.components.WrapperForMethods;
import org.springframework.stereotype.Component;


@WrapperForMethods
@Component
public class TestObjectImpl implements TestObject{

    @GeneratorValue(min=1,max=10)
    private int ident;


    TestObjectImpl(){
        System.out.println("phase1:"+ident);
    }

    @PostConstruct
    void init(){
        System.out.println("phase2:"+ident);
    }

    public void getIdent(){
        System.out.println("Value ident:"+ident);
    }
}
