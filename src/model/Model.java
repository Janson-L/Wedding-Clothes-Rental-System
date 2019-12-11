package model;

abstract class Model
{
	protected int ID;
	
	public Model(int ID)
	{
		this.ID=ID;
	}

	public int getID()
	{
		return ID;
	}
}