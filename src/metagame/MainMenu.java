package metagame;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainMenu extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		//Title of Window
		primaryStage.setTitle("Meta Game");
		
		//Creation of buttons on main menu
		final Button sett = new Button("Settings");
		final Button start = new Button("Start");
		
		//location of buttons
		start.setLayoutX(380);
		start.setLayoutY(200);
		
		//actions of buttons
		start.setOnAction(e -> {
			game(primaryStage);
		});

		sett.setOnAction(e -> {
			settings(primaryStage);
		});
		
		//Title on the main menu
		final Text text1 = new Text(350, 100, "Meta Game");
		text1.setFill(Color.WHITE);
		text1.setFont(Font.font(java.awt.Font.SERIF, 25));
		
		//creation of the main menu scene
		final Group root = new Group(start, sett, text1);
		final Scene scene = new Scene(root, 800, 400, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	//actions performed when "start" is clicked
	public void game(Stage ps) {
		final Group ro = new Group();
		final Scene sc = new Scene(ro, 800, 400, Color.BLUE);
		ps.setScene(sc);
	}

	public void settings(Stage ps) {
		final Slider sl = new Slider();

		sl.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (sl.isValueChanging()) {
					// cant implement until we know how to do audio
					// .setVolume(sl.getValue() / 100.0);
				}
			}
		});

		final Group ro = new Group(sl);
		final Scene sc = new Scene(ro, 800, 400, Color.GREEN);

		ps.setScene(sc);
	}
}