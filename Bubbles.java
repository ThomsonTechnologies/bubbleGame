package bubbles3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Bubbles extends Application{
	private Pane pane = new Pane();
	private Line line = new Line(400, 600, 600, 300);
	private ArrayList<Circle> totalBallsArray = new ArrayList<Circle>();
	private int ArrIndex = 0;
	//private boolean isIntersected = false;
	@Override
	public void start(Stage primaryStage) throws Exception {
		line.setStroke(Color.TRANSPARENT);
		setTotalBalls();
		pane.setId("pane");
		pane.setOnMouseClicked( e-> {
			Circle ball = totalBallsArray.get(ArrIndex);
						
			line.setEndX(e.getX());
			line.setEndY(e.getY());
			
//			CubicCurveTo cubicTo = new CubicCurveTo();
//			cubicTo.setControlX1(0.0f);
//			cubicTo.setControlY1(0.0f);
//			cubicTo.setControlX2(100.0f);
//			cubicTo.setControlY2(100.0f);
//			cubicTo.setX(100.0f);
//			cubicTo.setY(50.0f);
			
			
			PathTransition pt = new PathTransition();
			pt.setDuration(Duration.millis(2000));
			pt.setNode(ball);
			pt.setPath(line);
			pt.play();
			if(ball.getCenterY() < 50){
				pt.stop();
			}
			checkIntersection(ball);
//			if(isIntersected){
//				ball.setCenterY(-1);
//			}
			//pane.getChildren().clear();
			pane.getChildren().remove(line);
			pane.getChildren().add(line);
			pane.getChildren().add(ball);
			
			ArrIndex++;
		});
		
		
		Scene scene = new Scene(pane, 800, 600);
		scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
		primaryStage.setTitle("Bubbles");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	
	public void setTotalBalls(){
		
		for(int i = 0; i < 1000; i++){
	
			if((int )(Math.random() * 4) == 0){
				totalBallsArray.add(new RedBall());
			}
			if((int )(Math.random() * 4) == 1){
				totalBallsArray.add(new BlueBall());
			}
			if((int )(Math.random() * 4) == 2){
				totalBallsArray.add(new GreenBall());
			}
			if((int )(Math.random() * 4) == 3){
				totalBallsArray.add(new GreyBall());
			}
			
			long seed = System.nanoTime();
			Collections.shuffle(totalBallsArray, new Random(seed));
		}//for
	}
	
	public void checkIntersection(Circle ball){
		if(ball instanceof RedBall){
			//if(ball.inter)
			System.out.println("Red Ball");
		}
		//return false;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
}
