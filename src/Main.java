import java.io.*;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		TriangleNode head = null;
		
		try
		{
			args = new String[2]; args[0] = "c:\\Yodle\\triangle.txt"; args[1] = "c:\\LV\\output.csv";
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line; String[] entries;
			TriangleNode[] priorlevel = new TriangleNode[1];
			TriangleNode[] currentlevel;
			while ((line = reader.readLine()) != null) 
			{
				entries = line.split(" ");
				if (head == null)
				{
					head = new TriangleNode(Integer.parseInt(entries[0]), Integer.parseInt(entries[0]));
					head.total = head.number;
					priorlevel[0] = head;
					System.out.println(head);
				}
				else
				{
					currentlevel = new TriangleNode[entries.length];
					for (int i = 0; i < entries.length; i++)
					{
						int current = Integer.parseInt(entries[i]);
						if (i == 0)
						{
							currentlevel[i] = new TriangleNode(current, current + priorlevel[i].total);
						}
						if (i == (entries.length - 1))
						{
							currentlevel[i] = new TriangleNode(current, current + priorlevel[i-1].total);
						}
						if (i > 0 && i < (entries.length - 1))
						// find the max value possible at nodes
						{
							currentlevel[i] = new TriangleNode(current, current + (priorlevel[i-1].total > priorlevel[i].total ? priorlevel[i-1].total : priorlevel[i].total));
						}
						System.out.print(currentlevel[i] + " ");
					}
					System.out.println();
					priorlevel = currentlevel;
				}
			}
			int max = 0;
			for (int i = 0; i < priorlevel.length; i++)
			{
				if (priorlevel[i].total > max) 
				{
					max = priorlevel[i].total;
					System.out.println("largest total found so far at bottom row index " + i + ": " + max);
				}
			}
			System.out.println("largest total found: " + max);
		}
		catch (IOException ioe)
		{
			
		}
	}
}
