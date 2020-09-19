package com.example.springdemo;

import java.util.List;
import java.util.WeakHashMap;
import java.util.function.Predicate;

public class Test2 {
    public static void main(String[] args) throws Exception {
//        List<String> list = Arrays.asList("a","b","c");
//        List<Integer> list = Arrays.asList(10, 20, 30, 50, 30);
//        list.forEach(System.out::println);
//        list.forEach(x-> System.out.println(x));
//        list.stream().map(x -> x + 1).forEach(System.out::println);
//        int total = list.stream().map(x -> x + 10).reduce((sum, x) -> sum + x).get();
//        System.out.println(total);

//        List<Integer> newList = list.stream().filter(x -> x > 10).collect(Collectors.toList());
//        newList.forEach(System.out::println);

//        filterData(list, x -> x > 20);
//        int min = list.stream().max((e1,e2)->e2-e1).get();
//        System.out.println(min);

//        Stream<List<Integer>> inputStream = Stream.of(
//                Arrays.asList(1),
//                Arrays.asList(2, 3),
//                Arrays.asList(4, 5, 6)
//        );
//        Stream<Integer> outputStream = inputStream.
//                flatMap((childList) -> childList.stream());
//        outputStream.forEach(System.out::println);
        WeakHashMap map = new WeakHashMap();
//        HashMap map = new HashMap();
        long startTime = System.currentTimeMillis();
        map.put("a", "aa");
        map.put("b", "bb");
        map.put("c", "cc");
        map.put("c", "cc1");
//        while (map.size() < 10000000) {
//            map.put("ygq__@@_" + map.size(), "全报表系统共分为学校统计、OA统计、全流程统计、网站统计、资产统计、预算统计等几大模块，每个模块根据不同的条件查询出不同的结果使用echarts进行图表的渲染。报表系统数据量较大，大量使用了mysql的联合索引进行查询优化，查询图表使用weakhashmap进行缓存，以提高查询和内存使用效率，数据更新后再对weakhashmap缓存进行数据覆盖写入。");
//            System.out.println(map.size());
//        }
        long stopTime = System.currentTimeMillis();
        System.out.println("写入" + map.size() + "条数据用时" + (stopTime - startTime) / 1000 + "秒");
        while (true) {
            Thread.sleep(2000);
            System.out.println("当前有" + map.size() + "个对象");
            map.forEach((a, b) -> System.out.println(a + "--" + b));
        }
    }


    static void filterData(List<Integer> list, Predicate<Integer> condition) {
        list.stream().filter(e -> condition.test(e)).forEach(System.out::println);
    }
}

