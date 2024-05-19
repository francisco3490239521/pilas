#i#include <iostream>
#include <stdexcept>

class Pila {
private:
    int* stackArray;  
    int capacity;    
    int top;         

    void resize(int newCapacity) {
        int* newStackArray = new int[newCapacity];
        for (int i = 0; i < top; ++i) {
            newStackArray[i] = stackArray[i];
        }
        delete[] stackArray;
        stackArray = newStackArray;
        capacity = newCapacity;
    }

public:
    Pila(int initialCapacity = 10) : capacity(initialCapacity), top(0) {
        if (initialCapacity <= 0) {
            throw std::invalid_argument("Capacity must be positive");
        }
        stackArray = new int[capacity];
    }

    ~Pila() {
        delete[] stackArray;
    }

    void push(int value) {
        if (top == capacity) {
            resize(2 * capacity); 
        }
        stackArray[top++] = value;
    }

    int pop() {
        if (top == 0) {
            throw std::out_of_range("Pila vacía");
        }
        return stackArray[--top];
    }

    bool isEmpty() const {
        return top == 0;
    }

    int size() const {
        return top;
    }
};

int main() {
    Pila pila;

    pila.push(10);
    pila.push(20);
    pila.push(30);

    std::cout << "Elemento extraído: " << pila.pop() << std::endl;  // 30
    std::cout << "Elemento extraído: " << pila.pop() << std::endl;  // 20

    return 0;
}

