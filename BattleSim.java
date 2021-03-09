import java.util.Scanner;
import java.util.ArrayList;

/**
 * Simulates a battle of the bands.
 * @author CS1331TAs
 * @version 1.0
 */
public class BattleSim {
    private ArrayList<Band> bandList;
    private static Scanner sc = new Scanner(System.in);

    /**
     * Constructor for BattleSim.
     * @param bandList list of bands
     */
    public BattleSim(ArrayList<Band> bandList) {
        this.bandList = bandList;
    }

    /**
     * Main method to interact with program.
     * @param args arguments
     */
    public static void main(String[] args) {
        //Filling program with sample data
        ArrayList<Band> sampleBand = new ArrayList<>();
        ArrayList<BandMember> queen = new ArrayList<>();
        ArrayList<BandMember> bts = new ArrayList<>();
        bts.add(new Singer("Jungkook", 5, Singer.Range.TENOR));
        queen.add(new Guitarist("Brian May", 5, Guitarist.Specialty.ELECTRIC));
        sampleBand.add(new Band("Queen", "Rock", queen));
        sampleBand.add(new Band("BTS", "K-Pop", bts));
        BattleSim sim = new BattleSim(sampleBand);

        //Start of program
        int selection;
        System.out.println("Welcome to Battle of the Bands Simulator!\n");
        do {
            System.out.println("Would you like to:");
            System.out.println("1. View bands");
            System.out.println("2. Add new artist");
            System.out.println("3. Add new band");
            System.out.println("4. Change artist rating");
            System.out.println("5. Perform simulation");
            System.out.println("6. Exit program");
            System.out.println("Please enter one of the options above:");
            selection = sc.nextInt();
            sc.nextLine(); //this gets rid of newline character
            System.out.println();
            switch (selection) {
            case 1:
                sim.viewBand();
                break;
            case 2:
                sim.addArtist();
                break;
            case 3:
                sim.addBand();
                break;
            case 4:
                sim.changeRating();
                break;
            case 5:
                sim.battle();
                break;
            default:
                break;
            }
            System.out.println();
        } while (selection != 6);
    }

    /**
     * Displays a band's members.
     */
    public void viewBand() {
        listBands();
        System.out.print("What band would you like to view: ");
        Band band = bandList.get(sc.nextInt() - 1);
        System.out.println(band.toString());
    }

    /**
     * Adds an artist to a band.
     */
    public void addArtist() {
        listBands();
        System.out.print("Which band would you like to add a member to: ");
        Band band = bandList.get(sc.nextInt() - 1);
        sc.nextLine(); //this gets rid of newline character

        System.out.print("What is the artist's name? ");
        String name = sc.nextLine();

        System.out.print("Talent rating from 1 to 5: ");
        int talent = sc.nextInt();

        System.out.print("Singer or Guitarist: ");
        String type = sc.next();

        if (type.equals("Singer")) {
            listRange();
            System.out.print("Which range: ");
            Singer.Range range = Singer.Range.values()[sc.nextInt() - 1];

            Singer s = new Singer(name, talent, range);
            band.getMembers().add(s);

            System.out.println("Added singer " + name + " to " + band.getName());
        } else if (type.equals("Guitarist")) {
            listSpecialty();
            System.out.print("Which speciality: ");
            Guitarist.Specialty sp = Guitarist.Specialty.values()[sc.nextInt() - 1];

            Guitarist g = new Guitarist(name, talent, sp);
            band.getMembers().add(g);

            System.out.println("Added guitarist " + name + " to " + band.getName());
        } else {
            System.out.println("Failed to add artist.");
        }
    }

    /**
     * Adds a band with no members to the bandList.
     */
    public void addBand() {
        System.out.print("What is the band's name? ");
        String name = sc.nextLine();
        System.out.print("Genre: ");
        String genre = sc.nextLine();

        Band b = new Band(name, genre, new ArrayList<BandMember>());
        bandList.add(b);

        System.out.println("Created band named " + name + ".");
    }

    /**
     * Changes the rating of an artist.
     */
    public void changeRating() {
        listBands();
        System.out.print("What band is the artist a member of? ");
        Band band = bandList.get(sc.nextInt() - 1);

        listArtists(band);
        if (band.getMembers().size() > 0) {
            System.out.print("Select a member: ");
            BandMember b = band.getMembers().get(sc.nextInt() - 1);

            System.out.print("Talent rating from 1 to 5: ");
            int rating = sc.nextInt();

            b.setTalent(rating);

            System.out.println("Successfully changed " + b.getName() + "'s rating to " + rating);
        }
    }

    /**
     * Runs a battle simulation between two bands.
     */
    public void battle() {
        System.out.println("Setting up simulation...");
        listBands();
        System.out.print("Select the first band: ");
        Band b1 = bandList.get(sc.nextInt() - 1);
        System.out.print("Select the second band: ");
        Band b2 = bandList.get(sc.nextInt() - 1);
        System.out.println("\nBeginning simulation...");

        double a = b1.perform();
        double b = b2.perform();
        if (a > b) {
            String winner = b1.getName();
            System.out.println("The winner is " + winner);
        } else if (a < b) {
            String winner = b2.getName();
            System.out.println("The winner is " + winner);
        } else {
            if (a == b) {
                System.out.println("It was a tie.");
            }
        }
    }

    /**
     * Lists the bands.
     */
    private void listBands() {
        for (int i = 0; i < bandList.size(); i++) {
            System.out.println((i + 1) + ". " + bandList.get(i).getName());
        }
    }

    /**
     * Lists the artists in a band.
     * @param b the band
     */
    private void listArtists(Band b) {
        ArrayList<BandMember> members = b.getMembers();
        for (int i = 0; i < members.size(); i++) {
            System.out.println((i + 1) + ". " + members.get(i).getName());
        }
    }

    /**
     * Lists the vocal ranges in enum Range.
     */
    private static void listRange() {
        for (int i = 0; i < Singer.Range.values().length; i++) {
            System.out.println((i + 1) + ". " + Singer.Range.values()[i]);
        }
    }

    /**
     * Lists the guitar specialties in enum Specialty.
     */
    private static void listSpecialty() {
        for (int i = 0; i < Guitarist.Specialty.values().length; i++) {
            System.out.println((i + 1) + ". " + Guitarist.Specialty.values()[i]);
        }
    }
}