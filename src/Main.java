import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        boolean quitProgram = false;
        Login user = new Login();

        user.firstName = JOptionPane.showInputDialog("Enter Your Your First Name");

        user.lastName = JOptionPane.showInputDialog("Enter Your Your Last Name");

        // ENTER USERNAME
        do{
            user.username = JOptionPane.showInputDialog("Enter Username: Username should be \n no more  than 5" +
                    " characters and\n contain an underscore(_) ");
            user.isValidUser = user.checkUserName(user.username);
            if(!user.isValidUser){
                JOptionPane.showMessageDialog(null,"Username is not correctly formatted, please ensure \n that your username contains an underscore\n  an is more than 5 characters in length");
            }else{
                JOptionPane.showMessageDialog(null,"Username successfully captured");
            }
        }while(!user.isValidUser);

        // ENTER PASSWORD
        do{
            user.password = JOptionPane.showInputDialog("""
                    Enter Password: Your Password Should More Than\s
                     8 Characters Long, Contain A Capital
                     Letter,Contain A Number,
                     And Also Contain A Special Character""");
            user.isValidPassword = user.checkPasswordComplexity(user.password);
            if(!user.isValidPassword){
                String message = "Password is not correctly formatted, please ensure that your password contains  at least 8 " +
                        " characters, a capital letter, a number and a special character";
                JOptionPane.showMessageDialog(null,message);
            }else{
                JOptionPane.showMessageDialog(null,"Password successfully captured");
            }
        }while(!user.isValidPassword);

        JOptionPane.showMessageDialog(null,user.registerUser(user.username,user.password));
//         USER LOG IN
        JOptionPane.showMessageDialog(null,"You Can Now Login Using The Same Credentials");
        do{
            String loginUsername = JOptionPane.showInputDialog("Login:\n USERNAME Credentials");
            String loginPassword = JOptionPane.showInputDialog("Login:\n PASSWORD Credentials");
            user.isLoginIn =  user.loginUser(loginUsername,loginPassword,user.username,user.password);
            if(!user.isLoginIn){
                JOptionPane.showMessageDialog(null,"Your login details do not match try again");
            }

        }while(!user.isLoginIn);

        user.returnLoginStatus(user.isLoginIn, user.firstName, user.lastName);

        //Task Feature

        JOptionPane.showMessageDialog(null,"Welcome to EasyKanban.");


        // Task Add
        Task task = new Task();

        // Loop Runs On Repeat Until user selects Quit To Exit Program
        do{
        String[] options = {"Add Tasks", "Show Report", "Quit"};
        int statusChoose = JOptionPane.showOptionDialog(null, "Choose An Option:", "Option Status",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        String optionStatus = options[statusChoose];

        // Check Condition if Option is Quit , Show Report or Add Tasks
        if(optionStatus.equals("Quit")){
            quitProgram = false;
            return;
        }else if(optionStatus.equals("Show Report")) {
            JOptionPane.showMessageDialog(null,"Coming Soon");
            quitProgram = true;
        }else if(optionStatus.equals("Add Tasks")){
            // Adding Tasks
            task.numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of tasks:"));
            // Loop number of tasks to be added
            for(int i = 1; i <= task.numTasks; i++) {
                task.taskName = JOptionPane.showInputDialog("Enter task name:");
                task.taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
                while (!task.checkTaskDescription(task.taskDescription)) {
                    task.taskDescription = JOptionPane.showInputDialog("Task description too long. Enter again (max 50 characters):");
                }

                task.developerDetails = JOptionPane.showInputDialog("Enter developer details:");
                int taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration (hours):"));
                task.totalHours += taskDuration;
                task.taskID = task.createTaskID(i);

                String[] statusOptions = {"To Do", "Doing", "Done"};
                int status = JOptionPane.showOptionDialog(null, "Select task status:", "Task Status",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, statusOptions, statusOptions[0]);
                String taskStatus = statusOptions[status];

                String taskDetails = task.outputTaskDetails(task.taskName, i, task.taskDescription, task.developerDetails, taskDuration, task.taskID, taskStatus);
                JOptionPane.showMessageDialog(null, taskDetails);

            }
            JOptionPane.showMessageDialog(null, "Total combined hours for all tasks: " + task.returnTotalHours(task.totalHours));
            quitProgram = true;
            task.totalHours = 0;
        }



    }while(quitProgram);
    }
}