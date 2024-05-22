import javax.swing.JOptionPane;

public class Task {
     String taskName = "";
     String taskDescription = "";
    public int numTasks = 0;
    public int totalHours = 0;
    public String developerDetails;
    String taskID;








    public boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    public String createTaskID(int taskNumber) {
        return "TASK: " + taskNumber;
    }

    public String outputTaskDetails(String taskName, int taskNumber, String taskDescription,
                                   String developerDetails, int taskDuration, String taskID, String taskStatus) {
        return "Task Name: " + taskName + "\n" +
                "Task Number: " + taskNumber + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Duration: " + taskDuration + " hours\n" +
                "Task ID: " + taskID + "\n" +
                "Task Status: " + taskStatus;
    }

    public int returnTotalHours(int totalHours) {
        return totalHours;
    }

    public void setTaskNameAndDesc(String name,String description){
        this.taskName = name;
        this.taskDescription = description;
    }
}