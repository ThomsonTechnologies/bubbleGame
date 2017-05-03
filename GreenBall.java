package bubbles3;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class GreenBall extends Circle{
	private Image imgGreenBall = 
			new Image("file:///C:/Users/thoms_000/Desktop/Work/GameProjects/Bubbles/green.png");
	
	public GreenBall(){
		ImagePattern greenPattern = new ImagePattern(imgGreenBall);
		setFill(greenPattern);
		setCenterX(400);
		setCenterY(590);
		setRadius(20);
	}
	
}
