import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class grid implements Cloneable
{
  Square s[][];
  int n;
  int grid_length;
  int grid_breadth;
		   grid(int n, Square a[][])
		   {
			   grid_length = n;
			   grid_breadth= n;
			   this.n = n;
			   this.grid_length = n;
			   this.grid_breadth= n;
			   s = new Square[n][n];
			   for(int i=0;i<n;i++)
			   {
				   for(int j=0;j<n;j++)
				   {
					   this.s[i][j] = new Square();
					   this.s[i][j].occupied = a[i][j].occupied;
					   this.s[i][j].value= a[i][j].value;
					   this.s[i][j].player = a[i][j].player;
				   }
			   }
		   }
	   public boolean isVaild(int x, int y,int size)
	   {
		   if(x>=0 && x<size && y>=0 && y<size)
		   {
			   return true;
		   }
		   else
			   return false;
	   }
	   public grid clone(int size)
		   {
		      return new grid(this.s,size);
		   }
	   private grid(Square a[][],int size)
	   {
			    this.s= new Square[size][size];
				   for(int i=0;i<size ;i++)
				   {
						   for(int j=0;j<size;j++)
						   {
							   this.s[i][j]=new Square();
							   this.s[i][j].occupied = a[i][j].occupied;
							   this.s[i][j].value=a[i][j].value;
							   this.s[i][j].player =a[i][j].player;
						   }
				   }
		   }
   public ArrayList<Location> unOccupied(grid g ,int size)
   {
	 ArrayList<Location> hm = new ArrayList<Location>();
	   for(int i=0;i<size;i++)
	   {
		   for(int j=0;j<size;j++)
		   {
			   if(g.s[i][j].isOccupied() == false)
			   {
				   //System.out.println("NOT OCCUPIED");
				   Location l =new Location(i,j);
				   hm.add(l);
			   }
		   }
       }
	  //System.out.println("HM size inside unouccpied fn "+hm.size());
     return hm;
    }

   public void make_move(int x,int y,String movetype, String player,int size)
	   {
					   if(this.isVaild(x,y,size))
					   {

						   if(movetype.equalsIgnoreCase("Stake"))
								   {
							          this.s[x][y].occupied = true;
							          (this.s[x][y].player) = player;
								   }
						   else if(movetype.equalsIgnoreCase("Raid"))
							   {
								   this.s[x][y].occupied = true;
							       (this.s[x][y].player) = player;
							       if(this.isVaild(x, y-1,size) && !(this.s[x][y-1].player.equalsIgnoreCase(player)) && (this.s[x][y-1].occupied))
							       {
							    	    this.s[x][y-1].occupied = true;
								       (this.s[x][y-1].player) = player;
							       }
						          if(this.isVaild(x, y+1,size) && !(this.s[x][y+1].player.equalsIgnoreCase(player)) && (this.s[x][y+1].occupied))
							       {
							    	    this.s[x][y+1].occupied = true;
								       (this.s[x][y+1].player) = player;
							       }
						          if(this.isVaild(x+1, y,size) && !(this.s[x+1][y].player.equalsIgnoreCase(player))&& (this.s[x+1][y].occupied))
							       {
							    	    this.s[x+1][y].occupied = true;
								       (this.s[x+1][y].player) = player;
							       }
							       if(this.isVaild(x-1, y,size) && !(this.s[x-1][y].player.equalsIgnoreCase(player))&& (this.s[x-1][y].occupied))
								       {
								    	    this.s[x-1][y].occupied = true;
									       (this.s[x-1][y].player) = player;
								       }

							    }
			           }
	   }
		public boolean isFull(int size)
			{
				for(int i=0;i<size;i++)
				   {
						   for(int j=0;j<size;j++)
						   {
							   if(this.s[i][j].occupied == false )
								   return false;
						   }
				   }
			return true;

			}
}
