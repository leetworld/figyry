package org.example.task2_figura;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Square implements Shape {
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(Color.BLUE);
        gc.fillRect(50, 50, 200, 200);
    }
}