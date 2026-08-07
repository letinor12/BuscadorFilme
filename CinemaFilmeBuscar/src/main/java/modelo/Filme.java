package modelo;

public class Filme {
	private String Title;
	private String Year;
	private String Genre;
	private String Director;
	private String plot;
	private String Response;
	
	
	public String getResponse() {
		return Response;
	}
	public String getError() {
		return Error;
	}
	private String Error;
	
	public String getTitle() {
		return Title;
	}
	public String getYear() {
		return Year;
	}
	public String getGenre() {
		return Genre;
	}
	public String getDirector() {
		return Director;
	}
	public String getPlot() {
		return plot;
	}
}
