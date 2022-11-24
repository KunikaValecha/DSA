package LinkedList

class RemoveDuplicatesFromSortedList {
    companion object{
        fun deleteDuplicates(head: ListNode?): ListNode? {
            var h  = head
            var ans = h
            while( h!= null && h.next != null){
                if(h.`val`==h.next!!.`val`){
                    // while(h.`val`==h.next.`val`){
                    h.next = h.next!!.next
                    // }
                }
                else
                    h = h.next
            }
            return ans
        }
    }
}