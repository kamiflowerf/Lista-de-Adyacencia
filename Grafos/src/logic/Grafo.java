package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Grafo {
	
	private HashMap<String, List<String>> listAdy;
	
	public Grafo(int numVert) {
		listAdy = new HashMap<>(numVert);
	}
	
	public void addEdge(String origin, String dest) {
		
		//crea los nodos en caso de que no existan
		listAdy.putIfAbsent(origin, new ArrayList<>());
		listAdy.putIfAbsent(dest, new ArrayList<>());
		
		//agregar el nodo destino a la lista de adyacencia del nodo origen
		listAdy.get(origin).add(dest);
		
		//como el grafo es no dirigido, agregar la arista inversa
		listAdy.get(dest).add(origin);
	}
	
	public void printList() {
		System.out.println("Lista de Adyacencia: ");
		for (String node : listAdy.keySet()) {
			System.out.print(node + " -> ");
			System.out.println(listAdy.get(node));
		}
	}
	
	public void getDegreeSequence(int numNodes) {
		ArrayList<Integer> sequence = new ArrayList<>(numNodes);
		
		//Itera sobre la lista de adyacencia para contar el número de vecinos
		for (String node : listAdy.keySet()) {
			int degree = listAdy.get(node).size(); //el tamaño de la lista de ady es el grado del nodo
			sequence.add(degree);
		}
		
		System.out.println("Secuencia de grados: " + sequence);
	}
	
	public static void main(String[] args) {
		Grafo graph = new Grafo(10);
		
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("B", "D");
		graph.addEdge("B", "E");
		graph.addEdge("C", "F");
		graph.addEdge("C", "G");
		graph.addEdge("D", "E");
		graph.addEdge("D", "H");
		graph.addEdge("E", "I");
		graph.addEdge("F", "G");
		graph.addEdge("G", "H");
		graph.addEdge("H", "I");
		graph.addEdge("I", "F");
		
		graph.getDegreeSequence(10);
		graph.printList();
	}
}
