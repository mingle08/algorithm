package IOCplus.factory;

public interface BeanFactory {
    Object getBean(String beanId) throws Exception;
}
