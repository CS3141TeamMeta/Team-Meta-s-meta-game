




//DEAD CLASS





//package metagame;
//
//import javafx.application.Application;
//import javafx.event.EventHandler;
//import javafx.scene.Group;
//import javafx.scene.control.Button;
//import javafx.scene.effect.DropShadow;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//import java.util.ArrayList;
//
//public class windowbd extends Application {
//
//	Major1 maj1 = new Major1();
//	Major2 maj2 = new Major2();
//	Major3 maj3 = new Major3();
//	Major4 maj4 = new Major4();
//	
//	public Group text(String intext, String opt1, String opt2) {
//		
//		Text t = new Text(150, 150, intext);
//		t.setFill(Color.WHITE);
//		Button op1 = new Button(opt1);
//		op1.setLayoutX(150);
//		op1.setLayoutY(250);
//		t.setFont(Font.font("Comic Sans MS", 20));
//		Button op2 = new Button(opt2);
//		op2.setLayoutX(150);
//		op2.setLayoutY(300);
//		evt(op1, op2);
//		return new Group(t, op1, op2);
//	}
//
//	private void evt(Button op1, Button op2) {
//		DropShadow shadow = new DropShadow();
//		op1.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			public void handle(MouseEvent e) {
//				op1.setEffect(shadow);
//			}});
//		
//		op2.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
//			public void handle(MouseEvent e) {
//				op2.setEffect(shadow);
//			}});
//		
//		op1.setOnAction(e -> {
//			//ADD ACTIONS
//		});
//		op2.setOnAction(e -> {
//			//ADD ACTIONS
//		});
//	}
//
//	@Override
//	public void start(Stage arg0) throws Exception {
//	}
//
//}
