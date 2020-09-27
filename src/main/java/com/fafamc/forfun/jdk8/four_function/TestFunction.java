package com.fafamc.forfun.jdk8.four_function;

import com.fafamc.forfun.jdk8.Domain;
import org.junit.Test;

import java.util.function.Function;

/**
 * Function  接收一个功能参数t，并返回一个功能结果R。
 */
public class TestFunction {

    @Test
    public void testMethod(){
        Function<Domain,String> function = (domain) ->{
            return domain.getName();
        };
        Function<String,String> function1 =(s) ->{
            return s+"234";
        };
        String str = function.andThen(function1).apply(Domain.getList().get(2));
        System.out.println(str);
    }
}
/**

 @FunctionalInterface
 public interface Function<T, R> {

 R apply(T t);

 default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
 Objects.requireNonNull(before);
 return (V v) -> apply(before.apply(v));
 }

 default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
 Objects.requireNonNull(after);
 return (T t) -> after.apply(apply(t));
 }

 static <T> Function<T, T> identity() {
 return t -> t;
 }

 */
