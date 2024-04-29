package algstudent.s6.structure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap{

	private ArrayList<Node> heap = new ArrayList<Node>();
	
	
	public void insert(Node rootNode) {
		// TODO Auto-generated method stub
		
	}

	public boolean empty() {
		return heap.isEmpty();
	}
	
	
	public void add(Node node) {
		if (node == null) {
			throw new NullPointerException("null element");
		}

		heap.add(node);
		filterUp(heap.size() - 1);
	}
	
	public void filterUp(int index) {
		if (index == 0) {
			return;
		}
		
		int parent = (index - 1) / 2;
		Node currentNode = heap.get(index);
		Node parentNode  = heap.get(parent);
		
		if (currentNode.getHeuristicValue() >= parentNode.getHeuristicValue()) {
			return;
		} else {
			Collections.swap(heap, index, index - 1);
			filterUp(parent);
		}

	}

	public Node extractBestNode() {
		if (heap.isEmpty()) {
			throw new IllegalStateException();
		}
		return heap.get(0);
	}

	public int estimateBest() {
		return extractBestNode().getHeuristicValue();
	}

}
