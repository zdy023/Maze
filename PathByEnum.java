package alls.algorithms.maze;
//import java.util.ArrayDeque;
import alls.algorithms.maze.Landform;
import alls.algorithms.maze.Point;
public class PathByEnum
{
	private Point[] path;
	int countOfPath;
	private Landform[][] map;
	int beginX,beginY,parent;
	public PathByEnum(Landform[][] map,int beginX,int beginY)
	{
		this.map = map;
		path = new Point[map.length*map[0].length];
		for(int i = 0;i<path.length;i++)
			path[i] = new Point();
		countOfPath = 0;
		this.beginX = beginX;
		this.beginY = beginY;
		this.parent = -1;
	}
	public boolean findPath(int beginX,int beginY,int parent)
	{
		if((map[beginX][beginY]==Landform.END)
		{
			push(beginX,beginY,parent);
			return true;
		}
		if(has(beginX,beginY))
			return false;
		push(beginX,beginY,parent);
		boolean getPathOrNot = false;
		int nextX,nextY;
		for(int direct = parent+1,i = 1;i<4;direct++,i++)
		{
			nextX = path[countOfPath-1].nextX(direct);
			nextY = path[countOfPath-1].nextY(direct);
			if(map[nextX][nextY].isSafe())
			{
				getPathOrNot = findPath(nextX,nextY,direct);
			}
			if(getPathOrNot)
				break;
		}
		if(!getPathOrNot)
			pop();
	}
	private void push(int beginX,int beginY,int parent)
	{
		path[countOfPath].setX(beginX);
		path[countOfPath].setY(beginY);
		path[countOfPath].setParent(parent);
		countOfPath++;
	}
	private void pop()
	{
		countOfPath--;
	}
	private void has(int x,int y)
	{
		for(int i = 0;i<countOfPath;i++)
		{
			if(path[i].overlaps(x,y))
				return true;
		}
		return false;
	}
}
