// What should an Assignment do?
// How do you want to use it for this program?
// You can put any code related to the Assignment class you
// want in here.

public class Assignment
{
    private int priority;
    public String name;
    private Photographer photographer =  new Photographer("");
    public Assignment(int priority, String description)
    {
        this.priority=priority;
        this.name=description;
        this.photographer =  new Photographer("");
        
    }
    public Assignment(int priority, String description, Photographer photographer)
    {
        this.priority=priority;
        this.name=description;
        this.photographer =photographer;
    }
    
    public int returnPriority()
    {
        return this.priority;
    }
    public String returnDescription()
    {
        return this.name;
    }
    public void setPhotographer(Photographer photographer)
    {
        this.photographer=photographer;
    }
    public String returnPhotographerName()
    {
        return this.photographer.returnName();
    }
}
