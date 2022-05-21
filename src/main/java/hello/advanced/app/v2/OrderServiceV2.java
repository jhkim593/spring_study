package hello.advanced.app.v2;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {

    private final OrderRepositoryV2 orderRepository;

    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {

        TraceStatus traceStatus=null;
        try{
            traceStatus = trace.beginSync(traceId,"request OrderServiceV2");
            orderRepository.save(traceStatus.getTraceId(),itemId);
            trace.end(traceStatus);
        }catch (Exception e){
            trace.exception(traceStatus,e);
            throw  e;
        }
    }
 }

