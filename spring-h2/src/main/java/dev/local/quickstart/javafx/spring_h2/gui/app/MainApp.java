package dev.local.quickstart.javafx.spring_h2.gui.app;

import dev.local.quickstart.javafx.spring_h2.config.AppConfig;
import dev.local.quickstart.javafx.spring_h2.gui.controller.MainController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp extends Application {

  private static final Logger log = LoggerFactory.getLogger(MainApp.class);
  public static final ApplicationContext APPLICATION_CONTEXT = new AnnotationConfigApplicationContext(
      AppConfig.class);

  public static void main(String[] args) {
    try {
      launch(args);
    } catch (Exception e) {
      log.error("Application error: {}", e);
    }
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    MainController controller = (MainController) APPLICATION_CONTEXT.getBean("mainController");
    controller.setStage(primaryStage);

    FXMLLoader loader = new FXMLLoader();
    loader.setController(controller);

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
    ((ConfigurableApplicationContext) APPLICATION_CONTEXT).close();
    log.info("stop app");
  }
}
