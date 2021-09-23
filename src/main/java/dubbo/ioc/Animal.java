package dubbo.ioc;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

@SPI
public interface Animal {
    public void speak();

    @Adaptive("friend")
    public void speak(URL url);
}
