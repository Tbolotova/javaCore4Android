package lesson08HW;

import lesson08HW.Interfaces.Jumpable;
import lesson08HW.Interfaces.Runnable;
import lesson08HW.Interfaces.Participatable;
import lesson08HW.Obstacles.RaceTrack;
import lesson08HW.Obstacles.Wall;
import lesson08HW.Participants.Cat;
import lesson08HW.Participants.Human;
import lesson08HW.Participants.Robot;
import java.util.Random;

public class Main {

    public static Random random = new Random();

    public static int participantsNum = 8;
    public static int obstaclesNum = 5;
    public static Object[] participants = new Object[participantsNum];
    public static Object[] obstacles = new Object[obstaclesNum];

    public static void main(String[] args) {
        fillParticipantsArray();
        fillObstaclesArray();
        startCompetition();
    }

    private static void fillParticipantsArray() {
        for (int i = 0; i < participantsNum; i++) {

            int classIdentifier = random.nextInt(3);

            if (classIdentifier == 0) {
                participants[i] = new Cat(random.nextInt(500), random.nextDouble());
            } else if (classIdentifier == 1) {
                participants[i] = new Human(random.nextInt(500), random.nextDouble());
            } else {
                participants[i] = new Robot(random.nextInt(500), random.nextDouble());
            }
        }
    }

    private static void fillObstaclesArray() {
        for (int i = 0; i < obstaclesNum; i++) {

            int classIdentifier = random.nextInt(2);

            if (classIdentifier == 0) {
                obstacles[i] = new RaceTrack(random.nextInt(500));
            } else {
                obstacles[i] = new Wall(random.nextDouble() + 0.01);
            }
        }
    }

    private static void startCompetition() {
        for (Object participant:participants) {
            if (participant instanceof Participatable) {
                Participatable participatable = (Participatable) participant;
                System.out.println("Участник  " + participant.toString() + " начинает прохождение препятствий.");
                for (Object obstacle:obstacles) {
                    if (obstacle instanceof Runnable) {
                        Runnable runnable = (Runnable) obstacle;
                        boolean goOn = participatable.run(participatable.getRunLimit(), runnable.getLength());
                        if (!goOn) {
                            break;
                        }
                    } else if (obstacle instanceof Jumpable) {
                        Jumpable jumpable = (Jumpable) obstacle;
                        boolean goOn = participatable.jump(participatable.getJumpLimit(), jumpable.getHeight());
                        if (!goOn) {
                            break;
                            
                        }
                    }
                }
            }
        }
    }


}
