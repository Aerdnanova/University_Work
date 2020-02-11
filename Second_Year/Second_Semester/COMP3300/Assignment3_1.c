#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <pthread.h>
#include <ctype.h>
#include <math.h>

#define NUMBER_OF_THREADS 1

//global variables
int circle_count;
int pointNum;

//function declarations
double random_double ();
void *random_point ();

int main ()
{	
	int NumberOfPoints;
	double Pi;	
	//scan in the number
	printf("Enter in number of points: ");
	scanf("%d", &NumberOfPoints);
	
	NumberOfPoints /= NUMBER_OF_THREADS;

	clock_t begin = clock();
	//save it to the global variables
	pointNum = NumberOfPoints;

	pthread_t thread_id; //Create thread

	pthread_create (&thread_id, NULL, random_point, NULL); //Create thread and call function random_point
	
	pthread_join (thread_id, NULL); //Have main thread wait for slave thread to end before continuing

	//slave thread finishes
	
	Pi = 4 * ((double)circle_count / (double)NumberOfPoints); //Value of pi

	printf("The value of pi is about: %f\n", Pi); //Print value of pi
	
	clock_t end = clock();
	float time = (float)(end-begin)/CLOCKS_PER_SEC;
	
	printf("The time it took was: %f seconds\n", time );

	return 0;
}

//returns a random double
double random_double ()
{
	return random()/ ((double)RAND_MAX + 1);
}

//this will be used by the thread to count the number of hit_counts in the circle
void *random_point ()
{
	double x,y;
	int hit_count = 0;
	
	srandom((unsigned)time(NULL));

	for (int i = 0; i < pointNum; i++)	//Count for the number of points needed
	{
		x = random_double() * 2.0 - 1.0;
		y = random_double() * 2.0 - 1.0;
	
		if (sqrt(x*x + y*y) < 1.0 )
			hit_count++;
	}
	circle_count = hit_count; //Save it to global
	
	return NULL;
}
