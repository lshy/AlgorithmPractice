package programmers.hash;


import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Solution3 {

    class Music implements Comparable<Music> {
        public int plays;
        public int no;
        public int total;

        public Music(int plays, int no, int total) {
            this.plays = plays;
            this.no = no;
            this.total = total;
        }

        @Override
        public int compareTo(Music o) {
            if(total == o.total){
                if(plays == o.plays){
                    return no > o.no? 1 : -1;
                }else{
                    return plays >o.plays ? -1 : 1;
                }

            }else{
                return total > o.total ? -1 : 1;
            }
        }
    }

    public int[] solution(String[] genres, int[] plays) {


        HashMap<String, Integer> hashMap = new HashMap<>();

        int lenght = genres.length;

        for(int i = 0; i< lenght; i++){
            if(hashMap.containsKey(genres[i])){
                hashMap.replace(genres[i], hashMap.get(genres[i]) + plays[i]);
            }else{
                hashMap.put(genres[i], plays[i]);
            }
        }

        List<Music> musicList = new ArrayList<>();

        for(int i=0; i< lenght; i++){
            musicList.add(new Music(plays[i], i, hashMap.get(genres[i]).intValue()));
        }

        Collections.sort(musicList);


        List<Integer> ans = new LinkedList<>();

        int tmp = 0;
        int count = 0;
        for(int i=0; i< lenght; i++){
            if(tmp != musicList.get(i).total){
                count = 1;
                tmp = musicList.get(i).total;
                ans.add(musicList.get(i).no);
            }else{
                if(count <2){
                    ans.add(musicList.get(i).no);
                    count++;
                }
            }
        }

        int[] answer = ans.stream().mapToInt(i->i).toArray();



        return answer;
    }
}
