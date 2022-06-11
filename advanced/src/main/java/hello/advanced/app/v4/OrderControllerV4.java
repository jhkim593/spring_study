package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.LogTrace;
import hello.advanced.trace.template.AbstractTemplate;
import hello.advanced.trace.template.NewAbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {

    private final OrderServiceV4 orderService;
    private final LogTrace trace;


    @GetMapping("/v4/request")
    public String request(String itemId) {
        NewAbstractTemplate<String> template=new NewAbstractTemplate(trace) {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
       return template.execute("OrderController.request()");
    }
}
