// best case O(n) time when the input is sorted
// works efficiently when the input is nearly sorted.

void sort(int arr[]) 
{ 
    int n = arr.length; 
    for (int i = 1; i < n; ++i) { 
      int key = arr[i]; 
      int j = i - 1; 
      while (j >= 0 && arr[j] > key) { 
         arr[j + 1] = arr[j]; 
         j = j - 1; 
      }
    }
    arr[j + 1] = key;  
} 
