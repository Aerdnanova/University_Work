
/*
	Systems programming
	Assignment 1
	Andrea Bonato
	104760390

	Description:
		
		Recieves two .ppm photos as input, find their width and height, then combining them. Takes 2 ppm files and a name of the third file as an arguments
*/
#include <fcntl.h>
#include <unistd.h>
#define MAX 10000


//FUnctions
int getHeight(int);
int getWidth(int);
int combine(int, int, int,int,int,int, int);


//Main
int main(int argc, char *argv[]){
	
	//These are the attributes
	int w1, w2, h1, h2;	//Height and width variables
	int combin;
	int photo1 = open(argv[1], O_RDONLY);	//OPen photo1
	int photo2 = open(argv[2], O_RDONLY);	//Open photo2
	//Get sizes
	h1 = getHeight(photo1);
	h2 = getHeight(photo2);
	w1 = getWidth(photo1);
	w2 = getWidth(photo2);
	

	//If the first photo is bigger than the second bigger than this will work, other than that, write error to file
	if(h1 > h2 && w1 > w2){
		
		combin = open(argv[3], O_WRONLY| O_CREAT| O_TRUNC, 0700);
		combine(photo1, photo2, h1,h2,w1,w2, combin);
		
		return 0;
	}else{
		//Write error to file
		combin = open(argv[3], O_WRONLY | O_CREAT | O_TRUNC, 0700);
		write(STDOUT_FILENO, "ERROR:PHOTO 1 IS SMALLER THAN OR EQUAL TO PHOTO 2", 50);
		write(combin, "ERROR: PHOTO 1 IS SMALLER THAN OR EQUAL TO PHOTO 2", 50);
		close(combin);
		return 1;
	}
	
	close(photo1);
	close(photo2);
}
/**

	This file will open the third output file and do the following tasks:
	- It will check the photos and print the header for the first photo and skip the header for the second file
	- It will first print out the first photo
	- THen it will print out the second photo on the other photo
*/
int combine(int photo1, int photo2, int h1, int h2, int w1, int w2, int combin){
	
	//Attributes
	char buffer[3];
	int p1count=0, p2count=0,counter = 0;
	int new_line = 0;
	char p1;
	char p2;
	//-------------------------
	
	//THis will print out the head and skip the header for the second library
	lseek(combin,0,SEEK_SET);	//Start at the begining of both files
	lseek(photo1,0,SEEK_SET);
	read(photo1, &p1 , 1);


	//Print out the first photo's beader to the fial file byte by byte
	while(new_line < 3){
		
		if(p1 == '\n'){
			
			new_line++;
		}	

		write(combin, &p1, 1);
		read(photo1, &p1, 1);
		counter++;

	}
	
	//reset counters
	p1count = counter;
	counter = 0;
	new_line = 0;
	

	//For skipping the second photo
	lseek(photo2, 0 ,SEEK_SET);
	read(photo2, &p2,1);
	while(new_line < 3){
		
		if(p2 == '\n'){
		
			new_line++;
		}
		read(photo2, &p2,1);
		counter++;
	}
	
	//resetn counters
	p2count  = counter;
	
	//-------------------------
	//For printing out the first photo
	lseek(photo1, p1count, SEEK_SET);
	for(int i = 0; i < h1; i++){
		
		for(int j = 0; j < w1; j++){
			
			read(photo1, buffer, 3);	//Reading an printing
			write(combin, buffer, 3);
		}
	}

	//-------------------------------
	//THis will begin to print outth photos
	//FOr the second photo:
	lseek(photo2, p2count, SEEK_SET);

	lseek(combin, p1count + (w1-w2)*3, SEEK_SET);	//Using precalculated offset to place where photo is located at
	for(int i = 0; i < h2; i++){
		
		for(int j = 0; j < w2; j++){
			
			read(photo2, buffer, 3);
			write(combin, buffer, 3);
		}

		lseek(combin, (w1 - w2)*3, SEEK_CUR);
	}
	
	//Close new file
	close(combin);

	return 1;
}

//This method will use the inputted photo to calculate the height for the photo, and return it as an integer
int getHeight(int photo){
	
	//Attributes
	char size[MAX];
	int newline_counter = 0;
	int i = 3;
	lseek(photo,0,SEEK_SET);
	read(photo, size,  MAX);
	
	//THs will count to a spcific line, an produce an index i
	while(newline_counter < 1){
		
		if(size[i] == '\n' || size[i] == ' '){
			
			newline_counter++;
		}
		i++;
	
	}
	int a = 0;
	
	//Tthis will translate the character picked up at the index i, and convert it from ASCII Decimal to int
	while(size[i] != ' ' && size[i] != '\n' && i < MAX){
		
		a = a*10 + ((int)size[i] - 48);	//Subtract 48 to help onvert to int from ascii
		i++;
	
	}
	
	return a;	//Return the height of the photo
}

//This will get a photo as the input, and calculate the width given a specific calculated value and returnwidth
//Thiw sill calculate the value from ascii decimal to int
int getWidth(int photo){
	

	//Attributes
	int a = 0;
	int i = 3;
	char size[MAX];
	
	lseek(photo,0,SEEK_SET);
	read(photo,size,MAX);
	
	//This loop will go through the lines and see where the next line or space is ocate, and then pick up the ascii decimlal value
	//Then it will use mathimatics to convert the value intp an integer
	while(size[i] != ' ' && size[i] != '\n' && i< MAX){
		
		a = a*10 + ((int)size[i] - 48);	//Subtracting 48 to help convert it into int
		i++;
	}
	
	return a;	//Return width
}
