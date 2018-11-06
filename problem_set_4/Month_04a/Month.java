//Write a class Month.

//A Month has a constructor that takes the month number as a parameter (1 for January, 2 for February and so forth)
//   public Month(int monthNumber)
//If monthNumber is not 1 to 12, set it to 1

//And 2 methods
//   public String getMonthName() Use if / else if /else if ...
//   public int getNumberOfDays() Do NOT use a separate if / else branch for each month. Use Boolean operators (&&, ||, !).
//       You will have an if then else if then else.
//       For February return 28
//
//These are implemented for you as stubs

//Now write a class MonthPrinter which will instantiate a Month object, ask the user for a month number
//and print the name of the month and the number or days.

//If the month is 6, the output should look exactly like this
//June 30

//If the user enters an invalid month number print this error message: "Number must be 1 through 12"

//If the user enters a non-integer, give this error message: "Not an integer. Terminating"

//To be considered correct, you must enter the message exactly as specified.

//For the draft:
//In Month, provide the constructor and the instance variable.

//In MonthTester, ask the usr for a number 1 to 12 and create a date object with that number

public class Month
{
    //instance variables
    private int month ;
    /**
     * Contructs a Month
     * @param the month number. Must be 1 to 12. For any other number, the month number is set to 1
     */
    public Month(int theMonthNumber)
    {
        if (theMonthNumber>12 || theMonthNumber<1)
        {
            month=1;
        }
        else
        {
            month=theMonthNumber;
        }
        
    }

    /**
     * Gets the name of this month
     * @return the name of this month
     */
    public String getMonthName()
    {
        if (month == 1) {return "January";}
        if (month == 2) {return "February";}
        if (month == 3) {return "March";}
        if (month == 4) {return "April";}
        if (month == 5) {return "May";}
        if (month == 6) {return "June";}
        if (month == 7) {return "July";}
        if (month == 8) {return "August";}
        if (month == 9) {return "September";}
        if (month == 10) {return "October";}
        if (month == 11) {return "November";}

        return "December";
    }

    /**
     * Gets the number of days in this month
     * @return the number of days in this month in a non-leap year
     */
    public int getNumberOfDays()
    {
        if (month == 1 ||month == 3 || month == 5|| month == 7|| month == 8||month == 10 ||month == 12)
        {
        return 31;
        } 
        else if (month==2)
        {
            return 28;
        }
        else
        {
            return 30;
        }
        
    }
}
