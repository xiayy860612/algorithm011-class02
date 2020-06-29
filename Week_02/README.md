# Week2 学习笔记

## 哈希表(Hash Table)

根据关键码值(key)来访问数据, 
通过**哈希函数**把key映射到哈希表中一个位置来访问记录, 
加快查询速度.

哈希碰撞: 不同的数据经过哈希函数后得到相同的哈希值;

解决哈希碰撞:
- (工程上常用)拉链式解决冲突, 增加一个维度, 即哈希值的位置存一个链表
- 开放寻址法, 依次往下寻找空闲位置
    + 线性探测
    + 二次探测
    + 双重探测

- 参考[Java Hashtable](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Hashtable.html)
- 参考[Java HashMap](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/HashMap.html), put和get
- 参考[Java HashSet]()

### HashMap

- 哈希表使用数组存储位置, 每个位置上的元素被存储到链表, 
即采用了拉链式解决哈希碰撞
- 对key使用哈希函数进行处理
- 自动扩容
- 位置计算

参考:
- [JDK11版HashMap源码全部解析(详细)](https://blog.csdn.net/qq_21845263/article/details/89604721)

## 题目

- [有效的字母异位词](https://leetcode-cn.com/problems/valid-anagram/description/)
- [字母异位词分组](https://leetcode-cn.com/problems/group-anagrams/)