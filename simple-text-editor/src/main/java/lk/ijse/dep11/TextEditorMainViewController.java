package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

public class TextEditorMainViewController {
    public AnchorPane root;
    public MenuItem menuItemNew;
    public HTMLEditor htmlEditor;
    public MenuItem menuItemExit;
    public Rectangle dragBar;
    public  double x=0;
    public  double y=0;

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
}
