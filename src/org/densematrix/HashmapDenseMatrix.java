package org.densematrix;

import java.util.HashMap;
import java.util.Set;
public class HashmapDenseMatrix {

	HashMap <Pair,Long> hashmapmatrix= new HashMap<Pair,Long>();
	public HashmapDenseMatrix(){
		
	}
	
	public HashmapDenseMatrix(long matrix[][]){
		
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				hashmapmatrix.put(new Pair(i,j), matrix[i][j]);
			}
		}
		
	}
	

	
	
	public long getValueatXY(int i, int j){
		return this.hashmapmatrix.get(new Pair(i,j));
	}
	
	public void setValueatXY(int x, int y, long value){
		Pair temp=new Pair(x,y);
		this.hashmapmatrix.put(temp, value);
	}
	
	public int[][] getXYValues(){
		Set<Pair> all_values=this.hashmapmatrix.keySet();
		System.out.println("all_value_size="+all_values.size());
		int temp_values[][]=new int[all_values.size()][2];
		int i=0;
		for(Pair cell_value:all_values){
			temp_values[i][0]=cell_value.getX();
			temp_values[i][1]=cell_value.getY();
			i++;
		}
		return temp_values;
	}
	
	public HashmapDenseMatrix subtractMatrix(HashmapDenseMatrix matrix_to_subtract){
		int subtract_matrix_coordinates[][]=matrix_to_subtract.getXYValues();
		int subtract_from_matrix_coordinates[][]=this.getXYValues();
		HashmapDenseMatrix matrix_to_return=new HashmapDenseMatrix();
	    for(int i=0;i<subtract_matrix_coordinates.length;i++){
	    		Pair temp_pair=new Pair(subtract_matrix_coordinates[i][0],subtract_matrix_coordinates[i][1]);
	    		if(this.hashmapmatrix.containsKey(temp_pair)){
	    			long diff=this.hashmapmatrix.get(temp_pair)-matrix_to_subtract.hashmapmatrix.get(temp_pair);
	    			matrix_to_return.hashmapmatrix.put(temp_pair,diff);
	    		}else{
	    			matrix_to_return.hashmapmatrix.put(temp_pair,-1*matrix_to_subtract.hashmapmatrix.get(temp_pair));
	    		}
	    }
		
	    
	    for(int i=0;i<subtract_from_matrix_coordinates.length;i++){
	    		Pair temp_pair=new Pair(subtract_from_matrix_coordinates[i][0],subtract_from_matrix_coordinates[i][1]);
	    		if(matrix_to_subtract.hashmapmatrix.containsKey(temp_pair)){
	    			long diff=this.hashmapmatrix.get(temp_pair)-matrix_to_subtract.hashmapmatrix.get(temp_pair);
	    			matrix_to_return.hashmapmatrix.put(temp_pair,diff);
	    		}else{
	    			matrix_to_return.hashmapmatrix.put(temp_pair,this.hashmapmatrix.get(temp_pair));
	    		}
	    }
	    return matrix_to_return;
	    
	}
	
	public HashmapDenseMatrix addMatrix(HashmapDenseMatrix matrix_to_add){
	
		int add_matrix_coordinates[][]=matrix_to_add.getXYValues();
		int add_to_matrix_coordinates[][]=this.getXYValues();
		HashmapDenseMatrix matrix_to_return=new HashmapDenseMatrix();
	    for(int i=0;i<add_matrix_coordinates.length;i++){
	    		Pair temp_pair=new Pair(add_matrix_coordinates[i][0],add_matrix_coordinates[i][1]);
	    		if(this.hashmapmatrix.containsKey(temp_pair)){
	    			long sum=this.hashmapmatrix.get(temp_pair)+matrix_to_add.hashmapmatrix.get(temp_pair);
	    			matrix_to_return.hashmapmatrix.put(temp_pair,sum);
	    		}else{
	    			matrix_to_return.hashmapmatrix.put(temp_pair,matrix_to_add.hashmapmatrix.get(temp_pair));
	    		}
	    }
		
	    
	    for(int i=0;i<add_to_matrix_coordinates.length;i++){
	    		Pair temp_pair=new Pair(add_to_matrix_coordinates[i][0],add_to_matrix_coordinates[i][1]);
	    		
	    		if(matrix_to_add.hashmapmatrix.containsKey(temp_pair)){
	    			long sum=this.hashmapmatrix.get(temp_pair)+matrix_to_add.hashmapmatrix.get(temp_pair);
	    			matrix_to_return.hashmapmatrix.put(temp_pair,sum);
	    		}else{
	    			matrix_to_return.hashmapmatrix.put(temp_pair,this.hashmapmatrix.get(temp_pair));
	    		}
	    		
	    }
	    System.out.println("size of matrix="+matrix_to_return.hashmapmatrix.keySet().size());
	    return matrix_to_return;
	   
		
	}

public HashmapDenseMatrix  getAverageofMatrix(HashmapDenseMatrix matrix_to_add){
	HashmapDenseMatrix sum_matrix=this.addMatrix(matrix_to_add);
	int add_matrix_coordinates[][]=sum_matrix.getXYValues();
	for(int i=0;i<add_matrix_coordinates.length;i++){
		
		long curr_val=sum_matrix.hashmapmatrix.get(new Pair(add_matrix_coordinates[i][0],add_matrix_coordinates[i][1]));
	    sum_matrix.hashmapmatrix.put(new Pair(add_matrix_coordinates[i][0],add_matrix_coordinates[i][1]), curr_val/2);    	
	}
	
	return sum_matrix;	
	
	
}	
	
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
	
}
