//odd or even
#include <iostream>
using namespace std;

//find if a number is odd or even
void oddeven(int n)
{
    if ((n & 1) ==  1)
    {
        cout << n << " is odd" << endl;
    }
    else if ((n & 1) ==  0)
    {
        cout << n << " is even" << endl;
    }
}

int main() {
	oddeven(4);
}
_____________________________________________________________

//get i-th bit of a number
#include <iostream>
using namespace std;

void getIthBit(int n, int i)
{
    int mask = 1 << i;
    if ((n & mask) > 0)
    {
        cout << 1 << endl;
    }
    else
    {
        cout << 0 << endl;
    }
}

int main() {
	getIthBit(5, 2); //101
}
_____________________________________________________________

#include <iostream>
using namespace std;

void clearIthBit(int n, int i)
{
    int mask = (~(1 << i));
    int output = (n & mask);
    cout << output << endl;
}

int main() {
	clearIthBit(27, 3); 
}

_____________________________________________________________
  
#include <iostream>
using namespace std;

void setIthBit(int n, int i)
{
    int mask = 1 << i;
    int output = (n | mask);
    cout << output << endl;
}

int main() {
	setIthBit(27, 2); 
}

_____________________________________________________________
  
#include <iostream>
using namespace std;

void flipIthBit(int n, int i)
{
    int mask = 1 << i;
    int output = (n ^ mask);
    cout << output << endl;
}

int main() {
	flipIthBit(31, 2); 
}
_____________________________________________________________
  
#include <iostream>
using namespace std;

void setIthBit(int n, int i, int v)
{
    int mask = v << i;
    int output = (n | mask);
    cout << output << endl;
}

int main() {
	setIthBit(31, 2, 1); 
}

_____________________________________________________________
  
#include <iostream>
using namespace std;

void clearIthBit(int n, int i)
{
    //int mask = ((~1) << i);
    int mask = (-1 << i);
    int output = (n & mask);
    cout << output << endl;
}

int main() {
	clearIthBit(27, 2); 
}

_____________________________________________________________

#include <iostream>
using namespace std;

void clearBitsInRange(int n, int left, int right)
{
    int maskL = (-1 << (left+1));
    int maskR = (~(-1 << right));
    int mask = (maskL | maskR);
    int output = (n & mask);
    
    cout << output << endl;
}

int main() {
	clearBitsInRange(27, 3, 1); 
}
_____________________________________________________________
#include <iostream>
using namespace std;

void replaceBits(int n, int i, int j, int m)
{
    //clear bit range
    int maskL = (-1 << (j+1));
    int maskR = (~(-1 << i));
    int maskN = (maskL | maskR);
    n = (n & maskN);
    
    int mask = (m << i);
    int output = (n | mask);
    cout << output << endl;
}

int main() {
    int n = 15;//1111
    int i = 1;
    int j = 3;
    int m = 2;//0010
	replaceBits(n, i, j, m); 
}


