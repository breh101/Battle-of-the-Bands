import java.util.Random;

/**
 * Program that determines the best band.
 *
 * @author Summer Sneed
 * @version 1.0
 *
 */
public abstract class BandMember {
    protected String name;
    protected int talent;
    protected Random gen = new Random();

/** Constructor that takes in a name and talent score for each band member.
 *
 * @param n String name for band member.
 * @param t Int talent score for band member.
*/
    public BandMember(String n, int t) {
        name = n;
        talent = t;
        if (talent < 1) {
            talent = 1;
        } else if (talent > 5) {
            talent = 5;
        }
    }

/** Method that returns an int representing a score out of 10 on their performance. */
    protected abstract int perform();

/** Method that prints out BandMember object based on name and talent.
 *
 * @return Returns String value representing band member's name and talent.
*/
    public String toString() {
        return name + ": " + talent + "/5";
    }

/** Equals method that compares two band members based on name and talent.
 *
 * @param o Object for comparison.
 * @return Returns boolean value for objects being equal or not equal.
*/
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        BandMember bm = (BandMember) o;
        return (this.name.equals(bm.name) && this.talent == bm.talent);
    }

/** Accessor method to access the band member's name.
 *
 * @return Returns String value representing name.
*/
    public String getName() {
        return name;
    }

/** Mutator method to change band member's talent score.
 *
 * @param num Integer changing talent score.
 * @return Returns int value representing new talent score.
*/
    public int setTalent(int num) {
        return talent;
    }
}
