// How to run the code in the terminal - 
// javac URLConnectionExample.java
// java -cp . URLConnectionExample

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI; // Import for URI class
import java.net.URL; // Import for URL class
import java.net.URISyntaxException; // Import for URISyntaxException

public class URLConnectionExample {

  public static void main(String[] args) {
    try {
      // Create a URI object
      URI uri = new URI("https://www.youtube.com");

      // Convert the URI to a URL
      URL url = uri.toURL();

      // Open a connection to the URL
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();

      // Set the request method (e.g., GET, POST, PUT, DELETE)
      connection.setRequestMethod("GET");

      // Get the response code
      int responseCode = connection.getResponseCode();
      System.out.println("Response Code: " + responseCode);

      // Handle the response
      if (responseCode == HttpURLConnection.HTTP_OK) {
        // The connection was successful
        System.out.println("Connection successful!");
      } else {
        // The connection failed
        System.out.println("Connection failed.");
      }
    } catch (URISyntaxException e) {
      // Handle the exception if the URI cannot be created
      System.err.println("Error creating URI: " + e.getMessage());
    } catch (IOException e) {
      // Handle potential IO exceptions during connection
      e.printStackTrace();
    }
  }
}