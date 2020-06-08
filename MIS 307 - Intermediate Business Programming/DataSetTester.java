/**
   Run some tests for the DataSet class
*/
public class DataSetTester
{
   public static void main(String[] args)
   {
      DataSet data = new DataSet();
      data.add(4.5);
      data.add(-17.2);
      data.add(5.7);
      data.add(12.1);
      data.add(-2.8);
      data.add(22.2);
      data.add(6.6);
      data.add(-5.0);

      System.out.println("Sum: " + data.getSum());
      System.out.println("Expected: 26.1");
      System.out.println("Average: " + data.getAverage());
      System.out.println("Expected: 3.2626");
      System.out.println("Maximum: " + data.getMaximum());
      System.out.println("Expected: 22.2");
   }
}
