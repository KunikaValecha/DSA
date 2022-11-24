package LinkedList

class MiddleOfLinkedList {
    companion object{
        fun middleNode(head: ListNode?): ListNode? {
            var h = head
            val list = mutableListOf<Int>()
            while(h!=null){
                list.add(h.`val`)
                h = h.next
            }
            var mid = (list.size)/2

            var hNew = head

            while(mid != 0 && hNew != null){
                hNew.next = hNew.next
                hNew = hNew.next
                mid --

            }
            return hNew
        }
    }
}