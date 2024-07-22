Clone the repository using Git:

sh

git clone https://github.com/your-username/your-repository.git

Replace https://github.com/your-username/your-repository.git with the URL of your GitHub repository.

Navigate to the project directory:

sh

    cd your-repository

    Replace your-repository with the name of your cloned repository directory.

3. Build the Project

    Clean and Build the project using the Gradle Wrapper:

    sh

./gradlew clean build

This will clean the previous builds and compile your code.

Create a Custom Runtime Image using the Gradle Wrapper:

sh

    ./gradlew jlink

    This step generates a custom runtime image containing only the modules your application needs. The runtime image will be located in the build/image directory.

4. Run the Application

    Navigate to the build/image/bin directory where the custom runtime image is located:

    sh

cd build/image/bin

Run the application using the generated runtime image:

sh

./app

This will start your application using the custom runtime image.

Java Algorithm Visualizer

A versatile and interactive visualizer for sorting algorithms, implemented in Java using JavaFX. This project allows users to explore and understand various sorting algorithms through dynamic animations and intuitive graphical representations.
Features

Multiple Sorting Algorithms: Includes implementations for popular sorting algorithms like Bubble Sort and Selection Sort.
Interactive Visualization: Real-time animations of sorting steps, showcasing how algorithms process and sort data.
Customizable Animation: Adjust the speed of the sorting animations to observe algorithms in detail.
Modular Design: Built with a clean architecture using the Model-View-Controller (MVC) design pattern for easy extensibility and maintenance.
