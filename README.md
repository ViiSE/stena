# stena
Object-Oriented library for protection objects

### What?
When writing code, we often check objects: null or empty, negative or positive, and so on. For example, we can create
interface `Validator`, but interface name `Validator` for object-oriented world is bad, because we are validating data, 
not objects. Therefore, we'll not validate objects, but `protect` it. Interface `Wall` was creating for protect objects.
Now let's think like this: to protect the objects, we will decorate them with the `Wall`. If the `Wall` could not 
protect the objects, then an exception is thrown. Let's look at examples.

### Examples
Protect not null object:
```java
String myNotNullObject = "Hello, World!";
Wall<Object> walNotNull = new WalNotNull();
try {
    walNotNull.protect(myNotNullObject);
    // Yay! myNotNullObject is really not null
    // Now you don't have to worry about myNotNullObject is null
} catch (ProtectException e) {
    System.out.println(e.getMessage());
}
```

Protect positive Integer:
```java
Integer positiveInt = 1;
Wall<Integer> walPositiveInt = new WalPositiveInt();
try {
    walPositiveInt.protect(positiveInt);
} catch (ProtectException e) {
    System.out.println(e.getMessage());
}
```

For more examples, see tests.

### Why?
In order not to write business logic and object checks in the same place. This is primarily necessary for convenient 
testing. With this approach, you can write a separate test for checking objects, and write a separate test for business 
logic. Of course, another problem arises here: in order for business logic to work as intended, you also have to 
remember test for `Wall` implementation. But with this approach, in the class that implements business logic code 
that is responsible for business logic will be immediately visible, and will be cleaner than the class with code with 
business logic, where there is less logic than checks of objects. You need to weigh the pros and cons and understand 
whether you need to use the `Wall` at all or not.

### Project Name
"stena" is the transliteration of the Russian word "wall" :)
