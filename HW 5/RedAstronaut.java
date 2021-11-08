import java.util.Arrays;

public class RedAstronaut extends Player implements Impostor {
    private String skill; 

    // Static constants
    public static final String DEFAULT_SKILL = "experienced";

    // Constructors
    public RedAstronaut(String name) {
        super(name, DEFAULT_SUSLEVEL);
        this.skill = DEFAULT_SKILL;
    }

    public RedAstronaut(String name, int susLevel, String skill) {
        super(name, susLevel);
        this.skill = skill.toLowerCase();
    }

    // Methods
    /**
     * This method holds a meeting and freezes the most suspicious Player, out of the 
     * remaining unfrozen players.
     */
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
     * Freezes the target player if they are not an Impostor, not already frozen,
     * and the target's susLevel is higher than the attacker's.
     */
    public void freeze(Player p) {
        if (this.isFrozen() || p.isFrozen() || p instanceof Impostor) {
            return;
        }
        if (this.compareTo(p) < 0) {
            p.setFrozen(true);
            System.out.println(this.getName() + " froze " + p.getName() + "!");
            gameOver();
        } else {
            this.setSusLevel(this.getSusLevel() * 2);
        }
    }

    /**
     * Increases the sus value of the target if the target is not an impostor, not frozen.
     * If the attacker's susLevel is under 20, the target's susLevel increases by 50%.
     * Otherwise, the target's susLevel increases by 25%
     * Rounds down to the nearest int! Math.floor(x)?
     */
    public void sabotage(Player p) {
        if (this.isFrozen() || p.isFrozen() || p instanceof Impostor) {
            return;
        }
        if (this.getSusLevel() < 20) {
            p.setSusLevel((int)Math.floor(p.getSusLevel() * 1.5));
        } else {
            p.setSusLevel((int)Math.floor(p.getSusLevel() * 1.25));
        }
    }

    public boolean equals(Object o) {
        if (o instanceof RedAstronaut) {
            RedAstronaut redAst = (RedAstronaut) o;
            return (this.getName() == redAst.getName() && this.isFrozen() == redAst.isFrozen()
                    && this.getSusLevel() == redAst.getSusLevel() && 
                    this.skill == redAst.getSkill());
        }
        return false;
    }

    public String toString() {
        String response = super.toString() + "I am an " + this.getSkill() + " player!";
        if (this.getSusLevel() > 15) {
            return response.toUpperCase();
        }
        return response;
    }

    public String getSkill() {
        return skill;
    }
}
