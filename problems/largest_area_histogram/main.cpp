#include<iostream>
#include<stack>
using namespace std;

int main() {
    stack<int>st;
    int max = 0;
    int arr[] = {6,2,5,4,5,1,6};
    int i = 0;
    int n = sizeof(arr)/sizeof(int);
    while(i < n) {
        if(st.empty() == true || arr[i] >= arr[st.top()]) {
            st.push(i++);
        }
        else {
            int area = arr[st.top()];
            st.pop();
            area *= (st.empty()) ? i : (i - st.top() - 1);
            if(area > max) {
                max = area;
            }
        }
    }
    while(!st.empty()) {
         int area = arr[st.top()];
            st.pop();
            area *= (st.empty()) ? i : (i - st.top() - 1);
            if(area > max) {
                max = area;
            }
    }

    cout << max;
    return 0;
}
