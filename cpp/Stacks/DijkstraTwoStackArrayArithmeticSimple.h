#include "GenericResizingStackArray.h"

class DijkstraTwoStackArrayAlgorithmSimple {

private:
	GenericResizingStackArray<int> * values;
	GenericResizingStackArray<char> * operands;

public:
	DijkstraTwoStackArrayAlgorithmSimple();
	int evaluate(std::string s);
	void calculate();
};

DijkstraTwoStackArrayAlgorithmSimple::DijkstraTwoStackArrayAlgorithmSimple() {
	values = new GenericResizingStackArray<int>(0);
	operands = new GenericResizingStackArray<char>(0);
}

int DijkstraTwoStackArrayAlgorithmSimple::evaluate(std::string s) {
	int i = 0;
	while(i < s.size()) {
		if (s[i] == ')')
			calculate();
		else if (int(s[i]) >= 42 && int(s[i]) <= 45)
			operands->push(s[i]);
		else if (isdigit(s[i])) {
			std::string t = "" + s[i];
			while(isdigit(s[i+1])) {
				t += s[i++];
			}
			values->push(atoi(t.c_str()));
		}
		i++;
	}
	return values->pop();
}

void DijkstraTwoStackArrayAlgorithmSimple::calculate(){
	int v2 = values->pop();
	int v1 = values->pop();
	char o = operands->pop();
	int ans = 0;

	if (o == '+') { ans = v1 + v2; }
	else if (o == '-') { ans = v1 - v2; }
	else if (o == '*') { ans = v1 * v2; }
	else if (o == '/') { ans = v1 / v2; }

	values->push(ans);
}