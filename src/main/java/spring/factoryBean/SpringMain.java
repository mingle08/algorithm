package spring.factoryBean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanFactory与FactoryBean的区别
 */
public class SpringMain {
    public static void main(String[] args) {
        // 1，这个是BeanFactory
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("application.xml");
        //获取对应的对象化
        Object demo = beanFactory.getBean("fromBeanFactory");
        System.out.println(demo instanceof Person);
        System.out.println(demo);

        // 2. 从FactoryBean获取对象
        Person demoFromFactory = beanFactory.getBean("fromFactoryBean", Person.class);
        System.out.println(demoFromFactory);
        //获取对应的personFactoryBean
        Object bean = beanFactory.getBean("&fromFactoryBean");
        System.out.println(bean instanceof PersonFactoryBean);
        PersonFactoryBean factoryBean=(PersonFactoryBean) bean;
        System.out.println("初始化参数为："+factoryBean.getNameAgeStr());
    }
}
