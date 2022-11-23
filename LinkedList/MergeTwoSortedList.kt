package LinkedList

class MergeTwoSortedList {
    companion object{
        fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
            var list1 = list1
            var list2 = list2
            var list3 = ListNode(0)
            var head = list3
            while(list1!=null && list2!=null){
                if(list1.`val` < list2.`val`){
                    list3.next = list1
                    list1 = list1.next
                    list3 = list3.next!!
                }
                else if(list1.`val`==list2.`val`){
                    list3.next = list1
                    list1 = list1.next
                    list3 = list3.next!!
                    list3.next = list2
                    list2 = list2.next
                    list3 = list3.next!!
                }
                else{
                    list3.next = list2
                    list2 = list2.next
                    list3 = list3.next!!
                }
            }
            while(list1!=null){
                list3.next = list1
                list1 = list1.next
                list3 = list3.next!!
            }
            while(list2!=null){
                list3.next = list2
                list2 = list2.next
                list3 = list3.next!!
            }
            return head.next
        }
    }
}