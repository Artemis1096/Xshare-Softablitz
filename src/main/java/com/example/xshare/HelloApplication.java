package com.example.xshare;

import com.example.xshare.backend.config.SpringContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SpringContext.initializeContext(XshareApplication.class);
        ApplicationContext context = SpringContext.getContext();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("main.fxml"));
        fxmlLoader.setControllerFactory(context::getBean); // Allow Spring to inject controllers

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Xshare");
        stage.setWidth(730);
        stage.setHeight(530);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}