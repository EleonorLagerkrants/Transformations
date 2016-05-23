package Transformations.Transformations.src.XMLTransform;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLOutput {
	
	public static void main(String[] args) throws IOException {
		
		FileWriter fileWriter = null;
		XMLTransformer read = new XMLTransformer();
		List<Movie> movies = read.readXML("C:\\Users\\Eleonor\\workspace\\Programvaruteknik\\src\\Transformations\\Transformations\\files\\StarWars.xml");
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>"); 
		sb.append("<h1>Star Wars Movies<h1>");
		sb.append("<table border=\"5\">");
		sb.append("<tr bgcolor=\"#6699FF\">");
		sb.append("<th style=\"text-align:left\">Title</th><th style=\"text-align:left\">IMDb Rank</th><th style=\"text-align:left\">Year</th>");
		sb.append("</tr>");
		for( Movie m : movies ) {
			sb.append("<tr>");
			sb.append("<td>").append(m.getTitle());
			sb.append("</td><td>").append(m.getRank());
			sb.append("</td><td>").append(m.getYear());
			sb.append("</td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		String html = sb.toString();
		File htmlFile = new File("C:\\Users\\Eleonor\\workspace\\Programvaruteknik\\src\\Transformations\\Transformations\\files\\StarWars.html");
		fileWriter = new FileWriter(htmlFile);
		fileWriter.write(html);
		System.out.print("File written");
		fileWriter.close();
		
	}

}
