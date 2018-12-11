// TO-DO
// Fill in the methods in the manager class so
// that when the simulation runs, and simulates the
// story, the assignments are assigned to photographers
// in the correct order, and printed out with photographers
// signatures below them in the order in which they are completed.
import java.util.ArrayList;

public class Manager
{
    // YOUR CODE HERE
    // What does the manager need to remember to do his/her job?
    private ArrayList<Assignment> NewAssignments;
    private ArrayList<Assignment> DoneAssignments;
    private ArrayList<Photographer> photographers; 

    public Manager()
    {
        // YOUR CODE HERE
        // How do you need to initialize the instance variables?
        photographers = new ArrayList<Photographer>();
        NewAssignments = new ArrayList<Assignment>();
        DoneAssignments = new ArrayList<Assignment>();
    }

    /**
     * Called when it's time to hire a new photographer.
     */
    public void hire(String photographer)
    {

        // YOUR CODE HERE
        // How will you keep track of the photographers you have hired?
        photographers.add(new Photographer(photographer));
    }

    /**
     * Called when it's time for the daily meeting where
     * the highest priority assignments are given to photographers.
     * Each photographer can take one assignment. The highest priority
     * assignment should be given out first and the highest priority
     * assignment should go to the photographer who was hired first.
     */
    public void giveOutAssignments()
    {

        // YOUR CODE HERE
        // Where did you store the photographers and unfinished assignments?
        // Assign the highest priority assignment first to the
        // photographer who was hired first, then the next highest priority
        // assignment to the next photographer.

        for (Photographer photographer : photographers) 
        {
            if (NewAssignments.size()>0){
                int maxprio=0;
                int maxPrioID=NewAssignments.size()-1;
                for (int i = 0; i < NewAssignments.size(); i++)
                {
                    if (NewAssignments.get(i).returnPriority()>maxprio)
                    {
                        maxPrioID=i;
                        maxprio=NewAssignments.get(i).returnPriority();
                    }
                }

                Assignment doneAssingment=NewAssignments.remove(maxPrioID);
                doneAssingment.setPhotographer(photographer);
                DoneAssignments.add(doneAssingment);

            }

        }
    }

    /**
     * A Customer came up with a new assignment. The manager should
     * add it to the to-do list so that next time it's time to give
     * out assignments, the new assignment will be a possibility.
     */
    public void newAssignment(int priority, String description)
    {
        // YOUR CODE HERE
        // How will you keep track of the unfinished assignments?
        NewAssignments.add(new Assignment(priority,description));
    }

    /**
     * It's the end of the story for now. Time to look at all the
     * work the company has done.
     */
    public void checkPortfolio()
    {
        int previousx=0;
        int counter =0;
        for (int i=0; i<DoneAssignments.size();i++)
        {               

            Picture pic = new Picture();
            pic.load( DoneAssignments.get(i).returnPhotographer().takePicture(DoneAssignments.get(i).returnDescription()));
            if (i>0)
            {//kell translate
                pic.translate(previousx,0);
            }
            pic.draw();
            Text text = new Text(pic.getX(),pic.getMaxY(),DoneAssignments.get(i).returnPhotographerName());
            text.draw();
            previousx=pic.getMaxX();

        }
        // YOUR CODE HERE
        // You may need to display all the finished work when
        // this method is called, or you may have been displaying
        // the photos as you went. If you have already displayed
        // the photos, there is no need to do anything here.

    }
}
