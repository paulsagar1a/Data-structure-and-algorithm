 /*******************************************************
 * @author SAGAR PAUL (paulsagar1a)
 * @category greedy
 *******************************************************/

//write job sequencing code in java
package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class JobSequence {

	public static class Job {
		char jobId;
		int deadline;
		int profit;
		public Job(char jobId, int deadline, int profit) {
			this.jobId = jobId;
			this.deadline = deadline;
			this.profit = profit;
		}
		
		@Override
		public String toString() {
			return jobId+" "+deadline+" "+profit;
		}
	}

	private static void printJobSequencing(Job[] jobs, int n) {
		// TODO Auto-generated method stub
		Arrays.sort(jobs, new Comparator<Job>() {

			@Override
			public int compare(Job job1, Job job2) {
				return job2.profit - job1.profit;
			}
			
		});
		
		 // Creating TreeSet Object 
        TreeSet<Integer> ts = new TreeSet<>(); 
  
        for (int i = 0; i < n; i++) 
            ts.add(i); 
  
        for (int i = 0; i < n; i++) { 
            Integer x = ts.floor(jobs[i].deadline - 1); 
  
            if (x != null) { 
                System.out.print(jobs[i].jobId + " "); 
                ts.remove(x); 
            } 
        } 
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		Job[] jobs = new Job[n];
		jobs[0] = new Job('a', 2, 100);
		jobs[1] = new Job('b', 1, 19);
		jobs[2] = new Job('c', 2, 27);
		jobs[3] = new Job('d', 1, 25);
		jobs[4] = new Job('e', 3, 15);
		printJobSequencing(jobs, n);
	}

}
