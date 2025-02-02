package org.example.task2_figura;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape {

    @Override
    void draw(GraphicsContext gc, double x, double y, Color color) {
        gc.setStroke(color); // Устанавливаем цвет линии
        gc.setLineWidth(2); // Устанавливаем толщину линии (опционально)
        gc.beginPath();
        gc.moveTo(x, y); // Начальная точка линии
        gc.lineTo(x + 100, y + 50); // Конечная точка линии
        gc.stroke(); // Рисуем линию
    }

    @Override
    void updateColor(Color newColor) {
        super.color = newColor;
    }
}