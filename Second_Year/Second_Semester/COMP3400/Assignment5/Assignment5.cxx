/**
 * This assignment is designed to explore how to use the associate containers and add on to
 * Assignment 4 by using different containers
 * Andrea Bonato
 * 104760390
*/
#include <iostream>
#include <cstddef> //size_t is a typedef in this libary
#include <string>
#include <map>
#include <istream>
#include <ostream>
#include <set>

using namespace std;

//struct record
//Assume first name always appears before last
//First and last are always separated by a space
//Adjacent records have whitespaces
struct record
{
	string fname_;	//firstname
	string lname_;	//lastname
};


//input overloader

istream &operator >> (istream &is, record &newRecord)
{	
	string fname;
	string lname;
	
	cin >> fname;
	cin >> lname;

	newRecord.fname_ = fname;
	newRecord.lname_ = lname;

	return is;

}

//output operator

ostream &operator << (ostream &os, const record &oldRecord)
{

	os << oldRecord.fname_ << " " << oldRecord.lname_;
	return os;
}
// < overloader
bool operator < (const record &first, const record &second)
{
	bool boolean = false;
	
	if (first.lname_.compare(second.lname_) == 0)
	{
		if (first.fname_.compare(second.fname_) < 0) //if true second.fname_ < first.fname_
		{	
			boolean = true;
		}
		else
		{
			boolean = false;
		}
	}
	else
	{
		if (first.lname_.compare(second.lname_) < 0)
		{
			boolean = true;
		}
		else
		{
			boolean = false;
		}
	}

	return boolean;
}


//main
int main ()
{	
	using hist_t = map<record, size_t>;
	hist_t h;
	
	using invhist_t = map<size_t, set<record>>;
	invhist_t ih;

	//iterate through records	
	for (record r; cin >> r;)	
	{	
	
		//Insert or modify if exists
		auto frequency = h.insert(pair<record, size_t>(r,1));
		if (frequency.second == false)
		{	
			//if exists, modify val
			map<record, size_t>::iterator itr = h.find(r);
			itr->second++;	
		}
	}

	//fill the other map container
	for (auto val: h)
	{	
		auto ihfrequency = ih.insert(pair<size_t, set<record>>(val.second,set<record>()));
		
		//fill in for the set<record> from h
		record newR = val.first;
		map<size_t, set<record>>::iterator it = ih.find(val.second);
		it->second.insert(newR);
	}
	
	//print it out
	for (auto val: ih)
	{
		cout << val.first << " : " << " { ";
		
		for (auto it = val.second.begin(); it != val.second.end(); it++)
		{
			//print out each value in set<Record>
			cout << *it;
			if (next(it,1) != val.second.end())
			{
				cout << ", ";
			}
		}

		cout << " }\n";
	}

	return 0;
}
