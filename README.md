# Tasca-S1.05.-Java-Utils

## 📄 Descripción - Enunciado del ejercicio
Este proyecto permite a los usuarios gestionar y procesar directorios y archivos de manera eficiente. Ofrece funcionalidades para listar los contenidos de un directorio de manera jerárquica, guardar la estructura del directorio en un archivo, serializar y deserializar objetos, y cifrar y descifrar archivos. La aplicación demuestra operaciones robustas de manejo de archivos, gestión de configuración y persistencia de objetos.

El objetivo principal del proyecto es procesar la estructura de un directorio, mostrar su contenido, guardarlo en un archivo y realizar operaciones como cifrado, descifrado y serialización.

---

## 💻 Tecnologías Utilizadas
- **Java 17**: Lenguaje de programación principal utilizado en el proyecto.
- **IntelliJ IDEA**: Entorno de desarrollo integrado (IDE).
- **Java I/O**: Para la gestión de archivos y operaciones con directorios.
- **Serialización en Java**: Para serializar y deserializar objetos de Java.
- **API de Criptografía de Java**: Para cifrado y descifrado de archivos.
- **Maven**: Herramienta de gestión de dependencias y construcción del proyecto.

---

## 📋 Requisitos
Antes de ejecutar el proyecto, asegúrate de tener lo siguiente instalado:

1. **Java Development Kit (JDK)** versión 17 o superior.
2. **Maven** para gestionar las dependencias.
3. **IntelliJ IDEA** o cualquier editor/IDE que soporte Java.
4. Las siguientes dependencias (manejadas automáticamente por Maven):
   - Este proyecto utiliza exclusivamente las bibliotecas principales de Java.

---

## 🛠️ Instalación
Para configurar el proyecto localmente, sigue estos pasos:

1. Clona el repositorio:
   ```bash
   git clone https://github.com/your-repository/gestion-de-archivos.git
   ```
2. Navega al directorio del proyecto:
   ```bash
   cd gestion-de-archivos
   ```
3. Abre el proyecto en IntelliJ IDEA o tu IDE favorito.
4. Construye el proyecto para asegurar que todas las dependencias se hayan resuelto:
   ```bash
   mvn clean install
   ```

---

## ▶️ Ejecución
Para ejecutar el proyecto, sigue los pasos a continuación:

1. Proporciona el path del directorio que deseas procesar como primer argumento al ejecutar la aplicación.

2. Ejecuta la clase `Main` desde tu IDE o a través de la terminal:
   ```bash
   java -cp target/gestion-de-archivos-1.0.jar exercise1.Main <ruta-del-directorio>
   ```
   Reemplaza `<ruta-del-directorio>` con la ruta del directorio que deseas procesar.

3. La aplicación realizará las siguientes acciones:
   - Listará la estructura del directorio de forma jerárquica.
   - Guardará el contenido del directorio en el archivo `Path.txt` ubicado en el directorio `src/main/resources`.
   - Serializará el objeto `JavaObject` en el archivo `JavaObject.txt`.
   - Cifrará el archivo `Path.txt` y luego lo descifrará.

---

## 🌐 Despliegue
Este proyecto es una utilidad para usarse localmente y no requiere un despliegue específico en producción. Sin embargo, puedes empaquetarlo como un archivo JAR usando Maven y ejecutarlo en cualquier sistema con un entorno de ejecución de Java.

Para crear un archivo JAR:
```bash
mvn package
```
El archivo JAR será creado en el directorio `target`.

---

## 🤝 Contribuciones
¡Las contribuciones son bienvenidas! Si deseas contribuir, por favor sigue estas pautas:

1. Realiza un fork del repositorio y crea tu propia rama:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
2. Realiza tus cambios y haz un commit con un mensaje claro:
   ```bash
   git commit -m "Añadir nueva funcionalidad: descripción"
   ```
3. Envía tu rama a tu fork:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
4. Abre un pull request y describe tus cambios en detalle.

---

Si tienes preguntas o problemas, no dudes en abrir un issue en el repositorio.

---

💡 **Autor**: Pablo Federico Gomez
📧 Contacto: pablo.federico.gomez@gmail.com
