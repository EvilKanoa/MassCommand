package ca.kanoa.masscommand;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
	
	public static String readTextFile(File file) {
		if (file.isDirectory()) {
			return "";
		}

		StringBuilder builder = new StringBuilder();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new java.io.FileReader(file));
			String s;
			while ((s = reader.readLine()) != null) {
				builder.append(s).append("\n");
			}
		} catch (FileNotFoundException e) {
			return "";
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null) {
					reader.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		String formatted = builder.toString().trim();
		if (formatted.endsWith("\n")) {
			formatted = formatted.substring(0, formatted.length() - "\n"
					.length());
		}
		
		return formatted;
	}
}
