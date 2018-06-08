package com.cg;



public class Player {
	private String name;
	private Game game[];
   	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public Game[] getGame()
	{
		return game;
	}
	public void setGame(Game[] game)
	{
		this.game=game;
	}

} 
