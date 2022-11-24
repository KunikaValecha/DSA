package LinkedList

class RemoveDuplicatesFromSortedListII {
    companion object{
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var h = ListNode(0)
            var ans = h
            h.next = head
            while(h.next != null && h.next!!.next != null){
                if(h.next!!.`val` == h.next!!.next?.`val`){
                    var variable = h.next!!.`val`
                    while(h.next != null && h.next!!.`val` == variable){
                        h.next = h.next!!.next
                    }
                }
                else{
                    h = h.next!!
                }
            }
            return ans.next
        }
    }
}