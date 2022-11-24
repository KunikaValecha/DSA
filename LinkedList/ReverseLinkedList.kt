package LinkedList

class ReverseLinkedList {
    companion object{
        fun reverseList(head: ListNode?): ListNode? {
            var head = head
            var prev:ListNode? = null


            while(head!= null){
                var next : ListNode? = head.next
                head.next = prev
                prev = head
                head = next
            }
            return prev
        }
    }
}