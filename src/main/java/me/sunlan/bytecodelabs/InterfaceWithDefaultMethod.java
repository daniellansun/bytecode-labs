package me.sunlan.bytecodelabs;

public interface InterfaceWithDefaultMethod {
    //void helloworld();
    default void helloworld2() {
        System.out.println("hello, world!");
    }
}
