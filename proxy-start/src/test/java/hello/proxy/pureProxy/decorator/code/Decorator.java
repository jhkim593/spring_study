package hello.proxy.pureProxy.decorator.code;

public abstract class Decorator implements Component{
    public Component component;
    public Decorator(Component component) {
        this.component=component;
    }

}
