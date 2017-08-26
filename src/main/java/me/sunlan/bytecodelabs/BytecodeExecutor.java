package me.sunlan.bytecodelabs;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BytecodeExecutor {
    public static void main(String[] args) throws Throwable {
        SimpleClassLoader simpleClassLoader = new SimpleClassLoader();
        Thread.currentThread().setContextClassLoader(simpleClassLoader);

        final Constructor<MethodHandles.Lookup> constructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, int.class);
        if (!constructor.isAccessible()) {
            constructor.setAccessible(true);
        }

        Class<InterfaceWithDefaultMethod> interfaceWithDefaultMethodClass = (Class<InterfaceWithDefaultMethod>) simpleClassLoader.loadClass("me.sunlan.bytecodelabs.InterfaceWithDefaultMethod");

        Object obj = Proxy.newProxyInstance(simpleClassLoader, new Class[]{interfaceWithDefaultMethodClass}, (Object proxy, Method method, Object[] arguments) -> null);

        /*
        InterfaceWithDefaultMethod target =
                //new InterfaceWithDefaultMethod(){};
                (InterfaceWithDefaultMethod) obj;

        */

        Method method = interfaceWithDefaultMethodClass.getMethod("helloworld2");

        Object result = constructor.newInstance(method.getDeclaringClass(), MethodHandles.Lookup.PRIVATE)
                .unreflectSpecial(method, method.getDeclaringClass())
                .bindTo(obj)
                .invokeWithArguments();

    }
}
