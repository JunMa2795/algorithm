import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;

public class Solution {
	/*
	 * Complete the function below.
	 */
	static int getNumberOfMovies(String substr) {
		/*
		 * Endpoint: "https://jsonmock.hackerrank.com/api/movies/search/?Title=substr"
		 */
		String url = "https://jsomock.hackerrank.com/api/movies/search/?Title=";
		StringBuilder urlBuilder = new StringBuilder(url);
		urlBuilder.append(substr);

		StringBuffer response = new StringBuffer();

		try {
			URL urlObj = new URL(urlBuilder.toString());
			HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
			con.setRequestMethod("GET");
			// add request header
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("Sending 'GET' request to URL : " + urlObj.toString());
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}

			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(response.toString());
//		JsonObject jobj = new Gson().fromJson(response.toString(), JsonObject.class);

		return 1;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
//		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;
		String _substr;
		try {
			_substr = in.nextLine();
		} catch (Exception e) {
			_substr = null;
		}

		res = getNumberOfMovies(_substr);
//		bw.write(String.valueOf(res));
//		bw.newLine();
//
//		bw.close();
	}
}