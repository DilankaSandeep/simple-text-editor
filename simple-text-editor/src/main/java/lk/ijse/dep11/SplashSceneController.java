package lk.ijse.dep11;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SplashSceneController  {

    public AnchorPane rootPane;


    public  void  initialize() throws IOException, InterruptedException {
    new SplashScreen().start();

    }
    class  SplashScreen extends Thread{
        @Override
        public void run(){
            try {
                Thread.sleep(2000);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root =null;
                        try {
                            root =FXMLLoader.load(getClass().getResource("/view/TextEditorMainView.fxml"));
                            Scene textEditorMainScene = new Scene(root);
                            Stage newStage = new Stage();
                            newStage.setScene(textEditorMainScene);
                            newStage.centerOnScreen();
                            newStage.setTitle("Simple Text Editor");
                            newStage.show();
                            rootPane.getScene().getWindow().hide();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }


                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
