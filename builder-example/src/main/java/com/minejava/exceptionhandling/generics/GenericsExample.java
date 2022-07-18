package com.minejava.exceptionhandling.generics;

public class GenericsExample<T, U> {

    // Define fields
    T someInteger;
    U anotherDouble;

    public GenericsExample(T someInteger, U anotherDouble) {
        this.someInteger = someInteger;
        this.anotherDouble = anotherDouble;
    }

    public T getSomeInteger() {
        return someInteger;
    }

    public void setSomeInteger(T someInteger) {
        this.someInteger = someInteger;
    }

    public U getAnotherDouble() {
        return anotherDouble;
    }

    public void setAnotherDouble(U anotherDouble) {
        this.anotherDouble = anotherDouble;
    }

    @Override
    public String toString() {
        return "GenericsExample [anotherDouble=" + anotherDouble + ", someInteger=" + someInteger + "]";
    }




}
