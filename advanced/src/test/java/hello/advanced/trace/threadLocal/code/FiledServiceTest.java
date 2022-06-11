package hello.advanced.trace.threadLocal.code;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FiledServiceTest {

    private FieldService fieldService=new FieldService();

    @Test
    public void field()throws Exception{
       log.info("main start");

       Runnable userA=()->{
           fieldService.logic("userA");
       };

        Runnable userB=()->{
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        sleep(100);
        threadB.start();


        //countdown latch 방법도 사용 가능
        sleep(2000);
        log.info("main start");


    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
