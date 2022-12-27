package project1;

public class Album extends Media implements Comparable {
	private String artist;
	private String songs;

	public Album(String titel, int numOfCoppys,String artist, String songs,String code) {
        this.setTitel(titel);
        this.setNumOfCoppys(numOfCoppys);
        this.artist = artist;
		this.songs = songs;
		this.code=code;
	}
	
	
	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getSongs() {
		return songs;
	}


	public void setSongs(String songs) {
		this.songs = songs;
	}


	public int compareTo(Object o) {
		if(o instanceof Album) {
			return ((Album)o).getTitel().compareTo(this.getTitel());
		}
		return -150;
	}
	@Override
	public String toString() {
		return "Album [Code= "+ code+", Titel= " + getTitel() + ", NumOfCoppys= "+ getNumOfCoppys() +
				" , artist= " + artist + ", songs= " + songs +  " ]\n";
	}
	
	
}
