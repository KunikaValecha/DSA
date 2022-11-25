package StackAndQueue

import java.lang.Exception
import java.lang.NullPointerException
import javax.swing.text.Element


//CYCLIC OR CIRCULAR ARRAY HAS SAME CONCEPT
//Modulo to size of array makes an array circular

class ImplementingQueueUsingArray {
    private var arr = arrayOfNulls<Int>(5)
    private var count = 0
    private var rear = 0
    private var front = 0
    fun push(element: Int) {
        if (count == arr.size ) {
            throw Exception("Queue is full")
        }
        arr[rear % (arr.size)] = element
        rear++
        count++
    }

    fun peek(): Int {
        return arr[front%(arr.size)]?:throw Exception("empty queue")
    }

    fun pop(){
        if(arr[front%(arr.size)]==null){
                throw Exception("empty queue")
            }
        arr[front%(arr.size)]==null
        count--
        front++
    }
}

fun main() {
    var queue = ImplementingQueueUsingArray()
    queue.push(1)
    queue.push(2)
    queue.push(3)
    queue.push(4)
    queue.push(5)
    println( queue.peek())
    queue.pop()
    queue.pop()
    println(queue.peek())


}