package hello.core.singleton;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA: User A ordered 10000
//        statefulService1.order("User A", 10000);
        int userA_Price = statefulService1.order("User A", 10000);

        // ThreadB: User B ordered 20000
//        statefulService1.order("User B", 20000);
        int userB_Price = statefulService1.order("User B", 20000);

        // ThreadA: print out the price of User A => The result is not what we expected!
        // That's why we need to make Spring bean stateless
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);   //20000
        System.out.println("Price = " + userA_Price);   //10000

//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);

    }

    static class TestConfig{

        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }


}