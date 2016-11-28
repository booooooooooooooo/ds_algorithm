import java.util.*;
public class Poj3669_AC {
	public static class set
	{
		int x,y,t;
		set(int x,int y,int time)
		{
			this.x=x;this.y=y;t=time;
		}
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m=in.nextInt();
		int[][] dest=new int[303][303];
		for(int i=0;i<=302;i++)
		for(int j=0;j<=302;j++)
			dest[i][j]=10000;
		boolean[][] map=new boolean[303][303];
		int[] vx={0,0,1,-1},vy={1,-1,0,0};
		for(int i=0;i<m;i++)
		{
			int x=in.nextInt(),y=in.nextInt(),t=in.nextInt();
			if(dest[x][y]>t) dest[x][y]=t;
			for(int j=0;j<4;j++)
			{
				int a=x+vx[j],b=y+vy[j];
				if(0<=a&&a<=301&&0<=b&&b<=301&&dest[a][b]>t)
					dest[a][b]=t;
			}
		}
		Queue<set> q=new LinkedList<set>();
		q.add(new set(0,0,0));map[0][0]=true;int time=-1;
		while(!q.isEmpty())
		{
			set loc=q.poll();
			if(dest[loc.x][loc.y]!=10000&&loc.t<dest[loc.x][loc.y])
			{
				for(int i=0;i<4;i++)
				{
					int a=loc.x+vx[i],b=loc.y+vy[i];
					if(0<=a&&a<=302&&0<=b&&b<=302&&!map[a][b])
					{ q.add(new set(a,b,loc.t+1));map[a][b]=true; }
				}
			}
			else if(dest[loc.x][loc.y]==10000) { time=loc.t;break; }
		}
		System.out.println(time);
	}
}
