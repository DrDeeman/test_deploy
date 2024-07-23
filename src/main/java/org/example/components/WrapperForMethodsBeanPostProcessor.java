package org.example.components;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

@Component
public class WrapperForMethodsBeanPostProcessor implements BeanPostProcessor {

    Map<String, Class> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {

        if( bean.getClass().getAnnotation(WrapperForMethods.class) != null){
            map.put(beanName,bean.getClass());
        }

       return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
        Class<?> beanClass = map.get(beanName);

        if(beanClass != null){
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        System.out.println("Before work method...");
                        method.setAccessible(true);
                        method.invoke(bean,args);
                        System.out.println("After work method...");
                        return proxy;
                    }
            );
        }

        return bean;
    }

}
