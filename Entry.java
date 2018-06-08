package com.cg;

public class Entry {
	public static void main(String[] args) {
		String[] playernames={"Chaitanya","lohit", "Mahidhar","Charan","Bharath"};
		String[] gamenames1={"Cricket"};
		String[] gamenames2={"volley ball","chess","carrom"};
		String[] gamenames3={"Cricket","football","volley ball","TT"};
		String[] gamenames4={"chess","carrom","Badminton","Coco","Boxing"};
		String[] gamenames5={"videogame","TT"};
		Player p[]=new Player[5];
		Game game0[]=new Game[5];
	//player1
		
		p[0]=new Player();
		p[0].setName(playernames[0]);
		System.out.println("name is "+p[0].getName());
		if(gamenames1.length >= 2)
		{
			for(int j=0;j<gamenames1.length;j++)
			{
				game0[j]=new Game();
				game0[j].setName(gamenames1[j]);
				p[0].setGame(game0);
				System.out.println("game name is "+game0[j].getName());					
			}
		}
		 else
			{
				System.out.println("Plays less number of games");
			}	
		System.out.println("============================");
		
	//player2
			
			p[1]=new Player();
			p[1].setName(playernames[1]);
			System.out.println("name is "+p[1].getName());
			Game game1[]=new Game[5];
			if(gamenames2.length >= 2)
			{
				for(int j=0;j<gamenames2.length;j++)
				{
					game1[j]=new Game();
					game1[j].setName(gamenames2[j]);
					p[1].setGame(game1);
					System.out.println("game name is "+game1[j].getName());					
				}
			}
			else
			{
				System.out.println("Plays less number of games");
			}
			System.out.println("============================");
				
	//player3
				p[2]=new Player();
				p[2].setName(playernames[2]);
				System.out.println("name is "+p[2].getName());
				Game game2[]=new Game[5];
				if(gamenames3.length >= 2)
				{
				
					for(int j=0;j<gamenames3.length;j++)
					{
						game2[j]=new Game();
						game2[j].setName(gamenames3[j]);
						p[2].setGame(game2);
						System.out.println("game name is "+game2[j].getName());					
					}
				}
					else
					{
						System.out.println("Plays less number of games");
					}	
				System.out.println("============================");
	//player4
					
					p[3]=new Player();
					p[3].setName(playernames[3]);
					System.out.println("name is "+p[3].getName());
					Game game3[]=new Game[5];
					if(gamenames4.length >= 2)
					{
						for(int j=0;j<gamenames4.length;j++)
						{
							game3[j]=new Game();
							game3[j].setName(gamenames4[j]);
							p[3].setGame(game3);
							System.out.println("game name is "+game3[j].getName());					
						}
					}
					else
					{
						System.out.println("Plays less number of games");
					}	
					System.out.println("============================");
	//player5
						p[4]=new Player();
						p[4].setName(playernames[4]);
						System.out.println("name is "+p[4].getName());
						Game game4[]=new Game[5];
						if(gamenames5.length >= 2)
						{
							for(int j=0;j<gamenames5.length;j++)
							{
								game4[j]=new Game();
								game4[j].setName(gamenames5[j]);
								p[4].setGame(game4);
								System.out.println("game name is "+game4[j].getName());					
							}
						}
						else
						{
							System.out.println("Plays less number of games");
						}	
						System.out.println("============================");
		}
		}





