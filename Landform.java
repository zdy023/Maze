package alls.algorithms.maze;
/**
标注地图某块的地形.
*/
public Enum Landform
{
	PLAIN(true),TRAP(false),WALL(false),END(true);
	private boolean safeOrNot;
	public Landform(boolean safeOrNot)
	{
		this.safeOrNot = safeOrNot;
	}
	/**
	地图某块安全的判定.
	<p>标注地图上某块是否可以进入。</p>
	@return 一个布尔值<br>true - 可以<br>false - 不可以
	*/
	public boolean isSafe()
	{
		return this.safeOrNot;
	}
}
