package project1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface  MediaRentalInt {
	
	 boolean addCustomerlim(String id, String cosName, String cosAdress, String mobileNumber, String plan,int limnum);
	boolean addCustomerunlim(String id,String cosName, String cosAdress,String mobileNumber ,String plan);
	void addMovie(String title, int copiesAvailable,String rati,String code);
	void addGame(String title, int copiesAvailable,double weigh,String code);
	void addAlbum(String title,int copiesAvailable,String artist,String songs,String code);
	
	String getAllCustomersInfo() throws IOException;
	String getAllMediaInfo() throws IOException;
	String addToCart(String customerName,String mediaTitle) throws  Exception;
	boolean removeFromCart(String customerName, String mediaTitle);
	String processRequests() throws IOException ;
	boolean returnMedia(String customerName,String mediaTitl);
	ArrayList<String> searchMedia(String code);
	 boolean removeCustomer(String id) ;
	void setLimitedPlanLimit(int value, String id) throws IOException;
    void updateInfo(String id, String name, String addres, String mobile, String plan);
     void updateMovie(String title, int numcop, String rate, String code);
    void updateGame(String title, int numcop, Double whight, String code);
     void updateAlbum(String titel, int numOfCoppys, String artist, String songs, String code);
    
    
    
}
