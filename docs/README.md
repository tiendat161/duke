# User Guide
**Duke chatHub** is a **chatbot** that help users manage their tasks.

A User can simply **add**, **delete** or **markdone** a task via specific commands.

## Table of Contents
- [Requirements](#requirements)
- [Features](#features)
    - [Simple Graphic User Interface](#simple-graphic-user-interface)(GUI)
- [Usage](#usage)
    - [Add a task](#add-a-task)
    - [Delete a task](#delete-a-task)
    - [Mark done a task](#mark-done-a-task)
    - [Find a task](#find-a-task)
    - [Show all tasks](#show-all-task)
    - [Sort tasks in date order](#sort-all-task)
    - [Example of some usage](#Example-of-some-usages)
## Requirements
- Duke chatHub requires Java 11 to run.
- Limited usages in Command Line Interface.
## Features 
### Simple Graphic User Interface
Duke chatHub comes with a simple GUI to run and process commands .
<img src = "Ui.png" width = "250"

## Usage
### Add a task 
The User can add a task.
There are 3 type of tasks: `Todo`, `Event` and `Deadline`.
1. To add a **Todo** task: `Todo [description]`
2. To add a **Deadline** task: `Deadline [description] /by [DateTime]`
3. To add a **Event** task: `Event [description] /at [DateTime]`
### Delete a task
The User can delete a task.
To *delete* a task, type command: `delete [Task Number]`
### Mark done a task
The User can mark done a task.
To **mark done** a task, type command: `done [Task Number]`
### Find a task
The User can find a task in the list.
To **find** a task with a keyword, type command: `find [keyword]`
### Show all task
The User can show the list of all the tasks.
To **show all tasks**, type command: `list`
### Sort all task
The User can sort the list of tasks in Date order.
To **sort the list**, type command: `sort`
### Terminate the programme
The User can close the programme by simply type 'bye'
To **Terminate**, type command: `bye`

### Example of some usages
Finds a list of tasks from the task list which contains *[keyword]*.
Example of usage: `find homework`\
Sample Expected outcome: \
`Great, I have found 1 tasks that match your keyword:` 
`8:[T][x] CS2103 homework`
