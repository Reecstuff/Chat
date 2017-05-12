package client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Random;

public class WordlistSpamAttack extends BaseAttack
{
	
	public WordlistSpamAttack(String host, int port)
	{
		super(host, port);
		words = new ArrayList<String>();
		words.add("There");
		words.add("Worse");
		words.add("By");
		words.add("An");
		words.add("Of");
		words.add("Miles");
		words.add("Civil");
		words.add("Manner");
		words.add("Before");
		words.add("Lively");
		words.add("Wholly");
		words.add("Am");
		words.add("Mr");
		words.add("Indeed");
		words.add("Expect");
		words.add("Among");
		words.add("Every");
		words.add("Merry");
		words.add("His");
		words.add("Yet");
		words.add("Has");
		words.add("Her");
		words.add("You");
		words.add("Mistress");
		words.add("Get");
		words.add("Dashwood");
		words.add("Children");
		words.add("Off");
		words.add("Met");
		words.add("Whose");
		words.add("Marry");
		words.add("Under");
		words.add("The");
		words.add("Merit");
		words.add("In");
		words.add("It");
		words.add("Do");
		words.add("Continual");
		words.add("Consulted");
		words.add("No");
		words.add("Listening");
		words.add("Devonshire");
		words.add("Sir");
		words.add("Sex");
		words.add("Motionless");
		words.add("Travelling");
		words.add("Six");
		words.add("Themselves");
		words.add("So");
		words.add("Colonel");
		words.add("As");
		words.add("Greatly");
		words.add("Shewing");
		words.add("Herself");
		words.add("Observe");
		words.add("Ashamed");
		words.add("Demands");
		words.add("Minutes");
		words.add("Regular");
		words.add("Ye");
		words.add("To");
		words.add("Detract");
		words.add("Is");
		words.add("Him");
		words.add("Boisterous");
		words.add("Invitation");
		words.add("Dispatched");
		words.add("Had");
		words.add("Connection");
		words.add("Inhabiting");
		words.add("Projection");
		words.add("Mutual");
		words.add("Danger");
		words.add("Garret");
		words.add("Edward");
		words.add("Diverted");
		words.add("Strictly");
		words.add("Exertion");
		words.add("Addition");
		words.add("Disposal");
		words.add("Stanhill");
		words.add("This");
		words.add("Call");
		words.add("Wife");
		words.add("Sigh");
		words.add("Gate");
		words.add("Felt");
		words.add("And");
		words.add("Abode");
		words.add("Spite");
		words.add("Order");
		words.add("Procuring");
		words.add("Far");
		words.add("Belonging");
		words.add("Our");
		words.add("Ourselves");
		words.add("Certainly");
		words.add("Own");
		words.add("Perpetual");
		words.add("Elsewhere");
		words.add("Sometimes");
		words.add("Or");
		words.add("My");
		words.add("Certainty");
		words.add("Lain");
		words.add("Five");
		words.add("At");
		words.add("High");
		words.add("Everything");
		words.add("Set");
		words.add("How");
		words.add("Law");
		words.add("Literature");
		words.add("Repulsive");
		words.add("Questions");
		words.add("Contented");
		words.add("Few");
		words.add("Extensive");
		words.add("Supported");
		words.add("Remarkably");
		words.add("Thoroughly");
		words.add("He");
		words.add("Appearance");
		words.add("Supposing");
		words.add("Tolerably");
		words.add("Applauded");
		words.add("Be");
		words.add("Suffering");
		words.add("Unfeeling");
		words.add("Objection");
		words.add("Agreeable");
		words.add("Allowance");
		words.add("Me");
		words.add("Ask");
		words.add("Within");
		words.add("Entire");
		words.add("Season");
		words.add("Common");
		words.add("Who");
		words.add("Family");
		words.add("Valley");
		words.add("Warmth");
		words.add("Assure");
		words.add("On");
		words.add("Park");
		words.add("Girl");
		words.add("They");
		words.add("Rich");
		words.add("Hour");
		words.add("New");
		words.add("Well");
		words.add("Way");
		words.add("Face");
		words.add("Been");
		words.add("Room");
		words.add("We");
		words.add("Sons");
		words.add("Fond");
		words.add("If");
		words.add("Wandered");
		words.add("Relation");
		words.add("Surprise");
		words.add("Screened");
		words.add("Doubtful");
		words.add("Overcame");
		words.add("Insisted");
		words.add("Trifling");
		words.add("Husbands");
		words.add("Might");
		words.add("Hours");
		words.add("Found");
		words.add("Dissimilar");
		words.add("Companions");
		words.add("Friendship");
		words.add("Impossible");
		words.add("Diminution");
		words.add("Did");
		words.add("Yourself");
		words.add("Carriage");
		words.add("Learning");
		words.add("She");
		words.add("Man");
		words.add("Its");
		words.add("Replying");
		words.add("Sister");
		words.add("Piqued");
		words.add("Living");
		words.add("Enable");
		words.add("Mrs");
		words.add("Spirit");
		words.add("Really");
		words.add("Parish");
		words.add("Oppose");
		words.add("Repair");
		words.add("Misery");
		words.add("Quick");
		words.add("May");
		words.add("Saw");
		words.add("Style");
		words.add("After");
		words.add("Money");
		words.add("Smile");
		words.add("Spoke");
		words.add("Total");
		words.add("Great");
		words.add("Never");
		words.add("Their");
		words.add("Too");
		words.add("Amongst");
		words.add("Moments");
		words.add("Arrived");
		words.add("Replied");
		words.add("Fat");
		words.add("Weddings");
		words.add("Servants");
		words.add("But");
		words.add("Believed");
		words.add("Prospect");
		words.add("Understood");
		words.add("Especially");
		words.add("Pianoforte");
		words.add("Introduced");
		words.add("Nay");
		words.add("Newspaper");
		words.add("Can");
		words.add("Sportsman");
		words.add("Are");
		words.add("Admitting");
		words.add("Gentleman");
		words.add("Summer");
		words.add("Lovers");
		words.add("Twenty");
		words.add("Not");
		words.add("Difficulty");
		words.add("Surrounded");
		words.add("Bed");
		words.add("Seems");
		words.add("Folly");
		words.add("Given");
		words.add("Scale");
		words.add("Dependent");
		words.add("Conveying");
		words.add("Advantage");
		words.add("Use");
		words.add("Abilities");
		words.add("Perfectly");
		words.add("Pretended");
		words.add("Strangers");
		words.add("Exquisite");
		words.add("Oh");
		words.add("Another");
		words.add("Chamber");
		words.add("Pleased");
		words.add("Imagine");
		words.add("Went");
		words.add("Rank");
		words.add("Last");
		words.add("Loud");
		words.add("Shot");
		words.add("Draw");
		words.add("Excellent");
		words.add("Sincerity");
		words.add("Smallness");
		words.add("Removal");
		words.add("Request");
		words.add("Delight");
		words.add("Unaffected");
		words.add("Apartments");
		words.add("Astonished");
		words.add("Decisively");
		words.add("Offended");
		words.add("Ten");
		words.add("Old");
		words.add("Consider");
		words.add("Speaking");
		words.add("Happen");
		words.add("Unable");
		words.add("Uneasy");
		words.add("Drawings");
		words.add("Followed");
		words.add("Improved");
		words.add("Out");
		words.add("Sociable");
		words.add("Earnestly");
		words.add("Instantly");
		words.add("See");
		words.add("General");
		words.add("Civilly");
		words.add("Amiable");
		words.add("Account");
		words.add("Carried");
		words.add("Excellence");
		words.add("Projecting");
		words.add("Estimating");
		words.add("Side");
		words.add("Life");
		words.add("Past");
		words.add("Continue");
		words.add("Indulged");
		words.add("Was");
		words.add("Horrible");
		words.add("For");
		words.add("Domestic");
		words.add("Position");
		words.add("Seeing");
		words.add("Rather");
		words.add("Esteem");
		words.add("Men");
		words.add("Settle");
		words.add("Genius");
		words.add("Excuse");
		words.add("Deal");
		words.add("Say");
		words.add("Over");
		words.add("Age");
		words.add("From");
		words.add("Comparison");
		words.add("Ham");
		words.add("Melancholy");
		words.add("Son");
		words.add("Cause");
		words.add("Dried");
		words.add("Solid");
		words.add("Small");
		words.add("Still");
		words.add("Widen");
		words.add("Weather");
		words.add("Evident");
		words.add("Smiling");
		words.add("Against");
		words.add("Examine");
		words.add("Rendered");
		words.add("Opinions");
		words.add("Two");
		words.add("Moderate");
		words.add("Striking");
		words.add("Sufficient");
		words.add("Compliment");
		words.add("Stimulated");
		words.add("Assistance");
		words.add("Convinced");
		words.add("Resolving");
		words.add("Remainder");
		words.add("Cordially");
		words.add("Affection");
		words.add("Propriety");
		words.add("Towards");
		words.add("Private");
		words.add("More");
		words.add("Part");
		words.add("Lose");
		words.add("Need");
		words.add("Want");
		words.add("Bringing");
		words.add("Sensible");
		words.add("Pleasure");
		words.add("Prevent");
		words.add("Parlors");
		words.add("Waiting");
		words.add("Females");
		words.add("Message");
		words.add("Society");
		words.add("Father");
		words.add("Looked");
		words.add("Sooner");
		words.add("Attachment");
		words.add("Frequently");
		words.add("Gay");
		words.add("Terminated");
		words.add("Greater");
		words.add("Prudent");
		words.add("Placing");
		words.add("Passage");
		words.add("Distant");
		words.add("Behaved");
		words.add("Natural");
		words.add("Between");
		words.add("Talking");
		words.add("Friends");
		words.add("Windows");
		words.add("Painful");
		words.add("Event");
		words.add("Being");
		words.add("Think");
		words.add("Three");
		words.add("Aware");
		words.add("Point");
		words.add("Effects");
		words.add("Warrant");
		words.add("Feeling");
		words.add("Settled");
		words.add("Resolve");
		words.add("Depending");
		words.add("Sentiments");
		words.add("Rooms");
		words.add("Doors");
		words.add("Shall");
		words.add("Education");
		words.add("Dejection");
		words.add("Daughters");
		words.add("Sportsmen");
		words.add("Easy");
		words.add("Took");
		words.add("Shed");
		words.add("Kind");
		words.add("Phasellus");
		words.add("Accumsan");
		words.add("Neque");
		words.add("Non");
		words.add("Ex");
		words.add("Lobortis");
		words.add("Eget");
		words.add("Auctor");
		words.add("Mauris");
		words.add("Luctus");
		words.add("Nulla");
		words.add("Tempus");
		words.add("Elit");
		words.add("Sit");
		words.add("Amet");
		words.add("Tincidunt");
		words.add("Condimentum");
		words.add("Aliquam");
		words.add("Erat");
		words.add("Volutpat");
		words.add("Sed");
		words.add("Mattis");
		words.add("Velit");
		words.add("Blandit");
		words.add("Diam");
		words.add("Consectetur");
		words.add("Nec");
		words.add("Ante");
		words.add("Vitae");
		words.add("Pretium");
		words.add("Magna");
		words.add("Pellentesque");
		words.add("Euismod");
		words.add("Quam");
		words.add("Facilisis");
		words.add("Urna");
		words.add("Viverra");
		words.add("Eleifend");
		words.add("Nunc");
		words.add("Pharetra");
		words.add("Commodo");
		words.add("Ullamcorper");
		words.add("Sem");
		words.add("Nisl");
		words.add("Hendrerit");
		words.add("Dignissim");
		words.add("Gravida");
		words.add("Felis");
		words.add("Donec");
		words.add("Consequat");
		words.add("Molestie");
		words.add("Lacinia");
		words.add("Turpis");
		words.add("Varius");
		words.add("Imperdiet");
		words.add("Augue");
		words.add("Ligula");
		words.add("Et");
		words.add("Cursus");
		words.add("Tempor");
		words.add("A");
		words.add("Dictum");
		words.add("Cras");
		words.add("Fermentum");
		words.add("Id");
		words.add("Nisi");
		words.add("Ut");
		words.add("Posuere");
		words.add("Sagittis");
		words.add("Arcu");
		words.add("Vivamus");
		words.add("Leo");
		words.add("Vehicula");
		words.add("Metus");
		words.add("Pulvinar");
		words.add("Etiam");
		words.add("Libero");
		words.add("Proin");
		words.add("Morbi");
		words.add("Nibh");
		words.add("Eros");
		words.add("Efficitur");
		words.add("Eu");
		words.add("Nam");
		words.add("Ipsum");
		words.add("Vestibulum");
		words.add("Placerat");
		words.add("Tortor");
		words.add("Lacus");
		words.add("Tristique");
		words.add("Curabitur");
		words.add("Elementum");
		words.add("Aenean");
		words.add("Lorem");
		words.add("Egestas");
		words.add("Tellus");
		words.add("Est");
		words.add("Finibus");
		words.add("Maximus");
		words.add("Lectus");
		words.add("Dapibus");
	}
	
	private String get()
	{
		return words.get(rand.nextInt(words.size()));
	}
	
	private final Random rand = new Random();
	private final ArrayList<String> words;

	@Override
	public void execute() throws IOException
	{
		while(!Thread.currentThread().isInterrupted())
		{
			try
			{
				Socket socket = new Socket(host, port);
				DataOutputStream data = new DataOutputStream(socket.getOutputStream());
				
				data.writeUTF(Protocol.Join(get() + get() + get()));

				String message;	
				while(!Thread.currentThread().isInterrupted())
				{
					switch(rand.nextInt(4) + 2)
					{
					case 2:
						message = String.format("%s %s", get(), get());
						break;
					case 3:
						message = String.format("%s %s %s", get(), get(), get());
						break;
					case 4:
						message = String.format("%s %s %s %s", get(), get(), get(), get());
						break;
					default:
						message = String.format("%s %s %s %s %s", get(), get(), get(), get(), get());
						break;
					}
					
					data.writeUTF(Protocol.Message(message));
					
					try
					{
						Thread.sleep(rand.nextInt(200));					
					} catch(InterruptedException e) { }
					
				}
				
				socket.close();
			}
			catch(SocketException e) { }

			try
			{
				Thread.sleep(rand.nextInt(200));					
			} catch(InterruptedException e) { }
			
		}

	}
	
}