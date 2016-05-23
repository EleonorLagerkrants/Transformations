package Transformations.Transformations.src.XMLTransform;

public class Movie {
	
	String title;
	String rank;
	String year;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRank() {
		return rank;
	}
	
	public void setRank(String rank) {
		this.rank = rank;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String toString() {
		return "Movie [title: "+title +", rank: "+ rank+ ", year: "+ year+"]";
	}
	
	
	
	

}
