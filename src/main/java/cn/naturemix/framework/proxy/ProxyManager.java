package cn.naturemix.framework.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 代理管理器
 * @author flytoyou
 * @version 1.0.0
 */
public class ProxyManager {

    @SuppressWarnings("unchecked")
    public static <T> T creatProxu(final Class<T> targetClass, final List<Proxy> proxyList){
        //使用CGlib提供的Enhancer#create方法创建代理对象，
        return (T) Enhancer.create(targetClass, new MethodInterceptor() {
            @Override
            public Object intercept(Object targetObject, Method targetMethod, Object[] methodParams, MethodProxy methodProxy) throws Throwable {
                return new ProxyChain(targetClass,targetObject,targetMethod,methodProxy,methodParams,proxyList).doProxyChain();
            }
        });
    }

}
