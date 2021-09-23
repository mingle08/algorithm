package dubbo.ioc;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

public class DubboIocTest {

    public static void main(String[] args) {
        ExtensionLoader<Animal> extensionLoader = ExtensionLoader.getExtensionLoader(Animal.class);
        Animal animal = extensionLoader.getExtension("bird");

        Map<String, String> map = new HashMap<>();
        map.put("friend", "cat");
        URL url = new URL("", "", 1, map);
        animal.speak(url);
    }
}
