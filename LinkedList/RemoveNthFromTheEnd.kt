package LinkedList

class RemoveNthFromTheEnd {
    companion object{
        fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
            var h = head
            var lenLL = 0
            while(h!= null){
                lenLL++
                h = h.next
            }
            var headN = ListNode(0)
            var ans = headN
            headN.next = head
            var itr = lenLL -n
            var count = 0
            while(headN.next!=null && count<lenLL){
                if(count == itr){
                    headN.next = headN.next!!.next

                }
                else{
                    headN = headN.next!!

                }
                count++


            }
            return ans.next

        }
    }
}