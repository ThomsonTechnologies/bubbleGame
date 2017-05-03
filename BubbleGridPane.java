package bubbles3;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BubbleGridPane extends Application{
	private int rowIndex;
	private int colIndex;
	private int ballId = 1;
	private GridPane gridPane = new GridPane();
	private Pane animationPane = new Pane();
	private ArrayList<Circle> ballsArray = new ArrayList<Circle>();
	private int ArrIndex = 0;
	private Line line = new Line(400, 600, 600, 300);
	
	double lineEndX;
	double lineEndY;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane pane = new Pane();
		animationPane.setMinHeight(600);
		//animationPane.setMinWidth(840);
		pane.setId("pane");
		final Pane  spring = new Pane();
		//GridPane gridPane = new GridPane();
		
		
		for(int i = 0; i < 15; i++){
			RowConstraints row = new RowConstraints(15);
			row.setPrefHeight(40);
	         gridPane.getRowConstraints().add(row); 
			for(int j = 0; j < 21; j++){
				ColumnConstraints column = new ColumnConstraints(40);
		        gridPane.getColumnConstraints().add(column);
		        column.setPrefWidth(40);
		         
				//if((int )(Math.random() * 10) == 1) continue;
		        if(i > 4) gridPane.add(new Pane(), j, i);
				if(i > 4 )continue;//gridPane.add(new Pane(), j, i);
				if((int )(1 + Math.random() * 5) == 3);
				
		        int randNum = (1 + (int )(Math.random() * 5));
				
		        if(randNum == 1){
		        	 gridPane.add(new RedBall(), j, i);
				}else if(randNum == 2){
		         gridPane.add(new BlueBall(), j, i);
				}else if(randNum == 3){
					gridPane.add(new GreenBall(), j, i);
				}else if(randNum == 4){
					gridPane.add(new GoldenBall(), j, i);
				}else gridPane.add(new GreyBall(), j, i);
			}// for j
			   
		}//for i
		
		gridPane.setOnMouseClicked( e-> {
			setColIndex();
			setRowIndex();
			 System.out.println("Column Index: " + colIndex);
			 System.out.println("Row Index: " + rowIndex);
			 System.out.println(e.getX());
			 
			//Circle ball = ballsArray.get(ArrIndex);
			//line.setEndX(e.getX());
			//line.setEndY(e.getY());
		});
		
		
		pane.getChildren().add(gridPane);
		pane.getChildren().add(animationPane);
		Scene scene = new Scene(pane, 840, 600);
		scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
		primaryStage.setTitle("BubblesGridPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	private void setRowIndex(){
		gridPane.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
            	//Circle redBall = new RedBall();
                for( Node node: gridPane.getChildren()) {

                    if( node instanceof Circle || node instanceof Pane) {
                        if( node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
                            rowIndex = GridPane.getRowIndex( node);
                        }
                    }
                }
            }
        });
	}
	
	
	private void setColIndex(){
		gridPane.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                for( Node node: gridPane.getChildren()) {

                    if( node instanceof Circle || node instanceof Pane) {
                        if( node.getBoundsInParent().contains(e.getSceneX(),  e.getSceneY())) {
                            colIndex = GridPane.getColumnIndex(node);
                           // System.out.println(colIndex);
                        }
                    }
                }
            }
        });
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
