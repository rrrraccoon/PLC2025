import java.util.Scanner;
import java.util.EnumSet;

public class ErrorsEnum
{
    enum Error { FP_ROUNDING, FP_OVERFLOW, FP_UNDERFLOW, INT_OVERFLOW }

    enum Result { A_BIT_DIFFERENT, INFINITY, ZERO, VERY_DIFFERENT }
    
    private static <E extends Enum<E>> E getEnumElement(String elementTypeName, Class<E> elementType)
    {
        boolean haveError = false;
        E error = null;
        Scanner stdin = new Scanner(System.in);
        
        while ( ! haveError )
        {
            System.out.print("Input " + elementTypeName + ": ");
            try
            {
                error = Enum.valueOf(elementType, stdin.next().toUpperCase());
                haveError = true;
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Not a valid " + elementTypeName + ".");
                stdin.nextLine(); // skip the invalid input
            }
        }
        
        stdin.close();
        return error;
    }
  
    private static Error result2Error(Result r)
    {
        Error error = null;
        
        switch (r) {
        case A_BIT_DIFFERENT:
            error = Error.FP_ROUNDING;
            break;
        case INFINITY:
            error = Error.FP_OVERFLOW;
            break;
        case ZERO:
            error = Error.FP_UNDERFLOW;
            break;
        case VERY_DIFFERENT:
            error = Error.INT_OVERFLOW;
            break;
        }
        
        return error;
    }

    public static void main(String[] args)
    {
        System.out.print("Known results = ");
        for (Result r : EnumSet.allOf(Result.class)) 
        {
            System.out.print(r + " ");
        }
        System.out.println();
        
        Result r = getEnumElement("result", Result.class);
        System.out.println(r + " is from the error: " + result2Error(r));
    }
}
