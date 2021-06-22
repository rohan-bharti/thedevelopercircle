import java.util.*;

/**
 * (Insert a brief description about the approach for the problem)
 * 
 * Average - O(N) time | O(N) space
 * Worst - O(N) time | O(N) space
 */
class Program {
  public static void main(String[] args) {
	List<String> participants = new ArrayList<>();

	participants.add("Rohan");
	participants.add("Sarthak");
	participants.add("Pranit");
	participants.add("Manorath");

	for(String name: participants) {
		System.out.println(name);
	}
  }
}
