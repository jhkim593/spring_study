package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class ThreadLocalLogTraceTest {
    ThreadLocalLogTrace threadLocalLogTrace =new ThreadLocalLogTrace();


    @Test
    public void begin_end_level2()throws Exception{
        TraceStatus status1 = threadLocalLogTrace.begin("hello1");
        TraceStatus status2 = threadLocalLogTrace.begin("hello2");
        threadLocalLogTrace.end(status2);
        threadLocalLogTrace.end(status1);

    }
    @Test
    public void begin_end_level2_exception()throws Exception{
        TraceStatus status1 = threadLocalLogTrace.begin("hello1");
        TraceStatus status2 = threadLocalLogTrace.begin("hello2");
        threadLocalLogTrace.exception(status2,new IllegalStateException());
        threadLocalLogTrace.exception(status1,new IllegalStateException());

    }

}