package com.linklist;

public class Node<T> {
T data;	
Node front;
Node rear;


Node(Node front,Node rear){
	this.front=front;
	this.rear=rear;
}

Node(T data){
	this.data=data;

}

public T getData() {
	return data;
}

public void setData(T data) {
	this.data = data;
}

public Node getFront() {
	return front;
}

public void setFront(Node front) {
	this.front = front;
}

public Node getRear() {
	return rear;
}

public void setRear(Node rear) {
	this.rear = rear;
}



}
