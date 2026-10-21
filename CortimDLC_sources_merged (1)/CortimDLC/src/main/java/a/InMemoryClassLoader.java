/*
 * Decompiled with CFR 0.152.
 */
package a;

import a.dsx;
import a.dta;
import flow.dev.StringDecryptor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public final class InMemoryClassLoader
extends ClassLoader {
    private final Map<String, byte[]> dtf;
    private final Map<String, byte[]> dtg;
    private static /* synthetic */ String dth;
    private static /* synthetic */ long dti;

    public InMemoryClassLoader(ClassLoader classLoader, HashMap<String, byte[]> hashMap, HashMap<String, byte[]> hashMap2) {
        super(classLoader);
        this.dtf = hashMap;
        this.dtg = hashMap2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected Class<?> loadClass(String string, boolean bl) throws ClassNotFoundException {
        Object object = this.getClassLoadingLock(string);
        synchronized (object) {
            Class<?> clazz = this.findLoadedClass(string);
            if (clazz == null) {
                if (string.startsWith("flow.")) {
                    try {
                        clazz = this.findClass(string);
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        clazz = super.loadClass(string, false);
                    }
                } else {
                    clazz = super.loadClass(string, false);
                }
            }
            if (bl) {
                this.resolveClass(clazz);
            }
            return clazz;
        }
    }

    @Override
    protected Class<?> findClass(String string) throws ClassNotFoundException {
        byte[] byArray;
        byte[] byArray2 = byArray = this.dtf != null ? this.dtf.get(string) : null;
        if (byArray == null) {
            throw new ClassNotFoundException(string);
        }
        return this.defineClass(string, byArray, 0, byArray.length);
    }

    @Override
    protected URL findResource(String string) {
        byte[] byArray;
        if (string == null) {
            return null;
        }
        String string2 = string.startsWith("/") ? string.substring(1) : string;
        byte[] byArray2 = byArray = this.dtg != null ? this.dtg.get(string2) : null;
        if (byArray == null) {
            return super.findResource(string);
        }
        try {
            return new URL("flow2mem", "", -1, "/" + string2, new dsx(this, byArray));
        }
        catch (Exception exception) {
            return null;
        }
    }

    @Override
    public InputStream getResourceAsStream(String string) {
        byte[] byArray;
        if (string == null) {
            return null;
        }
        String string2 = string.startsWith("/") ? string.substring(1) : string;
        byte[] byArray2 = byArray = this.dtg != null ? this.dtg.get(string2) : null;
        if (byArray != null) {
            return new ByteArrayInputStream(byArray);
        }
        return super.getResourceAsStream(string);
    }

    @Override
    protected Enumeration<URL> findResources(String string) throws IOException {
        URL uRL = this.findResource(string);
        if (uRL == null) {
            Enumeration<URL> enumeration = super.getResources(string);
            return enumeration != null ? enumeration : Collections.emptyEnumeration();
        }
        return Collections.enumeration(Collections.singletonList(uRL));
    }

    public static void installStdoutFilter() {
        try {
            System.setOut(InMemoryClassLoader.dtj(System.out));
            System.setErr(InMemoryClassLoader.dtj(System.err));
        }
        catch (Throwable throwable) {
            // empty catch block
        }
    }

    private static PrintStream dtj(PrintStream printStream) {
        return new PrintStream((OutputStream)new dta(printStream), true, StandardCharsets.UTF_8);
    }

    private static /* synthetic */ int ac(int n, int n2) {
        return n + n2 + 1879057915;
    }

    private static /* synthetic */ int ad(int n, int n2) {
        return n - n2 ^ 0x437DEDFB;
    }
}

