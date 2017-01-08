import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MP
{
  public ArrayList<String> moves_possible(grid g, String p,int size)
  {
	  String current;
	  String opp;
	  if (p.equals("X"))
	  {
		  current="X";
		  opp="O";
	  }
	  else
	  {
		  current="O";
		  opp="X";
	  }
   ArrayList<String> hm = new ArrayList<String>();
   ArrayList<Location> not_occupied = g.unOccupied(g,size);
   for(int i=0;i< not_occupied.size();i++)
   {

	   boolean c_left = false;
	   boolean c_right= false;
	   boolean c_bottom = false;
	   boolean c_top= false;
	   boolean o_left = false;
	   boolean o_right= false;
	   boolean o_bottom = false;
	   boolean o_top= false;
	  int x= not_occupied.get(i).x;
	  int y= not_occupied.get(i).y;
	  Location l=new Location(x,y);
	/*  //Special boxes
	  if(x==0)
	  {
		 if((g.s[x][y+1].player).equalsIgnoreCase(current))   //c_right
		    	 {
		    		 c_right=true;
		    	 }
		    	 if((g.s[x+1][y].player).equalsIgnoreCase(current)) //c_bottom
		    	 {
		    		 c_bottom=true;
		    	 }
		    	 if((g.s[x][y+1].player).equalsIgnoreCase(opp))  //o_right
		    	 {
		    		 o_right=true;
		    	 }
		    	 if((g.s[x+1][y].player).equalsIgnoreCase(opp))  // o_bottom
		    	 {
		    		 o_bottom=true;
		    	 }
		   if((c_right && c_bottom) || ( c_right && !(o_bottom) ) || (c_bottom && !(o_right) ) || (!o_right && !o_bottom) )
		   {
			   hm.put(l,"Stake");
			   continue;
		   }
		   else
		   {
			   hm.put(l,"Raid");
			   continue;
		   }

	  }//end of left corner case

	  //outer else
	       else
			  {*/
			     if(g.isVaild(x, y-1,size))  // for c_left
			     {
			    	 if((g.s[x][y-1].player).equalsIgnoreCase(current))
			    	 {
			    		 c_left=true;
			    	 }
			     }
			     if(g.isVaild(x,y+1,size))  //c_right
			     {
			    	 if((g.s[x][y+1].player).equalsIgnoreCase(current))
			    	 {
			    		 c_right=true;
			    	 }
			     }
			     if(g.isVaild(x+1, y,size))  //c_bottom
			     {
			    	 if((g.s[x+1][y].player).equalsIgnoreCase(current))
			    	 {
			    		 c_bottom=true;
			    	 }
			     }
			     if(g.isVaild(x-1, y,size))  //c_top
			     {
			    	 if((g.s[x-1][y].player).equalsIgnoreCase(current))
			    	 {
			    		 c_top=true;
			    	 }
			     }
			     if(g.isVaild(x, y-1,size))  // for o_left
			     {
			    	 if((g.s[x][y-1].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_left=true;
			    	 }
			     }
			     if(g.isVaild(x, y+1,size))  //o_right
			     {
			    	 if((g.s[x][y+1].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_right=true;
			    	 }
			     }
			     if(g.isVaild(x+1, y,size))  //o_bottom
			     {
			    	 if((g.s[x+1][y].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_bottom=true;
			    	 }
			     }
			     if(g.isVaild(x-1, y,size))  //0_top
			     {
			    	 if((g.s[x-1][y].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_top=true;
			    	 }
			     }
			     //checking conditions
				 if ( (c_left || c_right  || c_bottom  || c_top) && ( o_left || o_right  || o_bottom  || o_top ) ) // one or more of neighbours are current and opponent
				 {
					 hm.add(l.x+" "+l.y+" "+"Raid");
					 continue;
				 }
			   if(c_left && (o_right || o_bottom || o_top))
			   {
				   hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_right && (o_left || o_bottom || o_top))
			   {
				   hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_bottom && (o_left || o_right || o_top))
			   {
				   hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_top && (o_left || o_right || o_bottom))
			   {
				   hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   else
			   {
				   hm.add(l.x+" "+l.y+" "+"Stake");
			   }
   }
   return hm;
  }
  public ArrayList<String> moves_possible_stake(grid g, String p,int size)
  {
	  String current;
	  String opp;
	  if (p.equals("X"))
	  {
		  current="X";
		  opp="O";
	  }
	  else
	  {
		  current="O";
		  opp="X";
	  }
   ArrayList<String> hm = new ArrayList<String>();
   ArrayList<Location> not_occupied = g.unOccupied(g,size);
   for(int i=0;i< not_occupied.size();i++)
   {

	   boolean c_left = false;
	   boolean c_right= false;
	   boolean c_bottom = false;
	   boolean c_top= false;
	   boolean o_left = false;
	   boolean o_right= false;
	   boolean o_bottom = false;
	   boolean o_top= false;
	  int x= not_occupied.get(i).x;
	  int y= not_occupied.get(i).y;
	  Location l=new Location(x,y);
	/*  //Special boxes
	  if(x==0)
	  {
		 if((g.s[x][y+1].player).equalsIgnoreCase(current))   //c_right
		    	 {
		    		 c_right=true;
		    	 }
		    	 if((g.s[x+1][y].player).equalsIgnoreCase(current)) //c_bottom
		    	 {
		    		 c_bottom=true;
		    	 }
		    	 if((g.s[x][y+1].player).equalsIgnoreCase(opp))  //o_right
		    	 {
		    		 o_right=true;
		    	 }
		    	 if((g.s[x+1][y].player).equalsIgnoreCase(opp))  // o_bottom
		    	 {
		    		 o_bottom=true;
		    	 }
		   if((c_right && c_bottom) || ( c_right && !(o_bottom) ) || (c_bottom && !(o_right) ) || (!o_right && !o_bottom) )
		   {
			   hm.put(l,"Stake");
			   continue;
		   }
		   else
		   {
			   hm.put(l,"Raid");
			   continue;
		   }

	  }//end of left corner case

	  //outer else
	       else
			  {*/
			     if(g.isVaild(x, y-1,size))  // for c_left
			     {
			    	 if((g.s[x][y-1].player).equalsIgnoreCase(current))
			    	 {
			    		 c_left=true;
			    	 }
			     }
			     if(g.isVaild(x,y+1,size))  //c_right
			     {
			    	 if((g.s[x][y+1].player).equalsIgnoreCase(current))
			    	 {
			    		 c_right=true;
			    	 }
			     }
			     if(g.isVaild(x+1, y,size))  //c_bottom
			     {
			    	 if((g.s[x+1][y].player).equalsIgnoreCase(current))
			    	 {
			    		 c_bottom=true;
			    	 }
			     }
			     if(g.isVaild(x-1, y,size))  //c_top
			     {
			    	 if((g.s[x-1][y].player).equalsIgnoreCase(current))
			    	 {
			    		 c_top=true;
			    	 }
			     }
			     if(g.isVaild(x, y-1,size))  // for o_left
			     {
			    	 if((g.s[x][y-1].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_left=true;
			    	 }
			     }
			     if(g.isVaild(x, y+1,size))  //o_right
			     {
			    	 if((g.s[x][y+1].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_right=true;
			    	 }
			     }
			     if(g.isVaild(x+1, y,size))  //o_bottom
			     {
			    	 if((g.s[x+1][y].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_bottom=true;
			    	 }
			     }
			     if(g.isVaild(x-1, y,size))  //0_top
			     {
			    	 if((g.s[x-1][y].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_top=true;
			    	 }
			     }
			     //checking conditions
				 if ( (c_left || c_right  || c_bottom  || c_top) && ( o_left || o_right  || o_bottom  || o_top ) ) // one or more of neighbours are current and opponent
				 {
					 //hm.add(l.x+" "+l.y+" "+"Raid");
					 continue;
				 }
			   if(c_left && (o_right || o_bottom || o_top))
			   {
				   //hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_right && (o_left || o_bottom || o_top))
			   {
				   //hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_bottom && (o_left || o_right || o_top))
			   {
				   //hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_top && (o_left || o_right || o_bottom))
			   {
				   //hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   else
			   {
				   hm.add(l.x+" "+l.y+" "+"Stake");
			   }
   }
   return hm;
  }
  public ArrayList<String> moves_possible_raid(ArrayList<String> hm, grid g, String p,int size)
  {
	  String current;
	  String opp;
	  if (p.equals("X"))
	  {
		  current="X";
		  opp="O";
	  }
	  else
	  {
		  current="O";
		  opp="X";
	  }
   ArrayList<Location> not_occupied = g.unOccupied(g,size);
   for(int i=0;i< not_occupied.size();i++)
   {
	   boolean c_left = false;
	   boolean c_right= false;
	   boolean c_bottom = false;
	   boolean c_top= false;
	   boolean o_left = false;
	   boolean o_right= false;
	   boolean o_bottom = false;
	   boolean o_top= false;
	  int x= not_occupied.get(i).x;
	  int y= not_occupied.get(i).y;
	  Location l=new Location(x,y);
	/*  //Special boxes
	  if(x==0)
	  {
		 if((g.s[x][y+1].player).equalsIgnoreCase(current))   //c_right
		    	 {
		    		 c_right=true;
		    	 }
		    	 if((g.s[x+1][y].player).equalsIgnoreCase(current)) //c_bottom
		    	 {
		    		 c_bottom=true;
		    	 }
		    	 if((g.s[x][y+1].player).equalsIgnoreCase(opp))  //o_right
		    	 {
		    		 o_right=true;
		    	 }
		    	 if((g.s[x+1][y].player).equalsIgnoreCase(opp))  // o_bottom
		    	 {
		    		 o_bottom=true;
		    	 }
		   if((c_right && c_bottom) || ( c_right && !(o_bottom) ) || (c_bottom && !(o_right) ) || (!o_right && !o_bottom) )
		   {
			   hm.put(l,"Stake");
			   continue;
		   }
		   else
		   {
			   hm.put(l,"Raid");
			   continue;
		   }

	  }//end of left corner case

	  //outer else
	       else
			  {*/
			     if(g.isVaild(x, y-1,size))  // for c_left
			     {
			    	 if((g.s[x][y-1].player).equalsIgnoreCase(current))
			    	 {
			    		 c_left=true;
			    	 }
			     }
			     if(g.isVaild(x,y+1,size))  //c_right
			     {
			    	 if((g.s[x][y+1].player).equalsIgnoreCase(current))
			    	 {
			    		 c_right=true;
			    	 }
			     }
			     if(g.isVaild(x+1, y,size))  //c_bottom
			     {
			    	 if((g.s[x+1][y].player).equalsIgnoreCase(current))
			    	 {
			    		 c_bottom=true;
			    	 }
			     }
			     if(g.isVaild(x-1, y,size))  //c_top
			     {
			    	 if((g.s[x-1][y].player).equalsIgnoreCase(current))
			    	 {
			    		 c_top=true;
			    	 }
			     }
			     if(g.isVaild(x, y-1,size))  // for o_left
			     {
			    	 if((g.s[x][y-1].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_left=true;
			    	 }
			     }
			     if(g.isVaild(x, y+1,size))  //o_right
			     {
			    	 if((g.s[x][y+1].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_right=true;
			    	 }
			     }
			     if(g.isVaild(x+1, y,size))  //o_bottom
			     {
			    	 if((g.s[x+1][y].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_bottom=true;
			    	 }
			     }
			     if(g.isVaild(x-1, y,size))  //0_top
			     {
			    	 if((g.s[x-1][y].player).equalsIgnoreCase(opp))
			    	 {
			    		 o_top=true;
			    	 }
			     }
			     //checking conditions
				 if ( (c_left || c_right  || c_bottom  || c_top) && ( o_left || o_right  || o_bottom  || o_top ) ) // one or more of neighbours are current and opponent
				 {
					 hm.add(l.x+" "+l.y+" "+"Raid");
					 continue;
				 }
			   if(c_left && (o_right || o_bottom || o_top))
			   {
				   hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_right && (o_left || o_bottom || o_top))
			   {
				   hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_bottom && (o_left || o_right || o_top))
			   {
				   hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
			   if(c_top && (o_left || o_right || o_bottom))
			   {
				   hm.add(l.x+" "+l.y+" "+"Raid");
				   continue;
			   }
   }
   return hm;
  }
}
