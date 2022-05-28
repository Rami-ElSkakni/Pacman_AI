import java.util.ArrayList;

public class SearchingTechniques {
	MultiTree<table> tree = new MultiTree<table>();
	static int depth = 0;

	public table apply (char op, table goal) {
		table after = new table(goal.a);
		
		after.findEntry(2);
		
		int i = after.i;
		int j = after.j;
		
		if (op == 'L' ) {
			if (j > 0) {
				
					if (after.a[i][j-1] == 1) {
						after.a[i][j-1] = 2;
						after.a[i][j] = 0;	
					}
					
					else if (after.a[i][j-1] == 0) {
						after.a[i][j-1] = 2;
						after.a[i][j] = 0;
					}
					else {
						return null;
					}
	
			}
			
			else {
				return null;
			}
		
		}
		
		else if (op == 'R' ) {
			if (j < 8) {
					if (after.a[i][j+1] == 1) {
						after.a[i][j+1] = 2;
						after.a[i][j] = 0;
						
					}
					
					else if (after.a[i][j+1] == 0) {
						after.a[i][j+1] = 2;
						after.a[i][j] = 0;
						
				}
				
				else {
					return null;
				}
				
			}
			
			else {
				return null;
			}
		
		}
		
		else if (op == 'U' ) {
			if (i > 0) {
				
					if (after.a[i - 1][j] == 1) {
						after.a[i - 1][j] = 2;
						after.a[i][j] = 0;
						
					}
					
					else if (after.a[i - 1][j] == 0) {
						after.a[i - 1][j] = 2;
						after.a[i][j] = 0;
						
					}
				
				else {
					return null;
				}
			}
			
			else {
				return null;
			}
		
		}
		
		else if (op == 'D' ) {
			if (i < 8) {

					if (after.a[i + 1][j] == 1) {
						after.a[i + 1][j] = 2;
						after.a[i][j] = 0;
					}
					else if (after.a[i + 1][j] == 1) {
						after.a[i + 1][j] = 2;
						after.a[i][j] = 0;
					}
				
					else {
					return null;
				}	
			}
			
			else {
				return null;
			}
		
		}

		else {
			return null;
		}
		
		return after;
	}

	public void depth(MultiTree tr) {
	tree = tr;
	depth(tree.root, 0);
}

	boolean flag = false;
public void depth(multinode node, int c) {
	c++;
	
	ArrayList<table> visited = new ArrayList<table>();
	table t = (table) node.data;
	visited.add(t);
	if (c > 15 || flag) {
		return;
	}
	
	if (goal(t)) {
		tree.display_solution(node);
		System.out.println("It found it at " + c);
		flag = true;
		return;
	}
	
	else {
		table t1 = apply('L', t);
		table t2 = apply('R', t);
		table t3 = apply('U', t);
		table t4 = apply('D', t);
		
			
		if (t1 != null && checkChild(visited, t1) == false) {
			tree.insertnode(t1, c);
			depth(tree.search_data(t1), c);
		}
		
		if (t2 != null && checkChild(visited, t2) == false) {
			tree.insertnode(t2, c);
			depth(tree.search_data(t2), c);
		}
		
		if (t3 != null && checkChild(visited, t3) == false) {
			tree.insertnode(t3, c);
			depth(tree.search_data(t3), c);
		}
		
		if (t4 != null && checkChild(visited, t4) == false) {
			tree.insertnode(t4, c);
			depth(tree.search_data(t4), c);
		}
	}
	
}



public void Iterativedepth(MultiTree m) {
	tree = m;
	multinode root = tree.root;
	for (depth = 1; depth < 50; depth++) {
		Iterativedepth(root, 0);
	}
	
}

boolean flagI = false;

private void Iterativedepth(multinode node, int c) {
	c++;

	table t = (table) node.data;

	if (c > depth || flagI) {
		
		return;
	}

	if (goal(t)) {
		tree.display_solution(node);
		System.out.println("C is " + (c));
		flagI = true;
		return;
		
	} else {

		table t1 = apply('L', t);
		table t2 = apply('R', t);
		table t3 = apply('U', t);
		table t4 = apply('D', t);

		if (t1 != null) {
			tree.insertnode(t1, c);
			Iterativedepth(tree.search_data(t1), c);
		}

		if (t2 != null) {
			tree.insertnode(t2, c);
			Iterativedepth(tree.search_data(t2), c);
		}

		if (t3 != null) {
			tree.insertnode(t3, c);
			Iterativedepth(tree.search_data(t3), c);
		}

		if (t4 != null) {
			tree.insertnode(t4, c);
			Iterativedepth(tree.search_data(t4), c);
		}
	}

}

public boolean goal(table t){
	boolean ans = true ;
	for(int i=0;i<9;i++){
		for(int j=0;j<9;j++){
			if(t.a[i][j]==1){
			ans = false;
			break;
			}
		}
		}
	return ans;
}

public boolean checkChild(ArrayList<table> arr, table t) {
	
	for (int i = 0; i < arr.size(); i++) {
		if (arr.get(i) == t) {
			return true;
		}
	}
	
	return false;
}

public void Breadth (MultiTree tr) {
	Queue<multinode<table>> q = new Queue<multinode<table>>();
	ArrayList<table> visited = new ArrayList<table>();
	tree = tr;
	q.enqueue(tree.root);
	
	while (!q.isEmpty()) {
		multinode del = q.dequeue();
		table dell = (table) del.data;
		visited.add(dell);
		if (goal(dell)) {
			tree.display_solution(del);
			return;
		}
		
		else {
			table t1 = apply('L', dell);
			table t2 = apply('R', dell);
			table t3 = apply('U', dell);
			table t4 = apply('D', dell);
			

			if (t1 != null && checkChild(visited, t1) == false) {
				tree.insertnode(t1, del.id);
				q.enqueue(tree.search_data(t1));
			}
			
			if (t2 != null && checkChild(visited, t2) == false ) {
				tree.insertnode(t2, del.id);
				q.enqueue(tree.search_data(t2));
			}
			
			if (t3 != null && checkChild(visited, t3) == false) {
				tree.insertnode(t3, del.id);
				q.enqueue(tree.search_data(t3));
			}
			
			if (t4 != null && checkChild(visited, t4) == false) {
				tree.insertnode(t4, del.id);
				q.enqueue(tree.search_data(t4));
			}
			
		}
	}
}


public int gofN (table t) {
int h = 0;
for (int i = 0; i < 9; i ++) {
	for (int j = 0; j < 9; j++) {
		if (t.a[i][j] == 1) {
			h++;
		}
	}
}

return h;
}


public int hOfN(table t, table goal) {
	int h = 0;
	
	int gi;
	int gj;
	
	for (int i = 0; i < 9; i++) {
		for (int j = 0; j < 9; j++) {
			t.findEntry(goal.a[i][j]);
			gi = goal.i;
			gj = goal.j;
			
			h = h + Math.abs(gi - i) + Math.abs(gj - j);
		}
	}
	
	return h;
}

public <T> void Astar (MultiTree m, table goal) {
	int c = 0;
	PriorityQueue<multinode<table>> q = new PriorityQueue<multinode<table>>();
	tree = m;
	multinode root = tree.root;
	q.enqueue(root, gofN((table)tree.root.data) + hOfN((table)tree.root.data, goal));
	
	while (!q.isEmpty()) {
		c++;
		multinode del = q.dequeue();
		table t = (table) del.data;
		if (t.isEqual(goal)) {
		tree.display_solution(del);
		return;
		}
		else{
			table t1 = apply('L', t);
			table t2 = apply('R', t);
			table t3 = apply('U', t);
			table t4 = apply('D', t);

			if (t1 != null) {
				tree.insertnode(t1, del.id);
				q.enqueue(tree.search_data(t1), gofN(t1) + hOfN(t1, goal));

			}

			if (t2 != null) {
				tree.insertnode(t2, del.id);
				q.enqueue(tree.search_data(t2), gofN(t2) + hOfN(t2, goal));
			}

			if (t3 != null) {
				tree.insertnode(t3, del.id);
				q.enqueue(tree.search_data(t3), gofN(t3) + hOfN(t3, goal));
			}

			if (t4 != null) {
				tree.insertnode(t4, del.id);
				q.enqueue(tree.search_data(t4), gofN(t4) + hOfN(t4, goal));
			}
		}

		}
		
		
	}
}
