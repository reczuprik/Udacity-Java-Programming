public class Person
{
    private String name;
    private String friends;
    private int xCoord;
    private int yCoord;
    public Person (String name, String pictureName, int xCoord, int yCoord)
    {
        this.name = name;
        friends = "";
        Picture picture = new Picture(pictureName);
        this.xCoord=xCoord;
        this.yCoord=yCoord;
        picture.translate(xCoord, yCoord);
        picture.draw();
      
    }
    
    public String getFriends()
    {
        return friends;
    }
    
    public void addFriend(Person friend)
    {
        friends= friends +  friend.name + " ";
        SmallCircle circle = new SmallCircle(this.xCoord, this.yCoord);
        circle.fill();
        Line someLine = new Line (this.xCoord, this.yCoord, friend.xCoord, friend.yCoord);
        someLine.draw();
    }
    
    public void makeMutualFriend(Person friend)
    {
        this.addFriend(friend);
        friend.addFriend(this);
    }
    
    public void makeMutualUnFriend(Person nonFriend)
    {
        this.unFriend(nonFriend);
        nonFriend.unFriend(this);
    }
    
    public void unFriend(Person nonFriend)
    {
        friends= friends.replace(nonFriend.name + " ","");
    }
}
