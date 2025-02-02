package org.example.task2_figura;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Pentagon implements Shape {
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.ORANGE);
        gc.fillPolygon(new double[]{150, 250, 200, 100, 50},
                new double[]{50, 150, 250, 250, 150}, 5);
    }
}