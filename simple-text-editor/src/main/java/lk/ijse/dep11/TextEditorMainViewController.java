package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.HTMLEditor;
import javafx.stage.*;

import java.io.*;

public class TextEditorMainViewController {
    public AnchorPane root;
    public MenuItem menuItemNew;
    public HTMLEditor htmlEditor;
    public MenuItem menuItemExit;
    public Rectangle dragBar;
    public  double x=0;
    public  double y=0;
    public Button btnExit;
    public MenuItem menuItemUserGuide;
    public MenuItem menuitemAboutUs;
    public Button btnmaximise;
    public Button btnMinimize;
    public MenuItem menuItemSave;

    public void menuItemNewOnAction(ActionEvent actionEvent) {
        htmlEditor.setHtmlText("");
    }

    public void menuItemExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void dragBarOnDragged(MouseEvent mouseEvent) {
        Stage stage=(Stage) root.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX()-x);
        stage.setY(mouseEvent.getScreenY()-y);
    }

    public void dragBarOnPressed(MouseEvent mouseEvent) {
        x=mouseEvent.getSceneX();
        y=mouseEvent.getSceneY();
    }

    public void btnExitOnAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    public void menuItemUserGuideOnAction(ActionEvent actionEvent) throws Exception{
        AnchorPane userGuideroot = FXMLLoader.load(getClass().getResource("/view/UserGuideView.fxml"));
        Scene userGuideScene = new Scene(userGuideroot);
        Stage userGuideStage = new Stage();
        userGuideStage.initModality(Modality.WINDOW_MODAL);
        userGuideStage.initOwner(root.getScene().getWindow());
        userGuideStage.setScene(userGuideScene);
        userGuideStage.setTitle("User Guide for Text Editor");
        userGuideStage.centerOnScreen();
        userGuideStage.show();
    }

    public void menuItemAboutUsOnAction(ActionEvent actionEvent) throws  Exception {
        AnchorPane aboutUsroot = FXMLLoader.load(getClass().getResource("/view/AboutUsView.fxml"));
        Scene aboutUsScene = new Scene(aboutUsroot);
        Stage aboutUsStage = new Stage();
        aboutUsStage.initStyle(StageStyle.TRANSPARENT);
        aboutUsroot.setBackground(Background.fill(Color.TRANSPARENT));
        aboutUsScene.setFill(Color.TRANSPARENT);
        aboutUsStage.initModality(Modality.WINDOW_MODAL);
        aboutUsStage.initOwner(root.getScene().getWindow());
        aboutUsStage.setScene(aboutUsScene);
        aboutUsStage.centerOnScreen();
        aboutUsStage.show();

    }

    public void btnmaximiseOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage)root.getScene().getWindow();
        if(stage.isMaximized()){
            stage.setMaximized(false);
        }else {
            stage.setMaximized(true);
        }

    }

    public void btnMinimizeOnAction(ActionEvent actionEvent) {
        Stage stage =(Stage) root.getScene().getWindow();
        stage.setIconified(true);
    }

    public void menuItemSaveOnAction(ActionEvent actionEvent) {
        DirectoryChooser targetDirectory = new DirectoryChooser();
        targetDirectory.setTitle("Save to");
        try {
            File file = targetDirectory.showDialog(root.getScene().getWindow());

            File targetFile = new File(file.getAbsolutePath() + "/" +htmlEditor.getHtmlText().substring(102,106)+".txt");
            boolean newFile = targetFile.createNewFile();
            if(targetFile!=null){
                FileOutputStream fos = new FileOutputStream(targetFile);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                byte[] bytes = htmlEditor.getHtmlText().substring(102,htmlEditor.getHtmlText().length()-25).getBytes();
                bos.write(bytes);
                System.out.println(new String(bytes));
                bos.close();
            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

        }


    }
}
