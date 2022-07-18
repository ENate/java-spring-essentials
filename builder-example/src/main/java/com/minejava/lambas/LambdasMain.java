package com.minejava.lambas;

public class LambdasMain {
    public static void main(String[] args) {
        LambdaExamples lamExample = new LambdaExamples();
        LambdaInterface lambdaInterface = someValue -> System.out.println(someValue);

        lamExample.smyImpl(lambdaInterface);
    }
}
