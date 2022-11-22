//package Recursion
//
//class EliminationGame {
//    companion object{
//        fun eliminate(num:Int):Int{
//            val lis = mutableListOf<Int>()
//            for(i in 1..num){
//                lis.add(i)
//            }
//            var count = 0
//            val ans = eliminateElements(lis, count)
//            return ans[0]
//
//        }
//        fun eliminateElements(lis:MutableList<Int>, count:Int):MutableList<Int>{
//            if(lis.size==1){
//                return lis
//            }
//
//                if(count%2==0){
//                    var itr = lis.iterator()
//                    for(i in itr){
//                        if(i%2!=0){
//                            lis.removeAt(i)
//                        }
//                    }
//                }
//                else{
//                    var itr = lis.iterator()
//                    for(i in itr){
//                        if(i%2==0){
//                            lis.removeAt(i)
//                        }
//                    }
//                }
//                eliminateElements(lis,count+1 )
//
//
//            return lis
//        }
//
//    }
//}
//
//fun main() {
//    println(EliminationGame.eliminate(9))
//}