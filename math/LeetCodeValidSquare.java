import java.util.*;
public class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[] lines = new int[6];
        lines[0] = (p1[0] - p2[0])*(p1[0] - p2[0]) + (p1[1] - p2[1])*(p1[1] - p2[1]);
        lines[1] = (p1[0] - p3[0])*(p1[0] - p3[0]) + (p1[1] - p3[1])*(p1[1] - p3[1]);
        lines[2] = (p1[0] - p4[0])*(p1[0] - p4[0]) + (p1[1] - p4[1])*(p1[1] - p4[1]);
        lines[3] = (p2[0] - p3[0])*(p2[0] - p3[0]) + (p2[1] - p3[1])*(p2[1] - p3[1]);
        lines[4] = (p2[0] - p4[0])*(p2[0] - p4[0]) + (p2[1] - p4[1])*(p2[1] - p4[1]);
        lines[5] = (p3[0] - p4[0])* (p3[0] - p4[0])+ (p3[1] - p4[1])*(p3[1] - p4[1]);

        Arrays.sort(lines);

        if(!(lines[0] == lines[1] && lines[1] == lines[2] && lines[2] == lines[3])) return false;
        if(lines[4] != lines[5]) return false;
        if(lines[0] + lines[2] != lines[4]) return false;
        if(lines[0] == 0) return false;

        return true;

    }
}
