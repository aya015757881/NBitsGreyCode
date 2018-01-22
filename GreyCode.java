package aya;
import java.util.Scanner;
public class GreyCode
{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		while(true)
		{
			System.out.print("请输入N位格雷码的N值，N=");
			int N=input.nextInt();
			int row=(int)Math.pow(2,N);
			byte[][] code=NbitGreyCode(N);
			System.out.println(N+"位格雷码如下：");
			for(int i=0;i<row;i++)
			{
				for(int j=0;j<N;j++)
					System.out.print(code[i][j]+" ");
				System.out.println();
			}
			System.out.println("\n");
		}
	}
	public static byte[][] NbitGreyCode(int N)
	{
		byte[][] thisCode;
		if(N==1)
		{
			thisCode=new byte[2][1];
			thisCode[0][0]=0;
			thisCode[1][0]=1;
		}
		else
		{
			int full=(int)Math.pow(2,N);
			int semi=full/2;
			byte[][] lastCode=NbitGreyCode(N-1);
			thisCode=new byte[full][N];
			for(int i=0;i<semi;i++)
				for(int j=0;j<N;j++)
					if(j!=0)
						thisCode[i][j]=lastCode[i][j-1];
					else
						thisCode[i][j]=0;
			for(int i=0;i<semi;i++)
				for(int j=0;j<N;j++)
					if(j!=0)
						thisCode[semi+i][j]=lastCode[semi-1-i][j-1];
					else
						thisCode[semi+i][j]=1;
		}
		return thisCode;
	}
}
