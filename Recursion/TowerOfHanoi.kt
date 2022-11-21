package Recursion

import java.util.TooManyListenersException

class TowerOfHanoi {
    companion object{

        fun moveDisk(fromRod:Char, auxRod: Char, toRod:Char, num:Int){

            if(num>0){
                moveDisk(fromRod,  auxRod, toRod,num-1)
                println("Moving plate $num from  $fromRod to $auxRod")
                moveDisk(auxRod, toRod, fromRod, num-1)
                println("Moving plate $num from $auxRod to $toRod")
            }


            else{
                println("Moving plate $num from $fromRod to $toRod")
                return;
            }





        }
    }
}

fun main() {
    TowerOfHanoi.moveDisk('A', 'B', 'C', 3)
}