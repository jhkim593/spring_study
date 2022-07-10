package hello.proxy.postProcessor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BasicTest {

    @Test
    void basicConfig(){
        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(BasicConfig.class);
        B beanA = applicationContext.getBean("beanA", B.class);
        beanA.hello();

    }

    @Slf4j
    @Configuration
    static class BasicConfig {
        @Bean(name = "beanA")
        public A a() {
            return new A();
        }
        @Bean
        public AToBPostProcessor AToBPostProcessor(){
            return new AToBPostProcessor();
        }

    }
    @Slf4j
    static class A{
        public void hello(){
            log.info("hello A");
        }
    }
    @Slf4j
    static class B{
        public void hello(){
            log.info("hello B");
        }
    }
    @Slf4j
    static class AToBPostProcessor implements BeanPostProcessor{
        @Override
        public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
            log.info("beanName={} bean={}",beanName ,bean);
            if(bean instanceof A){
                return new B();
            }
            return bean;
        }
    }
}
