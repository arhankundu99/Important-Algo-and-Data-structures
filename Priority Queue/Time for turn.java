// https://leetcode.com/discuss/interview-question/2199394/Google-or-Phone-or-Time-for-turn
public class Main {
    public static void main(String[] args) {
        /*  
            n = 3
            times = [3,2,5]
            k = 4
        */
        int[] arr= {3,2,5};
        System.out.println(getTimeForJosephsTurn(arr, 4));

        //Queue(0,0,0) -> {1}Q(0,0,4) -> {2}Q(0,3,4) -> {3}Q(3,4,8) -> {4}Q(4,5,8)
    }

    public static int getTimeForJosephsTurn(int[] arr, int k) {

        Queue<Pair> q = new PriorityQueue<>((x, y) -> 
                            x.endTime - y.endTime == 0
                                ? x.index - y.index 
                                    : x.endTime - y.endTime);
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            q.offer(new Pair(i, 0));
        }

        for(int i = 0; i < k; i++) {
            Pair p = q.poll();
            int endTime = arr[p.index] + p.endTime;
            p.endTime = endTime;
            q.offer(p);
        }

        Pair josephT = q.poll();
        return arr[josephT.index] + josephT.endTime;

    }

    static class Pair{
        int index;
        int endTime;

        Pair(int index, int endTime) {
            this.index = index;
            this.endTime = endTime;
        }
    }
}