package com.fsavage.classexample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoItem {
  private static final String TAG = "ToDoList";    /** Called when the activity is first created. */

  String task;
  Date created;
  
  public String getTask() {
    return task;
  }
  
  public Date getCreated() {
    return created;    
  }

  public ToDoItem(String _task) {
    this(_task, new Date(java.lang.System.currentTimeMillis()));
  }
  
  public ToDoItem(String _task, Date _created) {
    task = _task;
    created = _created;
  }

  @Override
  public String toString() {
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    String dateString = sdf.format(created);  
    return "(" + dateString +  ") " + task; 
  }
}
