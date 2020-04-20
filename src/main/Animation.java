package main;

import javafx.animation.FadeTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animation {
	
	// Animation for "big win"
	// Make sure the text for the win amount and the circle have their opacity set to 0.0f
	public static SequentialTransition bigWinAnimation(Node circle, Node text) { 
		// Fade in the circle and make the text visible
		FadeTransition fadeIn = new FadeTransition();
		fadeIn.setFromValue(0.0f);
		fadeIn.setToValue(1.0f);
		fadeIn.setCycleCount(1);
		fadeIn.setNode(circle);
		fadeIn.setDuration(Duration.seconds(3));
		fadeIn.setOnFinished(e -> {
			text.setOpacity(1.0f);
		});
		
		// Emphasize the win amount
		ScaleTransition scale = new ScaleTransition();  
        scale.setByX(1.5f);  
        scale.setByY(1.2f);  
        scale.setCycleCount(4);  
        scale.setAutoReverse(true);  
        scale.setNode(text);
        scale.setDuration(Duration.seconds(1));
		
		// Spin the win amount around twice
		RotateTransition rotateTxt = new RotateTransition();
		rotateTxt.setFromAngle(0f);
		rotateTxt.setToAngle(360f);
		rotateTxt.setCycleCount(2);
		rotateTxt.setAutoReverse(true);
		rotateTxt.setNode(text);
		rotateTxt.setDuration(Duration.seconds(1.5f));
		
		// Make the text disappear
		FadeTransition fadeOutTxt = new FadeTransition();
		fadeOutTxt.setFromValue(1.0f);
		fadeOutTxt.setToValue(0.0f);
		fadeOutTxt.setCycleCount(1);
		fadeOutTxt.setNode(text);
		fadeOutTxt.setDuration(Duration.seconds(2));
		
		// Make circle disappear
		FadeTransition fadeOutCirc = new FadeTransition();
		fadeOutCirc.setFromValue(1.0f);
		fadeOutCirc.setToValue(0.0f);
		fadeOutCirc.setCycleCount(1);
		fadeOutCirc.setNode(circle);
		fadeOutCirc.setDuration(Duration.seconds(2));
		
		// Transition that contains all of the needed transitions; to be returned
		SequentialTransition ret = new SequentialTransition(fadeIn, scale, rotateTxt, fadeOutTxt, fadeOutCirc);
		
		return ret;
	}
	
	// Animation for removing the cards from the hand
	public static TranslateTransition dismissCard(Node node) {
		TranslateTransition move = new TranslateTransition();
		//move.setToY(value);
		move.setCycleCount(1);
		move.setNode(node);
		move.setDuration(Duration.seconds(1.5f));
		return move;
	}
}
