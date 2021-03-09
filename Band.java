import java.util.ArrayList;

/**
 * Program that determines the best band.
 *
 * @author Summer Sneed
 * @version 1.0
 *
 */
public class Band {
    private String name;
    private String genre;
    private ArrayList<BandMember> members = new ArrayList<>();

/** Constructor that takes in a name, talent score, and specialization for each guitarist.
 *
 * @param n String name for band name.
 * @param g String genre type for band.
 * @param m ArrayList of band members in band.
 */
    public Band(String n, String g, ArrayList<BandMember> m) {
        name = n;
        genre = g;
        members = m;
    }

/** Method that calculates average talent score of the band members.
 *
 * @return Returns double value representing talent score average.
 */
    public double talentRating() {
        double rating = 0.0;
        if (members.isEmpty()) {
            return 1;
        }
        for (BandMember bandMember : members) {
            rating += bandMember.talent;
        }
        double avgRating = rating / members.size();
        return avgRating;
    }

/** Method that calculates average performance score of the band members.
 *
 * @return Returns double value representing performance score average.
 */
    public double perform() {
        double score = 0.0;
        for (BandMember bandMember : members) {
            score += bandMember.perform();
        }
        double avgScore = score / members.size();
        System.out.println(name + "'s Performance Score: " + avgScore + "/10");
        return avgScore;
    }

/** Method that prints out Band object based on name, talent rating, and band members.
 *
 * @return Returns String value representing band's name, talent rating, and band members.
 */
    public String toString() {
        String output = "";
        for (BandMember bandMember : members) {
            output += bandMember.toString() + "\n";
        }
        return name + " (" + genre + "): " + talentRating() + "/5\n" + output;
    }

/** Accessor method that accesses all of the band members.
 *
 * @return Returns ArrayList value holding all band members.
 */
    public ArrayList<BandMember> getMembers() {
        return members;
    }

/** Accessor method that accesses the band name.
 *
 * @return Returns String value representing band name.
 */
    public String getName() {
        return name;
    }
}
