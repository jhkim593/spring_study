package hello.aop.member;

import hello.aop.member.annotation.MethodAop;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements  MemberService{
    @Override
    @MethodAop("test value")
    public String hello(String param) {
        return "ok";
    }
    public String internal(String name){
        return "ok";
    }
}
