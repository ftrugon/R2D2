import kotlin.math.round

fun main(){

    var r2d2Pos:List<Int>

    r2d2Pos = mover(10, 5, -2)
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, dir: ${orientaacionRobot(r2d2Pos[2])}")

    r2d2Pos = mover(0, 0, 0)
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, dir: ${orientaacionRobot(r2d2Pos[2])}")

    r2d2Pos = mover()
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, dir: ${orientaacionRobot(r2d2Pos[2])}")

    r2d2Pos = mover(-10, -5, 2)
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, dir: ${orientaacionRobot(r2d2Pos[2])}")

    r2d2Pos = mover(-10, -5, 2, 4, -8)
    println("x: ${r2d2Pos[0]}, y: ${r2d2Pos[1]}, dir: ${orientaacionRobot(r2d2Pos[2])}")
}

fun orientaacionRobot(dir:Int)= when(dir){
        0-> "NEGATIVE Y"
        1-> "NEGATIVE X"
        2-> "POSITIVE Y"
        3-> "POSITIVE X"
        else -> "Posicion desconocida"
    }


fun mover(vararg movs:Int):List<Int>{

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