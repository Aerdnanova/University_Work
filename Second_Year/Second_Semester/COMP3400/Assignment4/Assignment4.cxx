/**
 * This assignment is designed to explore how to use the associate containers
 * Andrea Bonato
 * 104760390
*/
#include <iostream>
#include <cstddef> //size_t is a typedef in this libary
#include <string>
#include <map>
#include <istream>
#include <ostream>

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
	
	for (record r; cin >> r;)	
	{	

		auto frequency = h.insert(pair<record, size_t>(r,1));
		if (frequency.second == false)
		{
			map<record, size_t>::iterator itr = h.find(r);
			itr->second++;	
		}
	}

	cout << "{ ";

	for (map<record, size_t>::iterator itr = h.begin(); itr != h.end(); ++itr)
	{
		cout << itr->first << " : " << itr->second;
		if(next(itr,1) == h.end())
		{
			//do nothing
		}
		else
		{
			cout << ", ";
		}
	
	}
	cout << " }\n";

	return 0;
}
