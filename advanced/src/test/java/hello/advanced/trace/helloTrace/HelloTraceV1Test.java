package hello.advanced.trace.helloTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class HelloTraceV1Test {
    @Test
    public void begin_end()throws Exception{
        HelloTraceV1 traceV1=new HelloTraceV1();
        TraceStatus test = traceV1.begin("test");
        traceV1.end(test);

    }
    @Test
    public void begin_exception()throws Exception{
        HelloTraceV1 traceV1=new HelloTraceV1();
        TraceStatus begin = traceV1.begin("test");
        traceV1.exception(begin, new IllegalStateException());

    }

}