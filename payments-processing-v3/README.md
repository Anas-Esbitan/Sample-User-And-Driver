# Assignment: Payment Processing System Implementation


### Objective
Build a payment processing application by implementing the provided interface. 
The assignment includes a Maven project with predefined unit tests to verify your implementation, 
**all unit tests should pass or your submission will be disqualified**.


##### Transaction fields
each transaction consists of the following fields:
* unique ID
* customer id
* amount
* payment type
* transaction date

##### Fees calculation
The system currently supports three payment methods, and each one has different rules for fees calculation: 
* credit cards: 2.5% of the transaction amount
* transfer directly from the bank: 1.2% of the transaction amount (the minimum fee of this type is 0.50)
* digital wallet: 1.8% of the transaction amount + 0.30 fixed charge

If a customer has previous transactions with total of more than 5000 in the last month, apply a 5% discount on the final calculated fee.

##### Transactions reconciliation
In this system, reconciliation is required to compare and verify a specific customer transactions with a list of 
transactions coming from another system. Implement this method and return a detailed result showing the status of each 
single transaction.


##### Documentation
**This part is required, failing to complete will disqualify your application.**

In the Notes.txt file (provided with the code), answer the following:
* what did you learn while solving this task?
* what did you use to store transactions? did you consider other options?
* what difficulties did you face while solving the assignment? or which part wasn't clear?
* how would you improve this payment processing system for a real-world scenario?
* did you validate the values passed as method arguments?