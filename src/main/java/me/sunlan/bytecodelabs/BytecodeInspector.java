package me.sunlan.bytecodelabs;

import org.objectweb.asm.util.ASMifier;

public class BytecodeInspector {
    public static void main(String[] args) throws Exception {
        ASMifier.main(new String[]{"build/classes/java/main/me/sunlan/bytecodelabs/InterfaceWithDefaultMethod.class"});
    }
}
