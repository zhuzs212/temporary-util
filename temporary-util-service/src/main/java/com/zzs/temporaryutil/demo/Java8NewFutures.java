package com.zzs.temporaryutil.demo;

import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class Java8NewFutures {
    public static void main(String[] args) {
//        // Supplier
//        Supplier<String> supplier = () -> "我是供应商";
//        System.out.println(supplier.get());
//
//        // Function
//        Function<String, Integer> func = String::length;
//        System.out.println(func.apply("Java8")); // 5
//
//        // java11 新特性
////        BiFunction<String, Integer, String> biFunc = (s, i) -> s.repeat(i);
////        System.out.println(biFunc.apply("Hi", 3)); // HiHiHi
//
//
//// 静态方法引用
//        Function<String, Integer> parse = Integer::parseInt;
//
//// 实例方法引用（特定对象）
//        Consumer<String> out = System.out::println;
//
//// 实例方法引用（参数作为调用者）
//        Function<String, String> trim = String::trim;
//
//// 构造器引用
//        Supplier<List<String>> list = java.util.ArrayList::new;
//
//// Function + 实例方法引用
//        Function<String, Integer> lengthFunc = String::length;
//
//// BiFunction + 静态方法引用
//        BiFunction<Integer, Integer, Integer> maxFunc = Math::max;
//
//
//
//        // 1. 从集合
//        List<String> list1 = Arrays.asList("a", "bb", "ccc");
//        Stream<String> stream1 = list1.stream();
//
//// 2. 从数组
//        Stream<String> stream2 = Arrays.stream(new String[]{"x", "y"});
//
//// 3. 无限流
//        Stream<Integer> stream3 = Stream.iterate(1, n -> n + 1).limit(10);
//
//// 4. generate
//        Stream<Double> stream4 = Stream.generate(Math::random).limit(5);
//
//        Optional<String> name = Optional.empty();




        // 延迟执行，性能更好
        Optional<String> nameEmpty = Optional.empty();
        System.out.println("nameEmpty is present: " + nameEmpty.isPresent());
        // 情况1：orElse → 总是执行
        String result1 = nameEmpty.orElse("always apply");
        // getDefaultName() 一定会被调用！
        System.out.println("result1: " + result1);

        // 情况2：orElseGet → 延迟执行
        String result2 = nameEmpty.orElseGet(() -> "name is empty , apply ");
        // 只有 name 是 empty 时才调用！
        System.out.println("result2: " + result2);
//
        Optional.ofNullable(null);
        Optional<String> nameNotEmpty = Optional.of("hello");
        nameNotEmpty.ifPresent(System.out::println);
        String value = nameNotEmpty.orElse("default");
        System.out.println("value: " + value);
        String value2 = nameNotEmpty.orElseGet(() -> "computed");
        System.out.println("value2: " + value2);


        int size = 10_000_000;
        double[] data = new double[size];

        // 1. 并行初始化
        Arrays.parallelSetAll(data, i -> ThreadLocalRandom.current().nextDouble() * 100);

        // 2. 并行排序
        long start = System.nanoTime();
        Arrays.parallelSort(data);
        long end = System.nanoTime();
        System.out.println("并行排序耗时: " +(end-start) / 1_000_000 + " ms");

        // 3. 并行前缀计算（例如：归一化累加）
        start = System.nanoTime();
        double[] prefix = data.clone();
        Arrays.parallelPrefix(prefix, Double::sum);
        end = System.nanoTime();
        System.out.println("前缀和最后值: " + prefix[prefix.length - 1]);
        System.out.println("并行前缀计算耗时: " +(end-start) / 1_000_000 + " ms");
    }
}
