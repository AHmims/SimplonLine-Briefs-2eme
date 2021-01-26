package sample.helpers;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class Toast {
    private VBox vbox_root;
    private HBox hbox_root;
    private Pane pane_root;

    //
    public Toast(VBox root) {
        this.vbox_root = root;
    }

    public Toast(HBox root) {
        this.hbox_root = root;
    }

    public Toast(Pane root) {
        this.pane_root = root;
    }

    //
    public void normal(String text) {
        VBox box = new VBox();
        Label lb = new Label(text);
        //
        box.getChildren().add(lb);
        setStyle(box, "t_normal");
        //
        display(box);
    }

    //
    //
    //
    private void setStyle(VBox toast_, String type) {
        toast_.getStylesheets().add(getClass().getResource("../res/css/toast.css").toExternalForm());
        toast_.getStyleClass().add("toast");
        toast_.getStyleClass().add(type);
    }

    //
    private void display(VBox toast_) {
        if (vbox_root != null) {
            vbox_root.getChildren().add(toast_);
            toast_.setTranslateX(vbox_root.getWidth() / 2);
            toast_.setTranslateY(vbox_root.getHeight() - 50);
        } else if (hbox_root != null) {
            hbox_root.getChildren().add(toast_);
            toast_.setTranslateX((hbox_root.getWidth() / 2) * -1);
            toast_.setTranslateY(hbox_root.getHeight() - 50);
        } else if (pane_root != null) {
            pane_root.getChildren().add(toast_);
        }
    }
}
