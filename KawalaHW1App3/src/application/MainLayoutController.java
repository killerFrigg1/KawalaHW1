package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainLayoutController implements Initializable {
	ObservableList<Element> elements = FXCollections.observableArrayList();

	@FXML
	private Button button;
	@FXML
	private TableColumn<Element, String> tableColumn;
	@FXML
	private TableView<Element> tableView;
	@FXML
	private TextField textField;

	@FXML
	private ObservableList<Element> dodajDoListy() {
		elements.add(new Element(textField.getText()));
		textField.setText("");
		return elements;
	}

	@FXML
	private void usunZListy() {
		ObservableList<Element> elementsSelected;
		elementsSelected = tableView.getSelectionModel().getSelectedItems();
		elements.removeAll(elementsSelected);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		tableColumn.setCellValueFactory(new PropertyValueFactory<>("str"));
		tableView.setItems(elements);
	}

}
