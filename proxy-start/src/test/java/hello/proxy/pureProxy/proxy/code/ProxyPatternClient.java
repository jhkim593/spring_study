package hello.proxy.pureProxy.proxy.code;

import hello.proxy.pureProxy.proxy.code.Subject;

public class ProxyPatternClient {

    private Subject subject;
    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }
    public void execute() {
        subject.operation();
    }
}
