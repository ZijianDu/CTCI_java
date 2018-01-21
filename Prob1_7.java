import java.util.Arrays;

public class Prob1_7 {

	// O(n2) is the lower bound as each element in the matrix needs to be processed
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// define multidimensional array like this
		int[][] matrix = {{1,2,3},{3,4,5},{5,6,7}};
		Prob1_7 test = new Prob1_7();
		// arrays.deeptostring converts multidimensional array to string
		System.out.println(Arrays.deepToString(test.rotatematrix(matrix)));
		
	}
	int[][] rotatematrix(int[][] matrix)
	{
		int i = 0;
		int j = 0;
		int temp;
		for (i=0; i<matrix[0].length; i++)
		{
			for (j=0;j<matrix[0].length; j++)
			{
				temp = matrix[i][j];
				matrix[i][j] = matrix[j][matrix[0].length-i-1];
				matrix[j][matrix[0].length-i-1] = temp;
			}
		}
		return matrix;
	}
}
