# FrameworkProject

Create a test framework specifically for swapi.dev (Star Wars API)

The framework should focus on quality of abstraction over quantity of aspects of the API tested.

The framework is built around Rest Assured and Hamcrest dependencies and allows the user to fill a DTO which they can query on their own or use as argument to the framework's built-in methods. There are different DTOs depending on the swapi.dev URL, which specifies if the API entry is for a character, a planet, a movie etc. The framework recognises which DTO it should populate by extracting a keyword from the URL. 

With a populated DTO the user can call on framework methods which are stored in nested classes in the StarWarsAPITester class or use Rest Assured and Hamcrest methods.
