
public class Main {

	public static void main(String[] args) {
	
		int [][] initial={
				{0,0,0,0,0,3,0,1,1},
				{3,3,0,3,3,3,0,3,3},
				{0,3,0,0,0,0,0,0,0},
				{0,3,0,3,3,3,3,3,0},
				{0,3,0,3,0,0,0,3,0},
				{0,3,0,3,0,0,0,3,3},
				{2,1,1,0,0,3,0,3,0},
				{0,3,3,3,0,3,0,3,0},
				{0,0,0,3,0,3,0,0,0},
				};
		
		int [][] goal1={
				{0,0,0,0,0,3,0,0,2},
				{3,3,0,3,3,3,0,3,3},
				{0,3,0,0,0,0,0,0,0},
				{0,3,0,3,3,3,3,3,0},
				{0,3,0,3,0,0,0,3,0},
				{0,3,0,3,0,0,0,3,3},
				{0,0,0,0,0,3,0,3,0},
				{0,3,3,3,0,3,0,3,0},
				{0,0,0,3,0,3,0,0,0},
				};

		table initial1 = new table (initial);
		table goal = new table (goal1);
		
		SearchingTechniques s = new SearchingTechniques();
		
		MultiTree<table> t = new MultiTree<table>(initial1);
		
		//s.depth(t);
		//s.Breadth(t);
		//s.Iterativedepth(t);
		s.Astar(t, goal);
		
	}

}
