##### **How to run**
1) Open command line or terminal
2) Go to project directory named market-rate-spread
3) Within the directory execute: mvn clean install
4) Next execute: mvn exec:java -Dexec.mainClass="com.market.rates.Application"
5) Server should startup
6) Go to browser window or a rest client of your choice to execute the queries
7) To quit the server just press ctrl+c in terminal and then Y when prompted by terminal

##### **Queries to execute**

To get information about specific user profile execute the following:

1) http://localhost:8000/user/profile/userId?userId=default

There are three preset options for userId. Each has a different spread percentage.
Tier A user: default
Tier B user: test
Tier C user: prodUser

2) To get information about the spread for specific user execute the following:

http://localhost:8000/rates/latest?userId=default

##### **Assumptions**
1) Queries would be user specific. UserId needs to be supplied to get information 
about a user or rates.
2) Only userId parameter taken into account when submitting the queries. 
Other parameters would get ignored.
2) Users stored in-memory in Hashtable
3) No dependency injection or web framework used
4) Rates taken from the url provided in the task
5) Only the users specified in the in-memory storage can be used. 
If new users are required then those would need to be entered into the hashmap first.

 