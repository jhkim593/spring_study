package hello.advanced.trace.threadLocal.code;

import hello.advanced.trace.template.AbstractTemplate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic1 extends AbstractTemplate {
    @Override
    public void call() {
        log.info("비즈니스 로직 2실행");
    }
}
