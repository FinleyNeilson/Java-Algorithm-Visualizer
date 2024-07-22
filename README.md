Building and Running the Application
1. Clone the Repository

sh

git clone https://github.com/FinleyNeilson/Java-Algorithm-Visualizer.git
cd Java-Algorithm-Visualizer

2. Build the Project

sh

./gradlew clean build
./gradlew jlink

3. Run the Application

sh

cd build/image/bin
./app

Java Algorithm Visualizer

A versatile and interactive visualizer for sorting algorithms, implemented in Java using JavaFX. This project allows users to explore and understand various sorting algorithms through dynamic animations and intuitive graphical representations.
Features

Multiple Sorting Algorithms: Includes implementations for popular sorting algorithms like Bubble Sort and Selection Sort.
Interactive Visualization: Real-time animations of sorting steps, showcasing how algorithms process and sort data.
Customizable Animation: Adjust the speed of the sorting animations to observe algorithms in detail.
Modular Design: Built with a clean architecture using the Model-View-Controller (MVC) design pattern for easy extensibility and maintenance.
