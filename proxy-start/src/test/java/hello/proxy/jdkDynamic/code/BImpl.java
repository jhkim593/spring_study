package hello.proxy.jdkDynamic.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImpl implements BInterface{
    @Override
    public String call(String s) {
        log.info("B 호출");
        return "b";
    }
}