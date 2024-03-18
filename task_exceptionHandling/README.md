## task: Exception Handling & multithreading

**Overview**: These key points outline the objectives and expectations for each task, focusing on the implementation of a booking system with basic accounting functionality and extending it to support concurrency. This task involves implementing a simple booking system. Key elements of the booking process include opening an account, preparing a transaction (credit or debit), committing the transaction, and finally, closing the account. 


- **Basic Accounting Terms**: Familiarize yourself with basic accounting terms such as Account, Debit, Credit, Asset Accounts, Liability Accounts, and Journal Entry. This foundational knowledge is crucial for the task.

- **Account Asset & Liability Implementation**: Implement the methods `credit(int)` and `debit(int)` in the Asset and Liability classes, ensuring changes affect the delta value and not the account's value directly. The account's value is only modified upon the `commit()` method's call. Proper exceptions should be thrown for errors like an unopened account or insufficient funds.

- **AccountManager Implementation**: Implement `getAccount`, `getAsset`, and `getLiability` methods in the AccountManager class. These methods should fetch accounts based on the provided names, with `getAccount` searching through all accounts. An appropriate exception should be thrown if an account is not found, instead of returning null.

- **Accountant Implementation**: Implement the `postEntry()` method in the Accountant class, which takes a journal entry as its parameter. This method involves syntax checking of the journal entry, ensuring debits equal credits, opening accounts, preparing and committing the transaction, and handling errors by aborting if necessary, then closing accounts.

- **Testing**: Test the implementation with provided and custom journal entries, including handling of possible errors. Adjustments to the `ERRORRATIO` variable in the AccountManager class can increase or decrease the frequency of error-ridden journal entries in testing.

- **Lab Questions**: Be prepared to discuss your submission and answer related questions in the lab session.


- **JournalEntryQueue Implementation**: Implement a class named JournalEntryQueue in the ledger package to act as a buffer for a specified number of journal entries. The class should support adding entries, removing the first entry, and determining the current number of entries.

- **Accountant Extension for Concurrency**: Modify the Accountant class to support concurrency, either by extending Thread or implementing Runnable. Implement logic in the `run()` method to process journal entries from the buffer, handling all scenarios such as syntax errors, temporary conditions that prevent booking, and ensuring thread-safe access to accounts.

- **Main Method Alteration for Testing**: Change the main method to test the algorithm with various parameter values, creating JournalEntryQueue with a set number of random journal entries and starting multiple Accountant threads to process these entries. After processing, output the total number of successful bookings and the total time taken.

- **Concurrency Considerations**: Implement thread-safe operations, ensuring that accounts are only modified by the thread that has opened them. Consider deadlock scenarios and their resolution, for example, when two accountants try to open accounts that the other has already opened.

- **Lab Questions**: Be prepared to discuss your implementation and answer related questions in the lab session.

