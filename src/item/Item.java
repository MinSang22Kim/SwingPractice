package item;

import java.util.Scanner;

import facade.UIData;
import mgr.Manageable;

public class Item implements Manageable, UIData {
	String code;
	String name;
	int price;
	String imgfilename;
	public void read(Scanner scan) {  // Student
		imgfilename = scan.next();
		imgfilename = "image/" + imgfilename + ".png";
		code = scan.next();
		name = scan.next();
		price = scan.nextInt();  // 0.1%
	}
	public boolean matches(String kwd) {
		if (kwd.length() == 0)
			return true;
		if (code.contains(kwd))
		    return true;
		if (name.contains(kwd))
		    return true;
		return false;
    }
	public void print() {
		System.out.format("[%s] %s (%d원) ", 
				code, name, price);
		System.out.println();
	}
	@Override
	public void set(Object[] uitexts) {
		// TODO Auto-generated method stub
	}
	@Override
	public String[] getUiTexts() {
		// TODO Auto-generated method stub
		String[] texts = new String[4];
		texts[0] = code;
		texts[1] = name;
		texts[2] = ""+price;
		texts[3] = imgfilename;
		return texts;
	}
}