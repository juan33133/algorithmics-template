package algstudent.s7.numericalSquare;

import java.util.ArrayList;

import algstudent.s7.structure.Board;
import algstudent.s7.structure.Heap;
import algstudent.s7.structure.Node;

public class NumericalSquare {

	private Board board ; 
	protected Heap ds; //nodes to be explored (not used nodes)
	protected Node bestNode; //to save the final node of the best solution
	protected Node rootNode; //initial node

	public void numericalSquareBranchAndBound() {
		board = new Board();
	}

	public void branchAndBound() {
		branchAndBound(new Node(board));
	}

	private void branchAndBound(Node rootNode) {
		ds.add(rootNode); // first node to be explored DONE
		int pruneLimit = rootNode.initialValuePruneLimit();//NOT DONE
		while (!ds.empty() && ds.estimateBest() < pruneLimit) {//
			Node node = ds.extractBestNode();
			ArrayList<Node> children = node.expand();
			for (Node child : children)
				if (child.isSolution()) {
					int cost = child.getHeuristicValue();
					if (cost < pruneLimit) {
						pruneLimit = cost;
						bestNode = child;
					}
				} else if (child.getHeuristicValue() < pruneLimit) {
					ds.add(child);
				}
		} // while
	}

}