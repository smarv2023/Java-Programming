// Fig. 4.27: DrawLinesController.java
// Using strokeLine to connect the corners of a canvas.
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class DrawLinesController { 
   @FXML private Canvas canvas; // used to get the GraphicsContext

   // when user presses Draw Lines button, draw two Lines in the Canvas 
   @FXML
   void drawLinesButtonPressed(ActionEvent event) {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();
      int numSteps = 20;
      double endX = canvas.getWidth(); //300
      double endY = 0;
      double steps = 300/numSteps;
      
      // canvas.getWidth() and canvas.getHeight() is 300
      for (int i = 0; i < numSteps; i++ ) {
    	  endX -= steps;
    	  endY += steps;
    	  
    	  // Line From Top-Left corner to Middle
	      gc.strokeLine(0, 0, endX, endY);
    	  // Line From Bottom-Right corner to Middle
	      gc.strokeLine(canvas.getWidth(), canvas.getHeight(), endX, endY);
	      
    	  // Line From Bottom-Left corner to Middle
	      gc.strokeLine(0, canvas.getHeight(), endY, endY);
	      
    	  // Line From Top-Right corner to Middle
	      gc.strokeLine(canvas.getWidth(), 0, endX, endX);
	      
    	  // X-Lines
	      //gc.strokeLine(endY, 300, endX, 0);
    	  
    	  // Art
    	  // Top-Left -> Bottom-Right -> Bottom-Left - Top-Right
	      gc.strokeLine(endX, 0, 0, endY);
	      gc.strokeLine(endX, canvas.getHeight(), canvas.getWidth(), endY);
	      gc.strokeLine(0, endY, endY, canvas.getHeight());
	      gc.strokeLine(canvas.getWidth(), endX, endX, 0);

          System.out.printf("%.2f %.2f%n", endX, endY);
      }
      
      // draw line from upper-right to lower-left corner
      /*
      double stepSizeX = canvas.getWidth() / numSteps;
      double stepSizeY = canvas.getHeight() / numSteps;
      
      for (int i = 0; i < numSteps; i++) {
          double endX = stepSizeX * (i);
          double endY = canvas.getHeight() - stepSizeY * (i);
          gc.strokeLine(0, 0, endX, endY);
          System.out.printf("%.2f %.2f    -> ", endX, endY);
          System.out.printf("%.2f %.2f%n", stepSizeX, stepSizeY);
      }
       */
      // draw line from upper-left to lower-right corner
      //gc.strokeLine(0, 0, canvas.getWidth(), canvas.getHeight());

      //gc.strokeLine(canvas.getWidth(), 0, 0, canvas.getHeight());

   }
}
