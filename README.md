# ipChange-Server-Client-Socket-Communication
Communication from a Server to/from a Client, while simultaneously changing the bound IP Address.

In today's world, security is a major aspect of any communication. When a server and client communicate, only they should know the secure line on which they are talking on. This program creates a Client and a Server using socket progeramming methods in Java. 

After the server is Started, the client will send a message. The client outputs his message on the console as well. The Server recieves the message, and then prints the recieved message. The server will send back a message, outputting his own message this time. Finally, the client recieves the message, and outputs what he recieved on the console.

However, this is not the conceptually tough part. This project regards constantly changing the ip address of the server bind. Additionally, the client must know that the server has bound to a new IP address. So, using a common .csv file, both the server and the client extract the IP address in question, and the port of communication. The server binds to this address, and listens on the indicated port. The Client connects to the address, and will send the first message on the indicated port.

# Thank you so much for furthering the ventures of Connectivity! 

