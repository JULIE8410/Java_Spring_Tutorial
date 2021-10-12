package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest1 {

    @Test
    void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient1 client = ac.getBean(NetworkClient1.class);
        ac.close();  // Provided by ConfigurableApplicationContext
    }

    @Configuration
    static class LifeCycleConfig{

        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient1 networkClient1(){
            NetworkClient1 networkClient1 = new NetworkClient1();
            networkClient1.setUrl("https://hello-spring.dev");
            return networkClient1;
        }
    }
}
