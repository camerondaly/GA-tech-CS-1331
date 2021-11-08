import java.util.Arrays;

public class BlueAstronaut extends Player implements Crewmate {
    private int numTasks;
    private int taskSpeed;
    public static final int DEFAULT_NUMTASKS = 6;
    public static final int DEFAULT_TASKSPEED = 10;
    

    // Constructors
    public BlueAstronaut(String name) {
        super(name, DEFAULT_SUSLEVEL);
        this.numTasks = DEFAULT_NUMTASKS;
        this.taskSpeed = DEFAULT_TASKSPEED;
    }

    public BlueAstronaut(String name, int susLevel, int numTasks, int taskSpeed) {
        super(name, susLevel);
        this.numTasks = numTasks;
        this.taskSpeed = taskSpeed;
    }

    // Methods
    // Prompt asks to keep emergencyMeeting() as abstract in Player, so I guess I 
    // have to paste the code here as it is in RedAstronaut...
    public void emergencyMeeting() {
        if (this.isFrozen()) {
            System.out.println(this.getName() + " is frozen and cannot call a meeting. ");
            return;
        }
        System.out.println(this.getName() + " has called an emergency meeting... ");
        Player[] players = getPlayers();
        Arrays.sort(players);
        if (players[players.length-1].equals(this)) {
            System.out.println("The player who called the meeting is the most sus!");
            return;
        }
        int mostSusInd = players.length - 1;
        while (players[mostSusInd].isFrozen()) {
            mostSusInd -= 1;
        }
        if (players[mostSusInd].getSusLevel() != players[mostSusInd - 1].getSusLevel()) {
            players[mostSusInd].setFrozen(true);
            System.out.println(players[mostSusInd].getName() + " has been frozen!");
        } else{ 
            System.out.println("There is a tie!");
        }
        gameOver();
    }

    /**
     * BlueAstronaut that is frozen can't complete tasks!
     * if taskSpeed > 20, subtract 2 from numTasks, otherwise, subtract 1 from numTasks.
     * if numTasks < 0, set it to 0.
     * once numTasks hits 0 for the first time, print statement and reudce susLevel by 50%.
     */
    public void completeTask() {
        if (this.isFrozen() || this.numTasks == 0) {
            return;
        }
        if (this.taskSpeed > 20) {
            this.numTasks -= 2;
        } else {
            this.numTasks -= 1;
        }
        if (this.numTasks < 0) {
            this.numTasks = 0;
        }
        if (this.numTasks == 0) {
            System.out.println("I have completed all my tasks. ");
            this.setSusLevel((int)Math.floor(this.getSusLevel() * .5));
        }
    }

    public boolean equals(Object o) {
        if (o instanceof BlueAstronaut) {
            BlueAstronaut blueAst = (BlueAstronaut) o;
            return (this.getName() == blueAst.getName() && this.isFrozen() == blueAst.isFrozen()
                    && this.getSusLevel() == blueAst.getSusLevel() && 
                    this.numTasks == blueAst.getNumTasks() && this.taskSpeed == blueAst.getTaskSpeed());
        }
        return false;
    }

    public String toString() {
        String response = super.toString() + "I have " + this.numTasks + " left over.";
        if (this.getSusLevel() > 15) {
            return response.toUpperCase();
        }
        return response;
    }


    public int getNumTasks() {
        return this.numTasks;
    }

    public int getTaskSpeed() {
        return this.taskSpeed;
    }
}
