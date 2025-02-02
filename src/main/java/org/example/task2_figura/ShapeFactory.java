package org.example.task2_figura;

public class ShapeFactory {
    public Shape createShape(int numberOfSides){
        switch (numberOfSides) {
            case 1:
                return new Circle(); // 1 - Круг
            case 2:
                return new Angle();  // 2 - Угол
            case 3:
                return new Square(); // 3 - Квадрат
            case 4:
                return new Straight(); // 4 - Линия
            case 5:
                return new Pentagon(); // 5 - Пятиугольник
            default:
                return null; // Некорректный ввод
        }
    }
}