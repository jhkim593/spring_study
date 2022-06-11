package hello.advanced.app.v3;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {

    private final OrderRepositoryV3 orderRepository;

    private final LogTrace trace;

    public void orderItem(String itemId) {

        TraceStatus traceStatus=null;
        try{
            traceStatus = trace.begin("request OrderServiceV2");
            orderRepository.save(itemId);
            trace.end(traceStatus);
        }catch (Exception e){
            trace.exception(traceStatus,e);
            throw  e;
        }
    }
 }

