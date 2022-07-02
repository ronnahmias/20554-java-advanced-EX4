import java.util.Map;
import java.util.TreeMap;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class DictionaryController {

	@FXML
	private TextField valueField;

	@FXML
	private TextField keyField;

	@FXML
	private ListView<String> dictionaryList;

	@FXML
	private Button deleteBtn;

	@FXML
	private Button saveBtn;

	@FXML
	private TextField searchField;

	@FXML
	private VBox vbox;

	private Dictionary dictionary;

	public void initialize() {
		dictionary = new Dictionary();
		dictionary.loadFromFile();
		updateUiList(dictionary.getDictionaryList());
	}

	@FXML
	void deleteAction(MouseEvent event) {
		String keySelected = dictionaryList.getSelectionModel().getSelectedItem();
		if (keySelected == null) {
			showAlert("Please Select Term to delete");
			return;
		}
		dictionary.delKey(keySelected);
		updateUiList(dictionary.getDictionaryList());
		clearFields();
	}

	@FXML
	void saveAction(MouseEvent event) {
		// add new term to screen and to tree map
		if (keyField.getText().equals("") || valueField.getText().equals("")) {
			showAlert("Please Fill Meaning and Definition");
			return;
		}
		dictionary.addTerm(keyField.getText(), valueField.getText());
		updateUiList(dictionary.getDictionaryList());
		clearFields();
		addClosingEvent();
	}

	@FXML
	void searchAction(KeyEvent event) {
		System.out.println(searchField.getText());
		updateUiList(dictionary.getFilteredDictionaryList(searchField.getText()));
	}

	@FXML
	void listAction(MouseEvent event) {
		// get selected row forsee and update key an value
		String keySelected = dictionaryList.getSelectionModel().getSelectedItem();
		if (keySelected == null) {
			return;
		}
		String value = dictionary.getValue(keySelected);
		updateUiFields(keySelected, value);
	}

	@FXML
	void newAction(MouseEvent event) {
		// reset btn clear all fields and search filter
		clearFields();
		updateUiList(dictionary.getDictionaryList());
	}

	private void addClosingEvent() {
		Stage stage = (Stage) ((Node) vbox).getScene().getWindow();
		stage.getScene().getWindow().addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, event1 -> {

			dictionary.saveToFile();
		});
	}

	private void clearFields() {
		keyField.clear();
		valueField.clear();
		searchField.clear();
	}

	private void updateUiList(TreeMap<String, String> d) {
		// update the list according to treemap that he will get
		dictionaryList.getItems().clear();
		for (Map.Entry<String, String> entry : d.entrySet()) {
			dictionaryList.getItems().add(entry.getKey());
		}
	}

	private void updateUiFields(String key, String value) {
		keyField.setText(key);
		valueField.setText(value);
	}

	private void showAlert(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

}
