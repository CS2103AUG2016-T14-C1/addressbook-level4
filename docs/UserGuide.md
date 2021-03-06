# User Guide

* [Description](#description)
* [String the program](#starting-the-program)
* [Features](#features)
* [Command Summary](#command-summary)

<!-- @@author A0144061U -->
##Description
Tdoo Schedule Manager is a Command Line Interface Task Management Application that helps you manage your workflow.<br>
There are three main types of a task: Todo, Event and Deadline. Todo is a floating task that does not have a specific starting or ending time. When adding a Todo, you can set the priority of the task, so that you can strategise your work priority. Event is a task with specific start and end date/time. Deadline is a task with only end date and time. All three types of tasks can be marked as 'done' by the user, which is indicated by green in the interface. Events and Deadlines will be marked as 'Overdue', which is indicated by red, once the current time passes the end date/time, if they are not marked as 'done'. <br>
Once you type in a command to the command box, it will be reflected in the three task lists with three different task types. For most of the commands, it is required to specifiy which type of task is to be manipulated. Refer to the [Features](#features) section for more detail.

## Starting the program

0. Ensure you have Java version `1.8.0_60` or later installed in your Computer.<br>
   > Having any Java 8 version is not enough. <br>
   This app will not work with earlier versions of Java 8.

1. Download the latest `Tdoo.jar` from the [releases](../../../releases) tab.
2. Copy the file to the folder you want to use as the home folder for your TodoList.
3. Double-click the file to start the app. The GUI should appear in a few seconds.
4. Type the command in the command box and press <kbd>Enter</kbd> to execute it.<br>
   e.g. typing **`help`** and pressing <kbd>Enter</kbd> will open the help window.
5. Refer to the [Features](#features) section below for details of each command.<br>

## Features

#### Viewing help : `help`
Show features and respective commands of the app.<br>
Format: `help`

<!-- @@author A0139923X -->
<a name="add"></a>
#### Adding a task: `add`
Adds a task to the task-list.<br>
Different Types of tasks (Todo/Event/Deadline) have different command format.<br>

###### Adding a Todo:
Todos will be rearranged in the Todo-List based on their priority.<br>
> Format: `add TASK_NAME p/PRIORITY`<br>
> Example: `add Assignment 3 p/1`

###### Adding an Event:
Events will be rearranged in the Event-List based on their starting time.<br>
> Format: `add TASK_NAME from/DATE to/ENDDATE at/START_TIME to/END_TIME`<br>
> Example: `add Tim's birthday party from/25-12-2016 to/26-12-2016 at/14:00 to/16:00`

###### Adding a Deadline:
Deadlines will be rearranged in the Deadline-List based on their ending time.<br>
> Format: `add TASK_NAME on/DATE at/END_TIME`<br>
> Example: `add CS2103 v0.2 on/25-12-2016 at/16:00`

<!-- @@author A0139923X -->
<a name="edit"></a>
#### Editing a task: `edit`
Edits information of the task in the task-list.<br>
Different Types of tasks (Todo/Event/Deadline) have different command format.<br>
You can change the data type of a task by editing it with a different command format. For example, if you edit a Todo task with an Event data format, the Todo task will be transfromed into an Event task.

###### Editing a Todo:
Todos will be rearranged in the Todo-List based on their priority.<br>
> Format: `edit TASK_TYPE INDEX_NUMBER name/TASK_NAME p/PRIORITY`<br>
> Example: `edit todo 1 name/Assignment p/2`

###### Editing an Event:
> Format: `edit TASK_TYPE INDEX_NUMBER name/TASK_NAME from/DATE to/ENDDATE at/START_TIME to/END_TIME`<br>
> Example: `edit event 1 name/Time's birthday party from/25-12-2016 to/26-12-2016 at/12:00 to/16:00`

###### Editing a Deadline:
> Format: `edit TASK_TYPE INDEX_NUMBER name/TASK_NAME on/DATE at/END_TIME`<br>
> Example: `edit deadline 1 name/CS2103 v0.2 on/25-12-2016 at/14:00`

<a name="delete"></a>
#### Deleting a task : `delete`
Delete a task with given type and index number.<br>
> Format: `delete TASK_TYPE INDEX_NUMBER`<br>
> Example(Todo): `delete todo 1` <br>
> Example(Event): `delete event 1` <br>
> Example(Deadline): `delete deadline 1`

<a name="done"></a>
#### Marking a completed task : `done`
Mark a Todo-task with given index number as done.<br>
> Format: `done TASK_TYPE INDEX_NUMBER`<br>
> Example(Todo): `done todo 1` <br>
> Example(Event): `done event 1` <br>
> Example(Deadline): `done deadline 1`

<!-- @@author A0139923X -->
<a name="undone"></a>
#### Un-Marking a completed task : `undone`
Mark a Todo-task with given index number as undone.<br>
> Format: `undone TASK_TYPE INDEX_NUMBER`<br>
> Example(Todo): `undone todo 1` <br>
> Example(Event): `undone event 1` <br>
> Example(Deadline): `undone deadline 1`

<a name="list"></a>
#### Listing all tasks : `list`
Shows a list of all tasks in the task-list.<br>
> Format: `list TASK_TYPE` <br>
> Example(Todo): `list todo` <br>
> Example(Event): `list event` <br>
> Example(Deadline): `list deadline` <br>
> Example(All): `list all`

<!-- @@author A0139923X -->
<a name="find"></a>
#### Finding all tasks containing any keyword in their name: `find`
Finds tasks whose names contain any of the given keywords.<br>
The order of the keywords does not matter, and tasks matching at least one keyword will be returned (i.e. `OR` search).<br>
Keywords can be either name of the task or the starting date of the task. <br>
> Format: `find TASK_TYPE KEYWORD [MORE_KEYWORDS]` <br>
> Example(all): `find all School work is fun` <br>
> Example(Todo): `find todo Study is good` <br>
> Example(Event): `find event Party all night long` <br>
> Example(Deadline): `find deadline Assignment to hand up today` <br>
> Example by Start Date: `find TASK_TYPE date/[By day,month,year or whole date(25th December 2016)]`

<!-- @@author A0144061U -->
<a name="clear"></a>
#### Clearing all tasks : `clear`
Clears all data in the given task type list.<br>
> Format: `clear TASK_TYPE` <br>
> Example(all): `clear all` <br>
> Example(Todo): `clear todo` <br>
> Example(Event): `clear event` <br>
> Example(Deadline): `clear deadline`

<a name="clear_done"></a>
#### Clearing all done tasks : `clear_done`
Clears all done tasks in the given task type list.<br>
> Format: `clear_done TASK_TYPE` <br>
> Example(all): `clear_done all` <br>
> Example(Todo): `clear_done todo` <br>
> Example(Event): `clear_done event` <br>
> Example(Deadline): `clear_done deadline`

<a name="undo"></a>
#### Undo the previous command: `undo`
Undo the latest command. If there is no previous command, nothing will happen.<br>
> Format: `undo`

<a name="storage"></a>
#### Change the Storage directory : `storage`
Change the storage directory of the app. If the given directory does not exist, the app will create a new directory with given name.<br>
> Format: `storage DIRECTORY` <br>
> Example: `storage /Desktop/Tdoo/date`

#### Exiting the program : `exit`
Exits the program.<br>
> Format: `exit`  

#### Rearrangement of task lists
Whenever a new task is added/edited/done, Elements in each list are sorted by their priority/date.<br>
For Todo List, the tasks are arranged by their priority; Todos with higher priority are shifted up and those with lower priority are shifted down.<br>
For Evnet/Deadline List, the tasks are arranged by their date. Those with earlier starting/ending date are shifted up and those with later starting/ending date are shifted down.

#### Saving the data
Task-list data are saved in the hard disk automatically after any command that changes the data.<br>


## Command Summary

Command 	| Format  
--------------- | :--------
Add	Todo	| `add TASK_NAME p/PRIORITY`
Add	Event	| `add TASK_NAME from/DATE to/ENDDATE at/START_TIME to/END_TIME`
Add	Deadline| `add TASK_NAME on/DATE at/END_TIME`
Edit	Todo	| `edit TASK_TYPE INDEX_NUMBER name/TASK_NAME p/PRIORITY`
Edit	Event	| `edit TASK_TYPE INDEX_NUMBER name/TASK_NAME from/DATE to/ENDDATE at/START_TIME to/END_TIME`
Edit	Deadline| `edit TASK_TYPE INDEX_NUMBER name/TASK_NAME on/DATE at/END_TIME`
Delete		| `delete TASK_TYPE INDEX_NUMBER`
Done		| `done TASK_TYPE INDEX_NUMBER`
Undone		| `undone TASK_TYPE INDEX_NUMBER`
List		| `list TASK_TYPE`
Find		| `find TASK_TYPE KEYWORD(S)`
Help		| `help`
Clear		| `clear TASK_TYPE`
Clear Done	| `clear_done TASK_TYPE`
Undo		| `undo`
Storage		| `storage DIRECTORY`
Exit		| `exit`
