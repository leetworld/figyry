package org.example.task2_figura;

import java.util.ArrayDeque;
import java.util.Queue;

public class MemoSelect {
    private Queue<Memento> mementoList = new ArrayDeque<>(); // Очередь для хранения состояний

    // Добавление состояния в очередь
    public void push(Memento state) {
        mementoList.add(state);
    }

    // Извлечение состояния из очереди
    public Memento poll() {
        return mementoList.poll();
    }
}