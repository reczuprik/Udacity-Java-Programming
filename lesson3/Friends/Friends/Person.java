public class Person
{
    private String name;
    private String friends;
    
    public Person(String aName)
    {
        name=aName;
        friends="";
    }
    
    public String getFriends()
    {
        return friends;
    }
    
    public void addFriend(Person friend)
    {
        friends= friends +  friend.name + " ";
    }
    
    public void unFriend(Person nonFriend)
    {
        friends= friends.replace(nonFriend.name + " ","");
    }
}
