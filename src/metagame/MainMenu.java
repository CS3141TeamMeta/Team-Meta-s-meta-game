package metagame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class MainMenu extends Application {

	Group root;
	Scene scene;
	public ArrayList<String> dia = new ArrayList<>();
	double difficulty;
	String major;
	Frogger frog = new Frogger();

	// Audio Player(Beta)
	String path0 = MainMenu.class.getResource("/M1.mp3").toString();
	Media media0 = new Media(path0);
	MediaPlayer mp0 = new MediaPlayer(media0);

	// Audio Player(Beta)
	String path1 = MainMenu.class.getResource("/M2.mp3").toString();
	Media media1 = new Media(path1);
	MediaPlayer mp1 = new MediaPlayer(media1);

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws FileNotFoundException {

		fread();

		System.out.println(dia.get(9));

		// Title of Window
		String s1 = new String("Meta Game");
		primaryStage.setTitle(s1);

		// Creation of buttons on main menu
		Button sett = new Button("Settings");
		sett.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		Button start = new Button("Start");
		start.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		Button exit = new Button("Exit");
		exit.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		Button stats = new Button("Stats");
		stats.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");

		final Button mg = new Button("MG test");
		mg.setStyle("-fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		mg.setLayoutX(700);
		mg.setLayoutY(350);
		mg.setOnAction(e -> {
			try {
				frog.start(primaryStage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		// location of buttons
		start.setLayoutX(225);
		start.setLayoutY(525);
		start.setPrefSize(100, 50);

		sett.setLayoutX(375);
		sett.setLayoutY(525);
		sett.setPrefSize(100, 50);

		stats.setLayoutX(525);
		stats.setLayoutY(525);
		stats.setPrefSize(100, 50);

		exit.setLayoutX(675);
		exit.setLayoutY(525);
		exit.setPrefSize(100, 50);
		// actions of buttons
		start.setOnAction(e -> {
			game(primaryStage);
			mp0.stop();
			mp1.play();
		});

		DropShadow shadow = new DropShadow();
		start.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				start.setEffect(shadow);
			}
		});
		start.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				start.setEffect(null);
			}
		});

		sett.setOnAction(e -> {
			settings(primaryStage);
		});

		sett.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				sett.setEffect(shadow);
			}
		});

		sett.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				sett.setEffect(null);
			}
		});

		stats.setOnAction(e -> {
			try {
				stats(primaryStage);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		});
		stats.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				stats.setEffect(shadow);
			}
		});
		stats.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				stats.setEffect(null);
			}
		});

		exit.setOnAction(e -> {
			primaryStage.close();
		});
		exit.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				exit.setEffect(shadow);
			}
		});
		exit.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				exit.setEffect(null);
			}
		});
		// Title on the main menu
		Text title = new Text(370, 75, "Meta Game");
		title.setFill(Color.BLACK);
		title.setFont(Font.font(java.awt.Font.MONOSPACED, 50));
		title.setStyle("-fx-font-weight: bold");
		Image img = new Image("gold.jpg", 1000, 600, false, false);
		ImageView imgView = new ImageView(img);
		
		// creation of the main menu scene
		root = new Group(imgView, start, sett, exit, stats, title, mg);
		scene = new Scene(root, 1000, 600, Color.WHITE);
		primaryStage.setScene(scene);
		primaryStage.show();
		mp0.play();

	}

	// actions performed when "start" is clicked
	public void game(Stage ps) {

		Text title = new Text(370, 150, "Select Major");
		
		title.setFill(Color.BLACK);
		title.setFont(Font.font(java.awt.Font.MONOSPACED, 50));
		title.setStyle("-fx-font-weight: bold");
		
		Button mj1 = new Button("Engineering");
		Button mj2 = new Button("Comp Sci");
		Button mj3 = new Button("Mathematics");
		Button mj4 = new Button("Accounting");
		Button back = new Button("Back");

		mj1.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		mj1.setPrefSize(100, 50);
		mj2.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		mj2.setPrefSize(100, 50);
		mj3.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		mj3.setPrefSize(100, 50);
		mj4.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		mj4.setPrefSize(100, 50);
		back.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		back.setPrefSize(100, 50);
		back.setOnAction(e -> {
			back(ps);
			mp1.stop();
			mp0.play();
		});
		back.setLayoutX(450);
		back.setLayoutY(500);
		mj1.setLayoutX(200);
		mj1.setLayoutY(350);
		mj2.setLayoutX(366);
		mj2.setLayoutY(350);
		mj3.setLayoutX(533);
		mj3.setLayoutY(350);
		mj4.setLayoutX(700);
		mj4.setLayoutY(350);

		mj1.setOnAction(e -> {
			//game1(ps);
			Major1 maj = new Major1();
			major = "Engineering";
			maj.copy(dia, ps);
			maj.main(0);
		});
		mj2.setOnAction(e -> {
			//game1(ps);
			Major2 maj = new Major2();
			major = "Comp Sci";
			maj.copy(dia, ps);
			maj.main(0);
		});
		mj3.setOnAction(e -> {
			//game1(ps);
			Major3 maj = new Major3();
			major = "Mathematics";
			maj.copy(dia, ps);
			maj.main(0);
		});
		mj4.setOnAction(e -> {
			//game1(ps);
			Major4 maj = new Major4();
			major = "Accounting";
			maj.copy(dia, ps);
			maj.main(0);
		});

		
		Image img = new Image("admin build.jpg", 1000, 600, false, false);
		ImageView imgView = new ImageView(img);
		final Group gs = new Group(imgView, mj1, mj2, mj3, mj4, back, title);
		final Scene sc = new Scene(gs, 1000, 600, Color.BLACK);

		ps.setScene(sc);
	}

	public void settings(Stage ps) {
		Text title = new Text(370, 100, "Settings");
		title.setFill(Color.BLACK);
		title.setFont(Font.font(java.awt.Font.MONOSPACED, 50));
		title.setStyle("-fx-font-weight: bold");
		
		Slider sl = new Slider();
		Slider dif = new Slider();
		dif.setValue(50);
		sl.setValue(100);
		Button back = new Button("Back");
		back.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");

		back.setOnAction(e -> {
			back(ps);
		});
		back.setLayoutX(450);
		back.setLayoutY(500);
		back.setPrefSize(100, 50);

		sl.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (sl.isValueChanging()) {
					mp0.setVolume(sl.getValue() / 100);
				}
			}
		});

		dif.valueProperty().addListener(new InvalidationListener() {
			public void invalidated(Observable ov) {
				if (dif.isValueChanging()) {
					difficulty = dif.getValue();
				}
			}
		});

		Text slt = new Text(380, 260, "Audio");
		slt.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
		slt.setStyle("-fx-font-weight: bold");
		sl.setLayoutX(450);
		sl.setLayoutY(250);
		Text dift = new Text(320, 310, "Difficulty");
		dift.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
		dift.setStyle("-fx-font-weight: bold");
		dif.setLayoutX(450);
		dif.setLayoutY(300);

		Image img = new Image("dorm.jpg", 1000, 600, false, false);
		ImageView imgView = new ImageView(img);
		final Group ss = new Group(imgView, sl, back, title, dif, dift, slt);
		final Scene sc = new Scene(ss, 1000, 600, Color.WHITE);

		ps.setScene(sc);
	}

	public void stats(Stage ps) throws FileNotFoundException {
		File file = new File("C:\\Users\\Ethan\\git\\Team-Meta-s-meta-game\\bin\\stats.txt");
		Scanner s = new Scanner(file);
		String[] stats = new String[3];
		for(int i = 0; i < 3; i++){
			stats[i] = s.nextLine();
		}
		s.close();
		Text title = new Text(400, 100, "Stats");
		title.setFill(Color.BLACK);
		title.setFont(Font.font(java.awt.Font.MONOSPACED, 50));
		title.setStyle("-fx-font-weight: bold");
		
		Text ends = new Text(320, 280, "Endings Seen:\n\n          " + stats[0] + " / 8 ");
		ends.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
		ends.setStyle("-fx-font-weight: bold");
		Text mjr = new Text(320, 360, "Majors Completed:\n\n         " + stats[1] + " / 4 ");
		mjr.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
		mjr.setStyle("-fx-font-weight: bold");
		Text death = new Text(320, 440, "Total Deaths:\n\n         " + stats[2]);
		death.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
		death.setStyle("-fx-font-weight: bold");
		
		
		
		Button back = new Button("Back");
		back.setStyle(
				"-fx-font:14 arial; -fx-background-color: linear-gradient(#100C08, #100D08); -fx-text-fill: white;");
		back.setPrefSize(100, 50);
		back.setOnAction(e -> {
			back(ps);
		});
		back.setLayoutX(450);
		back.setLayoutY(500);

		Image img = new Image("library2.jpg", 1000, 600, false, false);
		ImageView imgView = new ImageView(img);
		final Group st = new Group(imgView, back, title, ends, mjr, death);
		final Scene sc = new Scene(st, 1000, 600, Color.WHITE);
		ps.setScene(sc);
	}

	public void back(Stage ps) {
		ps.setScene(scene);
		ps.show();
	}

	public void fread() throws FileNotFoundException {

		File file = new File("C:\\Users\\Ethan\\git\\Team-Meta-s-meta-game\\bin\\story.txt");
		//File file = new File("C:\\Users\\manar_000\\git\\Team-Meta-s-meta-game\\bin\\story.txt");
		Scanner s = new Scanner(file);
		dia.add("offset");
		while (s.hasNext()) {
			dia.add(s.nextLine());
		}
		s.close();
	}

}
