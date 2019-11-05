#include<sys/types.h>
#include<sys/socket.h>
#include<stdio.h>
#include<netinet/in.h> 
#include <unistd.h>
#include<string.h> 
#include <arpa/inet.h>
#include <stdlib.h>
#define MAXBUFLEN 1000000
void main()
{
int b,sockfd,connfd,sin_size,l,n,len;

if((sockfd=socket(AF_INET,SOCK_STREAM,0))>=0)  //socket creation
printf("Socket Created Sucessfully \n");                 //on success 0 otherwise -1

struct sockaddr_in servaddr;              
struct sockaddr_in clientaddr;

servaddr.sin_family=AF_INET;
servaddr.sin_addr.s_addr=inet_addr("127.0.0.1");
servaddr.sin_port=6007;

if((bind(sockfd, (struct sockaddr *)&servaddr,sizeof(servaddr)))==0)   //bind() assigns the
     //  address  specified  by  addr  to  the  socket  referred  to by the file
      // descriptor sockfd.  addrlen  specifies  the  size,  in  bytes,  of  the
     //  address structure pointed to by addr.  Traditionally, this operation is
      // called “assigning a name to a socket”.

printf("Bind Sucessful \n");

if((listen(sockfd,5))==0)  //listen for connections on a socket

printf("Listen Sucessful \n");

sin_size = sizeof(struct sockaddr_in);
if((connfd=accept(sockfd,(struct sockaddr *)&clientaddr,&sin_size))>0)
printf("Accept Sucessful \n");
char buffer[100];
char c[10000] = "this is file transfer program";
//char source[MAXBUFLEN + 1];
//bzero(buffer,10000);

FILE *fp; 
fp= fopen("/home/ubuntu/Downloads/CNL/Assg2/Assg2_b/send.txt", "w+");
//fp = fopen("file.txt", "w+");

   /* Write data to the file */
   fwrite(c, 1, strlen(c) + 1, fp);

   /* Seek to the beginning of the file */
   fseek(fp, 0, SEEK_SET);

   /* Read and display data */
   fread(buffer, 1,strlen(c)+1, fp);
  
  // fclose(fp);
    
write(connfd, buffer, strlen(buffer));
printf("Sent File Contents: %s\n", buffer);
fclose(fp);
close(sockfd);
}
