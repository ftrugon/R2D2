import kotlin.math.round

fun main(){

    val movimientos = pedirmovimientos()
    val cosa = mover(movimientos)
    println("x: ${cosa[0]}, y: ${cosa[1]}, dir: ${orientaacionRobot(cosa[2])}")

}

fun pedirmovimientos(): List<Int>{
    val lista = mutableListOf<Int>()
    do {

        print("Dime el numero de veces que quiera que se mueva el robot(Cualquier cosa que no sea un numero si quieres acabar): ")
        val num = try {
            readln().toInt()
        }catch (e:Exception){
            return lista
        }
        lista.add(num)
    }while (true)
}


fun orientaacionRobot(dir:Int)= when(dir){
        0-> "NEGATIVE Y"
        1-> "NEGATIVE X"
        2-> "POSITIVE Y"
        3-> "POSITIVE X"
        else -> "Posicion desconocida"
    }


fun mover(movs:List<Int>):List<Int>{

    var posX = 0
    var posY = 0
    var dir = 0

    for (pasos in movs){
       when (dir){
           0-> posY += pasos
           1-> posX -= pasos
           2-> posY -= pasos
           3-> posX += pasos
       }
        if (dir == 3) dir = 0 else dir ++
    }
    return listOf(posX,posY,dir)
}