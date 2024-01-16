import kotlin.math.round

fun main(){
    var estado = false
    do {
        val movimientos = pedirmovimientos()
        val cosa = mover(movimientos)
        println("x: ${cosa[0]}, y: ${cosa[1]}, dir: ${orientaacionRobot(cosa[2])}")
        val repetir = opcion()
        if (repetir){
            estado = true
        }
    }while (!estado)
}

fun opcion ():Boolean{

    do {
        print("Quieres hacer que el robot se mueva de nuevo? (s/n): ")
        val respuesta = readln()
        return if (respuesta.lowercase() == "s"){
            false
        }else if (respuesta.lowercase() == "n") {
            true
        }else{
            continue
        }
    }while(true)
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
        0-> "POSITIVE Y"
        1-> "NEGATIVE X"
        2-> "NEGATIVE Y"
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