package hello.proxy.pureProxy.decorator.code;

import hello.proxy.pureProxy.decorator.code.Component;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class  MessageDecorator extends Decorator {

    public MessageDecorator(Component component) {
        super(component);
    }

    @Override
    public String operation() {
        log.info("MessageDecorator 실행");
        String result=component.operation();
        String decoratorResult = "*****" + result + "*****";
        log.info("MessageDecorator 적용 꾸미기전 ={} , 후={}",result,decoratorResult);
        return decoratorResult;
    }
}


