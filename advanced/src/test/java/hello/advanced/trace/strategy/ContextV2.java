package hello.advanced.trace.strategy;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2 {

    /**
     * 의존성을 주입받아 선조립하는 v1과 다르게 유연하게 strategy를 선정
     * 단점은 실행할때마다 파라미터로 넘겨줘야됨
     * V1과 다르게 파리미터로 받음음
     * */
   public void execute(Strategy strategy){
        long startTime = System.currentTimeMillis();
        //비즈니스 로직 실행
        strategy.call();
        //비즈니스 로직 종료
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime={}", resultTime);

    }

}
