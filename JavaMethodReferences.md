### Theory:

- Java Method References
    - Method references are references to existing method implementations and can be passed like lambda expressions.
    - Method references are composed of a target reference, the "::" delimiter, and the method name without parentheses "()".
    - There are four different types of method references:
        
        
        | Type | Lambda Expression | Method Reference |
        | --- | --- | --- |
        | Static Method | (a) → Class.staticMethod(a) | Class::staticMethod |
        | Instance Method of 
        any Type | (obj) → obj.instanceMethod() | ObjectType::instanceMethod |
        | Method of a specific 
        object obj | (a) → obj.method(a) | obj::method |
        | Constructor | (a) → new Class(a) | Class::new |
    1. **Static Methods:**
        - The class name forms the target reference.
        - **Example:** From x -> Math.abs(x) becomes Math::abs
        
        ```java
        UnaryOperator<Double> absolutAsLambda = (Double value) -> Math.abs(value);
        System.out.println(absolutAsLambda.apply(-3.0)); //3
                
        UnaryOperator<Double> absolutAsRef = Math::abs;
        System.out.println(absolutAsRef.apply(-3.0)); //3
        ```
        
    2. **Instance Methods of any Type:**
        - Used when referencing a method whose object is passed as a parameter of the lambda expression.
        - From (self) -> self.toString() becomes Object::toString
        
        ```java
        Function<Thread, String> threadName = (threadObj) -> threadObj.getName();
        System.out.println(threadName.apply(new Thread()));
        
        Function<Thread, String> threadNameRef= Thread::getName;
        System.out.println(threadNameRef.apply(new Thread()));
        ```
        
    3. **Method for a specific Object:**
        - Used when referencing a method that is part of an external, existing object.
        - From ()-> expensiveTransaction.getValue() becomes expensiveTransaction::getValue
        
        ```java
        Thread myThread = new Thread();
        
        Supplier<String> tName = () -> myThread.getName();
        System.out.println(tName.get());
        
        Supplier<String> tNameRef = myThread::getName;
        System.out.println(tNameRef.get());
        
        //Another example: 
        
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Predicate<Integer> predicate = numbers::contains;
        
        System.out.println(predicate.test(1));  // true
        System.out.println(predicate.test(6));  // false
        
        ```
        
    4. **Constructors:**
        
        ```java
        public class Person {
            public String name;
        
            public Person(String name) {
                this.name = name;
            }
        }
        
        Function<String, Person> personCreatorL = (String name) -> new Person(name);
        
        Function<String, Person> personCreatorR = Person::new;
        
        Person john = personCreatorR.apply("John");
        ```
        
    
    Benefits of Method References:
    
    - More compact than lambda expressions.
    - Easier to read and understand.