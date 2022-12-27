package project1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalMannegar implements MediaRentalInt {

	ArrayList<Media> arrMedia = new ArrayList<>();
	ArrayList<Costomer> arrCostomer = new ArrayList<>();
	public static String costomInfo = "";

	@Override
	public boolean addCustomerlim(String id, String cosName, String cosAdress, String mobileNumber, String plan,
			int limnum) {
		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id))

				return false;
		}

		arrCostomer.add(new Costomer(id, cosName, cosAdress, mobileNumber, plan, limnum));
		try {
			setLimitedPlanLimit(limnum, id);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;

	}

	@Override
	public boolean addCustomerunlim(String id, String cosName, String cosAdress, String mobileNumber, String plan) {
		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id))
				return false;
		}

		arrCostomer.add(new Costomer(id, cosName, cosAdress, mobileNumber, plan));

		return true;

	}

	@Override
	public void addMovie(String title, int copiesAvailable, String rating, String code) {
		arrMedia.add(new Movie(title, copiesAvailable, rating, code));
		try {
			getAllMediaInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addGame(String title, int copiesAvailable, double weigh, String code) {
		arrMedia.add(new Game(title, copiesAvailable, weigh, code));
		try {
			getAllMediaInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addAlbum(String title, int copiesAvailable, String artist, String songs, String code) {
		arrMedia.add(new Album(title, copiesAvailable, artist, songs, code));
		try {
			getAllMediaInfo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setLimitedPlanLimit(int value, String id) throws IOException {

		int ind = findIndxCustomer(id);

		if (ind != -1) {

			arrCostomer.get(ind).setLimitNumMedia(value);

		}

	}

	@Override
	public String getAllCustomersInfo() throws IOException {
		File fcos = new File("costomer.txt");
		PrintWriter w = new PrintWriter(fcos);
		String kk = "";
		Collections.sort(arrCostomer, new Costomer());

		for (int i = 0; i < arrCostomer.size(); i++) {

			StringBuilder s2 = new StringBuilder(arrCostomer.get(i).toString());
			costomInfo += s2 + "\n";

		}
		kk = costomInfo;
		costomInfo = "";
		w.print(kk.toString());
		w.close();
		return kk.toString();
	}

	@Override
	public String getAllMediaInfo() throws IOException {

		File fmed = new File("media.txt");
		// FileWriter z = new FileWriter(fmed, true);
		PrintWriter w2 = new PrintWriter(fmed);

	/*	for (int k = 0; k < arrMedia.size(); k++) {

			for (int j = 0; j < arrMedia.size(); j++) {
				if (arrMedia.get(j).getCode().compareTo(arrMedia.get(k).getCode()) > 0)
					Collections.swap(arrMedia, k, j);

			}

		}*/
		w2.print(arrMedia.toString());
		w2.close();
		return arrMedia.toString();
	}

	@Override
	public String addToCart(String customerid, String mediaCode) throws FileNotFoundException {

		File fcart = new File("cart.txt");
		PrintWriter w3 = new PrintWriter(fcart);

		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(customerid)) {
				for (int j = 0; j < arrCostomer.get(i).getList1().size(); j++) {
					if (mediaCode.equalsIgnoreCase(arrCostomer.get(i).getList1().get(j))) {
						if (arrCostomer.get(i).getList1().get(j).equalsIgnoreCase(mediaCode)) {
							return (" item is  alredy exist please check for some thing else");

						}

					}

				}

				arrCostomer.get(i).getList1().add(mediaCode);

			}

		}
		for (int i = 0; i < arrCostomer.size(); i++) {

			for (int j = 0; j < arrCostomer.get(i).getList1().size(); j++) {
				w3.print(arrCostomer.get(i).getId() + "," + arrCostomer.get(i).getList1().get(j).toString() + "\n");
			}
		}
		w3.close();

		return ("added to cart");

	}

	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) {
		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getCosName().equalsIgnoreCase(customerName)) {
				for (int j = 0; j < arrCostomer.get(i).getList1().size(); j++) {
					if (arrCostomer.get(i).getList1().get(j).equalsIgnoreCase(mediaTitle)) {
						arrCostomer.get(i).getList1().remove(mediaTitle);
						return true;
					}
				}
			}
		}
		return false;

	}

	@Override
	public String processRequests() throws IOException {

		File frent = new File("rent.txt");
	
		PrintWriter w4 = new PrintWriter(frent);

		Collections.sort(arrCostomer, new Costomer());
		for (int i = 0; i < arrCostomer.size(); i++) {

			if (arrCostomer.get(i).getPlan().equalsIgnoreCase("UNLIMITED")) {

				for (int s = 0; s < arrMedia.size(); s++) {
					
			    	for (int j = 0; j < arrCostomer.get(i).getList1().size(); j++) {
					
			    		if (arrCostomer.get(i).getList1().get(j).equalsIgnoreCase(arrMedia.get(s).getCode())) {
					          if (arrMedia.get(s).getNumOfCoppys() > 0) {
					 
						      arrCostomer.get(i).getList2().add(arrCostomer.get(i).getList1().get(j));
								arrMedia.get(s).setNumOfCoppys((arrMedia.get(s).getNumOfCoppys() - 1));
								return ("Itames rented succesfuly");
					}
					          else
									return ("All Coppies Sold Out!!!");
						

					} 

				}
				//return ("Itames rented succesfuly");
			}}

			else if (arrCostomer.get(i).getPlan().toUpperCase().equalsIgnoreCase("LIMITED")) {
				for (int s = 0; s < arrMedia.size(); s++) {
			    	for (int j = 0; j < arrCostomer.get(i).getList1().size(); j++) {
			    		if (arrCostomer.get(i).getList1().get(j).equalsIgnoreCase(arrMedia.get(s).getCode())) {
					if ((arrMedia.get(s).getNumOfCoppys() > 0)
							&& (arrCostomer.get(i).getLimitNumMedia() >= arrCostomer.get(i).getList2().size())) {

						arrCostomer.get(i).getList2().add(arrCostomer.get(i).getList1().get(j));

						

							
								arrMedia.get(s).setNumOfCoppys((arrMedia.get(s).getNumOfCoppys() - 1));

							}
					else {
						return ("PROCESSED FAILD: YOUR PLAN IS FULL OR THIS MEDIA SOLD OUT !!");
						}
				
					}
					}
					

					
				
				}
			
				//return ("Itames rented succesfuly");
			}


			

		}
		
		for (int i = 0; i < arrCostomer.size(); i++) {
			for (int j = 0; j < arrCostomer.get(i).getList2().size(); j++) {
				w4.print(arrCostomer.get(i).getId() + "," + arrCostomer.get(i).getList2().get(j) + "\n");
			}
			
		}
		w4.close();
		

		return ("Itames rented succesfuly");
	}

	@Override
	public boolean returnMedia(String id, String code) {

		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id)) {
				
				
				for (int j = 0; j < arrCostomer.get(i).getList2().size(); j++) {
					if (arrCostomer.get(i).getList2().get(j).equalsIgnoreCase(code)) {
						for (int s = 0; s < arrMedia.size(); s++) {

							if (arrCostomer.get(i).getList1().get(j).equalsIgnoreCase(arrMedia.get(s).getCode())) {
								arrMedia.get(s).setNumOfCoppys((arrMedia.get(s).getNumOfCoppys() + 1));
							}
						}
						arrCostomer.get(i).getList2().remove(j);
						arrCostomer.get(i).getList1().remove(j);
						

						arrCostomer.get(i).setLimitNumMedia((arrCostomer.get(i).getLimitNumMedia() + 1));
						
						return true;
					}
				}
			}
		}

		return false;
	}

	@Override
	public ArrayList<String> searchMedia(String code) {
		ArrayList<String> ser = new ArrayList();

		for (int j = 0; j < arrMedia.size(); j++) {
			if (arrMedia.get(j).getCode().equalsIgnoreCase(code)) {
				ser.add(arrMedia.get(j).toString());
			}

		}

		Collections.sort(ser);

		return ser;
	}
	
	public ArrayList<String> searchMedia2(String title, String rating, String artist, String songs) {
		ArrayList<String> ser = new ArrayList();

		if ((title == null || title == "*") && (rating == null || rating == "*") && (artist == null || artist == "*")
				&& (songs == null || songs == "*")) {
			try {
				ser.add(this.getAllMediaInfo());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		for (int j = 0; j < arrMedia.size(); j++) {
			if (arrMedia.get(j).getTitel().equalsIgnoreCase(title)) {
				ser.add(arrMedia.get(j).toString());
			}

			if (arrMedia.get(j) instanceof Movie) {
				if (((Movie) arrMedia.get(j)).getRating().equalsIgnoreCase(rating)&& !((((Movie) arrMedia.get(j)).getTitel().equalsIgnoreCase(title)))) {
					ser.add(arrMedia.get(j).toString());
				}
			}
			if (arrMedia.get(j) instanceof Movie) {
				if ((((Movie) arrMedia.get(j)).getRating().equalsIgnoreCase(rating))&& (((Movie) arrMedia.get(j)).getTitel().equalsIgnoreCase(title))){
					ser.add(arrMedia.get(j).toString());
				}
			}
		/*	if (arrMedia.get(j) instanceof Album) { 
				String[] s = ((Album) arrMedia.get(j)).getSongs().split(",");
				for (int i = 0; i < s.length - 1; i++) {
					System.out.println(s);
					if (s[i].equalsIgnoreCase(songs))
						ser.add(arrMedia.get(j).toString());
				}
			}
*/
			if (arrMedia.get(j) instanceof Album) {
				if ((((Album) arrMedia.get(j)).getArtist().equalsIgnoreCase(artist))
						|| (((Album) arrMedia.get(j)).getSongs().equalsIgnoreCase(songs))) {
					ser.add(arrMedia.get(j).toString());

				}
			}

		}

		Collections.sort(ser);

		return ser;
	}

@Override
	public boolean removeCustomer(String id) {
		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id)) {
				arrCostomer.remove(i);
				return true;

			}
		}

		return false;

	}
@Override
	public void updateInfo(String id, String name, String addres, String mobile, String plan) {

		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id))
				arrCostomer.get(i).setCosName(name);
			arrCostomer.get(i).setCosAdress(addres);
			arrCostomer.get(i).setMobileNumber(mobile);
			arrCostomer.get(i).setPlan(plan);

		}
	}

	public boolean findCustomer(String id) {
		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id))
				return true;
		}
		return false;
	}

	public int findIndxCustomer(String id) {
		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id))
				return i;
		}
		return 0;
	}

	public String secCustomer(String id) {
		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id))
				return arrCostomer.get(i).toString() + "\n";
		}
		return "Customer not founded !".toString();
	}

	public String secMedia(String code) {
		for (int i = 0; i < arrMedia.size(); i++) {
			if (arrMedia.get(i).getCode().equalsIgnoreCase(code))
				return arrMedia.get(i).toString() + "\n";
		}
		return "Media not founded !".toString();
	}

	public boolean removemedia(String code) {
		for (int i = 0; i < arrMedia.size(); i++) {
			if (arrMedia.get(i).getCode().equalsIgnoreCase(code)) {
				arrMedia.remove(i);
				return true;

			}
		}

		return false;

	}
@Override
	public void updateMovie(String title, int numcop, String rate, String code) {

		for (int i = 0; i < arrMedia.size(); i++) {

			if (arrMedia.get(i) instanceof Movie)
				if (arrMedia.get(i).getCode().equalsIgnoreCase(code)) {
					arrMedia.get(i).setTitel(title);
					arrMedia.get(i).setNumOfCoppys(numcop);
					((Movie) arrMedia.get(i)).setRating(rate);

				}
		}
	}
@Override
	public void updateGame(String title, int numcop, Double whight, String code) {
		for (int i = 0; i < arrMedia.size(); i++) {
			if (arrMedia.get(i) instanceof Game)
				if (arrMedia.get(i).getCode().equalsIgnoreCase(code)) {
					arrMedia.get(i).setTitel(title);
					arrMedia.get(i).setNumOfCoppys(numcop);
					((Game) arrMedia.get(i)).setWhight(i);

				}

		}
	}

	public void updateAlbum(String titel, int numOfCoppys, String artist, String songs, String code) {
		for (int i = 0; i < arrMedia.size(); i++) {
			if (arrMedia.get(i) instanceof Album)
				if (arrMedia.get(i).getCode().equalsIgnoreCase(code)) {
					arrMedia.get(i).setTitel(titel);
					;
					arrMedia.get(i).setNumOfCoppys(numOfCoppys);
					((Album) arrMedia.get(i)).setArtist(artist);
					((Album) arrMedia.get(i)).setSongs(songs);

				}

		}
	}

	public String rented(String id) {
		ArrayList<String> ser = new ArrayList();

		for (int j = 0; j < arrMedia.size(); j++) {
			if (arrCostomer.get(j).getId().equalsIgnoreCase(id)) {
				for (int i = 0; i < arrCostomer.get(j).getList2().size(); i++) {
					ser.add(arrCostomer.get(j).getList2().get(i));

				}

			}

		}

		return ser.toString();
	}

	public String printCart(String id) {

		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id)) {

				return arrCostomer.get(i).getId() + "," + arrCostomer.get(i).getList1().toString();
			}

		}

		return "No media for this costomer";
	}

	public String printrented(String id) {

		for (int i = 0; i < arrCostomer.size(); i++) {
			if (arrCostomer.get(i).getId().equalsIgnoreCase(id)) {

				return arrCostomer.get(i).getId() + "," + arrCostomer.get(i).getList2().toString();
			}

		}

		return "No rented media for this costomer";
	}

}