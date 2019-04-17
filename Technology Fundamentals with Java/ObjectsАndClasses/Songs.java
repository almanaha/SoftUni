package ObjectsАndClasses;

import java.util.*;
import java.util.stream.Collectors;

public class Songs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int album = Integer.parseInt(sc.nextLine());
        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < album; i++) {
            String[] data = sc.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String length = data[2];

            Song song = new Song(type, name, length);
            songs.add(song);
        }

        String albumType = sc.nextLine();
        if (albumType.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            songs.stream().filter(e -> e.getTypeList().equals(albumType))
                    .forEach(e -> System.out.println(e.getName()));

//            for (Song song : songs) {
//                if (song.getTypeList().equals(albumType)){
//                    System.out.println(song.getName());
//                }
//            }
        }
    }

    public static class Song {
        private String typeList;
        private String name;
        private String time;

        public Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

        public String getTypeList() {
            return typeList;
        }

        public void setTypeList(String typeList) {
            this.typeList = typeList;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }


    }
}
