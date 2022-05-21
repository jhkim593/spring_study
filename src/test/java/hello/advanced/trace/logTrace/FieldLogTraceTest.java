package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class FieldLogTraceTest {
    FieldLogTrace fieldLogTrace=new FieldLogTrace();


    @Test
    public void begin_end_level2()throws Exception{
        TraceStatus status1 = fieldLogTrace.begin("hello1");
        TraceStatus status2 = fieldLogTrace.begin("hello2");
        fieldLogTrace.end(status2);
        fieldLogTrace.end(status1);

    }
    @Test
    public void begin_end_level2_exception()throws Exception{
        TraceStatus status1 = fieldLogTrace.begin("hello1");
        TraceStatus status2 = fieldLogTrace.begin("hello2");
        fieldLogTrace.exception(status2,new IllegalStateException());
        fieldLogTrace.exception(status1,new IllegalStateException());

    }

}