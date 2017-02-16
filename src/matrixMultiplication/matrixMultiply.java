package matrixMultiplication;

public class matrixMultiply {
	public static int[][] matrixMultiplyN3(int[][] a, int[][] b){
		int[][] c = new int[a.length][a.length];
		for(int i = 0; i < c.length; i++){
			for(int j = 0; j < c[i].length; j++){
				for(int k = 0; k < c.length; k++){
					c[i][j] += a[i][k]*b[k][j];
				}
			}
		}
		
		return c;
	}
	public static void main(String[] args) {
		int[][] matrix_a = {{2,3},{9,4}};
		int[][] matrix_b = {{5,4},{3,9}};
		
		int[][] result = matrixMultiplyN3(matrix_a, matrix_b);
		
		for(int i = 0; i < result.length; i++){
			for(int j = 0; j < result[i].length; j++){
				System.out.print(result[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
}
