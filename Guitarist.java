/**
 * Program that determines the best band.
 *
 * @author Summer Sneed
 * @version 1.0
 *
 */
public class Guitarist extends BandMember {
/** Enum values representing different ranges of singers.*/
    public enum Specialty { ACOUSTIC, ELECTRIC };
    private Specialty specialization;

/** Constructor that takes in a name, talent score, and specialization for each guitarist.
 *
 * @param n String name for band member.
 * @param t Int talent score for band member.
 * @param s Enum values of specializations for guitarist.
 */
    public Guitarist(String n, int t, Specialty s) {
        super(n, t);
        specialization = s;
    }

/** Method that returns score of guitarist.
 *
 * @return Returns int score of guitarist.
 */
    @Override
    public int perform() {
        int val = gen.nextInt(11);
        int score = talent + val;
        if (val == 3 || val == 6 || val == 9) {
            score += talent;
        }
        if (score > 10) {
            score = 10;
        }
        if (score < 5) {
            System.out.println(name + "'s fingers slipped and hit the wrong note! Score: " + score + "/10");
        } else if (score > 5) {
            System.out.println(name + " captured everyone's attention! Score: " + score + "/10");
        }
        return score;
    }

/** Method that prints out Guitarist object based on name, talent, and specialization.
 *
 * @return Returns String value representing guitarist's name, talent, and range.
 */
    public String toString() {
        return name + ": " + talent + "/5 " + specialization;
    }

/** Equals method that compares two guitarists based on name, talent, and specialization.
 *
 * @param o Object for comparison.
 * @return Returns boolean value for objects being equal or not equal.
 */
    @Override
    public boolean equals(Object o) {
        BandMember bm = (BandMember) o;
        Guitarist g = (Guitarist) o;
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        }
        return (this.name.equals(bm.name) && this.talent == bm.talent && this.specialization == g.specialization);
    }
}

