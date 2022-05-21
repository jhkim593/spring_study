package hello.advanced.trace.template;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logTrace.LogTrace;

public abstract class NewAbstractTemplate<T> {

    private final LogTrace logTrace;

    public NewAbstractTemplate(LogTrace logTrace){
        this.logTrace=logTrace;
    }

    public T execute(String message){
        TraceStatus status=null;
        try{
            status=logTrace.begin("message");
            T result=call();
            logTrace.end(status);
            return result;
        }catch (Exception e){
            logTrace.exception(status,e);
            throw e;
        }
    }
    protected abstract T call();
}
