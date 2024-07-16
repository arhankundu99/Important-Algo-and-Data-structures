// https://leetcode.com/discuss/interview-question/4964533/Google-Phone-Interview-Question
// There is stream of float values (-inf, inf) which is coming as input and an integer D.

// We need to find a set of 3 values which satisfy condition - |a - b| <= D, |b - c| <= D, |a - c| <= D, assuming a,b,c are 3 float values. Print these 3 values and remove them and continue ....

// Constraints -
// All values in stream will be unique.
// D -> [0, inf)

// Eg:
// Input stream - [1,10,7,-2,8,....], d = 5
// Output - (when 8 comes, then print "7 8 10" and remove them and continue)

// class Solution {
// 	private int D;
// 	void init(int d) {
// 		this.D = d;
// 	void func(float item) {
// 		// implement
// 	}
// }

//Suggested Solution
class Solution {
	private int D;
	//tree set will help to maintain ordered list of items
	TreeSet<Float> nums;

	//TC - O(1)
	void init(int d) {
		this.D = d;
		nums = new TreeSet<>();
	}

	//TC - O(logN) where N is current items count
	void func(float item) {
		//item is middle elt in triplet
		Float a = nums.floor(item);
		Float c = nums.ceiling(item);

		if(a!=null && c!=null && item-a<=D && c-item<=D) {
			nums.remove(a);
			nums.remove(c);
			return;
		}

		//item is 1st elt in triplet
		a = nums.ceiling(item);
		c = a!=null ? nums.ceiling(a) : null;
		if(a!=null && c!=null && a-item<=D && c-a<=D) {
			nums.remove(a);
			nums.remove(c);
			return;

		}

		//item is 3rd elt in triplet
		a = nums.floor(item);
		c = a!=null ? nums.floor(a) : null;
		if(a!=null && c!=null && item-c<=D && c-a<=D) {
			nums.remove(a);
			nums.remove(c);
			return;
		}
        nums.add(item);
	}
}