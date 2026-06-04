# Árbol Binario de Búsqueda en Java

Proyecto de Programación 3 que implementa un Árbol Binario de Búsqueda (BST)
de forma manual en Java.

## Reglas cumplidas

- No se usa `java.util`.
- No se usan librerías externas para la estructura del árbol.
- La cola usada en el recorrido por niveles está implementada manualmente.
- Los métodos nuevos están en `ArbolBinarioBusqueda`.
- Cada método nuevo se prueba desde `Principal`.

## Estructura del proyecto

```text
arboles/
├── pom.xml
└── src/main/java/umg/edu/progra/arboles/
    ├── Nodo.java
    ├── ArbolBinarioBusqueda.java
    └── Principal.java
```

## Cómo compilar y ejecutar

Desde la carpeta del proyecto:

```bash
mvn compile
java -cp target/classes umg.edu.progra.arboles.Principal
```

También se puede abrir en Eclipse:

1. Ir a `File > Import`.
2. Seleccionar `Maven > Existing Maven Projects`.
3. Elegir la carpeta del proyecto `arboles`.
4. Abrir `Principal.java`.
5. Ejecutar con `Run As > Java Application`.

## Árbol usado en las pruebas

El programa inserta los valores:

```text
50, 30, 70, 20, 40, 60, 80, 10
```

Con esos datos se forma este BST:

```text
        50
       /  \
     30    70
    /  \   / \
   20  40 60 80
  /
10
```

La impresión visual del programa aparece rotada 90 grados porque
`imprimirArbol()` imprime primero el subárbol derecho, luego la raíz y luego el
subárbol izquierdo.

## Problema 1: contar nodos recursivamente

Método implementado:

```java
public int contarNodos();
```

Este método cuenta todos los nodos usando recursividad. No usa el campo
`tamanio`.

Ejemplo de salida:

```text
Tamanio inicial: 8
Contar nodos inicial: 8
Contar nodos tras eliminar 20: 7 (tamanio: 7)
Contar nodos tras eliminar 30: 6 (tamanio: 6)
Contar nodos tras eliminar la raiz: 5 (tamanio: 5)
```

## Problema 2: verificar si está balanceado

Método implementado:

```java
public boolean esBalanceado();
```

Un árbol está balanceado si en cada nodo la diferencia de altura entre el
subárbol izquierdo y el derecho es menor o igual a 1.

Ejemplo de salida:

```text
Arbol inicial balanceado? true
InOrden desbalanceado: 1 2 3 4 5
Altura desbalanceado: 4
Esta balanceado? false
```

## Problema 3: validar que sea un BST

Método implementado:

```java
public boolean esBSTValido();
```

Este método revisa que cada nodo respete la propiedad del BST: los valores del
subárbol izquierdo deben ser menores y los valores del subárbol derecho deben
ser mayores. La validación se hace recursivamente usando rangos permitidos.

Ejemplo de salida:

```text
InOrden arbol valido: 10 20 30 40 50 60 70 80
Es BST valido? true
InOrden arbol roto: 90 50 70
Es BST valido? false
```

## Problema 4: ancestro común más bajo

Método implementado:

```java
public int ancestroComunMasBajo(int a, int b);
```

El método busca el ancestro común más bajo aprovechando la propiedad del BST.
Si ambos valores son menores que el nodo actual, busca a la izquierda. Si ambos
son mayores, busca a la derecha. Si los valores quedan separados, el nodo
actual es el ancestro común más bajo.

Si alguno de los dos valores no existe, lanza `IllegalArgumentException`.

Ejemplo de salida:

```text
LCA de 10 y 40: 30
LCA de 10 y 80: 50
LCA de 60 y 80: 70
LCA de 10 y 99: Ambos valores deben existir en el arbol
```

## Problema 5: invertir el árbol

Método implementado:

```java
public void invertir();
```

Este método convierte el árbol en su espejo, intercambiando el hijo izquierdo y
el hijo derecho en todos los nodos.

Ejemplo de salida:

```text
InOrden antes: 10 20 30 40 50 60 70 80
InOrden despues: 80 70 60 50 40 30 20 10
```

## Ejercicios extra

### E1: k-ésimo menor

Método implementado:

```java
public int kEsimoMenor(int k);
```

Devuelve el valor que ocupa la posición `k` si el árbol se recorre en inOrden.
Como el árbol es BST, el recorrido inOrden visita los valores de menor a mayor.

Ejemplo de salida:

```text
E1 - 1er menor: 10
E1 - 4to menor: 40
E1 - 8vo menor: 80
```

### E2: imprimir rango ordenado

Método implementado:

```java
public void imprimirRangoOrdenado(int min, int max);
```

Imprime en orden los valores que están dentro del rango `[min, max]`. El método
evita recorrer ramas que no pueden tener valores dentro del rango.

Ejemplo de salida:

```text
E2 - Valores entre 25 y 70: 30 40 50 60 70
```

### E3: diámetro del árbol

Método implementado:

```java
public int diametro();
```

Devuelve el camino más largo entre dos nodos del árbol, medido en aristas.

Ejemplo de salida:

```text
E3 - Diametro del arbol: 5
```

### E4: construir un BST desde argumentos

La clase `Principal` permite recibir valores desde la consola usando `args`.

Ejemplo:

```bash
java -cp target/classes umg.edu.progra.arboles.Principal 15 8 20 3 10
```

Ejemplo de salida:

```text
E4 - Arbol construido con args:
InOrden args: 3 8 10 15 20
Tamanio args: 5
```

## Resultado general

El programa demuestra los cinco problemas obligatorios y los ejercicios extra
desde la clase `Principal`. Todo se implementó sin usar `java.util`.

## Comandos Git sugeridos

Para revisar los archivos modificados:

```bash
git status
```

Para subir solamente el código fuente y el README, sin incluir archivos
generados por Maven en `target/`:

```bash
git add arboles/README.md
git add arboles/src/main/java/umg/edu/progra/arboles/ArbolBinarioBusqueda.java
git add arboles/src/main/java/umg/edu/progra/arboles/Principal.java
```

Si se quiere hacer un commit general con todo lo obligatorio y extra:

```bash
git commit -m "feat: completar problemas de arbol BST y ejercicios extra"
```

Si se quiere separar por partes, se puede usar `git add -p` para seleccionar
solo los bloques de código de cada problema:

```bash
git add -p arboles/src/main/java/umg/edu/progra/arboles/ArbolBinarioBusqueda.java
git add -p arboles/src/main/java/umg/edu/progra/arboles/Principal.java
git commit -m "feat: problema 1 contar nodos recursivamente"
```

Luego se repite el mismo proceso para los demás problemas.

Mensajes de commit recomendados:

```text
feat: problema 1 contar nodos recursivamente
feat: problema 2 validar arbol balanceado
feat: problema 3 validar propiedad BST
feat: problema 4 calcular ancestro comun mas bajo
feat: problema 5 invertir arbol
feat: agregar ejercicios extra del BST
docs: actualizar readme de entrega
```

Para subir los commits al repositorio remoto:

```bash
git push origin main
```

Si la rama se llama `master`, usar:

```bash
git push origin master
```
