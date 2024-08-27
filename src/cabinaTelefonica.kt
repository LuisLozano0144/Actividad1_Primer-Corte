// Define las tarifas
const val TARIFA_LOCAL = 50   // Tarifa por minuto para llamadas locales
const val TARIFA_LARGA_DISTANCIA = 350 // Tarifa por minuto para llamadas de larga distancia
const val TARIFA_CELULAR = 150 // Tarifa por minuto para llamadas a celulares

// Clase para representar una llamada
data class Llamada(
    val tipo: TipoLlamada,   // Tipo de llamada (local, larga distancia, celular)
    val duracion: Int        // Duración en minutos
)

// Enumeración para los tipos de llamada
enum class TipoLlamada {
    LOCAL, LARGA_DISTANCIA, CELULAR
}

// Clase para representar una cabina telefónica
class CabinaTelefonica(val id: Int) {
    private val registrosDeLlamadas = mutableListOf<Llamada>()

    // Registra una llamada
    fun registrarLlamada(llamada: Llamada) {
        registrosDeLlamadas.add(llamada)
    }

    // Obtiene el número de llamadas realizadas
    fun obtenerNumeroDeLlamadas(): Int = registrosDeLlamadas.size

    // Obtiene la duración total de las llamadas en minutos
    fun obtenerDuracionTotal(): Int = registrosDeLlamadas.sumOf { it.duracion }

    // Calcula el costo total de las llamadas
    fun calcularCostoTotal(): Int {
        return registrosDeLlamadas.sumOf { llamada ->
            when (llamada.tipo) {
                TipoLlamada.LOCAL -> llamada.duracion * TARIFA_LOCAL
                TipoLlamada.LARGA_DISTANCIA -> llamada.duracion * TARIFA_LARGA_DISTANCIA
                TipoLlamada.CELULAR -> llamada.duracion * TARIFA_CELULAR
            }
        }
    }

    // Obtiene el detalle de la cabina
    fun obtenerDetallesCabina(): String {
        return """
            Cabina ID: $id
            Número de llamadas realizadas: ${obtenerNumeroDeLlamadas()}
            Duración total de llamadas: ${obtenerDuracionTotal()} minutos
            Costo total de llamadas: \$${calcularCostoTotal()}
        """.trimIndent()
    }

    // Obtiene el historial de llamadas
    fun obtenerRegistrosDeLlamadas(): List<Llamada> = registrosDeLlamadas

    // Reinicia la cabina
    fun reiniciar() {
        registrosDeLlamadas.clear()
    }
}

// Clase para representar la empresa
class Empresa(val cabinasTelefonicas: MutableList<CabinaTelefonica>) {
    // Calcula el costo total de todas las cabinas
    fun calcularCostoTotal(): Int {
        return cabinasTelefonicas.sumOf { it.calcularCostoTotal() }
    }

    // Obtiene el número total de llamadas realizadas
    fun obtenerNumeroTotalDeLlamadas(): Int {
        return cabinasTelefonicas.sumOf { it.obtenerNumeroDeLlamadas() }
    }

    // Obtiene la duración total de llamadas en minutos
    fun obtenerDuracionTotal(): Int {
        return cabinasTelefonicas.sumOf { it.obtenerDuracionTotal() }
    }

    // Calcula el costo promedio por minuto
    fun calcularCostoPromedioPorMinuto(): Double {
        val totalMinutos = obtenerDuracionTotal()
        return if (totalMinutos > 0) {
            calcularCostoTotal().toDouble() / totalMinutos
        } else {
            0.0
        }
    }

    // Obtiene el consolidado total de las cabinas
    fun obtenerDetallesConsolidados(): String {
        return """
            Costo total de la línea: \$${calcularCostoTotal()}
            Número total de llamadas realizadas: ${obtenerNumeroTotalDeLlamadas()}
            Duración total de llamadas: ${obtenerDuracionTotal()} minutos
            Costo promedio por minuto: \$${calcularCostoPromedioPorMinuto()}
        """.trimIndent()
    }

    // Obtiene el historial completo de llamadas de todas las cabinas
    fun obtenerRegistrosDeLlamadasTotales(): List<Llamada> {
        return cabinasTelefonicas.flatMap { it.obtenerRegistrosDeLlamadas() }
    }
}
