package metagame;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Major2 extends Application {

	MainMenu mm = new MainMenu();
	ArrayList<String> dialog = mm.dia;
	Stage prm = null;
	int ticker = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	}

	public void main(int jump) {

		switch (jump) {

		case 0:
			sysout(dialog.get(29), dialog.get(30), dialog.get(31));
			break;
		case 1:
			sysout(dialog.get(36), dialog.get(37), dialog.get(38));
			break;
		case 2:
			sysout(dialog.get(36), dialog.get(37), dialog.get(38));
			break;
			
			// case xx:

			// case xx:
		}
	}
	
	public void sysout(String intext, String opt1, String opt2) {
		
		Text t = new Text(20, 50, intext);
		t.setFill(Color.WHITE);
		Button op1 = new Button(opt1);
		op1.setLayoutX(150);
		op1.setLayoutY(250);
		t.setFont(Font.font("Comic Sans MS", 20));
		Button op2 = new Button(opt2);
		op2.setLayoutX(150);
		op2.setLayoutY(300);
		event(op1, op2);
		Group gs = new Group(t, op1, op2);
		Scene sc =  new Scene(gs, 1000, 600, Color.BLACK);
		t.wrappingWidthProperty().bind(sc.widthProperty());
		prm.setScene(sc);
	}

	private void event(Button op1, Button op2) {
		DropShadow shadow = new DropShadow();
		op1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				op1.setEffect(shadow);
			}
		});

		op2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				op2.setEffect(shadow);
			}
		});
		ticker++;
		op1.setOnAction(e -> {
			caseset(1, ticker);
		});
		op2.setOnAction(e -> {
			caseset(1, ticker);
		});
	}

	public void caseset(int choice, int tick) {
		int jump = 0;

			if(choice == 1 && tick == 1) {
				jump = 1;
			}
			else if(choice == 1 && tick == 1) {
				jump = 2;
			}
			
		

		main(jump);
	}

	public void copy(ArrayList<String> dia, Stage ps) {
		for (int i = 0; i < dia.size(); i++) {
			dialog.add(dia.get(i));
		}
		prm = ps;
	}
}