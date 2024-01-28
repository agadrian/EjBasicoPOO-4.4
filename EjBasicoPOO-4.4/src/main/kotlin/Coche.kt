import java.util.*

// ANTIGUO
/**
 * Ejercicio 4.4¶
 * Crear una clase Coche, a través de la cual se pueda conocer el color del coche, la marca, el modelo, el número de caballos, el número de puertas y la matrícula. Crear el constructor del coche, así como los métodos estándar: getters, setters y toString().
 *
 * Para realizar getters y setters, añade el modificador private a los atributos de la clase y genera los métodos getColor(), setColor(), ..., así para todos los atributos.
 *
 * En el programa principal, instancia varios coches, muestra su información, cambia el color a algunos de ellos y vuelve a mostrarlos por pantalla.
 *
 * Realiza también una modificación al método setNumCaballos() para que no permita actualizar el atributo numCaballos con un valor interior a 70, ni superior a 700.
 *
 * Realiza otra modificación al método setNumPuertas() para que no se pueda actualizar con un valor inferior a 3, ni superior a 5... pero esta vez utiliza require.
 *
 * Para probar las modificaciones a los métodos anteriores, solicita al usuario el número de caballos para un coche y haz lo mismo para el número de puertas.



class Coche(
private var color: String,
private var marca: String,
private var modelo: String,
private var numCaballos: Int,
private var numPuertas: Int,
private var matricula: String
)   {

// GETTERS marca modelo
fun getMarca(): String = this.marca
fun setMarca(marca2: String){
this.marca = marca2
}


fun getModelo(): String = this.modelo
fun setModelo(modelo2: String){
this.modelo = modelo2
}


fun getColor():String = this.color
fun setColor(color2: String){
this.color = color2
}


fun getNumCaballos():Int = this.numCaballos
fun setNumCaballos(numCaballos2: Int){
//require(numCaballos2 in 70..700) {"ERROR: Los caballos deben estar entre 70-700"}
if (numCaballos2 !in 70..700) throw IllegalArgumentException ("ERROR: Los caballos deben estar entre 70-700")
this.numCaballos = numCaballos2
}



fun getNumPuertas():Int = this.numPuertas
fun setNumPuertas(numPuertas2: Int) {
require(numPuertas2 in 3..5) { "El numero de puertas debe ser 3-5" }
this.numPuertas = numPuertas2
}


fun getMatricula():String = this.matricula
fun setMatricula(matricula2: String){
this.matricula = matricula2
}


// Override toString()
override fun toString(): String {
return "Datos coche - Color: ${this.color}, Marca: ${this.marca}, Modelo: ${this.modelo}, Numero de Caballos: ${this.numCaballos}, Numero de Puertas: ${this.numPuertas}, Matricula: ${this.matricula}"
}

}


fun ejercicioBasico4(){

// Lista que contiene cada coche creado
val coches = listOf(
Coche("Rojo", "Toyota", "Corolla", 120, 4, "ABC123"),
Coche("Azul", "Honda", "Civic", 90, 5, "XYZ789"),
Coche("Verde", "Ford", "Focus", 150, 4, "DEF456"),
Coche("Negro", "Volkswagen", "Golf", 110, 3, "GHI789")
)

// Mostrar informacion coches por defecto
println("DATOS COCHES: ")
for (coche in coches){
println(coche.toString())
}

// Cambiar color de estos coches accediendo a sus posicione en la lista
coches[0].setColor("Amarillo") //coche1
coches[3].setColor("Verde") //coche2

// Mostrar informacion coches con los cambios
println("DATOS COCHES ACTUALIZADOS: ")
for (coche in coches){
println(coche.toString())
}

// Solicitar num de caballos y aplicarlo
println("Ingresa numero de caballos: ")
coches[0].setNumCaballos(readln().toIntOrNull() ?:0)

// Solicitar num de puertas y aplicarlo
println("Ingresa numero de puertas: ")
coches[0].setNumPuertas(readln().toIntOrNull() ?:0)

// Mostrar informacion de coche1 actualizada usando nuestra funcion reemplazada de toString()
println("Informacion actualizada coche1: ")
println(coches[0].toString())


// Se podria hacer sin usar lista, y haciendo coche1.toString(), coche2.toString() etc...

}
 **/


// NUEVO 4.4
/**
 * EJ 4 V2
 * Ejercicio 4.4¶
 * Crear una clase Coche, a través de la cual se pueda conocer el color del coche, la marca, el modelo, el número de caballos, el número de puertas y la matrícula. Crear el constructor del coche, así como el método toString().
 *
 * Marca y modelo no podrán ser blancos ni nulos y no podrán modificarse. --
 * Número de caballos, número de puertas y matrícula no podrán modificarse, ni podrán ser nulos.
 * Color podrá modificarse, pero no podrá ser nulo.
 * Recuerda que Kotlin añade los getters y setters con el comportamiento por defecto, por lo que no es necesario que los implementes, a no ser que tengas que añadir alguna funcionalidad extra.
 *
 * Modifica el atributo matricula para que no permita actualizar la matrícula con un valor que no tenga 7 caracteres.
 * Los atributos de modelo la marca siempre se devolverán con la primera letra en mayúscula.
 * Realiza también una modificación del atributo número de caballos, para que no permita actualizar el atributo numCaballos con un valor interior a 70, ni superior a 700.
 * Realiza una modificación del atributo número de puertas, para que no permita actualizar el atributo numPuertas con un valor inferior a 3, ni superior a 5.
 * Ten en cuenta todas estas condiciones a la hora de crear el constructor de la clase.
 * En el programa principal, instancia varios coches y muéstralos por pantalla. Probar las modificaciones anteriores, modifica el número de caballos para un coche y haz lo mismo para el número de puertas, el color, la marca y modelo. Vuelve a mostrarlos por pantalla.
 *
 * Intenta instanciar y modificar con la marca y modelo con valores nulos o blancos y comprueba que no es posible.
 * Intenta instanciar y modificar con el número de caballos con un valor inferior a 70 o superior a 700 y comprueba que no es posible.
 * Intenta instanciar y modificar con el número de puertas con un valor inferior a 3 o superior a 5 y comprueba que no es posible.
 * Intenta instanciar y modificar con la matrícula con un valor que no tenga 7 caracteres y comprueba que no es posible.
 * Intenta instanciar y modificar con el color, el número de caballos, el número de puertas y la matrícula con valores nulos/blancos y comprueba que no es posible.
 **/


class Coche(
    var color: String,
    marca: String,
    modelo: String,
    numCaballos: Int,
    numPuertas: Int,
    matricula: String
){
    init {

        require(marca.isNotBlank()){"Error - La marca no puede estar vacia"}
        require(modelo.isNotBlank()){"Error - El modelo no puede estar vacio"}
        require(matricula.length == 7) { "ERROR - La longitud de la matricula debe ser 7" }
        //requireNumCaballos(numCaballos)
        require(numCaballos in 70..700) { "ERROR - Los cv deben estar en el rango de 70..700" }
        require(numPuertas in 3..5) { "ERROR - El num de puertas debe estar entre 3..5" }
    }


    var matricula: String = ""
        set(value) {
            //require(value.length == 7) { "Error - La longitud de la matriicula debe ser 7" }
            //field = value
            if (value.length != 7) println( "ERROR - La longitud de la matriicula debe ser 7" ) else field = value
        }

    var marca: String = marca
        get() = field.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        set(value){
            if (value.isEmpty()) println("ERROR - La marca no puede estar vacia") else field = value
        }


    var modelo: String = modelo.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        set(value){
            if (value.isEmpty()) println("ERROR - El modelo no puede estar vacio") else field = value
        }
    var numCaballos: Int = numCaballos
        set(value) {
            //requireNumCaballos(value)
            //require(value in 70..700) { "Los cv deben estar en un rango 70-700. No se ha modificado" }
            //field = value
            if (value !in 70..700) println("ERROR - Los cv deben estar en un rango 70-700. No se ha modificado") else field = value


        }

    var numPuertas: Int = numPuertas
        set(value){
            //require(value in 3..5) { "Numero de puertas debe estar entre 3-5. No se ha modificado" }
            //field = value
            if (value !in 3..5) println("ERROR - Numero de puertas debe estar entre 3-5. No se ha modificado") else field = value

        }

    private fun requireNumCaballos(numCaballos: Int){
        require(numCaballos in 70..700) { "Los cv deben estar en un rango 70-700. No se ha modificado" }
    }


    // Override toString()
    override fun toString(): String {
        return "Datos coche - Color: ${this.color}, Marca: ${this.marca}, Modelo: ${this.modelo}, Numero de Caballos: ${this.numCaballos}, Numero de Puertas: ${this.numPuertas}, Matricula: ${this.matricula}"
    }
}