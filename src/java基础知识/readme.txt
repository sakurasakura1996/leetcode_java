java 容器分成两大部分：Collection 和 Map
Collection:主要是单个元素的集合，有List, Queue, Set三个接口区分不同的集合特征，然后由下面具体的类来实现对应的功能。
Map:有一组键值对的存储形式来保存，可以用键对象来查找值

Collection 的三个接口:
* List:
    List的特点就是所有的元素是可以重复的。List接口在Collection的基础上增加了很多的方法。
    List主要分为ArrayList和LinkedList，前者底层是使用数组实现List，后者是使用链表来实现的List
* Vector:
    Vector 是一个已经被弃用的类，因为他是线程同步的，而我们平时使用的时候都是非同步的，使用同步的坏处就是会在一个记录上加锁，
    防止多个程序访问同一条数据导致数据不同步。这样会导致访问速度变慢。
* Stack:
    Stack是满足“后进先出”规则的容器，注意 LinkedList 可以实现所有的栈功能。

    二、List
        2.1 ArrayList
            ArrayList是一个可以动态增长的数组。
            我们都知道Java中的数组一旦指定了长度就不可以改变，如果我们在业务中需要使用动态的数组，就可以使用ArrayList
            (ArrayList默认长度为10，如果我们插入的数据超过了10，ArrayList会不断的自我增长）
            ArrayList由于底层是数组实现的，所以随机访问速度快，插入删除比较慢
            * toArray:把LinkedList转换为Array

        2.2 LinkedList
            LinkedList是使用链表实现的容器。
            在列表中插入和删除速度快，但是查找需要遍历整个链表，速度较慢
            使用LinkedList可以实现很多队列、栈的数据结构，并且有很多方法很类似，但是有细小的差别

            getFirst和element都返回列表的头，但是不删除它，如果列表为空，抛出异常
            peek实现的功能一样，但是列表为空时返回null
            removeFirst和remove都是删除并返回列表的头，如果列表为空抛出异常
            pool实现的功能一样，但是列表为空时返回null
            使用LinkedList可以实现一个栈的功能，下面让我们写一个属于自己的栈

        2.3 Queue
            队列是一个满足“先进先出”的数据结构。
            LinkedList提供了方法支持队列操作，并且实现了Queue接口，所以LinkedList是队列的一种实现，可以通过LinkedList向上转型为Queue

            offer:将一个元素插入队尾
            peek:不移除的情况下将元素插入队尾，队列为空返回null
            element:不移除的情况下将元素插入队尾，队列为空报错
            poll:移除并返回队头，队列为空返回null
            remove:不移除的情况下将元素插入队尾，队列为空报错
            PriorityQueue是优先级队列，我们暂时先不介绍
    三、Set
        set代表的是数学上的集合的意思，所以set中的元素不可以重复。
        所以set中查找是最为重要的操作，而对于查找来说，我们最常用的就是HashSet

        HastSet底层是使用散列函数，在查询的方面有优化
        TreeSet底层使用的是红黑树

    四、Map
        Map是使用键值对存储的一种结构，所以在处理列如单词统计等方面是杀手锏
        Map的键值对都可以为null
        Map可以多维扩展。例如一个人拥有多个宠物，你可以这样定义：Map< Person, List< pet>>

        Object put(Object key, Object value):放进一个键值对，返回值是被替换的值
        Object remove(Object key)
        void putAll(Map mapping)
        void clear()
        boolean containsKey(Object key)是否包含某个键
        boolean containsValue(Object value)是否包含某个值
        在Map中比较重要的是处理键值对的集合

        public Set keySet()：返回这个Map的所有键的集合，因为Map中键是唯一的，所以返回使用一个set
        public Collection values()：返回这个Map的所有值的集合，因为值可能重复，所以返回一个Collection
        public Set entrySet()：返回一个实现Map.Entry接口对象集合，使用这个方法可以遍历每一条记录。
        遍历Map示范代码：

        for(Map.Entry<String, String> file : films.entrySet()){
            String title = file.getKey();
            String videoUrl = file.getValue();
        }
        HashMap更适合查找、删除、插入
        TreeMap更适合遍历。