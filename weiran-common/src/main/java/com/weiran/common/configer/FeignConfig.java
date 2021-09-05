//package com.weiran.common.configer;
//
//import com.codingapi.txlcn.tracing.TracingContext;
//import com.codingapi.txlcn.tracing.http.TracingHystrixConcurrencyStrategy;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.request.RequestAttributes;
//import org.springframework.web.context.request.RequestContextHolder;
//
//import java.util.Map;
//import java.util.concurrent.Callable;
//
///**
// * discription: 自定义并发策略
// * 将现有的并发策略作为新并发策略的成员变量
// * 在新并发策略中，返回现有并发策略的线程池、Queue
// *
// * hystrix.command.default.execution.isolation.strategy=THREAD   Hystrix的默认隔离策略（官方推荐，当使用该隔离策略时，是没办法拿到 ThreadLocal 中的值的，但是
// * RequestContextHolder 源码中，使用了两个ThreadLocal）
// *
// * hystrix.command.default.execution.isolation.strategy=SEMAPHORE （将隔离策略改为SEMAPHORE 也可以解决这个问题，但是官方并不推荐这个策略，因为这个策略对网络资源消耗比较大）
// *
// * 主要是解决当 Hystrix的默认隔离策略是THREAD时，不能通过RequestContextHolder获取到request对象的问题
// *
// * @author luobin@jouav.com
// * @date 2021/3/2 0002 13:11
// */
//@Component
//public class FeignConfig extends TracingHystrixConcurrencyStrategy {
//
//    @Override
//    public <T> Callable<T> wrapCallable(Callable<T> callable) {
//        Map<String, String> fields = TracingContext.tracing().fields();
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        return new WrappedCallable<>(callable, requestAttributes, fields);
//    }
//
//    static class WrappedCallable<T> implements Callable<T> {
//        private final Callable<T> target;
//        private final RequestAttributes requestAttributes;
//        private Map<String, String> fields;
//        public WrappedCallable(Callable<T> target, RequestAttributes requestAttributes, Map<String, String> fields) {
//            this.target = target;
//            this.requestAttributes = requestAttributes;
//            this.fields = fields;
//        }
//
//        @Override
//        public T call() throws Exception {
//            try {
//                RequestContextHolder.setRequestAttributes(requestAttributes);
//                boolean isReInitTracingContext = true;
//                try {
//                    if (!TracingContext.tracing().hasGroup()) {
//                        TracingContext.init(fields);
//                        return target.call();
//                    }
//                    isReInitTracingContext = false;
//                } finally {
//                    if (isReInitTracingContext) {
//                        TracingContext.tracing().destroy();
//                    }
//                }
//                return target.call();
//            } finally {
//                RequestContextHolder.resetRequestAttributes();
//            }
//        }
//    }
//}
