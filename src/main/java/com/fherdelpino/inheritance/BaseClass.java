package com.fherdelpino.inheritance;

public abstract class BaseClass {

    public static void main(String[] args) {
        aPrivateMethod();
    }

    public void aPublicMethod() {

    }

    void aDefaultMethod() {

    }

    protected void aProtectedMethod() {

    }

    static private void aPrivateMethod() {
        System.out.println("Print from BaseClass");
    }

    public abstract void anAbstractMethod();
}
