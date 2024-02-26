# Complejidad computacional

La complejidad computacional de este algoritmo depende de varios factores:

# 1. Lectura del Archivo:

La lectura del archivo se realiza línea por línea en un bucle while. Si el archivo tiene n líneas, la complejidad sería O(n).

# 2.Procesamiento de Palabras en cada Línea:

Dentro del bucle while, se procesa cada línea del archivo. Si una línea tiene m palabras, el procesamiento de palabras sería O(m).

# 3. Operaciones en el Mapa wordFrequency:

Se realiza una operación de inserción o actualización en el mapa wordFrequency para cada palabra en cada línea. Si hay un total de p palabras únicas en el archivo, la complejidad sería O(p).

# 4. Ordenamiento de las Entradas del Mapa:
Se realiza una operación de ordenamiento para ordenar las entradas del mapa por frecuencia. Si hay p palabras únicas, la complejidad sería O(p * log(p)). En general, la complejidad computacional se ve afectada por el número total de líneas (n), el número total de palabras (m), el número total de palabras únicas (p), y el tamaño del archivo en términos de caracteres. La complejidad dominante en términos de tiempo es el ordenamiento de las entradas del mapa.

# 5. Conclusion
Entonces, la complejidad total se puede expresar como O(n * (m + p * log(p))). En términos prácticos, la complejidad real dependerá de la distribución de palabras en el archivo y de cuántas palabras únicas hay.
