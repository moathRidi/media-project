package project1;

public class Movie extends Media implements Comparable{
	private String rating;

	public Movie(String title, int copiesAvailable,String rating,String code) {
		this.setTitel(title);
		this.setNumOfCoppys(copiesAvailable);
		this.rating = rating;
		this.code=code;
	}
 
	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public int compareTo(Object o) {
		if(o instanceof Movie) {
			return ((Movie)o).getTitel().compareTo(this.getTitel());
		}
		return -150;
	}

	@Override
	public String toString() {
		return "Movie [ Code= "+ code+" , Titel=" +getTitel() + ", NumOfCoppys= " + getNumOfCoppys() +", rati=" + rating + "]\n";
	}

	
	
	
}
