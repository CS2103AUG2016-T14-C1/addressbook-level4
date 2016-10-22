package seedu.todoList.model.task;

import seedu.todoList.commons.util.CollectionUtil;
import seedu.todoList.model.task.attributes.StartDate;
import seedu.todoList.model.task.attributes.EndTime;
import seedu.todoList.model.task.attributes.Name;
import seedu.todoList.model.task.attributes.Done;

/**
 * Represents a task in the TodoList.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Deadline extends Task implements ReadOnlyTask {

	private StartDate date;
    private EndTime endTime;
    private Done isDone;

    /**
     * Every field must be present and not null.
     */
    public Deadline(Name name, StartDate date, EndTime endTime, Done isDone) {
        assert !CollectionUtil.isAnyNull(name, date, endTime);
        super.name = name;
        this.date = date;
        this.endTime = endTime;
        this.isDone = isDone;
    }

    /**
     * Copy constructor.
     */
    public Deadline(Deadline source) {
        this(source.getName(), source.getDate(), source.getEndTime(),
        		source.getDone());
    }
    
    public Deadline(ReadOnlyTask source) {
    	this((Deadline) source);
    };
    
    public Done getDone(){
    	return isDone;
    }

    public StartDate getDate() {
        return date;
    }

    public EndTime getEndTime() {
        return endTime;
    }

    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Event // instanceof handles nulls
                && super.name.equals(((Event) other).getName())
                && this.date.equals(((Event) other).getDate())
				&& this.endTime.equals(((Event) other).getEndTime()));

    }

    @Override
    public String toString() {
    	final StringBuilder builder = new StringBuilder();
        builder.append(getName())
                .append("\nDate: ")
                .append(getDate())
                .append("\nEndTime: ")
                .append(getEndTime());
        return builder.toString();
    }

	public Deadline getDeadline() {
		// DEADLINE Auto-generated method stub
		return null;
	}
}
