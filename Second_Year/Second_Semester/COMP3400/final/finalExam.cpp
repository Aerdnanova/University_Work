//Andrea Bonato
//104760390
//Final Exam COMP 3400

//Headers
#include <iostream>
#include <string>
#include <list>
#include <cstring>
#include <set>
#include <algorithm>
#include <iterator>
#include <fstream>

//Include std 
using namespace std;

//struct that contains a string and a size
struct qwerty {

    string str;
    size_t size;

};


//This will be used in the sort method when comparing qwerty values
static bool operator < (qwerty const& value1, qwerty const& value2) {

    //check if the sizes are not equal
    if (value1.size != value2.size) {
     
        return value1.size < value2.size;
    
    }
    
    //if the sizes are equal, then it will check the string
    return value1.str < value2.str;

            
}

//This wil be an overloaded operator function involving std::ostream tat can write out qwerty instances
ostream& operator << (ostream& os, qwerty const& value) {
    
    //load it into std::ostream
    os << value.str << " " << value.size;
    
    return os;
}


//This will be a istream overloaded operator function invoving std::istream that can read in qwerty instances
istream& operator >> (istream& is, qwerty& value) {
    
    //variables to test for failbit
    string strValue;
    size_t sizeVal;
    
    //load it from std::istream
    if (is >> strValue >> sizeVal)
    {   
        //assign qwerty values
        value.str = strValue;
        value.size = sizeVal;
    
    } else {
        
        //set failbit state
        is.setstate(ios_base::failbit);
    }

    return is;
}
//program starts here
int main() {
    
    //Decalre variables
    set<qwerty> setVal;
    list<qwerty> listVal;
    string fileName = "data.dat";
    
    //open file
    ifstream in(fileName, fstream::in);
    
    //load contents into file
    qwerty tempValue;
    while(in >> tempValue) {
        setVal.insert(tempValue);
    }
    
    //Transform from set<qwerty> to list<qwerty>
    transform(
        setVal.begin(), //Begin
        setVal.end(), //End
        back_inserter(listVal), //insert into list
        [](qwerty value) {
            //lambda function to find size
            value.size += value.str.size();
            return value;
        
        }
    );
    
    //used to print out
    copy(
        listVal.begin(),
        listVal.end(),
        ostream_iterator<qwerty>(cout, " ")
    );

    cout << endl;
    return 0;
}
