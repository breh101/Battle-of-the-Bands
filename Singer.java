/**
 * Program that determines the best band.
 *
 * @author Summer Sneed
 * @version 1.0
 *
 */
public class Singer extends BandMember {
/** Enum values representing different ranges of singers.*/
    public enum Range { BASS, BARITONE, TENOR, ALTO, SOPRANO };
    private Range range;

/** Constructor that takes in a name, talent score, and range for each singer.
 *
 * @param n String name for band member.
 * @param t Int talent score for band member.
 * @param r Enum values of pitches for singer.
 */
    public Singer(String n, int t, Range r) {
        super(n, t);
        range = r;
    }

/** Method that returns score of singer.
 *
 * @return Returns int value score of singer.
 */
    @Override
    public int perform() {
        int val = gen.nextInt(11);
        int score = talent + val;
        int highNote = 10;
        if (val == highNote) {
            score *= 2;
        }
        if (score > 10) {
            score = 10;
        }
        if (score < 5) {
            System.out.println(name + "'s voice cracked in the middle of their performance! Score: " + score + "/10");
        } else if (score > 5) {
            System.out.println(name + " sang their heart out! Score: " + score + "/10");
        }
        return score;
    }

/** Method that prints out Singer object based on name, talent, and range.
 *
 * @return Returns String value representing singer's name, talent, and range.
 */
    public String toString() {
        return name + ": " + talent + "/5 " + range;
    }

/** Equals method that compares two singers based on name, talent, and range.
 *
 * @param o Object for comparison.
 * @return Returns boolean value for objects being equal or not equal.
 */
    @Override
    public boolean equals(Object o) {
        BandMember bm = (BandMember) o;
        Singer s = (Singer) o;
        if (o == null) {
            return false;
        } else if (getClass() != o.getClass()) {
            return false;
        }
        return (this.name.equals(bm.name) && this.talent == bm.talent && this.range == s.range);
    }
}
