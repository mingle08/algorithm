package algo.jdk.StreamDemoOfJdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * stackoverflow
 * 从List中筛选出符合年龄>23的User,得到一个Map，key为User的name，值为age，
 * 如果有同名的，把age放到一个List中，即Map<String, List<age>> 类型
 */
public class MapDemo {

    public static void main(String[] args){
        List<User> users = new ArrayList<>();
        users.add(new User("Joey", "admin", 24));
        users.add(new User("Joey", "guest", 26));
        users.add(new User("Ross", "admin", 27));
        users.add(new User("Rachel", "guest", 21));
        users.add(new User("Monica", "super", 22));

        Map<String, List<Integer>> userNameAndAge = users.stream().filter(user -> user.getAge() > 23)
                .collect(Collectors.groupingBy(User::getName,
                                                Collectors.mapping(User::getAge,
                                                                    Collectors.toList()
                                                                  )
                                              )
                        );

        System.out.println(userNameAndAge);  // {Joey=[24, 26], Ross=[27]}
    }
}
