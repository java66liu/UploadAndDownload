package net.hncu.util;
public class RandomId
{
	public static String getRandomId(int i)
	{
		return Long.toString(new java.util.Date().getTime())+i;
	}
}