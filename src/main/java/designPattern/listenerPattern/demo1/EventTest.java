package designPattern.listenerPattern.demo1;

public class EventTest {
    public static void main(String[] args) {
        IListener IListener = new MyIListener();
        //添加监听者
        Context.addListener(IListener);
        //模拟安装完成事件触发
        Context.sendNotification(new Event(Event.INSTALLED, new Object()));
    }
}
