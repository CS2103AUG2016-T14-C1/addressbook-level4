package seedu.todoList.ui;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import seedu.todoList.model.task.ReadOnlyTask;

public class EventCard extends UiPart{

    private static final String FXML = "EventCard.fxml";

    @FXML
    private HBox cardPane;
    @FXML
    private Label id;
    @FXML
    private Label date;
    @FXML
    private Label startTime;
    @FXML
    private Label endTime;

    private ReadOnlyTask task;
    private int displayedIndex;

    public EventCard(){

    }

    public static EventCard load(ReadOnlyTask task, int displayedIndex){
        EventCard card = new EventCard();
        card.task = task;
        card.displayedIndex = displayedIndex;
        return UiPartLoader.loadUiPart(card);
    }

    @FXML
    public void initialize() {
        id.setText(displayedIndex + ". ");
<<<<<<< HEAD:src/main/java/seedu/todoList/ui/TaskCard.java
        Todo.setText(task.getTodo().value);
=======
        date.setText(task.getDate().value);
        startTime.setText(task.getStartTime().value);
        endTime.setText(task.getEndTime().value);
>>>>>>> 599478dd0130f46dae3a83f7da3f6c2fd212f22d:src/main/java/seedu/todoList/ui/EventCard.java
    }

    public HBox getLayout() {
        return cardPane;
    }

    @Override
    public void setNode(Node node) {
        cardPane = (HBox)node;
    }

    @Override
    public String getFxmlPath() {
        return FXML;
    }
}
