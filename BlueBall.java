package bubbles3;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class BlueBall extends Circle{
	private Image imgBlueBall = 
			new Image("file:///C:/Users/thoms_000/Desktop/Work/GameProjects/Bubbles/blue.png");
	
	public BlueBall(){
		ImagePattern bluePattern = new ImagePattern(imgBlueBall);
		setFill(bluePattern);
		setCenterX(400);
		setCenterY(590);
		setRadius(20);
	}

}
