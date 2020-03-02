/**
	This section will take a virtual address in decimal on the command line and have it output
	the page numver and offset for the given address
	Andrea Bonato
	104760390

*/
#include <stdio.h>
#include <stdlib.h>
#define OFFSETVALUE 4095

int main (int arg, char *argv[])
{
	unsigned long adrs = atoi(argv[1]); //Get first value in command line
	unsigned long pgNumber = adrs >> 12;	//Get page number
	unsigned long offset = adrs & OFFSETVALUE; //Calculate offset

	//print
	printf("The address %lu contains: \nPage number = %lu\nOffset = %lu\n", adrs, pgNumber, offset);
}
