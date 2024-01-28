fun main() {
    // Creamos coches
    val coche1 = Coche("rojo", "audi", "rs6", 560, 5,"123d567")
    val coche2 = Coche("azul", "bmw", "m3", 450, 4, "XYZ5678")
    val coche3 = Coche("negro", "mercedes", "amg c63", 510, 4, "DEF9012")


    // Mostramos los coches
    println(coche1.toString())
    println(coche2.toString())
    println(coche3.toString())

    // Modificamos valores
    coche1.matricula = "abcdefg"
    coche1.numPuertas = 3
    coche1.color = "platino"
    coche1.numCaballos = 367



    // Mostramos los coches
    println("***************************************************************************")
    println("***************************************************************************")
    println(coche1.toString())
    println(coche2.toString())
    println(coche3.toString())

    // Intentamos modificar
    coche2.modelo = ""
    coche2.marca = ""
    coche2.numCaballos = 785
    coche2.numPuertas = 6
    coche3.matricula = "456123"

    // Mostramos los coches
    println("***************************************************************************")
    println("***************************************************************************")
    println(coche1.toString())
    println(coche2.toString())
    println(coche3.toString())

    // Intentamos instanciar
    try {
        val coche4 = Coche("", "", "", 0, 0, "")
    }catch (e: IllegalArgumentException){
        println("ERROR AL INSTANCIAR EL COCHE- $e")
    }
}