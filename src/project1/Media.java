package project1;

import java.util.ArrayList;

public abstract class Media  {
	protected String titel;
	protected int numOfCoppys;
	protected String code;

	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public int getNumOfCoppys() {
		
		return numOfCoppys;
	}
	public void setNumOfCoppys(int numOfCoppys) {
		this.numOfCoppys = numOfCoppys;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
}