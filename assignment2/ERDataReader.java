package er_data;


import java.io.FileReader;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

public class ERDataReader {
	public static int[][][] readData(String dataFile) throws FileNotFoundException, NoSuchElementException, IllegalStateException  {	
		 Scanner in = new Scanner(new FileReader("/home/amm0017/code/cs111_assignments/assignment1/data/data1.txt"));
		   final int hours=24;
		   final int days=7;
		   final int weeks=4;
		   int [][][]data=new int [weeks][days][hours];
		   while( in.hasNext()){ 
		   for(int i=0;i<weeks;i++){
			   for(int j=0;j<days;j++){
				   for(int k=0;k<hours;k++){
					   data[i][j][k]=in.nextInt();
				   }
			   }
		   }
		   }
		   in.close();
		   return data;
	}
}
