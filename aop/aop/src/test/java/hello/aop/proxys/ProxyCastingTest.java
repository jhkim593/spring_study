package hello.aop.proxys;

import hello.aop.member.MemberService;
import hello.aop.member.MemberServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

import static org.junit.jupiter.api.Assertions.assertThrows;

@Slf4j
public class ProxyCastingTest {

    @Test
    void jdkProxy(){
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true); //jdk 동적 프록시

        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();

        //jdk 동적 프록시를 구현 클래스로 캐스팅 시도 실패 , class casting Exception
        assertThrows(ClassCastException.class, () -> {
                    MemberServiceImpl castingMemberService =
                            (MemberServiceImpl) memberServiceProxy;
                }
        );
    }

    @Test
    void cglibProxy() {
        MemberServiceImpl target = new MemberServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.setProxyTargetClass(true);//CGLIB 프록시
        //프록시를 인터페이스로 캐스팅 성공
        MemberService memberServiceProxy = (MemberService) proxyFactory.getProxy();
        log.info("proxy class={}", memberServiceProxy.getClass());
        //CGLIB 프록시를 구현 클래스로 캐스팅 시도 성공
        MemberServiceImpl castingMemberService = (MemberServiceImpl)
                memberServiceProxy;
    }

}
