#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h> 
#include <unistd.h>
#include<string.h> 
#include <arpa/inet.h>
#include<netdb.h>
void main()
{
int b,sockfd,connfd,sin_size,l,n,len;
char buff[256];
char buff1[256];
if((sockfd=socket(AF_INET,SOCK_STREAM,0))>=0)  //socket creation
printf("socket created sucessfully \n");                 //on success 0 otherwise -1

struct sockaddr_in servaddr;              
struct sockaddr_in clientaddr;

//Assign server object parameters
servaddr.sin_family=AF_INET;
servaddr.sin_addr.s_addr=htonl(INADDR_ANY);
servaddr.sin_port=htons(6000);

//bind() assigns the
     //  address  specified  by  addr  to  the  socket  referred  to by the file
      // descriptor sockfd.  addrlen  specifies  the  size,  in  bytes,  of  the
     //  address structure pointed to by addr.  Traditionally, this operation is
      // called “assigning a name to a socket”.
if((b=bind(sockfd, (struct sockaddr *)&servaddr,sizeof(servaddr)))==0)   
printf("bind Sucessful \n");

//listen for connections on a socket
l=listen(sockfd,5);  
printf("listen Sucessful \n");

//accept call accepts connection from client
sin_size = sizeof(clientaddr);
if((connfd=accept(sockfd,(struct sockaddr *)&clientaddr,&sin_size))>0);
printf("accept sucessful \n");

bzero(buff,256);
//bzero(buff1,256);
//len=strlen(buff);
//reads msg from socket
n=read(connfd, buff, 256);
printf("msg from client:%s\n",buff);

//writes msg on socket
printf("Enter Your Message:");
fgets(buff1, 256,stdin);
len=strlen(buff1);

write(connfd, buff1, len);
//printf("msg to client:%s \n",buff1);
//close call closes socket created and free assigned parameters
close(sockfd);
}
