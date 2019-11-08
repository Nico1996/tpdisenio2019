package com.utn.frsf;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TPDisenio extends Application {

    public static ConfigurableApplicationContext applicationContext;
    public static Parent rootNode;
    public static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        applicationContext = SpringApplication.run(TPDisenio.class);
        FXMLLoader loader = new FXMLLoader(TPDisenio.class.getResource("/fxmls/main.fxml"));
        loader.setControllerFactory(applicationContext::getBean);
        Scene scene = new Scene (loader.load());
        primaryStage.setScene(scene);

        //Borderless options
            primaryStage.initStyle(StageStyle.UNDECORATED);
            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());

            primaryStage.requestFocus();


        primaryStage.show();
    }
}
