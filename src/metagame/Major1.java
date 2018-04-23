package metagame;

import java.util.ArrayList;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Major1 extends Application {

	MainMenu mm = new MainMenu();
	ArrayList<String> dialog = mm.dia;
	Stage prm = null;
	Scene sc = null;
	int ticker = 0;
	
	@Override
	public void start(Stage arg0) throws Exception {
	}

	public void main(int jump) {

		//TO START MINIGAMES
//		Frogger frog = new Frogger();
//		Stage stg = new Stage();
//		try {
//			frog.start(stg);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		
		switch (jump) {

		case 0:	
			sysout(dialog.get(20), dialog.get(21), "admin1.jpg");
			break;
		case 1:
			sysout(dialog.get(22), dialog.get(23), "rosa.jpg");
			break;
		case 2:
			sysout(dialog.get(24), dialog.get(25), "rosa.jpg");
			break;
		case 3:
			sysout(dialog.get(26), dialog.get(27), dialog.get(28), "dorms.jpg");
			break;
		case 4:
			sysout(dialog.get(29), dialog.get(30), "dining.jpg");
			break;
		case 5:
			sysout(dialog.get(31), dialog.get(32), "dining.jpg");
			break;
		case 6:
			sysout(dialog.get(33), dialog.get(34), "spng.png");
			break;
		case 7:
			//fail chance
			sysout(dialog.get(35), dialog.get(36), dialog.get(37), "dorms.jpg");
			break;
		case 8:
			//start frog
			sysout(dialog.get(38), dialog.get(39), "dorms.jpg");
			break;
		case 9:
			sysout(dialog.get(40), dialog.get(41), dialog.get(42),"fisher.jpg");
			Frogger frog = new Frogger();
			Stage stg = new Stage();
			try {
				frog.start(stg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 10:
			sysout(dialog.get(43), dialog.get(44), "fisher.jpg");
			break;
		case 11:
			sysout(dialog.get(45), dialog.get(46), "dorms.jpg");
			break;
		case 12:
				//
		case 13:
			sysout(dialog.get(47), dialog.get(48), dialog.get(49), "dorms.jpg");
			TetrisApp tet = new TetrisApp();
			stg = new Stage();
			try {
				tet.start(stg);
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 14:
			sysout(dialog.get(50), dialog.get(51), "dorms.jpg");
			break;		
		case 15:
			sysout(dialog.get(52), dialog.get(53), "dorms.jpg");
			break;
		case 16:
			sysout(dialog.get(54), dialog.get(56), "black.png");
			break;
		case 20:
			sysout(dialog.get(55), dialog.get(56), "black.png");
			break;
		default:
			sysout(dialog.get(22), dialog.get(23), "admin1.jpg");
			break;
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
//		t.setOpacity(0);
//		FadeTransition ft = new FadeTransition(Duration.seconds(0.66), t);
//		ft.setToValue(1);
//		ft.setDelay(Duration.seconds(1 * 0.15));
//		ft.play();
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
			caseset(2, ticker);
		});
	}

	public void caseset(int choice, int tick) {
		int jump = 0;

	

			if(choice == 1 && tick == 1) {
				jump = 1;
			}else if(choice == 1 && tick == 2) {
				jump = 2;
			}else if(choice == 1 && tick == 3) {
				jump = 3;
			}else if(choice == 1 && tick == 4) {
				String path0 = MainMenu.class.getResource("/jc.mp3").toString();
				Media media0 = new Media(path0);
				MediaPlayer mp0 = new MediaPlayer(media0);
				mp0.play();
				jump = 4;
			}else if(choice == 2 && tick == 4) {
				String path0 = MainMenu.class.getResource("/jc.mp3").toString();
				Media media0 = new Media(path0);
				MediaPlayer mp0 = new MediaPlayer(media0);
				mp0.play();
				jump = 4;
			}else if(choice == 1 && tick == 5) {
				jump = 5;
			}else if(choice == 1 && tick == 6) {
				jump = 6;
			}else if(choice == 1 && tick == 7) {
				jump = 7;
			}else if(choice == 1 && tick == 8) {
				jump = 20;
			}else if(choice == 2 && tick == 8) {
				jump = 8;
			}else if(choice == 1 && tick == 9) {
				
				jump = 9;
			}else if(choice == 1 && tick == 10) {
				jump = 11;
			}else if(choice == 2 && tick == 10) {
				jump = 10;
			}else if(choice == 1 && tick == 11) {
				jump = 13;
			}else if(choice == 1 && tick == 12) {
				String path0 = MainMenu.class.getResource("/plung.mp3").toString();
				Media media0 = new Media(path0);
				MediaPlayer mp0 = new MediaPlayer(media0);
				mp0.play();
				jump = 15;			
			}else if(choice == 2 && tick == 12) {
				jump = 14;
			}else if(choice == 1 && tick == 13) {
				jump = 16;
			}
			System.out.println(jump);

		main(jump);
	}

	public void copy(ArrayList<String> dia, Stage ps) {
		for (int i = 0; i < dia.size(); i++) {
			dialog.add(dia.get(i));
		}
		prm = ps;
	}
}