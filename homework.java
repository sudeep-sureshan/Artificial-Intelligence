import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.lang.*;

class Eval
{
		public int calc_gamescore(grid g, String p, int n,String I_Player)
	{
		int x_score= 0;
	    int o_score =0;
		for(int i=0; i< n;i++)
		{
			for(int j=0;j< n;j++)
			{
				if(g.s[i][j].player.equalsIgnoreCase("X"))
				{
					x_score += g.s[i][j].getValue();
				}
				else if (g.s[i][j].player.equalsIgnoreCase("O"))
				{
					o_score+= g.s[i][j].getValue();
				}
			}
		}
		if(p.contentEquals("X"))
			return x_score-o_score;
		else
			return o_score-x_score;
	}
}
class Square
{
				int value=0;
				boolean occupied = false;
				String player;
				public boolean isOccupied()
				{
					return (this.occupied);
				}
				public int getValue()
				{
					return (this.value);
				}
				public String getPlayer()
				{
					return this.player;
				}

}
public class homework
{
	int size;
	String mode;
	String turn;
	int f_depth;
	String f_move;  // stake or raid
    Square[][] grid_1;  // use this for calculation
    int game_score=0;  // diff between x and o
		public static void main(String[] args) throws IOException
		{
			homework call= new homework();
			call.solve();
		}
		public void solve()throws IOException
		{
	        Scanner sc = new Scanner(new File("input.txt"));
	        size = Integer.parseInt(sc.nextLine());  // the size of the maze
	        mode = sc.nextLine();   // the mode of playing
	        turn= sc.nextLine();  // whose turn 'X' or 'O'
	        Player player;
	        if(turn.contentEquals("X"))
	        	player=Player.X;
	        else
	        	player=Player.O;

	        f_depth= Integer.parseInt(sc.nextLine()); // depth value
	        grid_1= new Square[size][size]; // matrix to store the values of each position
	        String line;
	        String words[];
	        for(int i=0;i<size;i++)
		        {
		        	line=sc.nextLine();
				    words=line.split("\\s+");
		        	for(int j=0;j<size;j++)
			        	{
		        		   grid_1[i][j] = new Square();
			        	  	(grid_1[i][j]).value = Integer.parseInt(words[j]);

			        	}
		        }
	        for(int i=0;i<size;i++)
		        {
		        	line=sc.nextLine();
		        	for(int j=0;j<size;j++)
			        	{
		        		    grid_1[i][j].player=String.valueOf(line.charAt(j));
		        		    if(line.charAt(j) == 'X')
		        		    {
		        		    	grid_1[i][j].occupied = true;
		        		    }
		        		    else if(line.charAt(j) == 'O')
		        		    {
		        		    	grid_1[i][j].occupied = true;
		        		    }

			        	}
		        }
	        grid g = new grid(size, grid_1);
	        if(mode.equalsIgnoreCase("MINIMAX"))
		        {
		        	MM obj1= new MM();
		        	Eval e =new Eval();
		        	obj1.minimax(g,f_depth,player,e,size,grid_1,turn);
		        }
	        else if(mode.equalsIgnoreCase("ALPHABETA"))
		        {
	        	AB obj1= new AB();
	        	Eval e =new Eval();
	        	obj1.alphabeta(g,f_depth,player,e,size,grid_1,turn);
                // MM obj1= new MM();
		        // Eval e =new Eval();
		        // obj1.minimax(g,f_depth,player,e,size,grid_1,turn);
		        }
		}

}
