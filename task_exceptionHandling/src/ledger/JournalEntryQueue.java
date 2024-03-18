package ledger;

import java.util.ArrayList;

public class JournalEntryQueue {
	
	private static JournalEntryQueue queue;
	ArrayList<String> entries = new ArrayList<>();
	
	private JournalEntryQueue(int size) {
		for (int i = 0; i < size; i++) {
			add(AccountManager.getRandomJournalEntry(2));
		}
	}
	
	public static void init(int size) {
		queue = new JournalEntryQueue(size);
	}
	
	public static JournalEntryQueue getInstance() {
		return queue;
	}	
	
	public void add(String entry) {
		synchronized (entries) {
			entries.add(entry);
		}		
	}
	
	public String get() {
		synchronized (entries) {
			if (entries.size() > 0) {
				return entries.remove(0);
			}
		}		
		return null;
	}
	
	public int getSize() {
		return entries.size();
	}

}
