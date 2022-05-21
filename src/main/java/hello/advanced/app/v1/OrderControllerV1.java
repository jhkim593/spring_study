package hello.advanced.app.v1;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.helloTrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {

    private final OrderServiceV1 orderService;
    private final HelloTraceV1 trace;


    @GetMapping("/v1/request")
    public String request(String itemId) {
        TraceStatus traceStatus=null;
        try{
            traceStatus = trace.begin("request OrderControllerV1");
            orderService.orderItem(itemId);
            trace.end(traceStatus);
            return "ok";
        }catch (Exception e){
            trace.exception(traceStatus,e);
            throw  e;
        }
    }
}
