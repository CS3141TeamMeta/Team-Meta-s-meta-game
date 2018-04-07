package metagame;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.ArrayList;

public class windowbd extends Application {

	
	
	public Group text(String intext, String opt1, String opt2) {
		// String opt3, String opt4) {
		Text t = new Text(150, 150, intext);
		t.setFill(Color.WHITE);
		Button op1 = new Button(opt1);
		op1.setLayoutX(150);
		op1.setLayoutY(250);
		t.setFont(Font.font("Comic Sans MS", 20));
		Button op2 = new Button(opt2);
		op2.setLayoutX(150);
		op2.setLayoutY(300);
		evt(op1, op2);
		return new Group(t, op1, op2);
	}

	private void evt(Button op1, Button op2) {
		DropShadow shadow = new DropShadow();
		op1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				op1.setEffect(shadow);
			}});
		
		op2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				op2.setEffect(shadow);
			}});
		
		op1.setOnAction(e -> {
			//ADD ACTIONS
		});
		op2.setOnAction(e -> {
			//ADD ACTIONS
		});
	}

	@Override
	public void start(Stage arg0) throws Exception {
	}

}
