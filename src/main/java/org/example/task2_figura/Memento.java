package org.example.task2_figura;

import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Memento {
    private Shape shape; // Фигура
    private double strokeWidth; // Толщина обводки
    private Color strokeColor; // Цвет обводки

    // Конструктор для создания снимка состояния
    public Memento(Shape shape) {
        this.shape = shape;
        this.strokeWidth = shape.getStrokeWidth();
        this.strokeColor = (Color) shape.getStroke();
    }

    // Восстановление состояния фигуры
    public Shape getState() {
        shape.setStrokeWidth(strokeWidth);
        shape.setStroke(strokeColor);
        return shape;
    }

    // Выделение фигуры (изменение свойств)
    public Shape initState() {
        shape.setStrokeWidth(2); // Увеличиваем толщину обводки
        shape.setStroke(Color.RED); // Меняем цвет обводки
        return shape;
    }
}