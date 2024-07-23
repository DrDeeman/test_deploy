package org.example.components;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class GeneratorValueAnnotationBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName){

         Field[] fields = bean.getClass().getDeclaredFields();

         for(Field f : fields){
             GeneratorValue annotation = f.getAnnotation(GeneratorValue.class);

             if(annotation != null){
                 int min = annotation.min();
                 int max = annotation.max();
                 f.setAccessible(true);
                 ReflectionUtils.setField(
                         f,
                         bean,
                         ThreadLocalRandom.current().nextInt(min, max + 1)
                 );
             }
         }

         return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName){
       return bean;
    }
}
