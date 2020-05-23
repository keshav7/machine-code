

package com.base.dream11;


class B extends Exception {};
class C extends B {};

public class A {

  public static void main(String[] args) {
    //  try {
    //    throw new B();
    //  } catch (B e) {
    //    System.out.println("hello");
    //  } catch(Exception w) {
    //    System.out.println("hi");
    //  }
    //}

    Float f = new Float("3.0");

    int i = f.intValue();
    byte b = f.byteValue();
    double d = f.doubleValue();
    System.out.println(i + b + d);

  }


}
