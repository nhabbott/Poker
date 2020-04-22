package main;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class Main extends Application {

	// UI preparations
	private Stage window;
	private Scene titleScreen, settingsScreen, gameScreen, betScreen;
	
	// Settings screen elements
	private ComboBox<String> avatarBox = new ComboBox<>();
	private ToggleGroup numOfDecks = new ToggleGroup();
	private RadioButton oneDeck = new RadioButton("1");
	private RadioButton twoDeck = new RadioButton("2");
	private RadioButton threeDeck = new RadioButton("3");
	
	// Game screen elements
	private BorderPane gamePane = new BorderPane();
	private ToggleButton card1 = new ToggleButton("");
	private ToggleButton card2 = new ToggleButton("");
	private ToggleButton card3 = new ToggleButton("");
	private ToggleButton card4 = new ToggleButton("");
	private ToggleButton card5 = new ToggleButton("");
	private ImageView card1Image = new ImageView();
	private ImageView card2Image = new ImageView();
	private ImageView card3Image = new ImageView();
	private ImageView card4Image = new ImageView();
	private ImageView card5Image = new ImageView();
	private Label walletAmt = new Label("");
	private Label betAmt = new Label("");
	private Image avaImg;
	private Button discardBtn = new Button("Discard");
	private Button drawBtn = new Button("Draw");
	private Button betBox = new Button("Bet");
	private Button betBtn = new Button("Set Bet");
	private Button betAllBtn = new Button("All in");
	private TextField betAmount = new TextField();
	
	// Game preparations
	private Deck deck;							// Holds the deck for the game
	private int deckParam = 1;					// Holds the numOfDecks selected by the user
	private Hand hand;							// Holds the current hand
	private Wallet wallet = new Wallet(200);		// Holds the user's current wallet amount
	private String avatarOption = "Red";		// Holds the chosen avatar	
	
	@Override
	public void start(Stage stage) throws Exception {
		try {
			// Set window to the main stage
			window = stage;
			
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
			gamePane.setBottom(getGameButtons());
			gamePane.setCenter(getCards());
			gameScreen = new Scene(gamePane, 600, 400);
			gameScreen.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			
			// Set the JavaFX window title, icon, and scene. Then show the window
			window.setTitle("Poker");
			window.setResizable(false);
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
		playBtn.setOnAction(e -> {	
			// Set the game info
			try {
				gamePane.setTop(getGameInfo());
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			// Change the scene to the game
			window.setScene(gameScreen);
		});
		
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
		saveBtn.setOnAction((e) -> {
			// Get the selected number of decks
			RadioButton num = (RadioButton) numOfDecks.getSelectedToggle();
			
			// Save the selected option
			deckParam = Integer.parseInt(num.getText());
			
			// Save the selected avatar
			avatarOption = (String) avatarBox.getValue();
			try {
				avaImg = new Image(new FileInputStream("image/avatar/" + avatarOption + ".png"));
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
			
			// Alert the user
			saveBtn.setText("Saved!");
			Timeline resetSaveBtnText = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
				saveBtn.setText("Save");
			}));
			resetSaveBtnText.setDelay(Duration.seconds(1.5));
			resetSaveBtnText.setCycleCount(1);
			resetSaveBtnText.play();
		});
		
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
		avatarBox.getItems().add("Red");
		avatarBox.getItems().add("Green");
		avatarBox.getItems().add("Blue");
		avatarBox.getItems().add("Orange");
		avatarBox.getItems().add("Yellow");
		avatarBox.getItems().add("Purple");
		settings.add(avatarBox, 1, 0, 3, 1);
		
		// Assign the deck selecting RadioButtons to the numOfDecks ToggleGroup and set the default to one deck
		oneDeck.setToggleGroup(numOfDecks);
		twoDeck.setToggleGroup(numOfDecks);
		threeDeck.setToggleGroup(numOfDecks);
		oneDeck.setSelected(true);
		
		// Create the numOfDecks selection setting and label
		settings.add(new Label("Decks to Use:"), 0, 2);
		settings.add(oneDeck, 1, 2);
		settings.add(twoDeck, 2, 2);
		settings.add(threeDeck, 3, 2);
		
		// Set container content to center and return it
		settings.setAlignment(Pos.CENTER);
		return settings;
	}
	
	// Returns a GridPane with the cards
	private GridPane getCards() throws FileNotFoundException {
		// Generate the deck
		deck = new Deck(deckParam);
		
		// Generate the first hand
		hand = new Hand(deck);
		
		// Create the game GridPane container
		GridPane game = new GridPane();
		game.setHgap(5);
		game.setVgap(5);
		
		// Set the cards to their respective images
		final Image selected = new Image(new FileInputStream("image/card/b1fv.png"));
		final Image card1Img = new Image(new FileInputStream("image/card/" + hand.getCard(0).getValue() + ".png"));
		final Image card2Img = new Image(new FileInputStream("image/card/" + hand.getCard(1).getValue() + ".png"));
		final Image card3Img = new Image(new FileInputStream("image/card/" + hand.getCard(2).getValue() + ".png"));
		final Image card4Img = new Image(new FileInputStream("image/card/" + hand.getCard(3).getValue() + ".png"));
		final Image card5Img = new Image(new FileInputStream("image/card/" + hand.getCard(4).getValue() + ".png"));
		
		card1Image.setImage(card1Img);
		card2Image.setImage(card2Img);
		card3Image.setImage(card3Img);
		card4Image.setImage(card4Img);
		card5Image.setImage(card5Img);
		
		card1.setGraphic(card1Image);
		card2.setGraphic(card2Image);
		card3.setGraphic(card3Image);
		card4.setGraphic(card4Image);
		card5.setGraphic(card5Image);
		
		// TODO Figure out how this will work when using animations
		// Handle what happens to the image when the card is selected or not selected
		card1Image.imageProperty().bind(Bindings.when(card1.selectedProperty()).then(selected).otherwise(card1Img));
		card2Image.imageProperty().bind(Bindings.when(card2.selectedProperty()).then(selected).otherwise(card2Img));
		card3Image.imageProperty().bind(Bindings.when(card3.selectedProperty()).then(selected).otherwise(card3Img));
		card4Image.imageProperty().bind(Bindings.when(card4.selectedProperty()).then(selected).otherwise(card4Img));
		card5Image.imageProperty().bind(Bindings.when(card5.selectedProperty()).then(selected).otherwise(card5Img));
		
		// Add the cards to the container
		// column, row
		game.add(card1, 0, 0);
		game.add(card2, 1, 0);
		game.add(card3, 2, 0);
		game.add(card4, 3, 0);
		game.add(card5, 4, 0);
		
		// Set container content to center and return it
		game.setAlignment(Pos.CENTER);
		return game;
	}
	
	// Returns a HBox with the wallet amount & avatar
	private HBox getGameInfo() throws FileNotFoundException {
		// Create the wallet HBox container
		HBox container = new HBox();
		
		// Set the size and the text of the label to the current amount of the user's wallet
		walletAmt.setText("Wallet: $" + wallet.toString());
		walletAmt.setFont(new Font(15));
		betAmt.setText("Bet: $" + Integer.toString(wallet.getBetAmount()));
		betAmt.setFont(new Font(15));
		
		// Add the label to the container
		container.getChildren().addAll(walletAmt, betAmt);
		
		// Add the avatar
		//Rectangle square = new Rectangle(30, 30);
		//square.setFill(new ImagePattern(avaImg));
		//container.getChildren().add(square);
		
		// Set spacing
		container.setSpacing(430);
		//HBox.setMargin(square, new Insets(5, 5, 5, 5));
		HBox.setMargin(walletAmt, new Insets(5, -20, 5, 5));
		HBox.setMargin(betAmt, new Insets(5, 10, 5, 5));
		
		// Set container content to center and return it
		container.setAlignment(Pos.TOP_CENTER);
		return container;
	}
	
	// Returns a HBox with the draw & discard buttons
	private HBox getGameButtons() {
		// Create the buttons HBox container
		HBox container = new HBox();
		
		// Set draw button behaviors
		drawBtn.setOnAction(e -> {
			// Do stuff when draw btn is clicked
		});
		
		betBox.setOnAction(e -> {
			// Init betScreen scene
			getBetButtons();
			
			window.setScene(betScreen);
		});
		
		// Set discard button behaviors
		discardBtn.setOnAction(e -> {
			// Do stuff when discard btn is clicked
		});
		
		// Add the buttons
		container.getChildren().addAll(drawBtn, betBox, discardBtn);
		
		// Set spacing
		container.setSpacing(200);
		HBox.setMargin(drawBtn, new Insets(5, 5, 5, 5));
		HBox.setMargin(discardBtn, new Insets(5, 5, 5, 5));
		HBox.setMargin(betBox, new Insets(5, 5, 5, 5));
		
		// Set container content to center and return it
		container.setAlignment(Pos.BOTTOM_CENTER);
		return container;
	}
	
	// Create bet screen
	private void getBetButtons() {
		// Create the buttons containers
		BorderPane pane = new BorderPane();
		HBox container1 = new HBox();
		HBox container2 = new HBox();
		
		betBtn.setOnAction(e -> {
			if (Integer.parseInt(betAmount.getText()) > wallet.getMax()) {
				betBtn.setText("Enter amt > " + wallet.getMax());
				Timeline resetBetBtnText = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
					betBtn.setText("Set Bet");
				}));
				resetBetBtnText.setDelay(Duration.seconds(1.5));
				resetBetBtnText.setCycleCount(1);
				resetBetBtnText.play();
				return;
			}
			
			wallet.setBetAmount(Integer.parseInt(betAmount.getText()));
			betAmt.setText("Bet: $" + Integer.toString(wallet.getBetAmount()));
			window.setScene(gameScreen);
			window.show();
		});
		
		betAllBtn.setOnAction(e -> {
			int amount = (int) wallet.getMax();
			betAmount.setText(Integer.toString(amount));
		});
		
		// Add the buttons
		container1.getChildren().addAll(betBtn, betAllBtn);
		container2.getChildren().addAll((new Label("Bet Amount: ")), betAmount);
		
		// Set spacing
		container1.setSpacing(200);
		HBox.setMargin(betBtn, new Insets(5, 5, 5, 5));
		HBox.setMargin(betAllBtn, new Insets(5, 5, 5, 5));
		
		// Set container content to center and return it
		container1.setAlignment(Pos.CENTER);
		container2.setAlignment(Pos.BOTTOM_CENTER);
		
		// Add to pane
		pane.setCenter(container2);
		pane.setBottom(container1);
		pane.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		betScreen = new Scene(pane, 600, 400);
	}
	
	// Launches the JavaFX application
	public static void main(String[] args) {
		launch(args);
	}
}
