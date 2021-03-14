1. view绘制流程 && 如何在onCreate获取view的宽高
2. view的事件分发&&如何拦截一个事件并处理
3. activity的四种启动模式
4. okhttp && glide
5. 如何实现UDP的可靠传输
6. Android序列化
7. binder工作机制&&Android IPC方式
8. handler无消息时操作 handler如何内存泄漏&&弱引用处理内存泄漏 handler如何实现线程隔离 
9. Java泛型
10. Java注解类型
11. Java对象被引用时是否可以强制回收
12. hashmap如何解决冲突的和concurrenthashmap的线程安全实现原理
    1. hashmap根据键的hashcode存储数据，大多数情况可以直接定位，因此速度快
    2. hashmap基于哈希表，底层由数组实现，添加到集合中的元素以key-value形式保存在数组中，再数组中key-value被包装成一个实体处理，也就是ENTRY
    3. hashmap基于哈希表的Map接口的非同步实现，允许NULL，但不保证映射的顺序；底层使用数组实现，数组中每一项是一个链表；存储时根据hash算法决定存储位置；数组扩容时需要重新计算每个元素在数组中的位置很耗时
    4. concurrenthashmap使用锁分离技术允许多个修改同时进行，使用了多个锁来控制对哈希表不同段的修改。
    5. CAS：
13. Java中有哪些锁
    1. 
14. Java线程池（核心原理）
    1. 