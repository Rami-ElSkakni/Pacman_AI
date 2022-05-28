
public class table {
	int a[][] = new int [9][9];
	int i = 0;
	int j = 0;
	
	public table (int [][]b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	
	public void insertMatrix (int [][] b) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = b[i][j];
			}
		}
	}
	
	public void insertTable (table t) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				a[i][j] = t.a[i][j];
			}
		}
	}
	
	public String toString() {
		String s = "";
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j <a.length; j++) {
				 s+= a[i][j] + " ";
			}
			s+= "\n";
		}
		
		return s;
	}
	
	public void findEntry(int x) {
		for (int l = 0; l < a.length; l++) {
			for (int m = 0; m < a.length; m++) {
				if (x == a[l][m]) {
					i = l;
					j = m;
				}
			}
		}
	}
	
	public boolean isEqual(table t) {
		boolean flag = true;
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (t.a[i][j] != a[i][j]) {
					flag = false;
				}
			}
		}
		
		return flag;
	}
}
