package com.minejava.exceptionhandling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionExample {

    public static void main(String[] args) {


    try {
        adding(2, 3);
    } catch (Exception e) {
        //DO: handle exception
    }

}
    public static void adding(Integer x, Integer y) {
        log.info("doing {}", x + y);
    }
}
