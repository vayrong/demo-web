package com.example.herokudemo.mapping;


import com.example.herokudemo.models.Order;
import com.example.herokudemo.pojo.OrderDto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class OrderMapping {
    OrderDto entityToDto(Order object) throws InvocationTargetException, IllegalAccessException {
        OrderDto orderDto = new OrderDto();
        Method[] declaredMethods = object.getClass().getDeclaredMethods();
        Method[] declaredMethods1 = orderDto.getClass().getDeclaredMethods();
        for (Method m : declaredMethods) {
            String functionName = m.getName();
            // funcationName = "getId"
            String resultName = "setId";
            for (Method m2 : declaredMethods1) {
                if (m2.getName().endsWith(resultName)) {
                    m2.invoke(m2, m.invoke(m));
                }
            }
        }
        return null;
    }
    Object dtoToEntity(Object object) {
        return null;
    }
}
