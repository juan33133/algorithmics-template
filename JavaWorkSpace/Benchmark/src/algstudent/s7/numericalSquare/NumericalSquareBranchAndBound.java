package algstudent.s7.numericalSquare;

import java.util.ArrayList;

import algstudent.s7.structure.Board;
import algstudent.s7.structure.Heap;
import algstudent.s7.structure.Node;

public class NumericalSquareBranchAndBound {

	protected Heap ds; // nodes to be explored (not used nodes)
	protected Node bestNode; // to save the final node of the best solution

	public void branchAndBound() {
		ds = new Heap();
		branchAndBound(new Node(new Board()));
	}

	private void branchAndBound(Node rootNode) {
		bestNode = rootNode;
		ds.add(rootNode); // first node to be explored
		int pruneLimit = rootNode.initialValuePruneLimit();// the number of solutions
		// estimate best -> heuristic of the best node
		while (!ds.empty() && ds.estimateBest() <= pruneLimit) {
			// returns and removes the best node from the heap
			Node node = ds.extractBestNode();
			// new 10 nodes at the following possition
			// if the next node is given -> only this node is added
			ArrayList<Node> children = node.expand();

			for (Node child : children) {
				
				int cost = child.getHeuristicValue();
				// (child.isSolution())
				if (child.isSolution()) {
					if (cost == 0) {
						bestNode = child;
						break; 
					}
					if (cost < pruneLimit) {
						pruneLimit = cost;
						bestNode = child;
						ds.add(child);
					}
				
				} else if (child.isValid() && cost < pruneLimit) {
					ds.add(child);
				}
			}
		} // while
		System.out.println(bestNode.toString());
		System.out.println(pruneLimit);
	}

}