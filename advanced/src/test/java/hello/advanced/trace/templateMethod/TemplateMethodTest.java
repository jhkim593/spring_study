package hello.advanced.trace.templateMethod;

import hello.advanced.trace.template.AbstractTemplate;
import hello.advanced.trace.threadLocal.code.SubClassLogic1;
import hello.advanced.trace.threadLocal.code.SubClassLogin2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {
    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }
    private void logic1() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
    private void logic2() {
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);
    }
    @Test
    public void templateMethodV1()throws Exception{
        AbstractTemplate template1 = new SubClassLogic1();
        template1.execute();

        AbstractTemplate template2=new SubClassLogin2();
        template2.execute();

    }
    @Test
    public void templateMethodV2()throws Exception{
       AbstractTemplate template1=new AbstractTemplate() {
           @Override
           public void call() {
               log.info("비즈니스 로직1 실행");
           }
       };
       log.info("클래스 이름 ={}",template1.getClass());
       template1.execute();

        AbstractTemplate template2=new AbstractTemplate() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        log.info("클래스 이름 ={}",template2.getClass());
        template2.execute();
    }
}
