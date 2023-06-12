package momento;
import java.util.ArrayDeque;
import java.util.Deque;

class Originator<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public void printValue() {
        System.out.println(value);
    }

    public Memento<T> getMemento() {
        return new Memento<>(value);
    }

    public void setMemento(Memento<T> memento) {
        this.value = memento.value;
    }

    static class Memento<T> {
        private final T value;

        private Memento(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }
}

class Caretaker<T> {
    private final Originator<T> originator;
    private final Deque<Originator.Memento<T>> undoStack = new ArrayDeque<>();
    private final Deque<Originator.Memento<T>> redoStack = new ArrayDeque<>();

    Caretaker(Originator<T> originator) {
        this.originator = originator;
    }

    public void beforeValueChanged() {
        undoStack.push(originator.getMemento());
        redoStack.clear();
    }

    public void undo() {
        // TODO implement this method
        if (!undoStack.isEmpty()) {
            originator.setValue( undoStack.pop().getValue());

        }
    }

    public void redo() {
        // TODO implement this method
        if (!redoStack.isEmpty()) {
            originator.setValue(redoStack.getFirst().getValue());

        }
    }


}