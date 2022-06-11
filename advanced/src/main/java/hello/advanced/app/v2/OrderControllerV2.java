package hello.advanced.app.v2;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import hello.advanced.trace.helloTrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {

    private final OrderServiceV2 orderService;
    private final HelloTraceV2 trace;


    @GetMapping("/v2/request")
    public String request(String itemId) {
        TraceStatus traceStatus=null;
        try{
            traceStatus = trace.begin("request OrderControllerV2");
            orderService.orderItem(traceStatus.getTraceId(),itemId);
            trace.end(traceStatus);
            return "ok";
        }catch (Exception e){
            trace.exception(traceStatus,e);
            throw  e;
        }
    }
}
