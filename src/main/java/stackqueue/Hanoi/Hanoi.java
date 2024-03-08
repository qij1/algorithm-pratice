package stackqueue.Hanoi;

public class Hanoi {

    public static void main(String[] args) {
        hanoiProblem1(3, "left", "mid", "right");
    }

    public static int hanoiProblem1(int num, String left, String mid, String right) {
        if (num < 1) {
            return 0;
        }
        return process(num, left, mid, right, left, right);
    }

    public static int process(int num, String left, String mid, String right,
                              String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                System.out.println("Move 1 from " + from + " to  " + to);
                return 1;
            } else {
                System.out.println("Move 1 from " + from + " to  " + mid);
                System.out.println("Move 1 from " + mid + " to  " + to);
                return 2;
            }
        }
        if(from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num-1, left, mid, right, from, another);
            int part2 = 1;
            System.out.println("Move " + num + " from " +from+ " to "+ to);
            int part3 = process(num-1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num-1, left, mid, right, from, to);
            System.out.println("Move " + num + " from " +from+ " to "+ mid);
            int part2 = 1;
            int part3 = process(num-1, left, mid, right, to, from);
            System.out.println("Move " + num + " from " +mid+ " to "+ to);
            int part4 = 1;
            int part5 = process(num-1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }

}
