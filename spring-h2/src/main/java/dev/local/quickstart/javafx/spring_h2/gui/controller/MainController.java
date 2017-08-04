package dev.local.quickstart.javafx.spring_h2.gui.controller;

import dev.local.quickstart.javafx.spring_h2.commons.AppDao;
import dev.local.quickstart.javafx.spring_h2.pojo.CallNumber;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lombok.Setter;
import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;

@Component
public class MainController implements Initializable {

  private static final Logger log = LoggerFactory.getLogger(MainController.class);

  @Autowired
  private BasicDataSource dataSource;

  @Setter
  private Stage stage;

  private ObservableMap<Integer, CallNumber> numbers;

  @FXML
  private TableView<CallNumber> tblNumbers;

  @FXML
  private TableColumn<String, String> clmName;

  @FXML
  private TableColumn<Integer, String> clmNumber;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
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


  @FXML
  public void save(Event event) {

    try (AppDao dao = new AppDao()) {
      ResultSet resultSet = dao.query(dataSource.getConnection(), "select 1")
          .executeQuery();
      resultSet.next();
      System.out.println(resultSet.getString(1));
      dao.commit();
    } catch (Exception e) {
      log.error("{}", e);
    }

    ((Stage) tblNumbers.getScene().getWindow()).close();

  }

}
