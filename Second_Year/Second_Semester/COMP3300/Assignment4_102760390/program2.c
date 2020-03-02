/**
	This section will take the number of random addresses we want to generate in decimal
	on the command line and have it output the page numver and offset for the given addresses
	By using the time ./a.out randVal command we can calculate the time it takes to do so
	Andrea Bonato
	104760390

*/
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#define OFFSETVALUE 4095

int main (int arg, char *argv[])
{
	//Take in argument for number of times we want to run this
	unsigned long randVal = atoi(argv[1]), adrs, pgNumber, offset;
	time_t t;
	srand((unsigned) time(&t));

	//find randVal number of 
	for(int i = 0; i < randVal; i++){
		adrs = rand() % (int)(pow(2.0,32.0) + 1); //Get first value in command line
		pgNumber = adrs >> 12;	//Get page number
		offset = adrs & OFFSETVALUE; //Calculate offset

	}
	return 0;
}
