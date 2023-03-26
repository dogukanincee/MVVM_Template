# Implementing the MVVM Architecture in Android with Kotlin: A Guide to Model, View and ViewModel Classes

https://dogukanincee.medium.com/implementing-the-mvvm-architecture-in-android-a-guide-to-model-view-and-viewmodel-classes-dbcb72f07337

https://dogukanincee.medium.com/unit-testing-in-android-a-guide-of-using-junit-mockito-mockk-and-espresso-d7a47819ada5

The Model-View-ViewModel (MVVM) architecture is a popular Android application development design pattern. It divides an application into three layers: View, ViewModel, and Model.

To gain a deeper comprehension of the MVVM architecture, we will examine the Kotlin-written MainActivity, Message, and ViewModel classes of an Android application in this article.

MODEL

The Model layer of an app represents the data and business logic. This layer is responsible for handling data operations, such as fetching data from a database, manipulating data, and retrieving data from APIs. In our implementation, the Message class addresses the Model.

The Message data class that we have implemented is a straightforward data container that holds a message string. We have made the message string a read-only property to ensure that it cannot be modified once it is set. This is in keeping with the immutability principle of functional programming, which can assist with making more reliable and easier to code.

The Message data class as an example of a data container class that can be used to hold data for an application by encapsulating the text data within itself, the data is only modified in a controlled way, through the ViewModel class which aims to prevent bugs and making more robust code.

The Message data class has a single property which is text, will be used to address the message that will be displayed in the MainActivity and even though the aim of this class is straightforward, it fills its need as the data source for the application.

VIEW

The View layer of an app represents the user interface. This layer is liable for displaying data to the user and getting input from the user. In our implementation, the MainActivity class represents the View.

MainActivity class which represents our ViewModel and sets up the UI components. In order to bind ViewModel instance to the lifecycle of the MainActivity, ViewModelProvider is used. After that point, LiveData variable in the ViewModel is observed and when the data changes, messageTextView is updated.

Additionaliy, updateMessage() function is used to generate a random message by triggering the getRandomMessage() function. This function is called at the point when the user clicks the “Update Message” button which updates the ViewModel with the new random message.

VIEWMODEL

The ViewModel class is responsible for providing data to the UI layer and getting through setup changes, such as screen rotations. The ViewModel class provides a separation of concerns between the UI layer and the data layer. It holds the data needed by the UI layer and provides an interface for updating the data. The UI layer can observe the data changes through the LiveData objects that the ViewModel exposes.
In the implementation of the ViewModel class that is written, MutableLiveData object called _message is created to hold the message data. This object is private to ensure that it can only be modified within the ViewModel class. We have also created a public LiveData object called message that exposes the message data to the UI layer. The message object is read-only which makes it only to be read and not modified from the UI layer.

We have provided a public function called setMessage() that takes a string and sets the value of the _message object to that string. This function is the interface through which the UI layer can update the message data. At whatever point the _message object is updated, it will trigger an update of the message object, which can be observed by the UI layer.

CONCLUSION
In this article, View, ViewModel and Model classes, which are part of the MVVM architecture pattern is explained. Implementation of these classes which demonstrates the separation of concerns between the UI layer and the data layer as an Android application is given as an example.

A method is given by encapsulating the message data within the Message class and the business logic within the ViewModel class to make sure the data is only modified in a controlled way which assists with preventing bugs and making the code more robust. Thus, a way for the UI layer to observe the data changes and update the UI accordingl is provided by exposing the data through LiveData objects.

The MVVM architecture pattern is a strong example for building versatile, maintainable, and testable Android applications and by following the principles of the MVVM pattern and separating the concerns of the UI layer and the data layer.
