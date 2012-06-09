package org.densematrix;

public class Pair {
	
	private int[] dimensions;
	private int number_of_dimensions;
	private Integer x,y;
	public Pair(int number_of_dimensions){
		
		this.number_of_dimensions=number_of_dimensions;
		this.dimensions=new int[number_of_dimensions];		
	}
	
	public Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public int hashCode(){
		return this.x.hashCode()+31*this.y.hashCode();
	}
	@Override
	public boolean equals(Object o){
		Pair test=(Pair)o;
		if(test.x==this.x && test.y==this.y){
			return true;
		}else return false;
	}
	
	public int getDimensionvalue(int dimension){
		return this.dimensions[dimension];
		
	}
	public int [] getAllDimensionValues(){
		return this.dimensions;
	}
	
	public int getNumberOdDimensions(){
		return this.number_of_dimensions;
	}
	
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	
	
	

}
