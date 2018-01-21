import java.util.Arrays;

public class Prob1_8 {

	public static void main(String[] args) {
		Prob1_8 test = new Prob1_8();
		int[][] matrix1 = {{1,2,3,0},{0,3,1,2},{1,4,5,2}};
		int[][] matrix2 = {{1,2,3,0},{0,3,1,2},{1,4,5,2}};
		System.out.println(Arrays.deepToString(test.setzero_1(matrix1)));
		System.out.println(Arrays.deepToString(test.setzero_2(matrix2)));

	}
	// if there is zero, set the whole row and column to zero
	// use two int arrays to record if there is zero in that particular row/column.
	int[][] setzero_1(int[][] matrix)
	{
		boolean[] rowcount = new boolean[matrix.length];
		boolean[] columncount = new boolean[matrix[0].length];
		for (int i=0; i<matrix.length; i++)
		{
			for (int j=0; j<matrix[0].length; j++)
			{
				if(matrix[i][j]==0)
				{
					rowcount[i]=true;
					columncount[j]=true;
				}
			}
		}
		for (int i=0;i<rowcount.length;i++)
		{
			if (rowcount[i])
				nullifyrow(matrix, i);
		}
		for (int j=0; j<columncount.length;j++)
		{
			if (columncount[j])
				nullifycolumn(matrix, j);
		}

		return matrix;
		
	}
	void nullifyrow(int[][] matrix, int row)
	{	
		for (int j=0; j<matrix[0].length;j++)
				matrix[row][j]=0;
	}
	void nullifycolumn(int[][] matrix, int column)
	{
		for (int j=0;j<matrix.length;j++)
					matrix[j][column]=0;
	}
	// a slightly better way is to use the first row and column as the recording array
	int[][] setzero_2(int[][] matrix)
	{
		boolean rowzero=false;
		boolean columnzero=false;
		for (int j=0;j<matrix[0].length; j++)
		{
			if (matrix[0][j]==0) 
			{
				rowzero=true;
				break;
			}
		}
		for (int i=0; i<matrix.length; i++)
		{
			if (matrix[i][0]==0)
			{
				columnzero=true;
				break;
			}
		}
		for (int i=1;i<matrix.length; i++)
		{
			for (int j=1; j<matrix[0].length;j++)
			{
				if (matrix[i][j]==0)
				{
					matrix[0][j]=0;
					matrix[i][0]=0;
				}
			}
		}
		for (int i=1; i<matrix[0].length; i++)
		{
			if (matrix[0][i]==0)
				nullifycolumn(matrix, i);
				
		}
		for (int j=0; j<matrix.length; j++)
		{
			if (matrix[j][0]==0)
				nullifyrow(matrix, j);
		}
		if (rowzero==true)
		{
		nullifyrow(matrix,0);
		}
		if (columnzero==true)
		{
			nullifycolumn(matrix,0);
		}
		return matrix;
	}
}
