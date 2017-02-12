package alls.algorithms.maze;
//import alls.algorithms.Landform;
/**
<h1>class Point</h1>.
<p>
	地图的地形块。<br>
	该类被设计为在运行时不可更改的类，故使用者应设法减少建立该类的实例数量。
</p>
@author david Chang
*/
public class Point
{
	private int x;
	private int y;
	private int parentDirect;
	/**
	构造方法.
	<p>
		坐标自动置0。
	</p>
	@param x 水平坐标
	@param y 竖直坐标
	@param parent the direction of the previous point on the path
	*/
	public Point()
	{
		this.x = 0;
		this.y = :0;
		this.parentDirect = -1;
	}
	/**
	调整水平坐标.
	@param x the new x
	*/
	public void setX(int x)
	{
		this.x = x;
	}
	/**
	调整竖直坐标.
	@param y the new y
	*/
	public void setY(int y)
	{
		this.y = y;
	}
	/**
	设置路径上前一个迷宫块相对该迷宫块的方向.
	@param parent the direction of the previous point<br>0 - up<br>1 - right<br>2 - bottom<br>3 - left
	*/
	public void setParent(int parent)
	{
		this.parent = parent&3;
	}
	/**
	返回指定方向上下一个地图块的横坐标.
	@param direct 指定方向，含义见 @see setParent
	@return 指定方向上下一个地图块的横坐标
	*/
	public int nextX(int direct)
	{
		switch(direct&3)
		{
			case 0:
			case 3:
				return x;
			case 1:
				return x+1;
			case 2: return x-1;
		}
	}
	/**
	返回指定方向上下一个地图块的纵坐标.
	@param direct 指定方向，含义见 @see setParent
	@return 指定方向上下一个地图块的纵坐标
	*/
	public int nextY(int direct)
	{
		switch(direct&3)
		{
			case 1:
			case 2:
				return y;
			case 3:
				return y+1;
			case 0: return y-1;
		}
	}
	/*
	获得地形.
	@return landform
	*
	public Landform getLandform()
	{
		return this.lf;
	}*/
	/*
	判断对象与另一对象是否相等.
	@param p the another Point object
	@return if p and this equal,return true;if not,false
	*
	public boolean equals(Point p)
	{
		if((x==p.getX())&&(y==p.getY())&&(lf==p.getLandform())
			return true;
	}*/
	/**
	判断对象与另一点坐标是否相等。
	@param x the another Point object's x
	@param y the another Point object's y
	@return if (x,y) and this are at the same position,return true;if not,false
	*/
	public boolean overlaps(int x,int y)
	{
		return (this.x==x)&&(this.y==y);
	}
}
