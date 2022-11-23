package LinkedList

import LinkedList.ListNode

//class ListNode(var `val`: Int) {
//        var next: ListNode? = null
//     }
class AddTwoNumbers {
    companion object{
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
            var l1 = l1
            var l2 = l2
            var l3 = ListNode(0)
            var head = l3
            var carry =0

            while (l1 != null && l2 != null){
                var sum = (l1.`val` + l2.`val` + carry) %10
                var carry = (l1.`val` + l2.`val` + carry)/10
                l3.next = ListNode(sum)
                l3 = l3.next!!
                l1 = l1.next
                l2 = l2.next
            }
            while (l1!=null){
                var sum = (l1.`val` + carry) %10
                var carry = (l1.`val` + carry)/10
                l3.next = ListNode(sum)
                l3 = l3.next!!
                l1 = l1.next
            }

            while (l2!=null){
                var sum = (l2.`val` + carry) %10
                var carry = (l2.`val` + carry)/10
                l3.next = ListNode(sum)
                l3 = l3.next!!
                l2 = l2.next
            }
            if(carry>0){
                l3.next = ListNode(carry)
            }
        return head.next
        }
    }
}

fun main() {
    println(AddTwoNumbers.addTwoNumbers(ListNode(7), ListNode(7)))

}