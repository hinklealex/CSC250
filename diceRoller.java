package diceRolleer;
import java.util.StringTokenizer;

public class diceRoller 
{
	
	    private String dexpr;
	    
	    public diceRoller(String dexpr)
	    {
	        this.dexpr = dexpr; 
	    }
	    
	    public void display()
	    {
	        System.out.println("DiceRoller: " + this.dexpr);
	    }
	    private int stringToInt(String s)
	    {
	        return Integer.parseInt(s);
	        /*
	        int place =1;
	        int total =0;
	        for(int i = s.length()-1;i >=0; i--)
	        {
	            total = total + (place * "0123456789".indexOf(s.charAt(i)));
	            place = place * 10;
	        }
	        return total;
	        */
	    }
	    private int parseDice(String d)
	    {
	        System.out.println("Rolling: "+d);
	        String temp = "";
	        int numberOfDice = -1;
	        int numberOfSides = -1;
	        for(int i = 0; i < this.dexpr.length(); i++)
	        {
	            if(d.charAt(i) != 'D')
	            {
	                temp = temp + d.charAt(i);
	            }
	            else
	            {
	                //number of dice
	                numberOfDice = this.stringToInt(temp);
	                temp = "";
	            }
	        }
	        //number of sides
	        numberOfSides = this.stringToInt(temp);
	        
	        dice aDice = new dice(numberOfSides);
	        int total = 0;
	        for(int i = 0; i < numberOfDice; i++)
	        {
	            total += aDice.roll();
	        }
	        return total;
	    }
	    
	    private int processExpression()
	    {
	        String temp = "";
	        int total = 0;
	        for(int i = 0; i < this.dexpr.length(); i++)
	        {
	            if(this.dexpr.charAt(i) != '+')
	            {
	                temp = temp + this.dexpr.charAt(i);
	            }
	            else
	            {
	                total += this.parseDice(temp);
	                temp = "";
	            }
	        }
	        total += this.parseDice(temp);
	        return total; 
	    }
	    
	    public int roll()
	    {
	        //logic 
	        return this.processExpression();
	    }
	}

