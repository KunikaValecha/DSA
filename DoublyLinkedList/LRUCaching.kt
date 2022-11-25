package DoublyLinkedList

import java.lang.Exception

class LRUCaching {
    //initialising head and tail to avoid null pointer exception later
    private var head = DoublyLinkListNode(-1, -1)
    private var tail = DoublyLinkListNode(-1, -1)
    private var cap: Int? = null
    private var hash = hashMapOf<Int, DoublyLinkListNode>()

    constructor(capacity: Int) {
        head.next = tail
        tail.prev = head
        cap = capacity
    }

    private fun remove(node: DoublyLinkListNode) {
        hash.remove(node.key)
        var nodePrev = node.prev
        var nodeNext = node.next
        nodePrev?.next = nodeNext
        nodeNext?.prev = nodePrev
    }

    private fun insert(node: DoublyLinkListNode) {
        hash.put(node.key, node)
        var headNext = head.next
        head.next = node
        node.prev = head
        node.next = headNext
        headNext?.prev = node
    }

    fun get(key: Int): Int {
        return if (hash.contains(key)) {
            var node = hash.get(key)
            remove(node!!)
            insert(node)
            node.value
        } else {
            throw Exception("LRU cache is empty!")
        }
    }

    fun put(key: Int, value: Int) {
        if (hash.contains(key)) {
            var node = hash.get(key)
            remove(node!!)
        }
        if (hash.size == cap) {
            remove(tail.prev!!)
        }
        insert(DoublyLinkListNode(key, value))

    }
}

fun main() {
    var LRU = LRUCaching(3)
    LRU.put(1,3)
    LRU.put(2,15)
    LRU.put(3,16)
    LRU.get(1)
    LRU.put(7,9)
    LRU.put(5,13)
    print(LRU.get(1))
}