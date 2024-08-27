import java.util.Random
import java.util.Scanner

// Función para obtener un tipo de llamada aleatorio
fun obtenerTipoLlamadaAleatorio(): TipoLlamada {
    val tipos = TipoLlamada.values()
    return tipos[Random().nextInt(tipos.size)]
}

// Función para mostrar el menú y manejar las opciones del usuario
fun mostrarMenu(empresa: Empresa) {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n--- Menú ---")
        println("1. Añadir una cabina")
        println("2. Mostrar datos de todas las cabinas")
        println("3. Mostrar detalles consolidados")
        println("4. Registrar una llamada")
        println("5. Reiniciar una cabina")
        println("6. Salir")

        print("Elige una opción: ")
        val opcion = scanner.nextInt()

        when (opcion) {
            1 -> {
                // Añadir una nueva cabina
                print("Introduce el ID de la nueva cabina: ")
                val idCabina = scanner.nextInt()
                val nuevaCabina = CabinaTelefonica(id = idCabina)
                empresa.cabinasTelefonicas.add(nuevaCabina)
                println("Cabina con ID $idCabina añadida.")
            }
            2 -> {
                // Mostrar datos de todas las cabinas
                println("\n--- Datos de las Cabinas ---")
                empresa.cabinasTelefonicas.forEach { cabina ->
                    println(cabina.obtenerDetallesCabina())
                }
            }
            3 -> {
                // Mostrar detalles consolidados
                println("\n--- Detalles Consolidados ---")
                println(empresa.obtenerDetallesConsolidados())
            }
            4 -> {
                // Registrar una llamada
                if (empresa.cabinasTelefonicas.isEmpty()) {
                    println("No hay cabinas disponibles. Añade una cabina primero.")
                    continue
                }

                println("\n--- Registrar una Llamada ---")
                println("Selecciona una cabina (ID):")
                empresa.cabinasTelefonicas.forEach { cabina ->
                    println("ID: ${cabina.id}")
                }
                print("Introduce el ID de la cabina: ")
                val idCabina = scanner.nextInt()

                val cabinaSeleccionada = empresa.cabinasTelefonicas.find { it.id == idCabina }
                if (cabinaSeleccionada != null) {
                    println("Selecciona el tipo de llamada:")
                    println("1. Llamada Local")
                    println("2. Llamada de Larga Distancia")
                    println("3. Llamada a Celular")
                    print("Introduce el número de la opción: ")
                    val tipoOpcion = scanner.nextInt()

                    val tipoLlamada = when (tipoOpcion) {
                        1 -> TipoLlamada.LOCAL
                        2 -> TipoLlamada.LARGA_DISTANCIA
                        3 -> TipoLlamada.CELULAR
                        else -> {
                            println("Tipo de llamada no válido. Se registrará como llamada local por defecto.")
                            TipoLlamada.LOCAL
                        }
                    }

                    val duracion = Random().nextInt(1, 60)
                    val nuevaLlamada = Llamada(tipo = tipoLlamada, duracion = duracion)
                    cabinaSeleccionada.registrarLlamada(nuevaLlamada)
                    println("Llamada registrada: Tipo=${tipoLlamada.name}, Duración=$duracion minutos")
                } else {
                    println("Cabina con ID $idCabina no encontrada.")
                }
            }
            5 -> {
                // Reiniciar una cabina
                if (empresa.cabinasTelefonicas.isEmpty()) {
                    println("No hay cabinas disponibles. Añade una cabina primero.")
                    continue
                }

                println("\n--- Reiniciar una Cabina ---")
                println("Selecciona una cabina (ID):")
                empresa.cabinasTelefonicas.forEach { cabina ->
                    println("ID: ${cabina.id}")
                }
                print("Introduce el ID de la cabina: ")
                val idCabina = scanner.nextInt()

                val cabinaSeleccionada = empresa.cabinasTelefonicas.find { it.id == idCabina }
                if (cabinaSeleccionada != null) {
                    cabinaSeleccionada.reiniciar()
                    println("Cabina con ID $idCabina ha sido reiniciada.")
                } else {
                    println("Cabina con ID $idCabina no encontrada.")
                }
            }
            6 -> {
                // Salir del programa
                println("Saliendo del programa.")
                return
            }
            else -> {
                println("Opción no válida. Por favor, elige una opción correcta.")
            }
        }
    }
}

fun main() {
    // Crear la lista de cabinas vacía y la empresa
    val listaCabinas = mutableListOf<CabinaTelefonica>()
    val empresa = Empresa(cabinasTelefonicas = listaCabinas)

    // Mostrar el menú
    mostrarMenu(empresa)
}
