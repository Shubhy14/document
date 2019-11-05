#include<iostream>
using namespace std;
int main() 
{
    int data[10];
    int recieve[10],c,c1,c2,c3,i;
  
    cout<<"Enter 4 bits of data one by one\n"<<endl;
    cin>>data[0]>>data[1]>>data[2]>>data[4];
 
    //Calculation of even parity
    data[6]=data[0]^data[2]^data[4];
    data[5]=data[0]^data[1]^data[4];
    data[3]=data[0]^data[1]^data[2];
 
    cout<<"\nEncoded data is\n";
    for(i=0;i<7;i++)
        cout<<data[i];
 
    cout<<"\n\nEnter received data bits one by one\n";
    for(i=0;i<7;i++)
        cin>>recieve[i];
 
    c1=recieve[6]^recieve[4]^recieve[2]^recieve[0];
    c2=recieve[5]^recieve[4]^recieve[1]^recieve[0];
    c3=recieve[3]^recieve[2]^recieve[1]^recieve[0];
    c=c3*4+c2*2+c1 ;
 
    if(c==0) 
	{
        cout<<"\nNo error while transmission of data\n";
    }
    else 
	{
        cout<<"\nError on position "<<c;
        
        cout<<"\nData sent : ";
        for(i=0;i<7;i++)
            cout<<"%d",data[i];
        
        cout<<"\nData received : ";
        for(i=0;i<7;i++)
            cout<<recieve[i];

      	}
return 0;
}

