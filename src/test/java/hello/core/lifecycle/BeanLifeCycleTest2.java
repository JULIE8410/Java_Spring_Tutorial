package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest2 {

    @Test
    void lifeCycleTest(){
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient2 client = ac.getBean(NetworkClient2.class);
        ac.close();  // Provided by ConfigurableApplicationContext
    }

    @Configuration
    static class LifeCycleConfig{

        @Bean
        public NetworkClient2 networkClient1(){
            NetworkClient2 networkClient2 = new NetworkClient2();
            networkClient2.setUrl("https://hello-spring.dev");
            return networkClient2;
        }
    }
}
