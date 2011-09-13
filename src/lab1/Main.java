/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author lucian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println("Введите число из промежутка (-1,+1):\n");
        double x= strToDouble(readStr("0"));
        int n= 100;
        System.out.printf ("Result: %8.8f\n", calculate(x, n));
        
     }
    public static String readStr (String defVal)
    {
        InputStreamReader iStr = new InputStreamReader (System.in);
        BufferedReader br = new BufferedReader (iStr);
        String tmpStr = defVal;
        try
        {
            tmpStr = br.readLine();
        }
        catch (IOException e)
        {
            System.out.println ("Err::IOError "+e+"\n");

        }

        return tmpStr;
    }
    public static double strToDouble (String str)
    {
        double res = 0;        int sign = 1;
        String M=str;
        String m="0";
        if (str.indexOf('.')!=-1)
        {
            M = str.substring(0, str.indexOf('.'));
            m = str.substring(str.indexOf('.')+1,str.length());           
        }
 
        if (M.charAt(0) == '-')
        {
            sign = -1;
            M=M.substring(1);
        }
        for (int i=0;i<(m.length()>M.length()?m.length():M.length());i++)
        {
            if (i<m.length())
            {
                res+=(m.charAt(i)-'0')* Math.pow(10, -1*(i+1));
            }

            if (i<M.length())
            {
                res+=(M.charAt(i)-'0')* Math.pow(10, M.length()-i-1);
            }
        }

        return sign*res;
    }
    public static double calculate (double x, int n)
    {        double res=0;
        // (n+1)*(n+2)*(x^n)/2
        double pow_x = 1;
        int unit = 1;


        for (int i=0; i<n+1;i++)
        {
            res+=unit*pow_x*(i+1)*(i+2)/2;
            pow_x*=x;
            unit*=-1;
        }
        return res;
    }

}
