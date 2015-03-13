template <class T>
class GenericResizingStackArray {

private:
	T * stack;
	int size;

	// Member methods
	void resizeStack(int n);

public:
	// Constructors
	GenericResizingStackArray(int);
	~GenericResizingStackArray(void); // Destructor

	// Member methods
	void push(T t);
	T pop(void);
	bool isEmpty() const { return size == 0; };
	void printStack();
};

template <class T>
GenericResizingStackArray<T>::GenericResizingStackArray(int n)  {
	size = n;
	stack = new T[n];
}

template <class T>
void GenericResizingStackArray<T>::push(T t) {
	if (size == (sizeof(stack)/sizeof(*stack)))
		resizeStack(size * 2);
	stack[size++] = t;
}

template <class T>
T GenericResizingStackArray<T>::pop() {
	return stack[size--];
}

template<class T>
void GenericResizingStackArray<T>::resizeStack(int n) {
	T * temp = new T[n];
	for (int i = 0; i < size; i++)
		temp[i] = stack[i];
	stack = temp;
}

template <class T>
void GenericResizingStackArray<T>::printStack() {
	for (int i = 0; i < size; i++)
		std::cout << "index: " << i << "\titem: " << stack[i];
}