package project1;

public class Game extends Media implements Comparable {
 private double whight;
 
 
	public Game(String titel, int numOfCoppys,double whight,String code) {
	this.setTitel(titel);
	this.setNumOfCoppys(numOfCoppys);
	this.whight = whight;
	this.code= code;
}
	


	

	
public double getWhight() {
		return whight;
	}



	public void setWhight(double whight) {
		this.whight = whight;
	}






@Override
	public int compareTo(Object o) {
			return ((this.getTitel()).compareTo( ((Game)o).getTitel()));
		
	}



@Override
public String toString() {
	return "Game [Code= "+ code+", Titel=" + getTitel() + ", NumOfCoppys=" + getNumOfCoppys()+", whight=" + whight + "]\n";
}





}
