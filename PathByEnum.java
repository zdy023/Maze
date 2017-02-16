package alls.algorithms.maze;
//import java.util.ArrayDeque;
import alls.algorithms.maze.Landform;
import alls.algorithms.maze.Point;
import java.util.Arrays;
import java.util.Scanner;
/**
*<h1>借用栈按深度优先搜索的方式搜索迷宫路径</h1>.
*@author David Chang
*/
public class PathByEnum
{
	private Point[] path;
	int countOfPath;
	private Landform[][] map;
	int beginX,beginY;
	/**
	*构造方法.
	*<p>有一个地图，一个起点构造对象。</p>
	*@param map 地图
	*@param beginX 起点横坐标
	*@param beginY 起点纵坐标
	*/
	public PathByEnum(Landform[][] map,int beginX,int beginY)
	{
		this.map = map;
		path = new Point[map.length*map[0].length];
		for(int i = 0;i<path.length;i++)
			path[i] = new Point();
		countOfPath = 0;
		this.beginX = beginX;
		this.beginY = beginY;
	}
	/**
	*由指定起点搜索路径.
	*<p>该类用于递归算法，不对外暴露。</p>
	*@param beginX 起点横坐标
	*@param beginY 起点纵坐标
	*@param parent the direction of the previous point on the path
	*@return true - if the path is found
	*/
	private boolean findPath(int beginX,int beginY,int parent,int iSt)
	{
		if(map[beginX][beginY]==Landform.END)
		{
			push(beginX,beginY,parent);
			return true;
		}
		if(has(beginX,beginY))
			return false;
		push(beginX,beginY,parent);
		boolean getPathOrNot = false;
		int nextX,nextY;
		//System.out.println("node 2: " + parent);
		for(int direct = parent+1,i = iSt;i<4;direct++,i++)
		{
			int newD = direct&3;
			//System.out.println("node 5: " + direct);
			if((path[countOfPath-1].getX()==0)&&(newD==3))
				continue;
			if((path[countOfPath-1].getX()==map.length-1)&&(newD==1))
				continue;
			if((path[countOfPath-1].getY()==0)&&(newD==0))
				continue;
			if((path[countOfPath-1].getY()==map[0].length-1)&&(newD==2))
				continue;
			nextX = path[countOfPath-1].nextX(direct);
			nextY = path[countOfPath-1].nextY(direct);
			//System.out.println("node 1: " + direct + " " + path[countOfPath-1] + " " + "(" + nextX + "," + nextY + ")");
			if(map[nextX][nextY].isSafe())
			{
				//System.out.println("node 4: " + getPathOrNot);
				getPathOrNot = findPath(nextX,nextY,(direct+2)&3,1);
				//System.out.println("node 6: " + getPathOrNot);
			}
			if(getPathOrNot)
				break;
		}
		if(!getPathOrNot)
			pop();
		return getPathOrNot;
	}
	/**
	*由指定起点搜寻路径.
	*@param beginX 起点横坐标
	*@param beginY 起点纵坐标
	*@return true - if the path is found
	*/
	public boolean findPath(int beginX,int beginY)
	{
		return this.findPath(beginX,beginY,-1,0);
	}
	/**
	*由构造该对象时指定的起点搜寻路径.
	*@return true - if the path is found
	*/
	public boolean findPath()
	{
		return this.findPath(beginX,beginY,-1,0);
	}
	/**
	*将某一地图块压入路径栈.
	*@param X 横坐标
	*@param Y 纵坐标
	*/
	private void push(int X,int Y,int parent)
	{
		path[countOfPath].setX(X);
		path[countOfPath].setY(Y);
		path[countOfPath].setParent(parent);
		countOfPath++;
	}
	/**
	*将栈顶地图块取出路径栈.
	*/
	private void pop()
	{
		countOfPath--;
	}
	/**
	*判断某地图块是否已加入路径栈.
	*@param x 横坐标
	*@param y 纵坐标
	*@return true - if (x,y) is in the path stack
	*/
	private boolean has(int x,int y)
	{
		for(int i = 0;i<countOfPath;i++)
		{
			if(path[i].overlaps(x,y))
				return true;
		}
		return false;
	}
	/**
	*获得已找出的路径，若未找出路径，会返回空数组.
	*@return the path array
	*/
	public Point[] getPath()
	{
		return Arrays.copyOf(this.path,countOfPath);
	}
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Landform[][] map = new Landform[n][n];
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
				map[j][i] = Landform.values()[s.nextInt()];
		}
		System.out.println();
		for(int i = 0;i<n;i++)
		{
			for(int j = 0;j<n;j++)
				System.out.print(map[j][i].isSafe() + " ");
			System.out.println();
		}
		int x = s.nextInt(),y = s.nextInt();
		PathByEnum maze = new PathByEnum(map,x,y);
		if(maze.findPath())
		{
			Point[] path = maze.getPath();
			//System.out.println("node 3");
			for(int i = 0;i<path.length;i++)
				System.out.print(path[i].toString() + " ");
		}
		System.out.println("Finished.");
	}
}
