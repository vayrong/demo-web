package com.example.herokudemo.mapping;

import java.lang.reflect.Method;

public class ObjectMapping {
    Object entityToDto(Object object) {
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        for (Method m : declaredMethods) {
            m.getName();
        }
        return null;
    }
    Object dtoToEntity(Object object) {
        return null;
    }
}
