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

	Group root;
	Scene scene;
	
	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		// Title of Window
		primaryStage.setTitle("Meta Game");

		// Creation of buttons on main menu
		final Button sett = new Button("Settings");
		final Button start = new Button("Start");
		final Button exit = new Button("Exit");
		final Button stats = new Button("Stats");

		// location of buttons
		start.setLayoutX(380);
		start.setLayoutY(200);

		sett.setLayoutX(370);
		sett.setLayoutY(245);

		stats.setLayoutX(379);
		stats.setLayoutY(290);

		exit.setLayoutX(383);
		exit.setLayoutY(335);
		// actions of buttons
		start.setOnAction(e -> {
			game(primaryStage);
		});

		sett.setOnAction(e -> {
			settings(primaryStage);
		});

		stats.setOnAction(e -> {
			stats(primaryStage);
		});

		exit.setOnAction(e -> {
			primaryStage.close();
		});
		// Title on the main menu
		final Text title = new Text(320, 100, "Meta Game");
		title.setFill(Color.WHITE);
		title.setFont(Font.font(java.awt.Font.SANS_SERIF, 40));

		// creation of the main menu scene
		root = new Group(start, sett, exit, stats, title);
		scene = new Scene(root, 800, 400, Color.BLACK);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// actions performed when "start" is clicked
	public void game(Stage ps) {
		
		Text title = new Text(320, 100, "Select Major");
		title.setFill(Color.WHITE);
		title.setFont(Font.font(java.awt.Font.SANS_SERIF, 40));
		Button mj1 = new Button("Enginnering");
		Button mj2 = new Button("Comp Sci");
		Button mj3 = new Button("Mathematics");
		Button mj4 = new Button("Accounting");
		Button back = new Button("Back");
		back.setOnAction(e -> {
			back(ps);
		});
		back.setLayoutX(383);
		back.setLayoutY(335);
		mj1.setLayoutX(150);
		mj1.setLayoutY(200);
		mj2.setLayoutX(300);
		mj2.setLayoutY(200);
		mj3.setLayoutX(450);
		mj3.setLayoutY(200);
		mj4.setLayoutX(600);
		mj4.setLayoutY(200);
		
		final Group gs = new Group(mj1, mj2, mj3, mj4, back, title);
		final Scene sc = new Scene(gs, 800, 400, Color.BLACK);
		
		
		ps.setScene(sc);
	}

	public void settings(Stage ps) {
		final Text title = new Text(320, 100, "Settings");
		title.setFill(Color.WHITE);
		title.setFont(Font.font(java.awt.Font.SANS_SERIF, 40));
		final Slider sl = new Slider();
		Button back = new Button("Back");
		back.setOnAction(e -> {
			back(ps);
		});
		back.setLayoutX(383);
		back.setLayoutY(335);
		
		sl.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (sl.isValueChanging()) {
					// cant implement until we know how to do audio
					// .setVolume(sl.getValue() / 100.0);
				}
			}
		});

		sl.setLayoutX(325);
		sl.setLayoutY(250);
		
		final Group ss = new Group(sl, back, title);
		final Scene sc = new Scene(ss, 800, 400, Color.BLACK);

		ps.setScene(sc);
	}

	public void stats(Stage ps) {
		final Text title = new Text(320, 100, "Stats");
		title.setFill(Color.WHITE);
		title.setFont(Font.font(java.awt.Font.SANS_SERIF, 40));
		Button back = new Button("Back");
		back.setOnAction(e -> {
			back(ps);
		});
		back.setLayoutX(383);
		back.setLayoutY(335);
		
		final Group st = new Group(back, title);
		final Scene sc = new Scene(st, 800, 400, Color.BLACK);
		ps.setScene(sc);
	}

	public void back(Stage ps) {
		ps.setScene(scene);
		ps.show();
	}
}