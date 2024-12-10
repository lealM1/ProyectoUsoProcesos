import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    // Crear el número aleatorio entre 1 y 100
    val numeroAleatorio = (1..100).random()

    // Configurar el proceso hijo
    val proceso = ProcessBuilder(
        "C:\\Program Files\\Eclipse Adoptium\\" +
                "jdk-21.0.3.9-hotspot\\bin\\java.exe\" \"" +
                "-javaagent:C:\\Program Files\\JetBrains\\" +
                "IntelliJ IDEA Community Edition 2024.2.4\\lib\\" +
                "idea_rt.jar=50600:C:\\Program Files\\JetBrains\\IntelliJ IDEA " +
                "Community Edition 2024.2.4\\bin\" " +
                "-Dfile.encoding=UTF-8 -Dsun.stdout.encoding=UTF-8 " +
                "-Dsun.stderr.encoding=UTF-8 -classpath \"C:\\Users\\lealm\\" +
                "2º DAW\\proyectoPROCESOSDEF\\out\\production\\proyectoPROCESOSDEF;" +
                "C:\\Users\\lealm\\.m2\\repository\\org\\jetbrains\\kotlin\\kotlin-stdlib" +
                "\\2.0.20\\kotlin-stdlib-2.0.20.jar;C:\\Users\\lealm\\.m2\\repository\\org\\" +
                "jetbrains\\annotations\\13.0\\annotations-13.0.jar\" HijoKt"
    )
    // Iniciar el proceso hijo
    val hijo = proceso.start()

    // Enviar el número aleatorio al hijo
    val escribir = OutputStreamWriter(hijo.outputStream)
    escribir.write("$numeroAleatorio\n")
    escribir.flush()

    // Leer mensajes del hijo
    val leer = BufferedReader(InputStreamReader(hijo.inputStream))
    var mensaje: String?

    while (leer.readLine().also { mensaje = it } != null) {
        println(mensaje)
    }

    leer.close()
    escribir.close()
}
