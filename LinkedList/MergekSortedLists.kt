package LinkedList

class MergekSortedLists {
    companion object{
        fun mergeKLists(lists: Array<ListNode?>): ListNode? {
            var temp = ListNode(0)
            var ans = temp

            if(lists.size==1){
                return lists[0]
            }
            for(i in 0..lists.size-2){
                if(lists[i]==null && lists[i+1]==null){
                    continue
                }
                temp.next = merge(lists[i], lists[i+1])
                temp = temp.next!!
            }
            return ans.next
        }
        fun merge(l1: ListNode?, l2: ListNode?): ListNode {
            var l1 = l1
            var l2 = l2
            var head = ListNode(0)
            var ans = head

            while(l1!=null && l2!= null){
                if(l1.`val` <l2.`val`){
                    head.next = l1
                    head = head.next!!
                    l1 = l1.next
                }
                else if(l1.`val` == l2.`val`){
                    head.next = l1
                    head = head.next!!
                    l1 = l1.next
                    head.next = l2
                    head = head.next!!
                    l2 = l2.next
                }
                else{
                    head.next = l2
                    head = head.next!!
                    l2 = l2.next
                }

            }
            while(l1!=null){
                head.next = l1
                l1 = l1.next
                head = head.next!!
            }
            while(l2!=null){
                head.next = l2
                l2 = l2.next
                head = head.next!!
            }

            return ans.next!!
        }
    }
}

fun main() {

    val list1 = ListNode(1)
    list1.next = ListNode(4)
    list1.next = ListNode(5)
    val list2 = null
    val list3 = ListNode(-1)
    val arr = arrayOf(list1, list2, list3)
    var ans = MergekSortedLists.mergeKLists(arr)
    while(ans!=null){
        print("${ans.`val`},")
        ans = ans.next
    }

}