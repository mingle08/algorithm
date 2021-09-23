package dubbo.ioc;

import com.alibaba.dubbo.common.URL;

public class Bird implements Animal {

    private Animal friend;

    @Override
    public void speak() {
        System.out.println("I am a bird");
    }

    @Override
    public void speak(URL url) {
        friend.speak(url);
    }

    public void setFriend(Animal friend) {
        this.friend = friend;
    }
}
