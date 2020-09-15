package observer;

import java.util.ArrayList;

interface Observer {
	void onSubjectUpdated(double newValue);
}

class Subject {
	private ArrayList<Observer> observers = new ArrayList<Observer>();
	private double subjectValue;
	
	public void setValue(double x) {
		subjectValue = x;
		notifyObservers();
	}
	
	public void addObserver(Observer o) {
		observers.add(o);
	}
	
	public void notifyObservers() {
		for(Observer o : observers) {
			o.onSubjectUpdated(subjectValue);
		}
	}
}

class Observer1 implements Observer {
	@Override
	public void onSubjectUpdated(double value) {
		// TODO Auto-generated method stub
		System.out.println("Observer 1 received the new value: "+ value);
	}
}

class Observer2 implements Observer {
	@Override
	public void onSubjectUpdated(double value) {
		// TODO Auto-generated method stub
		System.out.println("Observer 2 received the new value: "+ value);
	}
}

class Observer3 implements Observer {
	@Override
	public void onSubjectUpdated(double value) {
		// TODO Auto-generated method stub
		System.out.println("Observer 3 received the new value: "+ value);
	}
}

class Container {
	private Observer3 observer = new Observer3();
	
	public void registerToSubject(Subject s) {
		s.addObserver(observer);
	}
}

public class ObserverDemo {
	static public void main(String[] args) {
		Observer1 observer1 = new Observer1();
		Observer2 observer2 = new Observer2();
		Container container = new Container();
		
		Subject changingSubject = new Subject();
		
		changingSubject.addObserver(observer1);
		changingSubject.addObserver(observer2);
		container.registerToSubject(changingSubject);
		
		changingSubject.setValue(0.12525);
		changingSubject.setValue(5.0);
	}
}
