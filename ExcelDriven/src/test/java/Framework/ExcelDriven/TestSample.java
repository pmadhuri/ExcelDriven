package Framework.ExcelDriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {

	public static void main(String[] args) throws IOException {
	DataDriven data=new DataDriven();
	  ArrayList al =data.getData("purchase");
	System.out.println(al.get(0));
	System.out.println(al.get(1));
	System.out.println(al.get(2));
	System.out.println(al.get(3));
	
	
	
	

	}

}
