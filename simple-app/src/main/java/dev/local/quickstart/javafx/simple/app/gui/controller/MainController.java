package dev.local.quickstart.javafx.simple.app.gui.controller;

import dev.local.quickstart.javafx.simple.app.pojo.CallNumber;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainController {

  private static final Logger log = LoggerFactory.getLogger(MainController.class);

  private Stage stage;

  private ObservableMap<Integer, CallNumber> numbers;

  @FXML
  private TableView<CallNumber> tblNumbers;

  @FXML
  private TableColumn<String, String> clmName;

  @FXML
  private TableColumn<Integer, String> clmNumber;

  @FXML
  public void initialize() {
    numbers = FXCollections.observableHashMap();

    numbers.put(1, new CallNumber(1, "aaa", 111));
    numbers.put(2, new CallNumber(2, "bbb", 222));
    numbers.put(3, new CallNumber(3, "ccc", 333));
    numbers.put(4, new CallNumber(4, "ddd", 444));
    numbers.put(5, new CallNumber(5, "eee", 555));

    clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
    clmNumber.setCellValueFactory(new PropertyValueFactory<>("number"));

    tblNumbers.getItems().setAll(numbers.values());
    tblNumbers.setEditable(true);
  }

  @FXML
  public void quit(Event event) {
    stage.close();
  }

  /* setters */
  public void setStage(Stage stage) {
    this.stage = stage;
  }
}
