package com.minejava.lambas;

public class LambdaExamples implements LambdaInterface {

    @Override
    public void mySoleMethod(String someValue) {
        // DO Auto-generated method stub
        System.out.println(someValue);
    }

    public void smyImpl(LambdaInterface lambdaInterface) {
        lambdaInterface.mySoleMethod("Hello!! ");
    }

}
