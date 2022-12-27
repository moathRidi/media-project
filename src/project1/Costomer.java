package project1;

import java.util.ArrayList;
import java.util.Comparator;

public class Costomer implements Comparator<Costomer> {
	private String cosName;
	private String cosAdress;
	private String plan;
	private int limitNumMedia ;
	private String id;
	private String mobileNumber;
	private ArrayList<String> list1 = new ArrayList<>();
	private ArrayList<String> list2 = new ArrayList<>();
	

	public Costomer() {

	}

	public Costomer(String id,String cosName, String cosAdress,String mobileNumber, String plan ) {
		
		this.cosName = cosName;
		this.cosAdress = cosAdress;
		this.plan = plan;
        this.id=id;
        this.mobileNumber=mobileNumber;
      
 	}
public Costomer(String id,String cosName, String cosAdress,String mobileNumber, String plan,int numlim ) {
		
		this.cosName = cosName;
		this.cosAdress = cosAdress;
		this.plan = plan;
        this.id=id;
        this.mobileNumber=mobileNumber;
        this.limitNumMedia=limitNumMedia;
 	}


	public String getCosName() {
		return cosName;
	}

	public void setCosName(String cosName) {
		this.cosName = cosName;
	}

	public String getCosAdress() {
		return cosAdress;
	}

	public void setCosAdress(String cosAdress) {
		this.cosAdress = cosAdress;
	}

	

	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getPlan() {
		return plan;
	}

	public int getLimitNumMedia() {
		return limitNumMedia;
	}

	public void setLimitNumMedia(int limitNumMedia) {
		this.limitNumMedia = limitNumMedia;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public ArrayList<String> getList1() {
		return list1;
	}

	public void setList1(ArrayList<String> list1) {
		this.list1 = list1;
	}

	public ArrayList<String> getList2() {
		return list2;
	}

	public void setList2(ArrayList<String> list2) {
		this.list2 = list2; 
	}

	@Override
	public String toString() {
		if(plan.equalsIgnoreCase("limited")) {

			return " Customer ID=" + id +", CustomerName= "+cosName+", CustomerAdress = "+cosAdress
						+", mobile number= "+mobileNumber+", Customer plan= "  +plan+" ,limSize="+limitNumMedia;
			
		}
		
		else {
		
		return " Customer ID=" + id +", CustomerName= "+cosName+", CustomerAdress = "+cosAdress
					+", mobile number= "+mobileNumber+", Customer plan= "  +plan;
		}
	}
		
	@Override
	public int compare(Costomer o1, Costomer o2) {
		return o1.getId().compareTo(o2.getId());
	}

	public boolean equals(Object o) {
		if (o instanceof Costomer) {
			return ((Costomer) o).getId().equalsIgnoreCase(this.id);
		}
		return false;
	}

}
