
/*
	Name: Anastasios-Rafail Papadopoulos
	Student Number: 3160130
*/

public class VotingApp {

	public static void main(String[] args) {
		
		int votes[][] = {
							{182, 41, 202},
							{145, 85, 325},
							{195, 15, 115},
							{110, 24, 407},
							{255, 11, 357},
						};
		
		int totalVotesA = 0, totalVotesB = 0, totalVotesC = 0, totalVotes;
		
		for (int i = 0; i < 5; i++) {
			
			if (i == 0) {
				System.out.println("Voting District\t\tA\t\tB\t\tC");
			}
			System.out.print("      " + (i + 1) + "\t\t");
			
			for (int j = 0; j < 3; j++) {
				
				if (j == 0) {
					System.out.print("\t");
				}
				
				if (j == 0) {
					totalVotesA += votes[i][j];
				} else if (j == 1) {
					totalVotesB += votes[i][j];
				} else {
					totalVotesC += votes[i][j];
				}
				
				System.out.print(votes[i][j] + "\t\t");
				
			}
			System.out.println();
			
		}
		
		totalVotes = totalVotesA + totalVotesB + totalVotesC;
		
		System.out.println("\nTotal number of votes for candidate A: " + totalVotesA);
		System.out.println("Total number of votes for candidate B: " + totalVotesB);
		System.out.println("Total number of votes for candidate C: " + totalVotesC);
		
		float percentageOfA = ((float)totalVotesA / (float)totalVotes) * 100;
		float percentageOfB = ((float)totalVotesB / (float)totalVotes) * 100;
		float percentageOfC = ((float)totalVotesC / (float)totalVotes) * 100;
		
		System.out.printf("\nPercentage of votes for candidate A: %.2f %%", percentageOfA);
		System.out.printf("\nPercentage of votes for candidate B: %.2f %%", percentageOfB);
		System.out.printf("\nPercentage of votes for candidate C: %.2f %%%n%n", percentageOfC);
		
		boolean greaterThan50 = false;
		
		if (percentageOfA > 50) {
			greaterThan50 = true;
			System.out.println("And the winner of the election iiis...... candidate A");
		}
		
		if (percentageOfB > 50) {
			greaterThan50 = true;
			System.out.println("And the winner of the election iiis...... candidate B");
		}
		
		if (percentageOfC > 50) {
			greaterThan50 = false;
			System.out.println("And the winner of the election iiis...... candidate C");
		}
		
		if (greaterThan50 == false) {
			
			System.out.println("We didn't have a candidate with a percentage great than 50 from the election, "
							 + "\nso a repeat round wil be held between the 2 first candidates."
							 + "\n\nIn no particular order, the first 2 candidates are: \n");
			
			if (percentageOfA > percentageOfC && percentageOfB > percentageOfC) {
				
				System.out.printf("1. Candidate A\nNumber of votes: %d\nPercentage: %.2f %%%n%n", totalVotesA, percentageOfA);
				System.out.printf("2. Candidate B\nNumber of votes: %d\nPercentage: %.2 %%f", totalVotesB, percentageOfB);
				
			} else if (percentageOfB > percentageOfA && percentageOfC > percentageOfA) {
				
				System.out.printf("1. Candidate B\nNumber of votes: %d\nPercentage: %.2f %%%n%n", totalVotesB, percentageOfB);
				System.out.printf("2. Candidate C\nNumber of votes: %d\nPercentage: %.2f %%", totalVotesC, percentageOfC);
				
			} else if (percentageOfA > percentageOfB && percentageOfC > percentageOfB) {
				
				System.out.printf("1. Candidate A\nNumber of votes: %d\nPercentage: %.2f %%%n%n", totalVotesA, percentageOfA);
				System.out.printf("2. Candidate C\nNumber of votes: %d\nPercentage: %.2f %%", totalVotesC, percentageOfC);
				
			}
			
		}

	}

}
