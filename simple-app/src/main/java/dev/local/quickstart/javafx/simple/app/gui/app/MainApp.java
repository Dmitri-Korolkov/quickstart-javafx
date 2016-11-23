package dev.local.quickstart.javafx.simple.app.gui.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainApp extends Application {

  private static final Logger log = LoggerFactory.getLogger(MainApp.class);

  public static void main(String[] args) {
    try {
      launch(args);
    } catch (Exception e) {
      log.error("Application error: {}", e);
    }
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    FXMLLoader loader = new FXMLLoader();
    Parent rootNode = (Parent) loader.load(getClass().getResourceAsStream("/fxml/main.fxml"));
    Scene scene = new Scene(rootNode, 800, 600);
    scene.getStylesheets().add("/styles/styles.css");
    primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icon.png")));//icon
    primaryStage.setMinWidth(400);
    primaryStage.setMinHeight(200);
    primaryStage.setTitle("Simple JavaFX Application");
    primaryStage.setScene(scene);

    primaryStage.show();
  }

  @Override
  public void stop() {
    log.info("stop app");
  }
}
