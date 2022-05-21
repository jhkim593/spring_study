package hello.advanced.trace.helloTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;


class HelloTraceV2Test {
    @Test
    public void begin_end()throws Exception{
        HelloTraceV2 traceV2=new HelloTraceV2();
        TraceStatus test = traceV2.begin("test1");
        TraceStatus traceStatus = traceV2.beginSync(test.getTraceId(), "test2");
        traceV2.end(traceStatus);
        traceV2.end(test);

    }
    @Test
    public void begin_exception()throws Exception{
        HelloTraceV2 traceV2=new HelloTraceV2();
        TraceStatus begin = traceV2.begin("test1");
        TraceStatus traceStatus = traceV2.beginSync(begin.getTraceId(), "test2");
        traceV2.exception(traceStatus, new IllegalStateException());
        traceV2.exception(begin,new IllegalStateException());

    }

}