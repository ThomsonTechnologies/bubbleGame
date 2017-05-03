package bubbles3;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class GreyBall extends Circle{
	private Image imgGreyBall = 
			new Image("file:///C:/Users/thoms_000/Desktop/Work/GameProjects/Bubbles/grey.png");
	
	public GreyBall(){
		ImagePattern greyPattern = new ImagePattern(imgGreyBall);
		setFill(greyPattern);
		setCenterX(400);
		setCenterY(590);
		setRadius(20);
	}

}
