package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan
public class App 
{

    public static void main( String[] args )
    {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(App.class);

        System.out.println( "Hello World! I am alive" );
        applicationContext.getBean(TestObject.class).getIdent();
    }


}
