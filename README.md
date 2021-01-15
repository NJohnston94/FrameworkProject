# FrameworkProject

Create a test framework specifically for swapi.dev

The framework should focus on quality of abstraction over quantity of aspects of the API tested. 

The methods available to the tester are held in the clas StarWarsAPITester, in which there are two nested classes called APIConnection and DTO, each of which has class-specific methods. APIConnection has methods for creating a Response object, testing HTTP status codes and testing response Headers and their values. DTO has methods for creating a StarWarsAPIResource DTO object which has data injected via a valid URL to swapi.dev and methods for testing general features of swapi.dev resources. All methods typically only require a URL or Response object as a parameter (method overloading ensures the tester can use either and get the same result) so that a tester can get as much information as possible from a single parameter.

All methods output useful information to the console window and some methods throw custom exceptions specific to problems that could be faced in querying this API.

Currently, this framework can handle testing of People resources from swapi.dev, but the StarWarsAPIResource objects are set up with a common interface so the framework can be easily expanded to handle querying of Species, Starship, Vehicle, Film and Planet resources, too.
