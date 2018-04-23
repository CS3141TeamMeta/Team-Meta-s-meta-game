package metagame;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Major3 extends Application {

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
			sysout(dialog.get(20), dialog.get(21), dialog.get(22));
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
	
	public void sysout(String intext, String opt1, String opt2, String imgname) {
		
		Text t = new Text(150,50, intext);
		t.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: .9px;");
		t.setFont(Font.font("Comic Sans MS", 24));
		Button op1 = new Button(opt1);
		op1.setLayoutX(150);
		op1.setLayoutY(400);
		op1.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		op1.setPrefHeight(50);
		Button op2 = new Button(opt2);
		op2.setLayoutX(150);
		op2.setLayoutY(450);
		op2.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		op2.setPrefHeight(50);
		event(op1, op2);
		Image img =new Image(imgname);
		ImageView imgView = new ImageView(img);
		imgView.setFitHeight(600);
		imgView.setFitWidth(1000);
		Group gs = new Group(imgView, t, op1, op2);
		Scene sc = new Scene(gs, 1000, 600, Color.BLACK);
		t.setWrappingWidth(750);
		prm.setScene(sc);
	}
	
	public void sysout(String intext, String opt1, String imgname) {

		Text t = new Text(150,50, intext);
		t.setStyle("-fx-fill: white; -fx-stroke: black; -fx-stroke-width: .9px;");
		t.setFont(Font.font("Comic Sans MS", 24));	
		Button op1 = new Button(opt1);
		op1.setLayoutX(150);
		op1.setLayoutY(400);
		op1.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		op1.setPrefHeight(50);
		Button op2 = new Button();
		event(op1, op2);
		Image img =new Image(imgname);
		ImageView imgView = new ImageView(img);
		imgView.setFitHeight(600);
		imgView.setFitWidth(1000);
		Group gs = new Group(imgView, t, op1);
		Scene sc = new Scene(gs, 1000, 600, Color.BLACK);
		t.setWrappingWidth(750);
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