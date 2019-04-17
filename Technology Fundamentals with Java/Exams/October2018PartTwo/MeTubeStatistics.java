package Exams.October2018PartTwo;

import java.util.*;

public class MeTubeStatistics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String,Integer> videosAndViews = new HashMap<>();
        Map<String,Integer> videosAndLikes = new HashMap<>();

        String input;
        while (!"stats time".equals(input = sc.nextLine())){
            if (input.contains("-")){
                String[] data = input.split("-");
                String videos = data[0];
                int views = Integer.parseInt(data[1]);

                videosAndViews.putIfAbsent(videos,0);
                videosAndLikes.putIfAbsent(videos,0);
                videosAndViews.put(videos,videosAndViews.get(videos) + views);
            }else{
                String[] data = input.split(":");
                String videos = data[1];
                videosAndLikes.putIfAbsent(videos,0);
                switch (data[0]){
                    case "like":
                        videosAndLikes.put(videos,videosAndLikes.get(videos) + 1);
                        break;
                    case "dislike":
                        videosAndLikes.put(videos,videosAndLikes.get(videos) - 1);
                        break;
                }
            }
        }

        String sort = sc.nextLine();
        if (sort.equals("by views")){
            videosAndViews.entrySet().stream().sorted((a,b) ->
                    b.getValue().compareTo(a.getValue()))
                    .forEach(e -> System.out.printf("%s - %d views - %d likes%n",
                    e.getKey(),e.getValue(),videosAndLikes.get(e.getKey())));
        }else {
            videosAndLikes.entrySet().stream().sorted((a,b) ->
                    b.getValue().compareTo(a.getValue()))
                    .forEach(e -> System.out.printf("%s - %d views - %d likes%n",
                            e.getKey(),videosAndViews.get(e.getKey()),e.getValue()));
        }

    }
}
