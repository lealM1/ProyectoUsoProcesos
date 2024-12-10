import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    // Leer el número objetivo enviado por el padre
    val lector = BufferedReader(InputStreamReader(System.`in`))
    val numeroObjetivo = lector.readLine()?.toIntOrNull() ?: 0

    val respuesta = OutputStreamWriter(System.out)
    var adivinado = false

    respuesta.write("Adivina el numero entre 1 y 100!\n")
    respuesta.flush()

    while (!adivinado) {
        respuesta.write("Introduce tu número: ")
        respuesta.flush()

        // Leer el intento del usuario
        val intento = lector.readLine()?.toIntOrNull() ?: 0

        if (intento < numeroObjetivo) {
            respuesta.write("El número es mayor.\n")
        } else if (intento > numeroObjetivo) {
            respuesta.write("El número es menor.\n")
        } else {
            respuesta.write("Felicidades, has adivinado el número.\n")
            adivinado = true
        }
        respuesta.flush()
    }

    lector.close()
    respuesta.close()
}
