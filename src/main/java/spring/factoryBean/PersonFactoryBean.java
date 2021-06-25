package spring.factoryBean;

import org.springframework.beans.factory.FactoryBean;

import java.util.Objects;

/**
 * T getObject()：返回实例
 * Class<?> getObjectType();:返回该装饰对象的Bean的类型
 * default boolean isSingleton():Bean是否为单例
 * <p>
 * 在某些情况下，对于实例Bean对象比较复杂的情况下，使用传统方式创建bean会比较复杂，例如（使用xml配置），这样就出现了FactoryBean接口，
 * 可以让用户通过实现该接口来自定义该Bean接口的实例化过程。即包装一层，将复杂的初始化过程包装，让调用者无需关系具体实现细节。
 */
public class PersonFactoryBean implements FactoryBean<Person> {

    private String nameAgeStr;

    @Override
    public Person getObject() throws Exception {
        //获取参数
        Objects.requireNonNull(nameAgeStr);
        String[] split = nameAgeStr.split(",");
        Person p = new Person();
        p.setAge(Integer.parseInt(split[0]));
        p.setName(split[1]);
        //这里可能还有其他复杂事情需要处理
        return p;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    public String getNameAgeStr() {
        return nameAgeStr;
    }

    public void setNameAgeStr(String nameAgeStr) {
        this.nameAgeStr = nameAgeStr;
    }
}
