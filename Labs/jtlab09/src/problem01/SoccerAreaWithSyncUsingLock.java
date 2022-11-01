//package problem01;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.concurrent.*;
//import java.util.concurrent.locks.*;
//
//public class SoccerAreaWithSyncUsingLock {
//    private static SoccerArea soccerArea = new SoccerArea();
//
//    public static void main(String[] args) {
//
//        Scanner input = new Scanner(System.in);
//        System.out.print("Bagiin toog oruul: ");
//        Integer m = input.nextInt();
//
//        ExecutorService executor = Executors.newCachedThreadPool();
//
//        for (int i = 0; i < m; i++) {
//            executor.execute(new AddTeamTask());
//        }
//
//        executor.shutdown();
//
//        while (!executor.isTerminated()) {
//        }
//
//        System.out.println(" " + soccerArea());
//    }
//
//    public static class AddTeamTask implements Runnable {
//        public void run() {
//            soccerArea.areaTeams(new Team("m1"));
//        }
//    }
//
//    public static class Team{
//        String name;
//
//        public Team(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//
//    public static class SoccerArea {
//        private static Lock lock = new ReentrantLock(); // Create a lock
//        private ArrayList<Team> areaTeams = new ArrayList<>();
//
//        public ArrayList<Team> getAreaTeams() {
//            return areaTeams;
//        }
//
//        public void receiveTeam(Team team) {
//            lock.lock();
//
//            try {
//                areaTeams.add(team);
//                Thread.sleep(5);
//            } catch (InterruptedException ex) {
//            } finally {
//                lock.unlock(); // Release the lock
//            }
//        }
//    }
//}