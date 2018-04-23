package metagame;

import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Frogger extends Application {

	int i = 0;

	private AnimationTimer timer;

	private Pane root;

	private List<Node> carsl = new ArrayList<>();
	private List<Node> carsr = new ArrayList<>();

	private Node frog;

	Stage ps = null;
	Scene scn = null;
	
	private Parent createContent() {
		root = new Pane();
		Image img = new Image("roads.png", 1000, 600, false, false);
		ImageView imgview = new ImageView(img);
		root.getChildren().add(imgview);

		root.setPrefSize(1000, 600);

		frog = initFrog();

		root.getChildren().add(frog);

		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				onUpdate();
			}
		};
		timer.start();

		return root;
	}

	private Node initFrog() {
		Rectangle rect = new Rectangle(38, 38, Color.GREEN);
		rect.setTranslateY(600 - 39);
		rect.setTranslateX(500);

		return rect;
	}

	private Node spawnCar() {
		Rectangle rect = new Rectangle(40, 40, Color.RED);

		if (i % 2 == 0) {
			rect.setTranslateY((int) (Math.random() * 200));
		} else {
			rect.setTranslateY((int) (500 - Math.random() * 200));
			rect.setTranslateX((int) (1000));
		}
		i++;
		root.getChildren().add(rect);
		return rect;
	}

	private void onUpdate() {
		for (Node car : carsl) {
			car.setTranslateX(car.getTranslateX() + Math.random() * 5);
		}
		for (Node car : carsr) {
			car.setTranslateX(car.getTranslateX() - Math.random() * 5);
		}

		if (Math.random() < 0.025) {
			if (i % 2 == 0) {
				carsl.add(spawnCar());
			} else {
				carsr.add(spawnCar());
			}
		}
		checkState();
	}

	private void checkState() {
		for (Node car : carsr) {
			
			
			if (car.getBoundsInParent().intersects(frog.getBoundsInParent())) {
				String death = "YOU DIED";

				HBox hBox = new HBox();
				hBox.setTranslateX(300);
				hBox.setTranslateY(250);
				root.getChildren().add(hBox);

				for (int i = 0; i < death.toCharArray().length; i++) {
					char letter = death.charAt(i);

					Text text = new Text(String.valueOf(letter));
					text.setFill(Color.RED);
					text.setFont(Font.font(java.awt.Font.MONOSPACED, 56));
					text.setStyle("-fx-font-weight: bold");
					text.setOpacity(0);
				
					hBox.getChildren().add(text);

					FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
					ft.setToValue(1);
					ft.setDelay(Duration.seconds(i * 0.15));
					ft.play();					
				}
			}

		}
		for (Node carl : carsl) {
			if (carl.getBoundsInParent().intersects(frog.getBoundsInParent())) {
				String death = "YOU DIED";

				HBox hBox = new HBox();
				hBox.setTranslateX(300);
				hBox.setTranslateY(250);
				root.getChildren().add(hBox);

				for (int i = 0; i < death.toCharArray().length; i++) {
					char letter = death.charAt(i);

					Text text = new Text(String.valueOf(letter));
					text.setFill(Color.RED);
					text.setFont(Font.font(java.awt.Font.MONOSPACED, 56));
					text.setStyle("-fx-font-weight: bold");
					text.setOpacity(0);

					hBox.getChildren().add(text);

					FadeTransition ft = new FadeTransition(Duration.seconds(0.66), text);
					ft.setToValue(1);
					ft.setDelay(Duration.seconds(i * 0.15));
					ft.play();
				}
					
			}
		}

		if (frog.getTranslateY() <= 0) {
			ps.close();
			return;
		}
	}
	@Override
	public void start(Stage stage) throws Exception {

		ps = stage;
		stage.setScene(new Scene(createContent()));

		stage.getScene().setOnKeyPressed(event -> {
			switch (event.getCode()) {
			case W:
				frog.setTranslateY(frog.getTranslateY() - 40);
				break;
			case S:
				frog.setTranslateY(frog.getTranslateY() + 40);
				break;
			case A:
				frog.setTranslateX(frog.getTranslateX() - 40);
				break;
			case D:
				frog.setTranslateX(frog.getTranslateX() + 40);
				break;
			default:
				break;
			}
		});

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}