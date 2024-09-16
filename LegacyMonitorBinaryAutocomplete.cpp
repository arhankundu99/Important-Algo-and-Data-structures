// Online C++ compiler to run C++ program online
#include <iostream>
#include <string>
#include <vector>
using namespace std;
typedef struct Trie {
    public:
    Trie*left=nullptr;
    Trie*right=nullptr;
    int val=0;
    Trie(int num){
        val=num;
    }
} Trie;

vector<int> helper(vector<std::string>s){
    vector<int>res;
    Trie* head= new Trie(0);
    for(int i=0;i<s.size();i++){
        auto cur=head;
        if(i==0){
            res.push_back(0);
        }else{
            bool f=false;
            int num=cur->val;
           for(int j=0;j<s[i].length();j++){
               if(s[i][j]=='0'){
                   if(cur->left!=nullptr){
                       cur=cur->left;
                       num=cur->val;
                   }else{
                       f=true;
                       break;
                   }
               }else{
                   if(cur->right!=nullptr){
                       cur=cur->right;
                       num=cur->val;
                   }else{
                       f=true;
                       break;
                   }
               }
               
           }
           res.push_back(num);
        }
        cur=head;
        head->val=i+1;
        
        for(int j=0;j<s[i].length();j++){
            if(s[i][j]=='0'){
                if(cur->left!=nullptr){
                    cur=cur->left;
                    cur->val=i+1;
                }else{
                    cur->left=new Trie(i+1);
                    cur=cur->left;
                }
            }else{
                if(cur->right!=nullptr){
                    cur=cur->right;
                    cur->val=i+1;
                }else{
                    cur->right=new Trie(i+1);
                    cur=cur->right;
                }
            }
        }
        
    }
    return res;
}

int main() {
    // Write C++ code here
    vector<string>in{"000","1110","01","001","110","11"};
    vector<string>in1{"10110100","1011","10110001"};
    auto res= helper(in1);
    for(auto y:res){
        cout<<y<<" ";
    }
    cout<<"\n";
    
    return 0;
}
