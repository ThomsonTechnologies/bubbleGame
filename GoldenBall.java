package bubbles3;

import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

public class GoldenBall extends Circle{
	private Image imgGoldenBall = 
			new Image("file:///C:/Users/thoms_000/Desktop/Work/GameProjects/Bubbles/golden.png");
	
	public GoldenBall(){
		ImagePattern goldenPattern = new ImagePattern(imgGoldenBall);
		setFill(goldenPattern);
//		setCenterX(400);
//		setCenterY(590);
		setRadius(20);
	}
	
}
