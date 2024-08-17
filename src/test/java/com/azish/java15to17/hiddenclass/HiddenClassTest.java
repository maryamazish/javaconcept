package com.azish.java15to17.hiddenclass;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HiddenClassTest {
    @Test
    void hiddenClass_test() throws
            IOException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException {

        Class<?> clazz = HiddenClass.class;
        String className = clazz.getName();
        String classAsPath = className.replace('.', '/') + ".class";
        InputStream stream = clazz.getClassLoader().getResourceAsStream(classAsPath);
        byte[] bytes = stream.readAllBytes();

        MethodHandles.Lookup lookup = MethodHandles.lookup();
        Class<?> hiddenClass = lookup.defineHiddenClass(bytes, true, MethodHandles.Lookup.ClassOption.NESTMATE).lookupClass();
        Object hiddenClassObject = hiddenClass.getConstructor().newInstance();
        Method method = hiddenClassObject.getClass()
                .getDeclaredMethod("convertToUpperCase", String.class);
        assertEquals("HELLO", method.invoke(hiddenClassObject, "Hello"));
    }
}
