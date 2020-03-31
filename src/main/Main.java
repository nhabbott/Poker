package main;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.animation.Animation:

public class Main extends Application {

	private Stage window;
	private Scene titleScreen, settingsScreen, gameScreen;
	private ComboBox<String> avatar = new ComboBox<>();
	private ToggleGroup numOfDecks;
	private RadioButton oneDeck = new RadioButton("1");
	private RadioButton twoDeck = new RadioButton("2");
	private RadioButton threeDeck = new RadioButton("3");
	
	@Override
	public void start(Stage stage) throws Exception {
		try {
			// Set window to the main stage
			window = stage;
			
			// Assign the deck selecting RadioButtons to the numOfDecks ToggleGroup and set the default to one deck
			oneDeck.setToggleGroup(numOfDecks);
			twoDeck.setToggleGroup(numOfDecks);
			threeDeck.setToggleGroup(numOfDecks);
			oneDeck.setSelected(true);
			
			// Create the titleScreen scene
			BorderPane titlePane = new BorderPane();
			titlePane.setCenter(getTitleImage());
			titlePane.setBottom(getTitleScreenButtons());
			titleScreen = new Scene(titlePane, 600, 400);
			titleScreen.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			
			// Create the settingsScreen scene
			BorderPane settingsPane = new BorderPane();
			settingsPane.setCenter(getSettings());
			settingsPane.setBottom(getSettingsScreenButtons());
			settingsScreen = new Scene(settingsPane, 600, 400);
			settingsScreen.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			
			// Create the gameScreen scene
			BorderPane gamePane = new BorderPane();
			gameScreen = new Scene(gamePane, 600, 400);
			gameScreen.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			
			// Set the JavaFX window title, icon, and scene. Then show the window
			window.setTitle("Poker");
			//window.setIcon(new Image());
			window.setScene(titleScreen);
			window.show();
		} catch (Exception e)	{
			e.printStackTrace();
		}
	}
	
	// Create the buttons for the title screen
	private HBox getTitleScreenButtons() {
		// Create the HBox container for the buttons
		HBox box = new HBox(15);
		box.setPadding(new Insets(15, 15, 15, 15));
		box.setAlignment(Pos.CENTER);
		
		// Create the play game button
		Button playBtn = new Button("Play");
		playBtn.setId("menuBtn");
		//playBtn.setOnAction(e -> window.setScene(gameScreen));
		
		// Create the settings menu button
		Button settingsBtn = new Button("Settings");
		settingsBtn.setId("menuBtn");
		settingsBtn.setOnAction(e -> window.setScene(settingsScreen));
		
		// Add the buttons to the HBox and return it
		box.getChildren().addAll(playBtn, settingsBtn);
		return box;
	}
	
	// Create the buttons the the settings screen
	private HBox getSettingsScreenButtons() {
		// Create the HBox container for the buttons
		HBox box = new HBox(15);
		box.setPadding(new Insets(15, 15, 15, 15));
		box.setAlignment(Pos.CENTER);
		
		// Create the back button
		Button backBtn = new Button("Back");
		backBtn.setId("menuBtn");
		backBtn.setOnAction(e -> window.setScene(titleScreen));
		
		// Create the save settings button
		Button saveBtn = new Button("Save");
		saveBtn.setId("menuBtn");
		//saveBtn.setOnAction(e -> window.setScene(settingsScreen));
		
		// Add the buttons to the HBox and return it
		box.getChildren().addAll(backBtn, saveBtn);
		return box;
	}
	
	// Create the image for the title screen
	private HBox getTitleImage() {
		// Create the HBox container for the title screen image
		HBox box = new HBox(25);
		
		// Create the image for the title screen
		//ImageView imageView = new ImageView(new Image("titleScreen.png"));
		
		// Set container content to center, add the image to container, and return it
		box.setAlignment(Pos.CENTER);
		//box.getChildren().add(imageView);
		return box;
	}
	
	// Create the settings screen
	private GridPane getSettings() {
		// Create the settings GridPane container
		GridPane settings = new GridPane();
		settings.setHgap(5);
		settings.setVgap(5);
		
		// Create the avatar selection setting and label
		settings.add(new Label("Avatar:"), 0, 0);
		settings.add(avatar, 1, 0, 3, 1);
		
		// Create the numOfDecks selection setting and label
		settings.add(new Label("Decks to Use:"), 0, 2);
		settings.add(oneDeck, 1, 2);
		settings.add(twoDeck, 2, 2);
		settings.add(threeDeck, 3, 2);
		
		// Set container content to center and return it
		settings.setAlignment(Pos.CENTER);
		return settings;
	}
	
	// Launches the JavaFX application
	public static void main(String[] args) {
		launch(args);
	}
}
