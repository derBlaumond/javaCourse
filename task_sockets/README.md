### task: Using Sockets and implementing Client & Server

**Overview**: This task focuses on creating a client program for an online trading simulation, requiring interaction with a server to perform trading activities using virtual goods.

### Client
- **Objective**: Develop an interactive console application that enables comfortable use of all functions provided by the trading simulation.
- **Server Address**: The trading simulation is available at `vm3.mcc.tu-berlin.de` on port `8080`.
- **Authentication and Identification**: Users must authenticate and identify themselves with a key, a name, and a security number (`sec_nr`) to interact with the application.
- **Key Activities**: After registration (`Register`), users can trade with virtual starting resources, retrieve their current inventory (`GetInventory`), delete their account (`Delete`), and unblock their account (`Unblock`) if locked. Correct user name and security number are mandatory for transactions to prevent account lock.
- **Server Interaction**: Client-server communication involves sending a 6-digit authentication key followed by commands with parameters for specific actions.
- **Implementation Hints**: Ensure correct syntax in commands, avoid leading or trailing spaces, and convert your matriculation number to bytes for transmission. Sample program flow is available on ISIS for reference. Monitor server availability and report extended downtime on the ISIS forum.

### Server
- **Objective**: Analyze parts of the server source code obtained during a hacker attack to devise a strategy that exploits the price-finding process of the application to your advantage.
- **Key Functions**: `getSale[README.md](README.md)s`, `getPurchases`, and `getAverageAmount` determine the sales prices, purchase prices, and average amount of inventory, respectively. The deletion of a user (`deleteUser`) involves adjusting the bank's inventory based on the user's inventory.
- **Price-Finding Exploit**: Understand the price calculation to manipulate the system for beneficial trading conditions, focusing on how inventory levels affect sales and purchase prices.
