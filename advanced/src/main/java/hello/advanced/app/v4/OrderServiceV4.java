package hello.advanced.app.v4;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.LogTrace;
import hello.advanced.trace.template.NewAbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;

    private final LogTrace trace;


    public void orderItem(String itemId) {

        NewAbstractTemplate<Void> template=new NewAbstractTemplate(trace) {
            @Override
            public Void call() {
              orderRepository.save(itemId);
                return null;
            }
        };
       template.execute("OrderController.request()");
    }

}

