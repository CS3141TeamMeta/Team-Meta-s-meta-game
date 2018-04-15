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
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Major4 extends Application {

	ArrayList<String> dialog = new ArrayList<>();
	Stage prm = null;
	int ticker = 0;

	@Override
	public void start(Stage primaryStage) throws Exception {
	}

	public void main(int jump) {

		switch (jump) {

		case 0:
			sysout(dialog.get(29), dialog.get(30), dialog.get(31), "gold.jpg");
			break;
		case 1:
			sysout(dialog.get(36), dialog.get(37), dialog.get(38), "gold.jpg");
			break;
		case 2:
			sysout(dialog.get(36), dialog.get(37), dialog.get(38), "gold.jpg");
			break;
			
		//case xx:

		//case xx:
		}

	}

	public void sysout(String intext, String opt1, String opt2, String imgname) {

		Text t = new Text(20, 50, intext);
		t.setFill(Color.WHITE);

		Button op1 = new Button(opt1);
		op1.setLayoutX(150);
		op1.setLayoutY(250);
		t.setFont(Font.font("Comic Sans MS", 20));
		
//		if(opt2 != "0") {
		Button op2 = new Button(opt2);
		op2.setLayoutX(150);
		op2.setLayoutY(300);
		event(op1, op2);
//		}else{ event opt1;}
		
		Image img =new Image("gold.jpg");
		ImageView imgView = new ImageView(img);
		imgView.setFitHeight(100);
		imgView.setFitWidth(100);
		imgView.setLayoutX(350);
		imgView.setLayoutY(200);
		
		//BACKGROUND IMAGE STUFF, DOESNT WORK & IM TOO TIRED TO CARE
	
//		BackgroundImage bg = new BackgroundImage(new Image("gold.jpg", 100, 60, false, false),
//				 BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
//		          BackgroundSize.DEFAULT);
//		Background bk = new Background(bg);
//HBox hb = new HBox();
//hb.getChildren().addAll(t, op1, op2);
//StackPane gs = new StackPane(t, op1, op2);
//StackPane g1 = new StackPane(imgView);
//HBox h1 = new HBox();
//h1.getChildren().addAll(imgView);
//StackPane gs = new StackPane(hb);
//Pane pane = new Pane();
//pane.getChildren().addAll(t, op1, op2);
//pane.setBackground(bk);
//sc.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
		
		Group gs = new Group(t, op1, op2, imgView);
		Scene sc = new Scene(gs, 1000, 600, Color.BLACK);
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
	
	private void event(Button op1) {
		DropShadow shadow = new DropShadow();
		op1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				op1.setEffect(shadow);
			}
		});
		ticker++;
		op1.setOnAction(e -> {
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