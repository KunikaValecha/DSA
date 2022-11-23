package LinkedList

class SwapPairs {
    companion object{
        fun swapPairs(head: ListNode?): ListNode? {
            var head = head
            var arr = mutableListOf<Int>()
            while(head!=null){
                arr.add(head.`val`)
                head = head.next
            }
            var newHead = ListNode(0)
            var ans = newHead
            val list = swap(arr)
            for(i in list){
                newHead.next = ListNode(i)
                newHead = newHead.next!!
            }
            return ans.next
        }
        fun swap(lis: MutableList<Int>):MutableList<Int>{
            for(i in 0 until lis.size-1){
                if(i%2==0){
                    val temp = lis[i]
                    lis[i] = lis[i+1]
                    lis[i+1] = temp
                }
            }
            return lis
        }
    }
}

