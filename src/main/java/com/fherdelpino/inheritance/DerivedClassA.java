package com.fherdelpino.inheritance;

public class DerivedClassA extends BaseClass {

    public static void main(String[] args) {
        new DerivedClassA().aPrivateMethod();
    }

    private void myMethod() {
        aPublicMethod();
        aDefaultMethod();
        aProtectedMethod();
    }

    @Override
    public void aPublicMethod() {
        super.aPublicMethod();
    }

    @Override
    void aDefaultMethod() {
        super.aDefaultMethod();
    }

    @Override
    protected void aProtectedMethod() {
        super.aProtectedMethod();
    }

    private void aPrivateMethod() {
        System.out.println("Print from DerivedClassA");
    }

    @Override
    public void anAbstractMethod() {

    }

}
