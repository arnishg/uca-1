#include<iostream>
#include<stack>

using namespace std;
void find(int arr[], int *span, int s) {
    stack<int> st;
    st.push(0);
    span[0] = 1;

    for(int i = 1; i < s; i++) {
        while(!st.empty() && arr[st.top()] <= arr[i]) {
            st.pop();
        }
        span[i] = (st.empty())?(i+1):(i-st.top());
        st.push(i);

    }


}
int main() {
    int arr[] = {10,4,5,90,120,80};
    int span[sizeof(arr)/sizeof(int)] = {0};
    int s = sizeof(arr)/sizeof(int);
    find(arr,span,s);

    for(int i = 0; i < sizeof(span)/sizeof(int); i++) {
        cout << span[i] << " ";
    }
    return 0;
}
