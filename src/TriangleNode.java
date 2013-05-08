public class TriangleNode 
{
	public TriangleNode(TriangleNode l, TriangleNode r, int n)
	{
		left = l;
		right = r;
		number = n;
	}
	
	public TriangleNode(int n, int t)
	{
		left = null;
		right = null;
		number = n;
		total = t;
	}
	
	public TriangleNode left;
	public TriangleNode right;
	public int number;
	public int total;
	
	@Override
	public String toString()
	{
		return (number + "(" + total + ")");
	}
}

