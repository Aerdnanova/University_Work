/**
	This progra will take in an address space, a page size, and an address, and return the page
	number and the offset number of the input address.
	Andrea Bonato
	104760390
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#define KILO 1024

int main (int arg, char* argv[])
{
	unsigned long adrs, adrsSpace, pgSize, pgOffsetBit;
	
	//load value into variables using atoi
	adrsSpace = (unsigned long) atoi(argv[1]);
	pgSize = (unsigned long) atoi(argv[2]);
	adrs = (unsigned long) atoi(argv[3]);


	//Check if in proper range
	//Check if adrsSpace is in the power of 2
	//Check if pgSize is a power of 2
	if ((adrs <= 0 || pgSize <= 0 || adrsSpace <= 0) || 
	(!(adrsSpace != 0) && (adrsSpace & (adrsSpace - 1)) == 0) ||
	((!(pgSize !=0) && (pgSize & (pgSize - 1)) == 0))) 
	{
		
		
		printf("Error: Not in range");
		return -1;
	}

	pgSize = pgSize * KILO;
	long index = 1;
	long indexCount = 0;
	long hold;


	//This will try and find the base of what power of 2 the page size it
	while (index != pgSize)
	{
		index = index * 2;
		indexCount++;
	}
	
	for (int i = 0; i < indexCount; i++)
	{
		hold = 1;
		hold = hold << i;
		pgOffsetBit = pgOffsetBit | hold;
	}

	unsigned long offset = adrs & pgOffsetBit;
	pgSize = adrs >> indexCount;

	printf("Page Number: %lu\nOffset: %lu\n", pgSize, offset);

	return 0;
}
