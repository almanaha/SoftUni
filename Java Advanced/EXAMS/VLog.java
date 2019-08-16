package EXAMS;
import java.util.*;

public class VLog {
    static class Vlogger{
        private String name;
        private Set<Vlogger> followers;
        private Set<Vlogger> following;

        public Vlogger(String name) {
            this.name = name;
            this.followers = new HashSet<>();
            this.following = new HashSet<>();
        }

        public void follow(Vlogger v){
            if (v == this) {
                return;
            }
            this.followers.add(v);

        }

        public void addFollowing(Vlogger v){
            if (v == this) {
                return;
            }
            this.following.add(v);
        }

        public String getName() {
            return name;
        }

        public int getFollowersSize() {
            return this.followers.size();
        }
        public int getFollowingSize() {
            return this.following.size();
        }

        public String toFullString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.toBasicString()).append("\n");
            for (Vlogger f : followers) {
               sb.append(" * ").append(f.getName()).append("\n");
            }
            return sb.toString();
        }
        public String toBasicString() {
            return String.format("%s : %d followers, %d following",
                    this.name,
                    this.getFollowersSize(),
                    this.getFollowingSize());
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Vlogger> vloggers = new TreeMap<>();

        String input = sc.nextLine();
        while (!input.equals("Statistics")){
            String[] data = input.split("\\s+");

            if (data[1].equals("joined")){
                if (vloggers.containsKey(data[0])){
                    continue;
                }

                Vlogger vlogger = new Vlogger(data[0]);
                vloggers.put(data[0],vlogger);
            }else{
                Vlogger follower = vloggers.get(data[0]);
                Vlogger followed = vloggers.get(data[1]);

                if (follower == null || followed == null){
                    input = sc.nextLine();
                    continue;
                }

                followed.follow(follower);
                follower.addFollowing(followed);

                vloggers.put(followed.getName(), followed);
                vloggers.put(follower.getName(), follower);
            }
            input = sc.nextLine();
        }
//        List<Vlogger> sorted = vloggers.values()
//                .stream()
//                .sorted((f,s) -> {
//                    int diff = f.getFollowersSize() - s.getFollowersSize();
//
//
//                })
//                .collect(Collectors.toList());
//
//        System.out.printf("The V-Loggers has a total of %d vloggers in its logs.%n", sorted.size());
//        System.out.print("1. " + sorted.get(0).toFullString());
//        for (int i = 0; i < sorted.size(); i++) {
//            System.out.println(i + 1 + " ");
//        }


    }
}
