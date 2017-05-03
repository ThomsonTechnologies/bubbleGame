package bubbles3;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class RedBall extends Circle{
	private Image imgRedBall = 
			new Image("file:///C:/Users/thoms_000/Desktop/Work/GameProjects/Bubbles/red.png");
	
	public RedBall(){
		ImagePattern redPattern = new ImagePattern(imgRedBall);
		setFill(redPattern);
		setCenterX(400);
		setCenterY(590);
		setRadius(20);
	}
}
