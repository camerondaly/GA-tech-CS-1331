public class Gameplay {
    public static void main(String[] args) {
        BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
        BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
        BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
        BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);
        RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
        RedAstronaut suspiciousPerson = new RedAstronaut("Suspicious Person", 100, "expert");
        // 1 pass
        liam.sabotage(bob);
        System.out.println(bob);
        // 2 pass
        System.out.println(suspiciousPerson);
        liam.freeze(suspiciousPerson);
        System.out.println(suspiciousPerson);
        // 3 pass
        liam.freeze(albert);
        System.out.println(liam);
        System.out.println(albert);
        // 4 pass
        albert.emergencyMeeting();
        // 5 pass
        suspiciousPerson.emergencyMeeting();
        // 6 pass
        bob.emergencyMeeting();
        // 7 pass
        heath.completeTask();
        System.out.println(heath);
        // 8 pass
        heath.completeTask();
        System.out.println(heath);
        // 9 pass
        heath.completeTask();
        System.out.println(heath);
        // 10 pass
        System.out.println("Test #10...");
        liam.freeze(angel);
        System.out.println(angel);
        System.out.println(liam);
        // 11 pass
        System.out.println("Test #11...");
        liam.sabotage(bob);
        liam.sabotage(bob);
        System.out.println(bob);
        // 12  pass
        liam.freeze(bob);
        System.out.println(bob);
        // 13 pass
        angel.emergencyMeeting();
        System.out.println(liam);
    }
}
