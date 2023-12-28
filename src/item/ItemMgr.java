package item;

import java.util.List;

import facade.DataEngineImpl;
import mgr.Factory;
import mgr.Manageable;
import mgr.Manager;

public class ItemMgr extends DataEngineImpl<Item> {
	private static ItemMgr engine = null;
	private ItemMgr() {
		setLabels(headers);
		readAll("items.txt", new Factory<Item>() {
			public Item create() {
				return new Item();
			}
		});		
	}
	public static ItemMgr getInstance() {
		if (engine == null)
			engine = new ItemMgr();
		return engine;
	}
	private String[] headers = {"코드", "이름", "가격", "filename"};
}
