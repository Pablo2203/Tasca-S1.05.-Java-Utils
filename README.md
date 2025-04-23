# Tasca-S1.05.-Java-Utils

## 📄 Descripción - Enunciado del ejercicio
Este proyecto permite a los usuarios gestionar y procesar directorios y archivos de manera eficiente, implementando funcionalidades como la listar contenidos de un directorio, guardar estructuras en archivos, leer configuraciones, serializar objetos y cifrar/descifrar archivos. Abarca tres niveles de dificultad, ofreciendo diferentes funcionalidades para aprender y dominar aspectos clave del manejo de archivos, directorios, objetos y seguridad en Java.

El objetivo principal del proyecto es procesar directorios y archivos, mostrando y almacenando estructuras, permitiendo la configuración dinámica de parámetros y demostrando el uso de AES para la seguridad de los datos.

---

## 💻 Tecnologías Utilizadas
- **Java 17**: Lenguaje de programación utilizado.
- **IntelliJ IDEA o Eclipse**: Entornos de desarrollo integrado (IDE).
- **Java I/O**: Operaciones con directorios, archivos y flujos de entrada/salida.
- **Java Serialization**: Serialización y deserialización de objetos Java.
- **API de Criptografía de Java**: Para el cifrado/descifrado usando AES.
- **Maven**: Herramienta de construcción del proyecto y gestión de dependencias.

---

## 📋 Requisitos
Antes de ejecutar el proyecto, asegúrate de cumplir con los siguientes requisitos:
1. **Instalar Java Development Kit (JDK)**, versión 17 o superior.
2. **Maven** para gestionar las dependencias.
3. Editor/IDE favorito (**IntelliJ IDEA** o **Eclipse**).
4. Este proyecto utiliza las bibliotecas estándar de Java, por lo que no necesitas instalar dependencias externas.

---

## 🛠️ Instalación
Para instalar el proyecto localmente:

1. **Clona el repositorio**:
   ```bash
   git clone https://github.com/your-repository/gestion-de-archivos.git
   ```
2. **Accede al directorio**:
   ```bash
   cd gestion-de-archivos
   ```
3. **Abre el proyecto** en IntelliJ IDEA o el IDE de tu preferencia.
4. **Construye el proyecto** con Maven para asegurarte de que todas las dependencias estén configuradas:
   ```bash
   mvn clean install
   ```

---

## ▶️ Ejecución
### Ejecución desde terminal:
Todas las funcionalidades del proyecto deben ejecutarse desde la línea de comandos. Sigue los pasos:

1. **Compila el proyecto** para generar los archivos `.class` desde los archivos `.java`:
   ```bash
   javac -d out src/main/java/*.java
   ```

2. **Ejecuta el programa** desde la terminal, especificando la clase principal y los argumentos si es necesario:
   ```bash
   java -cp out Main <ruta-del-directorio>
   ```
   - Si deseas ejecutar sin argumentos, la aplicación utilizará valores predeterminados (como procesar el contenido del directorio `src/main/resources`).
   - Estos comandos siguen buenas prácticas:
     - Usa **rutas relativas** en lugar de absolutas.
     - Usa `File.separator` para garantizar la portabilidad en diferentes sistemas operativos.

### Funcionalidades del proyecto por niveles:

---

### **Nivel 1**

#### - Ejercicio 1:
Crea una clase que liste alfabéticamente el contenido de un directorio recibido por parámetro.

**Ejecución**:
```bash
java -cp out Main <ruta-del-directorio>
```
Resultado: Lista todos los archivos/directorios alfabéticamente en el directorio especificado.

#### - Ejercicio 2:
Extiende la funcionalidad anterior para recorrer recursivamente los subdirectorios, listando todo su contenido en orden alfabético, incluyendo tipo ("D" para directorio, "F" para archivo) y su última fecha de modificación.

**Ejecución**:
```bash
java -cp out Main <ruta-del-directorio>
```
Resultado: Muestra la estructura completa del árbol del directorio en la consola.

#### - Ejercicio 3:
Guarda la estructura del directorio (nivel 2) en un archivo `Path.txt`. Por defecto, el archivo se guardará en `src/main/resources/`.

**Ejecución**:
```bash
java -cp out Main <ruta-del-directorio>
```
Resultado: La estructura jerárquica del directorio se almacena en el archivo `Path.txt`.

#### - Ejercicio 4:
Añade la funcionalidad de leer cualquier archivo .txt y mostrar su contenido por consola.

**Ejecución**:
```bash
java -cp out Main <ruta-del-archivo-txt>
```
Resultado: Muestra el contenido del archivo especificado.

#### - Ejercicio 5:
Añade la capacidad de serializar un objeto Java a un archivo `.ser` y después deserializarlo.

**Ejecución**:
```bash
java -cp out Main
```
El programa serializará el objeto en un archivo (`JavaObject.txt`) y lo deserializará, mostrando el contenido por consola.

---

### **Nivel 2**

#### - Ejercicio 1:
Extiende el ejercicio 3 (de guardar el contenido del árbol de directorios en un archivo `.txt`), configurando todo mediante un archivo de configuración. El programa debe leer:
- Directorio a procesar.
- Directorio y nombre del archivo de salida.

Usaremos un archivo de configuración `config.properties` (por ejemplo, ubicado en `src/main/resources/config.properties`).

**Ejecución**:
```bash
java -cp out Main
```
El programa leerá la configuración del archivo `config.properties` y utilizará esos parámetros para procesar el directorio y guardar el archivo.

---

### **Nivel 3**

#### - Ejercicio 1:
Añade una utilidad para **cifrar y descifrar** los archivos generados en los niveles anteriores, utilizando el algoritmo AES (modo ECB o CBC con PKCS5Padding).

**Ejecución**:
```bash
java -cp out Main <path-del-archivo>
```
Resultado:
- El programa cifrará `Path.txt` (o cualquier archivo generado) y lo guardará como `Path_encrypted.txt`.
- Luego descifrará el archivo cifrado, mostrando el contenido descifrado en la consola.

---

## 🌐 Despliegue
Este proyecto está pensado para ejecutarse de forma local. Sin embargo, si deseas crear un archivo JAR ejecutable, sigue estos pasos:

1. Usa Maven para empaquetar el proyecto:
   ```bash
   mvn package
   ```

2. Esto generará un archivo JAR en el directorio `target`. Puedes ejecutar el archivo JAR con:
   ```bash
   java -jar target/gestion-de-archivos.jar
   ```

---

## 🤝 Contribuciones
Este proyecto acepta contribuciones. Sigue los pasos:
1. Haz un fork del repositorio.
2. Crea una nueva rama:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios, haz un commit y súbelos:
   ```bash
   git commit -m "Añadir funcionalidad X"
   git push origin feature/nueva-funcionalidad
   ```
4. Abre un Pull Request y espera revisión.

---

## 💡 Mejores Prácticas
- Usa rutas relativas y `File.separator` en lugar de rutas absolutas para garantizar portabilidad.
- Los ejercicios deben implementarse siguiendo el estándar de codificación del Sprint 0.
- Programa en inglés para mantener la coherencia y profesionalidad del código.

---

💡 **Autor**: Pablo Federico Gomez  
📧 **Contacto**: pablo.federico.gomez@gmail.com  
