package com.fafamc.forfun.jdk8.stream;

import com.fafamc.forfun.jdk8.Domain;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 总之，Stream 的特性可以归纳为：
 *
 * 1不是数据结构
 * 2它没有内部存储，它只是用操作管道从 source（数据结构、数组、generator function、IO channel）抓取数据。
 * 3它也绝不修改自己所封装的底层数据结构的数据。例如 Stream 的 filter 操作会产生一个不包含被过滤元素的新 Stream，而不是从 source 删除那些元素。
 * 4所有 Stream 的操作必须以 lambda 表达式为参数
 * 5不支持索引访问
 * 6你可以请求第一个元素，但无法请求第二个，第三个，或最后一个。不过请参阅下一项。
 * 7很容易生成数组或者 List
 * 8惰性化
 * 9很多 Stream 操作是向后延迟的，一直到它弄清楚了最后需要多少数据才会开始。
 * 10Intermediate 操作永远是惰性化的。
 * 11并行能力
 * 12当一个 Stream 是并行化的，就不需要再写多线程代码，所有对它的操作会自动并行进行的。
 * 13可以是无限的
 * 14集合有固定大小，Stream 则不必。limit(n) 和 findFirst() 这类的 short-circuiting 操作可以对无限的 Stream 进行运算并很快完成。
 *
 *
 * Intermediate：一个流可以后面跟随零个或多个 intermediate 操作。其目的主要是打开流，做出某种程度的数据映射/过滤，然后返回一个新的流，交给下一个操作使用。这类操作都是惰性化的（lazy），就是说，仅仅调用到这类方法，并没有真正开始流的遍历。
 * Terminal：一个流只能有一个 terminal 操作，当这个操作执行后，流就被使用“光”了，无法再被操作。所以这必定是流的最后一个操作。Terminal 操作的执行，才会真正开始流的遍历，并且会生成一个结果，或者一个 side effect。
 * 还有一种操作被称为 short-circuiting。用以指：
     * 对于一个intermediate 操作，如果它接受的是一个无限大（infinite/unbounded）的Stream，但返回一个有限的新Stream。
     * 对于一个 terminal 操作，如果它接受的是一个无限大的 Stream，但能在有限的时间计算出结果。
 *
 * Intermediate
 *      map (mapToInt, flatMap 等)、 filter、 distinct、 sorted、 peek、 limit、 skip、 parallel、 sequential、 unordered
 * Terminal
 *      forEach、 forEachOrdered、 toArray、 reduce、 collect、 min、 max、 count、 anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 iterator
 * Short-circuiting
 *      anyMatch、 allMatch、 noneMatch、 findFirst、 findAny、 limit
 */
public class TestStream {

    /**
     * 场景1.一组对象，过滤并且获取id集合
     */
    @Test
    public void test1_pre8(){
        List<Domain> list = new ArrayList<>();
        for(Domain t: Domain.getList()){
            if(t.getType() == 0){
                list.add(t);
            }
        }
        Collections.sort(list, new Comparator<Domain>(){
            @Override
            public int compare(Domain t1, Domain t2){
                return t2.getName().compareTo(t1.getName());
            }
        });
        List<String> transactionIds = new ArrayList<>();
        for(Domain t: list){
            transactionIds.add(t.getId());
        }
        System.out.println(Arrays.toString(transactionIds.toArray()));
    }

    @Test
    public void test1_jdk8(){
        List<String> transactionIds = Domain.getList().stream()
                .filter(a->a.getType()==0)
                .sorted((o1, o2) -> o2.getName().compareTo(o1.getName()))
                .map(Domain::getId)
                .collect(Collectors.toList());
        System.out.println(Arrays.toString(transactionIds.toArray()));
    }

    @Test
    public void test2(){
        //stream的构成方式
        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        System.out.println(Arrays.toString(stream.toArray()));
        // 2. Arrays
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        System.out.println(Arrays.toString(stream.toArray()));

        stream = Arrays.stream(strArray);
        System.out.println(Arrays.toString(stream.toArray()));

        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
        System.out.println(Arrays.toString(stream.toArray()));
    }

    @Test
    public void test3(){
        IntStream.of(new int[]{1, 2, 3}).forEach(System.out::println);
        IntStream.range(1, 3).forEach(System.out::println);
        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    @Test
    public void test4(){
        // 1. Array
        String [] strArray = new String[] {"a", "b", "c"};
        Stream<String> stream = Stream.of(strArray);

//        // 2. Collection
//        List<String> list1 = stream.collect(Collectors.toList());
//        List<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
//        Set set1 = stream.collect(Collectors.toSet());
//        Stack stack1 = stream.collect(Collectors.toCollection(Stack::new));
        // 3. String
        String str = stream.collect(Collectors.joining()).toString();
        System.out.println(str);
    }

    /**
     * flatMap
     */
    @Test
    public void test5(){
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)
        );

        List<Integer> list = inputStream.flatMap(List::stream).collect(Collectors.toList());
        System.out.println(Arrays.toString(list.toArray()));
    }

    /**
     * 大概区别是：
     *  foreach在循环时，如果操作每个元素，会修改元素的值，返回值是void
     *  peek在循环时，如果操作元素，不会修改原元素的值，而是生成一个新的stream
     */
    @Test
    public void test6_peekAndForeach(){
        Domain.getList().stream().forEach(a->a.setName(a.getName()+"ttt"));
        System.out.println(Arrays.toString(Domain.getList().toArray()));

        Stream<Domain> stream = Domain.getList().stream().peek(a->a.setName(a.getName()+"qqq"));
        System.out.println(Arrays.toString(Domain.getList().toArray()));

        System.out.println(Arrays.toString(stream.toArray()));
    }

    /**
     * findFirst 的返回值是optional
     *  findAny、max/min 等相似
     *  目的是尽可能的在编译期 处理空值问题
     */
    @Test
    public void test6_findFirst(){
        System.out.println(Domain.getList().stream().findFirst().get().toString());
    }

    /**
     *  reduce()，
     *  第一个参数（空白字符）即为起始值，
     *  第二个参数（String::concat）为 BinaryOperator。这类有起始值的 reduce() 都返回具体的对象。
     *  而对于第四个示例没有起始值的 reduce()，由于可能没有足够的元素，返回的是 Optional，请留意这个区别。
     */
    @Test
    public void test7_reduce(){
        // 字符串连接，concat = "ABCD"
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        // 求最小值，minValue = -3.0
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        // 求和，sumValue = 10, 有起始值
        int sumValue = Stream.of(1, 2, 3, 4).reduce(0, Integer::sum);
        // 求和，sumValue = 10, 无起始值
        sumValue = Stream.of(1, 2, 3, 4).reduce(Integer::sum).get();
        // 过滤，字符串连接，concat = "ace"
        concat = Stream.of("a", "B", "c", "D", "e", "F").
                filter(x -> x.compareTo("Z") > 0).
                reduce("", String::concat);
    }

}
