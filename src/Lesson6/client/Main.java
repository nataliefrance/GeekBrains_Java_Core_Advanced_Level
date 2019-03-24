package Lesson6.client;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxmlFile.fxml"));
        primaryStage.setTitle("My Green Chat");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();
    }

        //    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        primaryStage.setTitle("chat 2k19");
////        Scene scene = new Scene(root, 350, 375);
////        primaryStage.setScene(scene);
////        primaryStage.show();
////
////        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
////            public void handle(WindowEvent we) {
////                System.out.println("Stage is closing");
////            }
////        });
////        primaryStage.close();
//
//
//
//        final Scene scene = new Scene(root, 300, 250);
//        scene.setFill(null);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            public void handle(WindowEvent we) {
//                System.out.println("Stage is closing");
//                System.exit(0);
//            }
//        });
//    }

    public static void main (String[]args){
        launch(args);
    }
}
