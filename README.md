Gestión de Cabinas Telefónicas
Descripción
Este proyecto es una aplicación en Kotlin para la gestión de cabinas telefónicas. Permite registrar llamadas en diferentes cabinas, calcular el costo total de las llamadas, y mostrar detalles consolidados sobre todas las cabinas. También incluye la capacidad de reiniciar una cabina, eliminando todas las llamadas registradas.

Requisitos
Kotlin: Asegúrate de tener Kotlin instalado en tu sistema para ejecutar el código.
JDK: Este proyecto requiere Java Development Kit (JDK) 8 o superior.
Instalación
Clona el repositorio:
Copiar código
git clone https://github.com/LuisLozano0144/Actividad1_Primer-Corte.git
Navega al directorio del proyecto:
Uso
Ejecuta la aplicación:
Interacción con el menú:

Añadir una cabina: Introduce un ID para la nueva cabina.
Mostrar datos de todas las cabinas: Muestra información detallada sobre cada cabina.
Mostrar detalles consolidados: Proporciona un resumen consolidado de todas las cabinas.
Registrar una llamada: Selecciona una cabina y registra una llamada con su duración y tipo.
Reiniciar una cabina: Borra todas las llamadas registradas en una cabina específica.
Salir: Cierra la aplicación.
Aspectos Relevantes
Estructura del Código: El código está dividido en dos archivos: uno para las clases y otro para el código principal.
Data Classes: Llamada es una data class que simplifica la gestión de datos de llamadas, proporcionando automáticamente métodos como equals, hashCode, y toString.
Enumeraciones: TipoLlamada define los diferentes tipos de llamadas posibles.
Persistencia en Memoria: Los datos de las llamadas se mantienen en memoria y se pierden al cerrar la aplicación. Considera implementar persistencia en disco si es necesario.

Posibles Mejoras
Persistencia de Datos: Implementar almacenamiento en disco para guardar las llamadas y cabinas entre ejecuciones de la aplicación.
Interfaz de Usuario: Añadir una interfaz gráfica para una mejor experiencia de usuario en lugar de una interfaz de línea de comandos.
Validación de Entradas: Mejorar la validación de las entradas del usuario para evitar errores y entradas inválidas.
Soporte para Múltiples Empresas: Expandir la funcionalidad para gestionar múltiples empresas con diferentes conjuntos de cabinas.
Nuevas Funcionalidades
Exportación de Datos: Añadir la capacidad para exportar datos a archivos CSV o Excel para análisis externo.
Notificaciones: Implementar un sistema de notificaciones para alertar a los usuarios sobre ciertos eventos (por ejemplo, llamadas de larga duración).
Informes Detallados: Generar informes detallados sobre el uso de las cabinas y el costo de las llamadas.
Contribuciones
Las contribuciones son bienvenidas. Por favor, sigue estos pasos si deseas contribuir:

Realiza un fork del repositorio.
Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
Realiza tus cambios y realiza un commit (git commit -am 'Añadir nueva funcionalidad').
Empuja la rama (git push origin feature/nueva-funcionalidad).
Crea un nuevo Pull Request.
#Realizado por Luis Lozano
