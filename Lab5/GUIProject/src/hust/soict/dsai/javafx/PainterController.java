package hust.soict.dsai.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class PainterController {
    @FXML
    private Pane drawingAreaPane;

    @FXML
    private RadioButton pen;

    @FXML
    private RadioButton eraser;

    @FXML
    private ToggleGroup drawTools;
    
    private Color inkColor = Color.BLACK;


    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, inkColor);
        drawingAreaPane.getChildren().add(newCircle);
        }
    
    @FXML
    void switchPenColor(ActionEvent event) { 
    	 if (pen.isSelected()) {
             inkColor = Color.BLACK;
         } else if (eraser.isSelected()) {
             inkColor = Color.WHITE;
         }
    }
}