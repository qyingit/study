package com.qying.gc;

import org.junit.Test;

public class MetaspaceDemo {
    //ģ��OutOfMemoryError: Metaspace
    //-XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
    @Test
    public void demo() {
        //��Ƶ��ʹ����Enhancer�࣬���ҵ�JDK���沢û������࣬�ѵ���JDK�汾����
        //MethodInterceptor��Ҳû��
        //�ٶ���һ�£�Enhancer��cglib�����
//        while(true){
//            Enhancer enhancer = new Enhancer();
//            enhancer.setSuperclass(OOM.class);
//            enhancer.setUserCache(false);
//            enhancer.setCallback(new MethodInterceptor({
//                @Override
//                public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable{
//                    return methodProxy.invokeSuper(o,args);
//                }
//            }));
//            enhancer.create();
//        }
    }

    //дһ����̬�ڲ���
    class OOM {

    }
}