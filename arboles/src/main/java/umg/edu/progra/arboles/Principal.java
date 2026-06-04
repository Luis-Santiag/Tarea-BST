package umg.edu.progra.arboles;

/**
 * Clase principal que demuestra el uso del Arbol Binario de Busqueda (BST)
 * implementado manualmente, sin usar librerias como java.util.
 *
 * Ejecucion sugerida:
 *   1. mvn compile
 *   2. mvn exec:java -Dexec.mainClass="umg.edu.progra.arboles.Principal"
 *
 * @author Walter Cordova
 */
public class Principal {

    public static void main(String[] args) {

        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        /*
         * Insertamos estos valores para formar el siguiente BST:
         *
         *               50
         *              /  \
         *            30    70
         *           /  \   / \
         *          20  40 60  80
         *         /
         *        10
         */
        int[] valores = { 50, 30, 70, 20, 40, 60, 80, 10 };
        for (int v : valores) {
            arbol.insertar(v);
        }

        System.out.println("===== Arbol Binario de Busqueda =====");
        System.out.println("Tamanio: " + arbol.tamanio());
        System.out.println("Contar nodos recursivo: " + arbol.contarNodos());
        System.out.println("Altura:  " + arbol.altura());
        System.out.println("Minimo:  " + arbol.minimo());
        System.out.println("Maximo:  " + arbol.maximo());
        System.out.println("Hojas:   " + arbol.contarHojas());
        System.out.println("Esta balanceado? " + arbol.esBalanceado());
        System.out.println("Es BST valido? " + arbol.esBSTValido());

        System.out.println("\n--- Representacion visual (rotada 90 grados) ---");
        arbol.imprimirArbol();

        System.out.println("\n--- Recorridos ---");
        System.out.print("InOrden    (ascendente): ");
        arbol.inOrden();

        System.out.print("PreOrden   (raiz primero): ");
        arbol.preOrden();

        System.out.print("PostOrden  (raiz al final): ");
        arbol.postOrden();

        System.out.print("Por niveles (BFS):         ");
        arbol.recorridoPorNiveles();

        System.out.println("\n--- Busquedas ---");
        System.out.println("Contiene 40? " + arbol.contiene(40));
        System.out.println("Contiene 99? " + arbol.contiene(99));

        System.out.println("\n--- Problema 4: Ancestro comun mas bajo (LCA) ---");
        System.out.println("LCA de 10 y 40: " + arbol.ancestroComunMasBajo(10, 40));
        System.out.println("LCA de 10 y 80: " + arbol.ancestroComunMasBajo(10, 80));
        System.out.println("LCA de 60 y 80: " + arbol.ancestroComunMasBajo(60, 80));
        try {
            System.out.println("LCA de 10 y 99: " + arbol.ancestroComunMasBajo(10, 99));
        } catch (IllegalArgumentException e) {
            System.out.println("LCA de 10 y 99: " + e.getMessage());
        }

        System.out.println("\n--- Problema 2: Arbol desbalanceado ---");
        ArbolBinarioBusqueda desbalanceado = new ArbolBinarioBusqueda();
        for (int i = 1; i <= 5; i++) {
            desbalanceado.insertar(i);
        }
        System.out.print("InOrden desbalanceado: ");
        desbalanceado.inOrden();
        System.out.println("Altura desbalanceado: " + desbalanceado.altura());
        System.out.println("Esta balanceado? " + desbalanceado.esBalanceado());

        System.out.println("\n--- Problema 3: Validacion de BST roto ---");
        ArbolBinarioBusqueda arbolRoto = new ArbolBinarioBusqueda();
        arbolRoto.insertar(50);
        arbolRoto.insertar(30);
        arbolRoto.insertar(70);
        arbolRoto.getRaiz().izquierdo.dato = 90;
        System.out.print("InOrden arbol roto: ");
        arbolRoto.inOrden();
        System.out.println("Es BST valido? " + arbolRoto.esBSTValido());

        System.out.println("\n--- Eliminacion ---");
        System.out.println("Contar nodos antes de eliminar: " + arbol.contarNodos()
                + " (tamanio: " + arbol.tamanio() + ")");
        System.out.println("Eliminando 20 (nodo con 1 hijo)...");
        arbol.eliminar(20);
        System.out.print("InOrden tras eliminar 20: ");
        arbol.inOrden();
        System.out.println("Contar nodos tras eliminar 20: " + arbol.contarNodos()
                + " (tamanio: " + arbol.tamanio() + ")");

        System.out.println("Eliminando 30 (nodo con 2 hijos)...");
        arbol.eliminar(30);
        System.out.print("InOrden tras eliminar 30: ");
        arbol.inOrden();
        System.out.println("Contar nodos tras eliminar 30: " + arbol.contarNodos()
                + " (tamanio: " + arbol.tamanio() + ")");

        System.out.println("Eliminando 50 (raiz)...");
        arbol.eliminar(50);
        System.out.print("InOrden tras eliminar la raiz: ");
        arbol.inOrden();
        System.out.println("Contar nodos tras eliminar la raiz: " + arbol.contarNodos()
                + " (tamanio: " + arbol.tamanio() + ")");

        System.out.println("\n--- Estado final ---");
        arbol.imprimirArbol();
        System.out.println("Tamanio final: " + arbol.tamanio());
        System.out.println("Altura final:  " + arbol.altura());

        System.out.println("\n--- Problema 5: Invertir arbol (espejo) ---");
        ArbolBinarioBusqueda espejo = new ArbolBinarioBusqueda();
        for (int v : valores) {
            espejo.insertar(v);
        }
        System.out.println("Antes de invertir:");
        espejo.imprimirArbol();
        System.out.print("InOrden antes: ");
        espejo.inOrden();
        espejo.invertir();
        System.out.println("Despues de invertir:");
        espejo.imprimirArbol();
        System.out.print("InOrden despues: ");
        espejo.inOrden();
    }
}
