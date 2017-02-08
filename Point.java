package alls.algorithms;
import alls.algorithms.Landform;
/**
<h1>class Point</h1>.
<p>
	地图的地形块。<br>
	该类被设计为在运行时不可更改的类，故使用者应设法减少建立该类的实例数量。
</p>
*/
public class Point
{
	private int x;
	private int y;
	private Landform lf;
	/**
	构造方法.
	<p>
		由坐标与地形构造Point。坐标必须大于等于0。否则会被自动置0。
	</p>
	@param x 水平坐标
	@param y 竖直坐标
	@param lf 地形
	*/
	public Point(int x,int y,Landform lf)
	{
		this.x = x>=0?x:0;
		this.y = y>=0?y:0;
		this.lf = lf;
	}
	/**
	获得水平坐标.
	@return x
	*/
	public int getX()
	{
		return x;
	}
	/**
	获得竖直坐标.
	@return y
	*/
	public int getY()
	{
		return y;
	}
	/**
	获得地形.
	@return landform
	*/
	public Landform getLandform()
	{
		return this.lf;
	}
	/**
	判断对象与另一对象是否相等.
	@param p the another Point object
	@return if p and this equal,return true;if not,false
	*/
	public boolean equals(Point p)
	{
		if((x==p.getX())&&(y==p.getY())&&(lf==p.getLandform())
			return true;
	}
	/**
	判断对象与另一对象坐标是否相等。
	@param p the another Point object
	@return if p and this are at the same position,return true;if not,false
	*/
	public boolean overlaps(Point p)
	{
		return (this.x==p.getX())&&(this.y==p.getY());
	}
}
