public class Trial 
{
    public static void main(String[] args)
    {
        int x = 60;
        int y = 90;
        int width = 200;
        int height = 300;

        Rectangle box = new Rectangle(x, y, width, height);
        Rectangle box2 = new Rectangle(x+width, y+height, width, height);
        box.setColor(Color.MAGENTA);
        
        box.fill();
        box.setColor(new Color(0,255,255));
        box2.fill();
    }
}
