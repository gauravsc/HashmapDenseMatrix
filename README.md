HashmapDenseMatrix
==================

A lightweight library for dense matrix manipulation, dense matrix is implemented based on java hashmaps. It provides some basic operations like addition, subtraction and average calculation.


An Example Code:
================


public static void main( String args[]){
	
	long abc[][]={{1,2,3},{2,3,4}};
	long def[][]={{1,2,3},{2,3}};
	HashmapDenseMatrix matrix=new HashmapDenseMatrix(abc);
	
	HashmapDenseMatrix matrix_temp=new HashmapDenseMatrix(def);
	
	
	matrix=matrix_temp.subtractMatrix(matrix);
	int coordinates[][]=matrix.getXYValues();

	for(int i=0;i<coordinates.length;i++){
		System.out.println("i="+coordinates[i][0]+"\n"+"j="+coordinates[i][1]+"value="+matrix.getValueatXY(coordinates[i][0], coordinates[i][1]));
	}
	
}

Available functions:
====================

public HashmapDenseMatrix  getAverageofMatrix(HashmapDenseMatrix matrix_to_add)

public HashmapDenseMatrix addMatrix(HashmapDenseMatrix matrix_to_add)

public HashmapDenseMatrix subtractMatrix(HashmapDenseMatrix matrix_to_subtract)

public int[][] getXYValues()
