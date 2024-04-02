import java.util.*;

public class hw11 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor == newColor) // prevents infinite loop
            return image;
        
        int w = image.length;
        int l = image[0].length;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int[] pix = queue.poll();
            int r = pix[0];
            int c = pix[1];

            if(image[r][c] == oldColor){
                image[r][c] = newColor;

                if(r>0)
                    queue.add(new int[]{r-1,c});
                if(r<w-1)
                    queue.add(new int[]{r+1,c});
                if(c>0)
                    queue.add(new int[]{r,c-1});
                if(c<l-1)
                    queue.add(new int[]{r,c+1});
            }
        }

        return image;

    }

    public static void main(String[] args){
        // int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        // hw11 test = new hw11();
        // for(int[]row:image)
        //     System.out.println(Arrays.toString(row));

        // int[][] result = test.floodFill(image,1,1,2);
        // System.out.println();
        // for(int[]row:result)
        //     System.out.println(Arrays.toString(row));
        // System.out.println();

    }
}
