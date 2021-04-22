package usantatecla.movies.v27;

public class MovieBuilder {

	private String title;
	
	private Movie movie;
	
	public MovieBuilder() {
		title = "movieName";
	}
	
	public MovieBuilder title(String title) {
		this.title = title;
		return this;
	}
	
	public MovieBuilder childrens() {
		this.movie = new ChildrenMovie(title);
		return this;
	}
	
	public MovieBuilder regular() {
		this.movie = new RegularMovie(title);
		return this;
	}
	
	public MovieBuilder newRelease() {
		this.movie = new NewReleaseMovie(title);
		return this;
	}
	
	public Movie build() {
		return movie;
	}
}
