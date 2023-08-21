package lk.ijse.dep11;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class AboutUsViewController {


    public Button btnClose;
    public AnchorPane aboutusroot;
    public Rectangle aboutusDragBar;
    double x=0;
    double y=0;


    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage stage=(Stage) aboutusroot.getScene().getWindow();
        stage.close();
    }

    public void aboutusDragBarOnDrag(MouseEvent mouseEvent) {
        Stage stage =(Stage) aboutusroot.getScene().getWindow();
        stage.setX(mouseEvent.getScreenX()-x);
        stage.setY(mouseEvent.getScreenY()-y);
    }

    public void aboutusDragBarOnPressed(MouseEvent mouseEvent) {
        x=mouseEvent.getSceneX();
        y=mouseEvent.getSceneY();
    }
}
