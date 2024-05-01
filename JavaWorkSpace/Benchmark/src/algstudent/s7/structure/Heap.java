package algstudent.s7.structure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap {

	private ArrayList<Node> heap = new ArrayList<Node>();

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
		Node root = heap.get(0);

		Collections.swap(heap, 0, heap.size() - 1);
		heap.remove(heap.size() - 1);
		filterDown(0);
		return root;
	}
	private void filterDown(int index) {

		if (isLeaf(index)) {
			return;
		}
		int smalest = smalest(index);
		if (heap.get(index).getHeuristicValue() > (heap.get(smalest).getHeuristicValue())) {
			Collections.swap(heap, index, smalest);
			filterDown(smalest);
		} else {
			return;
		}
	}
	
	private int smalest(int index) {

		int left = index * 2 + 1;
		int right = index * 2 + 2;

		if (right >= heap.size()) {
			return left;
		}

		if (heap.get(left).getHeuristicValue() < (heap.get(right).getHeuristicValue()) ) {
			return left;
		} else {
			return right;
		}
	}
	
	private boolean isLeaf(int index) {
		int left = index * 2 + 1;
		return left >= heap.size();
	}

	public int estimateBest() {
		return heap.get(0).getHeuristicValue();
	}

}
