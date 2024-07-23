package org.example.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class PostProxyEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private ConfigurableListableBeanFactory factory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent e){
        ApplicationContext context = e.getApplicationContext();

        for(String beanDefinitionName : context.getBeanDefinitionNames()){
            try {
                String name = factory.getBeanDefinition(beanDefinitionName).getBeanClassName();
              if(name!=null) {
                  Class<?> originalClass = Class.forName(name);
                  for (Method method : originalClass.getMethods()) {
                      if (method.getAnnotation(PostProxy.class) != null) {
                          Class<?>[] interfaces = originalClass.getInterfaces();

                          if(interfaces.length > 0) {
                              Object bean = context.getBean(interfaces[0]);
                              Method currentMethod = bean.getClass().getMethod(method.getName(), method.getParameterTypes());
                              currentMethod.invoke(bean);
                          }
                      }
                  }
              }
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
