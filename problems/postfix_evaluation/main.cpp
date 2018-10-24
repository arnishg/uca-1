#include<iostream>
#include<stack>

using namespace std;

int isOperator(char ch) {
    return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
}
int check(string s) {
    stack<int> st;

    for(int i = 0; i < s.length(); i++) {
        if(isOperator(s[i])) {
            int a = st.top();
            st.pop();
            int b = st.top();
            st.pop();
            switch(s[i]) {
                case '+':
                    a += b;
                    break;
                case '-':
                    a = b - a;
                    break;
                case '*':
                    a *= b;
                    break;
                case '/':
                    a = b/a;
                    break;
            }
            st.push(a);
        }
        else {
            int p = s[i] - '0';
            st.push(p);
        }
    }
    /*while(!st.empty()) {
        cout << st.top() << endl;
        st.pop();
    } */
    //return 0;
    return st.top();

}
int main() {
    string s = "25*7/83*42*++";
    cout << check(s) << endl;
}
