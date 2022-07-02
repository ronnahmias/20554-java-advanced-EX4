import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.TreeMap;

import javafx.stage.FileChooser;

public class Dictionary implements Serializable {

	private TreeMap<String, String> terms;

	public Dictionary() {
		this.terms = new TreeMap<String, String>();
	}

	public void addTerm(String meaning, String definition) {
		this.terms.put(meaning, definition);
	}

	public TreeMap<String, String> getDictionaryList() {
		return terms;
	}

	public String getValue(String key) {
		return terms.get(key);
	}

	public void delKey(String key) {
		terms.remove(key);
	}

	public TreeMap<String, String> getFilteredDictionaryList(String searchTerm) {
		TreeMap<String, String> filteredDictionary = new TreeMap<>();
		String value = terms.get(searchTerm);
		if (value != null) {
			filteredDictionary.put(searchTerm, value);
		}
		return filteredDictionary;
	}

	public void saveToFile() {

		File file = getFile();

		try {
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream out = new ObjectOutputStream(fo);
			out.writeObject(terms);
			out.close();
			fo.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private File getFile() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("select a file");
		fileChooser.setInitialDirectory(new File("."));
		return fileChooser.showOpenDialog(null);
	}

	public void loadFromFile() {

		File file = getFile();

		if (file != null) {
			try {

				FileInputStream fi = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fi);
				terms = (TreeMap<String, String>) ois.readObject();
				ois.close();
				fi.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

}
