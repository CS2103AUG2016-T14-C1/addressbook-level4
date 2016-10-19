package seedu.todoList.logic.commands;

import seedu.todoList.commons.core.Messages;
import seedu.todoList.commons.core.UnmodifiableObservableList;
import seedu.todoList.commons.exceptions.IllegalValueException;
import seedu.todoList.model.task.*;
import seedu.todoList.model.task.UniqueTaskList.TaskNotFoundException;
import seedu.todoList.model.task.attributes.*;

/**
 * Edit a task identified using it's last displayed index from the TodoList.
 */
public class EditCommand extends Command {

    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits information of the task in the task-list.\n"
            + "Parameters: TASK_TYPE INDEX_NUMBER n/TASK_NAME p/PRIORITY\n"
            + "Example: " + COMMAND_WORD + " todo 1 n/Assignment 1 d/25-12-2016 p/2\n"
            + "Parameters: TASK_TYPE INDEX_NUMBER n/TASK_NAME d/DATE s/START_TIME e/END_TIME\n"
            + "Example: " + COMMAND_WORD + " event 1 n/Time's birthday party d/25-12-2016 s/1200 e/1600\n"
            + "Parameters: TASK_TYPE INDEX_NUMBER n/TASK_NAME d/DATE e/END_TIME\n"
            + "Example: " + COMMAND_WORD + " deadline 1 n/CS2103 v0.2 d/25-12-2016 e/1400";

    public static final String MESSAGE_EDIT_task_SUCCESS = "Edited task: %1$s";
    public static final String INVALID_VALUE = "Invalid value";
    public static final String MISSING_TASK = "The target task cannot be missing";
    public static final String MESSAGE_EDIT_DUPLICATE_TASK = "This task already exists in the Task-list";
    
    public final String dataType;
    public final int targetIndex;
    private final Task toEdit;
    
    /**
     * Edit Todo
     * Convenience constructor using raw values.
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public EditCommand(String name, String date, int priority, int targetIndex)
            throws IllegalValueException {
    	this.targetIndex = targetIndex;
    	this.dataType = "todo";
        this.toEdit = new Todo(
                new Name(name),
                new Date(date),
                new Priority(Integer.toString(priority))
        );
    }
    
    /**
     * Edit Event
     * Convenience constructor using raw values.
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public EditCommand(String name, String date, String startTime, String endTime, int targetIndex)
            throws IllegalValueException {
    	this.targetIndex = targetIndex;
    	this.dataType = "event";
        this.toEdit = new Event(
                new Name(name),
                new Date(date),
                new StartTime(startTime),
                new EndTime(endTime)
        );
    }
    
    /**
     * Edit Deadline
     * Convenience constructor using raw values.
     * @throws IllegalValueException if any of the raw values are invalid
     */
    public EditCommand(String name, String date, String endTime, int targetIndex)
            throws IllegalValueException {
    	this.targetIndex = targetIndex;
    	this.dataType = "deadline";
        this.toEdit = new Deadline(
                new Name(name),
                new Date(date),
                new EndTime(endTime)
        );
    }

    @Override
    public CommandResult execute() {
    	UnmodifiableObservableList<ReadOnlyTask> lastShownList = null;
    	switch (dataType) {
    		case "todo":
    			lastShownList = model.getFilteredTodoList();
    			break;
    		case "event":
    			lastShownList = model.getFilteredEventList();
    			break;
    		case "deadline":
    			lastShownList = model.getFilteredDeadlineList();
    	}
        if (lastShownList.size() < targetIndex) {
            indicateAttemptToExecuteIncorrectCommand();
            return new CommandResult(Messages.MESSAGE_INVALID_task_DISPLAYED_INDEX);
        }
        
        ReadOnlyTask taskToEdit = lastShownList.get(targetIndex - 1);
        
        assert model != null;
        try {
            model.editTask(taskToEdit, dataType, toEdit);
            return new CommandResult(String.format(MESSAGE_EDIT_task_SUCCESS, toEdit));
        } catch (IllegalValueException ive) {
        	return new CommandResult(INVALID_VALUE);
        }catch (TaskNotFoundException pnfe) {
            return new CommandResult(MISSING_TASK);
        }
    }
}
