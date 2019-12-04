# BridgeLabz

Object Oriented Programs
Address Book Problem.
JSON Inventory Data Management of Rice, Pulses and Wheats
Desc -> Create a JSON file having Inventory Details for Rice, Pulses and Wheats with properties name, weight, price per kg. 
Use Library : Java JSON Library, For IOS JSON Library use NSJSONSerialization for parsing the JSON.
I/P -> read in JSON File
Logic -> Get JSON Object in Java or NSDictionary in iOS. Create Inventory Object from JSON. Calculate the value for every Inventory. 
O/P -> Create the JSON from Inventory Object and output the JSON String
Inventory Management Program
Desc -> Extend the above program to Create InventoryManager to manage the Inventory. The Inventory Manager will use InventoryFactory to create Inventory Object from JSON. The InventoryManager will call each Inventory Object in its list to calculate the Inventory Price and then call the Inventory Object to return the JSON String. The main program will be with InventoryManager
I/P -> read in JSON File
Logic -> Get JSON Object in Java or NSDictionary in iOS. Create Inventory Object from JSON. Calculate the value for every Inventory. 
O/P -> Create the JSON from Inventory Object and output the JSON String.
Stock Account Management
Desc -> Write a program to read in Stock Names, Number of Share, Share Price. Print a Stock Report with total value of each Stock and the total value of Stock.
I/P -> N number of Stocks, for Each Stock Read In the Share Name, Number of Share, and Share Price
Logic -> Calculate the value of each stock and the total value
O/P -> Print the Stock Report.
Hint -> Create Stock and Stock Portfolio Class holding the list of Stocks read from the input file. Have functions in the Class to calculate the value of each stock and the value of total stocks
Commercial data processing - StockAccount.java implements a data type that might be used by a financial institution to keep track of customer information. The StockAccount class implements following methods

The StockAccount class also maintains a list of CompanyShares object which has Stock Symbol and Number of Shares as well as DateTime of the transaction. When buy or sell is initiated StockAccount checks if CompanyShares are available and accordingly update or create an Object.
Maintain the List of CompanyShares in a Linked List So new CompanyShares can be added or removed easily. Do not use any Collection Library to implement Linked List.
Further maintain the Stock Symbol Purchased or Sold in a Stack implemented using Linked List to indicate transactions done.
Further maintain DateTime of the transaction in a Queue implemented using Linked List to indicate when the transactions were done.
Write a Program DeckOfCards.java, to initialize deck of cards having suit ("Clubs", "Diamonds", "Hearts", "Spades") & Rank ("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"). Shuffle the cards using Random method and then distribute 9 Cards to 4 Players and Print the Cards the received by the 4 Players using 2D Array…
Extend the above program to create a Player Object having Deck of Cards, and having ability to Sort by Rank and maintain the cards in a Queue implemented using Linked List. Do not use any Collection Library. Further the Player are also arranged in Queue. Finally Print the Player and the Cards received by each Player.
Clinique Management Programme. This programme is used to manage a list of Doctors associated with the Clinique. This also manages the list of patients who use the clinique. It manages Doctors by Name, Id, Specialization and Availability (AM,  PM or both). It manages Patients by Name, ID, Mobile Number and Age. The Program allows users to search Doctor by name, id, Specialization or Availability. Also the programs allows users to search patient by name, mobile number or id. The programs allows patients to take appointment with the doctor. A doctor at  any availability time can see only 5 patients. If exceeded the user can take appointment for patient at different date or availability time. Print the Doctor Patient Report. Also show which Specialization is popular in the Clinique as well as which Doctor is popular. For .NET Engineers use the following
ADO.NET Connection Pooling to maintain Doctor, Patient and Appointment Info in the Database
Use Log4NET to Log Data
Read Patient and Doctor Data from JSON File using File IO and latter with Firebase. Use Factory Pattern and Interface Approach to read Doctor and Patient information.
