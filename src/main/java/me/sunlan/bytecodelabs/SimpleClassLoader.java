package me.sunlan.bytecodelabs;

public class SimpleClassLoader extends ClassLoader {
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {

        if (name.endsWith("InterfaceWithDefaultMethod")) {
            try {
                byte[] content = InterfaceWithDefaultMethodDump.dump();

                System.out.println("### dumped class found! ###");

                return defineClass(name, content, 0, content.length);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return super.loadClass(name, false);
    }
}
