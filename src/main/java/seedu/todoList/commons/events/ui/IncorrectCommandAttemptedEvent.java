package seedu.todoList.commons.events.ui;

import seedu.address.logic.commands.Command;
import seedu.todoList.commons.events.BaseEvent;

/**
 * Indicates an attempt to execute an incorrect command
 */
public class IncorrectCommandAttemptedEvent extends BaseEvent {

    public IncorrectCommandAttemptedEvent(Command command) {}

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

}