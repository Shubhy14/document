import socket

print 'Welcome to DNS Lookup'
print 'Enter your option 1. Host by Name 2. Host by Address'
op=raw_input('Enter Option') #The raw_input() function reads a line from input (i.e. the user) and returns a string by stripping a trailing newline.
var=raw_input('Enter URL/IP') # Number data types store numeric values. Number objects are created when you assign a value to them
addr1 = socket.gethostbyname(var) # Returns the hostname.// get local machine name
addr6=socket.gethostbyaddr(var)
if op==1:	
	print(addr1)

else:
	print(addr6)



#Sockets are the endpoints of a bidirectional communications channel. Sockets may communicate within a process, between processes on the same machine, or between processes on different continents.
