class Robot(private var nombre:String ){

    private var posX:Int=0
    private var posY:Int=0
    private var dir:Int=0

    /**
     * Mueve al robot segun una array de movimientos
     * @param movimiento: es la array de movimientos
     */
    fun mover (movimiento: IntArray){
        for (pasos in movimiento){
            when (this.dir){
                0-> this.posY += pasos
                1-> this.posX -= pasos
                2-> this.posY -= pasos
                3-> this.posX += pasos
            }
            if (this.dir == 3) this.dir = 0 else this.dir ++
        }
    }

    /**
     * Convierte la posicion del robot en un string
     * @return String de la posicion
     */
    private fun obtenerDireccion():String{ //Tiene que retornar un String
        return when (this.dir){
            0-> "POSITIVE Y"
            1-> "NEGATIVE X"
            2-> "NEGATIVE Y"
            3-> "POSITIVE X"
            else -> "Posicion desconocida"
        }
    }

    /**
     * Muestra la posicion del robot
     */
    fun mostrarPosicion(){
        println("${this.nombre} esta en (x:${this.posX} y:${this.posY}) apuntando hacia ${this.obtenerDireccion()}")
    }
}

fun main(){

    val robot1 = Robot("R2D2")

    val movs = arrayOf(
        intArrayOf(1, -5, 0, -9),
        intArrayOf(3, 3, 5, 6, 1, 0, 0, -7),
        intArrayOf(2, 1, 0, -1, 1, 1, -4),
        intArrayOf(),
        intArrayOf(3, 5)
    )

    //for (mov in movs){
    //    robot1.mover(mov)
    //    robot1.mostrarPosicion()
    //}
    movs.forEach {
        robot1.mover(it)
        robot1.mostrarPosicion()
    }
}