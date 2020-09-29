# User Guide

## Features 

### Feature 1 
Add a standard task.

## Usage

### `Keyword` - todo

Type todo followed by the description of the task.

Example of usage: 

`todo do homework`

Expected outcome:

`------------------------------------------------------------`<br/>
`[T][X]do homework`<br/>
`Got it. I've added this task.`<br/>
`Now you have 1 task in the list`<br/>
`------------------------------------------------------------`<br/>

### Feature 2 
Add a task that has a deadline.

## Usage

### `Keyword` - deadline

Type deadline followed by the description of the task. Then type '/by' and the date
of the deadline in the format yyyy-mm-dd.

Example of usage: 

`deadline individual project /by 2020-10-02`

Expected outcome:

`------------------------------------------------------------`<br/>
`[D][X]individual project (by: Oct 2 2020)`<br/>
`Got it. I've added this task.`<br/>
`Now you have 2 tasks in the list`<br/>
`------------------------------------------------------------`<br/>

### Feature 3 
Add an event that has a date.

## Usage

### `Keyword` - event

Type event followed by the description of the task. Then type '/at' and the time
of the event.

Example of usage: 

`event team meeting /at Sunday`

Expected outcome:

`------------------------------------------------------------`<br/>
`[E][X]team meeting (at: Sunday)`<br/>
`Got it. I've added this task.`<br/>
`Now you have 3 tasks in the list`<br/>
`------------------------------------------------------------`<br/>

### Feature 4 
Show the task list.

## Usage

### `Keyword` - list

Type list.

Example of usage: 

`list`

Expected outcome:

`------------------------------------------------------------`<br/>
`Here are the tasks in your list`<br/>
`1.[T][x]do homework`<br/>
`2.[D][X]individual project (by: Oct 2 2020)`<br/>
`3.[E][X]team meeting (at: Sunday)`<br/>
`------------------------------------------------------------`<br/>

### Feature 4 
Mark the tasks as done.

## Usage

### `Keyword` - done

Type done and the index of the task that you want to mark as done.

Example of usage: 

`done 2`

Expected outcome:

`------------------------------------------------------------`<br/>
`Nice! I've marked this task as done:`<br/>
`[v]individual project (by: Oct 2 2020)`<br/>
`------------------------------------------------------------`<br/>

### Feature 5 
delete a task from the task list.

## Usage

### `Keyword` - delete

Type delete and the index of the task that you want to delete.

Example of usage: 

`delete 2`

Expected outcome:

`[D][v]individual project (by: Oct 2 2020)`<br/>
`------------------------------------------------------------`<br/>
`Noted. I've removed this task:`<br/>
`Now you have 2 tasks in the list`<br/>
`------------------------------------------------------------`<br/>

### Feature 6 
find tasks that matche the keyword from the task list.

## Usage

### `Keyword` - find

Type find followed by the keyword.

Example of usage: 

`find homework`

Expected outcome:

`------------------------------------------------------------`<br/>
`Here are the matching tasks in your list:`<br/>
`1. [T][X]do homework`<br/>
`------------------------------------------------------------`<br/>

### Feature 7 
Exit the program.

## Usage

### `Keyword` - bye

Type bye to exit.

Example of usage: 

`bye`

Expected outcome:

`------------------------------------------------------------`<br/>
`Bye. Hope to see you again soon!`<br/>
`------------------------------------------------------------`<br/>