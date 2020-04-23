/**
Andrea Bonato
104760390
This program will execute the previous part of it, then run the commands in terminal.
It will then kill the process and show the zombie process
**/

#include <stdio.h>
#include <unistd.h>
#include <string.h>
#include <stdlib.h>

int main()
{	
	
	printf("Killing Parent Process and Waiting For 10 Seconds ....\n");
	system("cc -o Assignment2_1 Assignment2_1.c");	//Create name for original file and compile
	system("./Assignment2_1 &"); //Call previous file
	sleep(10);
	system("ps -l");	//State log
	printf("\nNew table ....\n");
	sleep(1);
	system("kill -9 $(ps -l|grep -w Z|tr -s ' '|cut -d ' ' -f 5)"); //Kill process
	system("ps -l");	//Call new state without zombie
	return 0;

}
