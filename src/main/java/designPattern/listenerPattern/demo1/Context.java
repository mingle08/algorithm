package designPattern.listenerPattern.demo1;

import java.util.ArrayList;
import java.util.List;

public class Context {
    private static List<IListener> list = new ArrayList<IListener>();

    public static void addListener(IListener iListener) {
        list.add(iListener);
    }

    public static void removeListener(IListener iListener) {
        list.remove(iListener);
    }

    public static void sendNotification(Event event) {
        for (IListener iListener : list) {
            iListener.onChange(event);
        }
    }
}
