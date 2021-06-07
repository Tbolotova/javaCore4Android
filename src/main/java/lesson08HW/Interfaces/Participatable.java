package lesson08HW.Interfaces;

public interface Participatable {
    boolean run (int runLimit, int distance);
    boolean jump (double jumpLimit, double height);
    int getRunLimit();
    double getJumpLimit();
    String toString();
}
