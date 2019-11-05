#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h> 
#include <unistd.h>
#include<string.h> 
#include<strings.h>
#include <arpa/inet.h>
#include <stdlib.h>

void main()
{
int b,sockfd,sin_size,con,n,len;
char buff[256];
char buff1[256];
char ip[50];
char port[10];
struct sockaddr_in servaddr;

// Socket call for socket creation: socket on sucess returns smallest integer value (3) otherwise -1
if((sockfd=socket(AF_INET,SOCK_STREAM,0))>=0)
printf("Socket Created Sucessfully \n");



//Initialize object parameters of server: family,ip,port
servaddr.sin_family=AF_INET;
servaddr.sin_addr.s_addr=inet_addr("10.15.9.218");
servaddr.sin_port=6000;

//initiate a connection on a socket from client to server using connect call
// connect call on sucess return 0 otnerwise -1
sin_size = sizeof(servaddr);
if((con=connect(sockfd,(struct sockaddr *) &servaddr, sin_size))==0) 
printf("connect sucessful \n");

bzero(buff,256); //null 256 bytes of buff
bzero(buff1,256); //null 256 bytes of buff1
 
//fgets call reads msg from user
printf("Enter Your Message:");
fgets(buff, 256,stdin);
len=strlen(buff);

//write call writes message on socket
write(sockfd,buff,len);
//printf("\n msg to server:%s",buff);

//read call reads message from socket
read(sockfd, buff1, 256);
printf("msg from server:%s \n",buff1);

//close call closes socket created and free assigned parameters
close(sockfd);
}
