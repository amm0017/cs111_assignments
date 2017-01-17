package er_data;


public class ERDataAnalyzer {
	// private methods here
	// If you find yourself writing the same code over and over, 
	// consider creating a private method which you can call instead.

	/**
	 * Returns the total number of patients for each week
	 * 
	 * @param data	a 3-d integer array corresponding to the number of visitations. 
	 * 				1st dimension corresponds to the week, 2nd dimension the day, 3rd dimension the hour 				
	 * @return 		an 1-d integer array of weekly totals
	 */
	public static int[] patientsPerWeek(int[][][] data) {
		int []patients=new int[data.length];
		for(int i=0;i<data.length;i++){
			int sum=0;
			for(int j=0;j<data[i].length;j++){
				for(int k=0;k<data[i][j].length;k++){
					sum+=data[i][j][k];
				}
			}
			patients[i]=sum;
		}
		return patients;
	}
	
	/**
	 * Returns the total number of visits for each day, for each week.
	 * 
	 * @param data	
	 * @return		2-d integer array of daily totals. 1st dimension is the week, 2nd is the day
	 */
	public static int[][] patientsPerDayPerWeek(int[][][] data) {
		int [][]patients=new int[data[0].length][data.length];
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[0].length;j++){
				int sum=0;
				for(int k=0;k<data[0][0].length;k++){
					sum+=data[i][j][k];
				}
				patients[i][j]=sum;
			}
		}
		return patients;
	}
	
	/**
	 * Returns the average number of patients seen in a day for each week.
	 * For example, given the following two weeks of daily visitations:
	 * 
	 * twoWeekDailyTotals = [[10, 10, 10, 15, 20, 20 20], [20, 20, 20, 30, 40, 40, 40]]
	 * assert averagePatientsPerWeek(twoWeekDailyTotals) == [15.0, 30.0]
	 * 
	 * @param data
	 * @return 		1-d double array of the average number of daily patients for each week
	 */
	public static double[] averagePatientsPerWeek(int[][][] data) {
		double[]patients=new double[data.length];
		for(int i=0;i<data.length;i++){
			double avg=0;
			for(int j=0;j<data[0].length;j++){
				int sum=0;
				for(int k=0;k<data[0][0].length;k++){
				sum+=data[i][j][k];
				}
				avg=sum/data[0].length;
			}
			patients[i]=avg;
		}
		return patients;
	}
	
	/**
	 * Returns the average number of patients seen on Sundays, Mondays, Tuesdays, etc. 
	 * over an n week period.
	 * 
	 * @param data
	 * @return 		a 1-d double array of daily average visitations
	 * 				where the 1st dimension corresponds to the day
	 */
	public static double[] averagePatientsPerDayAcrossWeeks(int[][][] data) {
		double[]patients=new double[data[0].length];
		for(int i=0;i<data[0].length;i++){
			int dayTotal=0;
			for(int j=0;j<data.length;j++){
				for(int k=0;k<data[0][0].length;k++){
					dayTotal+=data[i][j][k];
				}
				dayTotal/=data.length;
			}
			patients[i]=dayTotal;
		}
		return patients;
	}
	
	/**
	 * Returns an array of integers indexing the busiest day (most visits)
	 * of the week, for each week. For example, if the daily total visits
	 * over a two week period are:
	 * 
	 * twoWeekDailyTotals = [[10, 50, 20, 15, 30, 9 25], [20, 30, 60, 60, 10, 15, 5]]
	 * assert busiestDayPerWeek(twoWeekDailyTotals) == [1,  2]
	 * (In case of ties, just choose one of the busiest days)
	 * 
	 * 
	 * @param data
	 * @return		1-d integer array of array indices indicating, for each
	 *              week, the (or one of the) day(s) with the most visits 
	 */
	public static int[] busiestDayPerWeek(int[][][] data) {
		int[]patients=new int[data.length];
		for(int i=0;i<data.length;i++){
		
			for(int j=0;j<data[0].length;j++){
				int maxPatients=0;
				int position=-1;
				for(int k=0;k<data[0][0].length;k++){
					if(data[i][j][k]>maxPatients){
						maxPatients=data[i][j][k];
						position=k;
					}
				}
				patients[j]=position;
			}
		
		}
		return patients;
	}
	
	/**
	 * Returns an array of integers indexing the least busy day (fewest visits)
	 * of the week, for each week.
	 * 
	 * @param data
	 * @return		1-d integer array of array indices indicating, for each
	 * 				week, the (or one of the) day(s) with the fewest visits 
	 */
	public static int[] leastBusyDayPerWeek(int[][][] data) {
		int[]patients=new int[data.length];
		for(int i=0;i<data.length;i++){
		
			for(int j=0;j<data[0].length;j++){
				int minPatients=0;
				int position=0;
				for(int k=0;k<data[0][0].length;k++){
					if(data[i][j][k]>minPatients){
						minPatients=data[i][j][k];
						position=k;
					}	
				}
				patients[j]=position;
			}
		
		}
		return patients;
	}
}