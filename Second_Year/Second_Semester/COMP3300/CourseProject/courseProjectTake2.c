//libraries
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <string.h>
#include <time.h>

//definitions
#define frameSize 256
#define pageSize 256
#define sizeTLB 16

//Struct to hold the page and fram for up to 16 TLB entries
struct TLB_Table {
    unsigned char page[16];
    unsigned char frame[16];
    int value;
} tlbTable;

//To declare the functions
int readingValues(int page, char *physicalMemory, int *openFrame);
int bufferSearch(int logicalAddress, char *pageTable, struct TLB_Table *TLB, char *physicalMemory, int *openFrame, int *pageFaults, int *TLB_Count);

//Main
int main (int argc, char *argv[]) {
    
    //used to time the code upon running
    clock_t start, end, finalTime;
    start = clock();
    
    //Used to chart the actual memory used
    unsigned char actualMemory[frameSize][frameSize];
    
    //Basic counters
    int pageFault = 0, TLBhit = 0, addressCount = 0;
    
    //Used for page table
    unsigned char pageTable[pageSize];
    memset(pageTable, -1, sizeof(pageTable));

    //create the TLB table and request a chunk of memory to store it in
    struct TLB_Table TLB;
    memset(TLB.page, -1, sizeof(TLB.page));
    memset(TLB.frame, -1, sizeof(TLB.frame));
    TLB.value = 0;

    int buffer;
    FILE *fd;
    int openFrame = 0;

    //if there is no other file ./a.out file.txt don't run
    if (argc < 2 ) {
        printf("ERROR5!");
        exit(0);
    }

    //opens file and checks if it is a valid file
    fd = fopen(argv[1], "r");
    if(fd == NULL) {
        printf("ERROR4!");
        exit(0);
    }
    
    //Read through and scan contents of file. Use contents to call bufferSearch and increment the address counter
    while(fscanf(fd, "%d", &buffer) == 1) {
        bufferSearch(buffer, pageTable, &TLB, (char*)actualMemory, &openFrame, &pageFault, &TLBhit);
        addressCount++;
    }
    
    //print stats
    printf("Number of Translated Addresses = %d\nPage Faults = %d\nPage Fault Rate = %.4f\nTLB Hits = %d\nTLB hit rate = %0.4f\n", addressCount, pageFault, (float)pageFault/(float)addressCount, TLBhit,(float)TLBhit/(float)addressCount);
    
    //get secondary time
    end = clock();
    //cacluate total time
    finalTime = end - start;
    //Print time
    printf("CPU Time: %f\n", (double)finalTime/CLOCKS_PER_SEC);
    pclose(fd);
}
/*
    This fuction takes in the page number, physical Memory address, and an integer representing the next open frame
    It will return an int that represents yet again, the enxt open frame
    This function will open up a bin file that will be used to store information on the disk of the device
*/
int readingValues(int page, char *physicalMemory, int *openFrame) {
    
    //This is to hold the infromation from the bin file
    char buffer[pageSize];
    memset(buffer, 0, sizeof(buffer));

    FILE *fp;
    fp = fopen("BACKING_STORE.bin", "rb");

    if(fp == NULL) {
        printf("ERROR1!");
        exit(0);
    }

    if(fseek(fp, page * pageSize, SEEK_SET) != 0){
        printf("ERROR2!");
    }

    if(fread(buffer, sizeof(char), pageSize, fp) == 0){
        printf("ERROR3!");
    }
    
    //This will loop and assign each addresses available a value
    for (int i = 0; i < pageSize; i++) {
        
        *((physicalMemory + (*openFrame)*pageSize) + i ) = buffer[i];
    }
    
    //sends the next open frame as an int
    (*openFrame)++;
    
    pclose(fp);
    return (*openFrame)-1;
}

/*
    This function will take in the virtual address, page table, tlb table, physical memory matrix, the next open frame, and the current number of page and tlb faults.
    This will determine the number of page faults, tlb hits and the actual physical memory address
*/
int bufferSearch(int logicalAddress, char*pageTable, struct TLB_Table *TLB, char *physicalMemory, int *openFrame, int *pageFaults, int *TLB_Count) {
    
    //printf virtual memory
    printf("Virtual Address: %d\t", logicalAddress);
    
    //counters
    int frame = 0;
    int value1 = 0;
    int nextFrame = 0;

    unsigned char offset;
    unsigned char page;
    bool hit = false;
    
    //find the page and the offset
    page = (logicalAddress >> 8) & 0xFF;
    offset = logicalAddress & 0xFF;
    
    //find the number of tlb counts
    for (int i = 0; i < sizeTLB; i++) {
        if(TLB->page[i] == page){
            frame = TLB->frame[i];
            (*TLB_Count)++;
            hit = true;
        }
    }
    
    //if there is a tlb hit, then determine if there is a page fault as well
    if(hit == false) {
     
        if(pageTable[page] != -1){
        //do nothing
        }else{
            //page fault!
             nextFrame = readingValues(page, physicalMemory, openFrame);
             pageTable[page] = nextFrame;
            (*pageFaults)++;
        }
        
        //assign the values in the TLB table
         frame = pageTable[page];
         TLB->page[TLB->value] = page;
         TLB->frame[TLB->value] = pageTable[page];
         TLB->value = (TLB->value + 1) % sizeTLB;

    }
    //determine the value and print out the physical address, and value
    int index = ((unsigned char)frame*pageSize) + offset;
    value1 = *(physicalMemory + index);
    printf("Physical Address: %d\tValue: %d\n", index, value1);

    return 0;
}


