package com.zzs.temporaryutil.demo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FullContainerPerformanceTest {
    private static final int SIZE = 500_000;  // 50万数据，足够看出差距
    private static final int QUERY_TIMES = 10_000;  // 随机查询次数

    public static void main(String[] args) {
        System.out.println("=== Java 容器全量性能测试（增删改查）===\n");
        testLists();
        testSets();
        testQueues();
        testMaps();
    }

    // ==================== List 测试 ====================
    static void testLists() {
        System.out.println("┌───────────────── List 性能测试 ─────────────────┐");
        System.out.println("│ 容器       | 添加(尾) | 插入(头) | 删除(头) | 随机查 | 修改(中) │");
        System.out.println("├────────────┼──────────┼──────────┼──────────┼────────┼──────────┤");

        testArrayList();
        testLinkedList();

        System.out.println("└────────────────────────────────────────────────┘\n");
    }

    static void testArrayList() {
        List<Integer> list = new ArrayList<>();

        // 1. 添加（尾部）
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) list.add(i);
        long addTime = System.nanoTime() - start;

        // 2. 插入（头部）
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) list.add(0, -i); // 只测1000次，避免太慢
        long insertTime = System.nanoTime() - start;

        // 3. 删除（头部）
        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) list.remove(0);
        long removeTime = System.nanoTime() - start;

        // 4. 随机查询
        Random rand = new Random(42);
        start = System.nanoTime();
        for (int i = 0; i < QUERY_TIMES; i++) list.get(rand.nextInt(list.size()));
        long getTime = System.nanoTime() - start;

        // 5. 修改（中间位置）
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) list.set(list.size() / 2, i);
        long setTime = System.nanoTime() - start;

        printf("ArrayList   ", addTime, insertTime, removeTime, getTime, setTime);
    }

    static void testLinkedList() {
        List<Integer> list = new LinkedList<>();

        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) list.add(i);
        long addTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) list.add(0, -i);
        long insertTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 1000; i++) list.remove(0);
        long removeTime = System.nanoTime() - start;

        Random rand = new Random(42);
        start = System.nanoTime();
        for (int i = 0; i < QUERY_TIMES; i++) list.get(rand.nextInt(list.size()));
        long getTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) list.set(list.size() / 2, i);
        long setTime = System.nanoTime() - start;

        printf("LinkedList  ", addTime, insertTime, removeTime, getTime, setTime);
    }

    // ==================== Set 测试 ====================
    static void testSets() {
        System.out.println("┌───────────────── Set 性能测试 ──────────────────┐");
        System.out.println("│ 容器           | 添加     | 删除     | 包含查   | 备注     │");
        System.out.println("├────────────────┼──────────┼──────────┼──────────┼──────────┤");

        testHashSet();
        testLinkedHashSet();
        testTreeSet();

        System.out.println("└────────────────────────────────────────────────┘\n");
    }

    static void testHashSet() { testSet(new HashSet<>(), "HashSet       "); }
    static void testLinkedHashSet() { testSet(new LinkedHashSet<>(), "LinkedHashSet "); }
    static void testTreeSet() { testSet(new TreeSet<>(), "TreeSet       "); }

    static void testSet(Set<Integer> set, String name) {
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) set.add(i);
        long addTime = System.nanoTime() - start;

        Random rand = new Random(42);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) set.remove(rand.nextInt(SIZE));
        long removeTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < QUERY_TIMES; i++) set.contains(rand.nextInt(SIZE));
        long containsTime = System.nanoTime() - start;

        printf(name, addTime, removeTime, containsTime, 0, 0);
    }

    // ==================== Queue 测试 ====================
    static void testQueues() {
        System.out.println("┌───────────────── Queue 性能测试 ────────────────┐");
        System.out.println("│ 容器           | offer    | poll     | peek     | 备注     │");
        System.out.println("├────────────────┼──────────┼──────────┼──────────┼──────────┤");

        testArrayDeque();
        testPriorityQueue();

        System.out.println("└────────────────────────────────────────────────┘\n");
    }

    static void testArrayDeque() {
        Deque<Integer> deque = new ArrayDeque<>();
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) deque.offerLast(i);
        long offerTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < SIZE / 2; i++) deque.pollFirst();
        long pollTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) deque.peekFirst();
        long peekTime = System.nanoTime() - start;

        printf("ArrayDeque    ", offerTime, pollTime, peekTime, 0, 0);
    }

    static void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) queue.offer(i);
        long offerTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < SIZE / 2; i++) queue.poll();
        long pollTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) queue.peek();
        long peekTime = System.nanoTime() - start;

        printf("PriorityQueue ", offerTime, pollTime, peekTime, 0, 0);
    }

    // ==================== Map 测试 ====================
    static void testMaps() {
        System.out.println("┌───────────────── Map 性能测试 ─────────────────┐");
        System.out.println("│ 容器               | put      | remove   | get      | 备注     │");
        System.out.println("├────────────────────┼──────────┼──────────┼──────────┼──────────┤");

        testHashMap();
        testLinkedHashMap();
        testTreeMap();
        testConcurrentHashMap();

        System.out.println("└──────────────────────────────────────────────────┘\n");
    }

    static void testHashMap() { testMap(new HashMap<>(), "HashMap           "); }
    static void testLinkedHashMap() { testMap(new LinkedHashMap<>(), "LinkedHashMap     "); }
    static void testTreeMap() { testMap(new TreeMap<>(), "TreeMap           "); }
    static void testConcurrentHashMap() { testMap(new ConcurrentHashMap<>(), "ConcurrentHashMap "); }

    static void testMap(Map<Integer, Integer> map, String name) {
        long start = System.nanoTime();
        for (int i = 0; i < SIZE; i++) map.put(i, i);
        long putTime = System.nanoTime() - start;

        Random rand = new Random(42);
        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) map.remove(rand.nextInt(SIZE));
        long removeTime = System.nanoTime() - start;

        start = System.nanoTime();
        for (int i = 0; i < QUERY_TIMES; i++) map.get(rand.nextInt(SIZE));
        long getTime = System.nanoTime() - start;

        printf(name, putTime, removeTime, getTime, 0, 0);
    }

    // ==================== 工具方法 ====================
    static void printf(String name, long t1, long t2, long t3, long t4, long t5) {
        String f = "│ %-17s │ %6.1f │ %6.1f │ %6.1f │ %6.1f │ %6.1f │%n";
        if (t4 == 0 && t5 == 0) {
            f = "│ %-17s │ %6.1f │ %6.1f │ %6.1f │%s│%n";
            System.out.printf(f, name, t1/1e6, t2/1e6, t3/1e6, "      ");
        } else {
            System.out.printf(f, name, t1/1e6, t2/1e6, t3/1e6, t4/1e6, t5/1e6);
        }
    }
}